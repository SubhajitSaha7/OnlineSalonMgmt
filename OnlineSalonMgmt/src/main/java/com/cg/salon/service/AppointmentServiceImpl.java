package com.cg.salon.service;

import java.time.LocalDate;
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
import com.cg.salon.exceptions.AppointmentCancelException;
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
			throws SalonServiceNotFoundException, CustomerNotFoundException, SalonServiceScheduleNotFoundException,
			AppointmentNotFoundException, AppointmentCancelException {

		Optional<Customer> optcust = customerdao.findById(appdto.getCustId());
		if (!optcust.isPresent())
			throw new CustomerNotFoundException(SalonConstraints.CUSTOMER_NOT_FOUND);

		Optional<SalonServiceSchedule> optschedule = scheduledao.findById(appdto.getScheduleId());
		if (!optschedule.isPresent())
			throw new SalonServiceScheduleNotFoundException(SalonConstraints.SALON_SCHEDULE_NOT_EXIST);

		SalonServiceSchedule schedule = optschedule.get();
		if (schedule.getScheduleStatus().equals(SalonConstraints.CANCELLED))
			throw new AppointmentCancelException(SalonConstraints.SCHEDULE_CANCELLED);
		if (schedule.getNoofappointments() <= SalonConstraints.ZERO)
			throw new AppointmentNotFoundException(SalonConstraints.SCHEDULE_SLOT_FULL);

		Appointment appointment = new Appointment();
		appointment.setAppointmentStatus(SalonConstraints.AVAILABLE);
		appointment.setPreferredDate(appdto.getPreferredDate());
		appointment.setCustomer(optcust.get());
		appointment.setSalonServiceSchedule(optschedule.get());
		Appointment savedAppointment = appointmentdao.save(appointment);
		schedule.setNoofappointments(schedule.getNoofappointments() - SalonConstraints.ONE);
		scheduledao.save(schedule);
		return savedAppointment.getAppointmentId();

	}

	@Override
	@Transactional
	public boolean cancelAppointment(int appid) throws SalonServiceNotFoundException, AppointmentNotFoundException,
			CustomerNotFoundException, SalonServiceScheduleNotFoundException, AppointmentCancelException {

		Optional<Appointment> optapp = appointmentdao.findById(appid);
		if (!optapp.isPresent())
			throw new AppointmentNotFoundException(SalonConstraints.APPOINTMENT_NOT_FOUND);

		Appointment appointment = optapp.get();
		if (appointment.getPreferredDate().isBefore(LocalDate.now())
				|| appointment.getPreferredDate().isEqual(LocalDate.now()))
			throw new AppointmentCancelException(SalonConstraints.APPOINTMENT_NOT_CANCELLED);
		appointment.setAppointmentStatus(SalonConstraints.APPOINTMENT_CANCELLED);

		appointmentdao.save(appointment);
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
