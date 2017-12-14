package net.metrosystems.danutdumitru.pontaj.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PontajEntry {

	@ Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long id;
	
	private Timestamp  dateStart, dateEnd;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDateStart() {
		return dateStart;
	}

	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}

	public Timestamp getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String toString() {
		return "PontajEntry [id=" + id + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + "]";
	}

	public PontajEntry(long id, Timestamp dateStart, Timestamp dateEnd) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	public PontajEntry(Timestamp dateStart, Timestamp dateEnd) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	public PontajEntry()
	{
		//needed by JPA
	}
	
}
