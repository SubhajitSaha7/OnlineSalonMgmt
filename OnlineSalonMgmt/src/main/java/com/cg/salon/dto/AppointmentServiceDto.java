package com.cg.salon.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;

import com.cg.salon.entity.Customer;
import com.cg.salon.entity.SalonServiceSchedule;

public class AppointmentDto {
	
	private Integer appointmentId;
	
	@FutureOrPresent(message = "Preferred Date must not be in the past")
	private LocalDate preferredDate;
	
	private Customer customer;

    private String timeSlots;
	
	private SalonServiceSchedule salonServiceSchedule;

    private Payment payment;
	
	private String appointmentStatus;

	public AppointmentDto() {
		super();
	}

	public AppointmentDto(Integer appointmentId, LocalDate preferredDate, Customer customer,String timeSlots,
			SalonServiceSchedule salonServiceSchedule,Payment payment,String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.preferredDate = preferredDate;
		this.customer = customer;
        this.timeSlots= timeSlots;
		this.salonServiceSchedule = salonServiceSchedule;
        this.payment= payment;
		this.appointmentStatus = appointmentStatus;
	}

	public Integer getAppointmentId()
	{
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) 
    {
		this.appointmentId = appointmentId;
	}

	public LocalDate getPreffeDate()
    {
		return preferredDate;
	}

	public void setPreffeDate(LocalDate preffeDate) 
    {
		this.preferredDate = preffeDate;
	}

	public Customer getCustomer() 
    {
		return customer;
	}

	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	}

    public String getTimeSlots()
    {
        return timeSlots;
    }

    public void setTimeSlots(String timeSlots)
    {
    	this.timeSlots = timeSlots;
    }

	public SalonServiceSchedule getSalonServiceSchedule() 
    {
		return salonServiceSchedule;
	}

	public void setSalonServiceSchedule(SalonServiceSchedule salonServiceSchedule)
    {
		this.salonServiceSchedule = salonServiceSchedule;
	}

    public Payment getPayment()
	{
		return payment;
	}

    public void setPayment(Payment payment)
	{
		this.payment=payment;
	}

	public String getAppointmentStatus() 
	{
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) 
	{
		this.appointmentStatus = appointmentStatus;
	}
	
}
