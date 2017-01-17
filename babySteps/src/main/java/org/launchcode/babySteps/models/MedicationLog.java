package org.launchcode.babySteps.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "medications")
public class MedicationLog extends AbstractEntity{
	
	private String medicine;
	private String dose;
	private Child child;
	private Date created;
	private Date modified;
	
	public MedicationLog() {}
	
	public MedicationLog(String medicine, String dose, Child child) {
		
		super();
		
		this.medicine = medicine;
		this.dose = dose;
		this.child = child;
		this.created = new Date();
		this.updated();
		
		child.addMedication(this);
	}
	
	
	@NotNull
    @Column(name = "medicine")
	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
		this.updated();
	}
	
	@NotNull
	@Column(name = "dose")
	public String getDose(){
		return dose;
	}
	
	public void setDose(String dose) {
		this.dose = dose;
		this.updated();
	}
	
	@ManyToOne
	public Child getChild() {
		return child;
	}
	
	@SuppressWarnings("unused")
	private void setChild(Child child) {
		this.child = child;
	}
	
	@NotNull
	@OrderColumn
	@Column(name = "created")
	public Date getCreated() {
		return created;
	}
	
	@SuppressWarnings("unused")
	private void setCreated(Date created) {
		this.created = created;
	}
	
	@NotNull
	@Column(name = "modified")
	public Date getModified() {
		return modified;
	}
	
	@SuppressWarnings("unused")
	private void setModified(Date modified) {
		this.modified = modified;
	}
	
	private void updated() {
		this.modified = new Date();
	}

}
