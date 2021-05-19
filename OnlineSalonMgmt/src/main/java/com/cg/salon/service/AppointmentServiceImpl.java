package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.dao.ICustomerDao;
import com.cg.salon.dao.ISalonServiceScheduleDao;
import com.cg.salon.dto.AppointmentDto;
import com.cg.salon.dto.SalonServiceScheduleDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.entity.Customer;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.util.SalonConstraints;

@Service("appointment")
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentDao appointmentdao;

	@Autowired
	private ICustomerDao customerdao;

	@Autowired
	private ISalonServiceScheduleDao scheduledao;

	@Override
	public Appointment viewAppointmentById(int appId) throws AppointmentNotFoundException {

		Optional<Appointment> optappointment = appointmentdao.findById(appId);
		if (!optappointment.isPresent())
			throw new AppointmentNotFoundException(SalonConstraints.APPOINTMENT_NOT_FOUND + appId);
		return optappointment.get();
	}

	@Override
	public List<Appointment> viewAppointmentByCustomerId(int custId) throws AppointmentNotFoundException {

		List<Appointment> lst = appointmentdao.findByCustomerId(custId);
		if (lst.isEmpty())
			throw new AppointmentNotFoundException(SalonConstraints.NO_APPOINTMENT_FOUND_FOR_CUSTOMER_ID + custId);
		return lst;
	}

	@Override
	public Appointment viewAppointmentByScheduleId(int serviceScheduleId) throws AppointmentNotFoundException {

		Optional<Appointment> optappointment = appointmentdao.findById(serviceScheduleId);
		if (!optappointment.isPresent())
			throw new AppointmentNotFoundException(
					SalonConstraints.NO_APPOINTMENT_FOUND_FOR_SCHEDULE_ID + serviceScheduleId);
		return optappointment.get();

	}

	@Override
	public Integer addAppointment(AppointmentDto appdto)
			throws SalonServiceNotFoundException, CustomerNotFoundException, SalonServiceScheduleNotFoundException {

		Optional<Customer> optcust = customerdao.findById(appdto.getCustId());
		if (!optcust.isPresent())
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_FOUND);

		Optional<SalonServiceSchedule> optschedule = scheduledao.findById(appdto.getScheduleId());
		if (!optschedule.isPresent())
			throw new SalonServiceScheduleNotFoundException(SalonConstraints.SALON_SCHEDULE_NOT_EXIST);

		/*
		 * SalonServiceSchedule schedule = null; schedule =
		 * scheduledao.findByNoofappointments(appdto.getScheduleId())
		 * if(optschedule.filter(null))
		 */

		Appointment appointment = new Appointment();
		appointment.setAppointmentStatus(SalonConstraints.AVAILABLE);
		appointment.setPreferredDate(appdto.getPreferredDate());
		appointment.setCustomer(optcust.get());
		appointment.setSalonServiceSchedule(optschedule.get());
		Appointment savedAppointment = appointmentdao.save(appointment);
		return savedAppointment.getAppointmentId();

	}

	@Override
	@Transactional
	public boolean editAppointment(AppointmentDto appdto) throws SalonServiceNotFoundException,
			AppointmentNotFoundException, CustomerNotFoundException, SalonServiceScheduleNotFoundException {

		Optional<Appointment> optapp = appointmentdao.findById(appdto.getAppointmentId());
		if (!optapp.isPresent())
			throw new AppointmentNotFoundException(SalonConstraints.APPOINTMENT_NOT_FOUND);

		Optional<Customer> optcust = customerdao.findById(appdto.getCustId());
		if (!optcust.isPresent())
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_FOUND);

		Optional<SalonServiceSchedule> optschedule = scheduledao.findById(appdto.getScheduleId());
		if (!optschedule.isPresent())
			throw new SalonServiceScheduleNotFoundException(SalonConstraints.SALON_SCHEDULE_NOT_EXIST);

		Appointment appointment = optapp.get();
		appointment.setAppointmentStatus(appdto.getAppointmentStatus());
		appointment.setPreferredDate(appdto.getPreferredDate());

		Appointment persistedappointment = appointmentdao.save(appointment);
		return true;
	}

	@Override
	public boolean removeAppointment(int appointmentId) throws AppointmentNotFoundException {
		Appointment appointment = viewAppointmentById(appointmentId);
		if (appointment == null)
			throw new AppointmentNotFoundException(SalonConstraints.APPOINTMENT_DELETED);
		appointmentdao.delete(appointment);
		return true;
	}

	@Override
	public List<Appointment> viewAllAppointment() throws AppointmentNotFoundException {
		List<Appointment> lst = appointmentdao.findAll();
		if (lst.isEmpty()) {
			throw new AppointmentNotFoundException(SalonConstraints.APPOINTMENT_NOT_FOUND);
		}
		return lst;
	}

}
