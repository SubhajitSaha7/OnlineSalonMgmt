package com.cg.salon.dto;
import java.time.LocalDate;



import com.cg.salon.entity.SalonService;
public class SalonServiceScheduleDto {
	private Integer serviceScheduleId;
	private Integer noofappointments;
	private LocalDate scheduleDate;
	private String slot;
	private SalonService salonService;
	public SalonServiceScheduleDto()
	{
		
	}
	public SalonServiceScheduleDto(Integer serviceScheduleId, Integer noofappointments, LocalDate scheduleDate,
			String slot, SalonService salonService) {
		super();
		this.serviceScheduleId = serviceScheduleId;
		this.noofappointments = noofappointments;
		this.scheduleDate = scheduleDate;
		this.slot = slot;
		this.salonService = salonService;
	}
	public Integer getServiceScheduleId() {
		return serviceScheduleId;
	}
	public void setServiceScheduleId(Integer serviceScheduleId) {
		this.serviceScheduleId = serviceScheduleId;
	}
	public Integer getNoofappointments() {
		return noofappointments;
	}
	public void setNoofappointments(Integer noofappointments) {
		this.noofappointments = noofappointments;
	}
	public LocalDate getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public SalonService getSalonService() {
		return salonService;
	}
	public void setSalonService(SalonService salonService) {
		this.salonService = salonService;
	}
	
}
