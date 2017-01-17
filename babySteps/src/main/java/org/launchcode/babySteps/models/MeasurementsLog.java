package org.launchcode.babySteps.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "measurements")
public class MeasurementsLog extends AbstractEntity{
	
	private String height;
	private String weight;
	private Child child;
	private Date created;
	private Date modified;
	
	public MeasurementsLog() {}
	
	public MeasurementsLog(String height, String weight, Child child) {
		
		super();
		
		this.height = height;
		this.weight = weight;
		this.child = child;
		this.created = new Date();
		this.updated();
		
		child.addMeasurements(this);
	}
	
	
	@NotNull
    @Column(name = "height")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
		this.updated();
	}
	
	@NotNull
	@Column(name = "weight")
	public String getWeight(){
		return weight;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
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
