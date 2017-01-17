package org.launchcode.babySteps.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "feedings")
public class FeedingLog extends AbstractEntity{
	
	private String food;
	private String burps;
	private String ounces;
	private Child child;
	private Date created;
	private Date modified;
	
	public FeedingLog() {}
	
	public FeedingLog(String food, String burps, String ounces, Child child) {
		
		super();
		
		this.food = food;
		this.burps = burps;
		this.ounces = ounces;
		this.child = child;
		this.created = new Date();
		this.updated();
		
		child.addFeeding(this);
	}
	
	
	@NotNull
    @Column(name = "food")
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
		this.updated();
	}
	
	@NotNull
	@Column(name = "burps")
	public String getBurps(){
		return burps;
	}
	
	public void setBurps(String burps) {
		this.burps = burps;
		this.updated();
	}
	
	@NotNull
	@Column(name = "ounces")
	public String getOunces(){
		return ounces;
	}
	
	public void setOunces(String ounces) {
		this.ounces = ounces;
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
