package net.metrosystems.danutdumitru.pontaj.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import net.metrosystems.danutdumitru.pontaj.domain.PontajEntry;

//clasa cu toate detaliile unui intrari de Pontaj
public class PontajEntryDetails extends PontajEntry{

	private String dayName;
	private String day, hourStart, hourEnd;
	private long differenceMinutes;
	@Override
	public String toString() {
		return "PontajEntryDetails [dayName=" + dayName + ", hourStart=" + hourStart + ", hourEnd=" + hourEnd
				+ ", differenceMinutes=" + differenceMinutes + "]";
	}
	public String getDayName() {
		return dayName;
	}

	public String getHourStart() {
		return hourStart;
	}

	public String getHourEnd() {
		return hourEnd;
	}

	public long getDifferenceMinutes() {
		return differenceMinutes;
	}

	
	public PontajEntryDetails(long id, Timestamp dateStart, Timestamp dateEnd) {
		super(id, dateStart, dateEnd);
		
		LocalDateTime dStart = dateStart.toLocalDateTime();
		LocalDateTime dEnd = dateEnd.toLocalDateTime();
		this.day = String.format("%02d.%02d.%04d",dStart.getDayOfMonth() , dStart.getMonthValue(),  dStart.getYear());
		this.dayName = dStart.getDayOfWeek().name();
		this.hourStart = String.format("%02d:%02d" , dStart.getHour(), dStart.getMinute()); 
		this.hourEnd = String.format("%02d:%02d" , dEnd.getHour(), dEnd.getMinute()); 
		
		this.differenceMinutes = dStart.until(dEnd, ChronoUnit.MINUTES) 
					- ( (dStart.getDayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0 )?390:540);
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public PontajEntryDetails(PontajEntry pontajEntry) {
		this(pontajEntry.getId(), pontajEntry.getDateStart(), pontajEntry.getDateEnd());
		
	}
}
