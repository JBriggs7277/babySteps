package org.launchcode.babySteps.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "events")
public class EventLog extends AbstractEntity{
	
	private String title;
	private String body;
	private Child child;
	private Date created;
	private Date modified;
	
	public EventLog() {}
	
	public EventLog(String title, String body, Child child) {
		
		super();
		
		this.title = title;
		this.body = body;
		this.child = child;
		this.created = new Date();
		this.updated();
		
		child.addEvent(this);
	}
	
	
	@NotNull
    @Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.updated();
	}
	
	@NotNull
	@Column(name = "body")
	public String getBody(){
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
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
