package org.launchcode.babySteps.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "changings")
public class ChangingLog extends AbstractEntity{
	
	private String contents;
	private Child child;
	private Date created;
	private Date modified;
	
	public ChangingLog() {}
	
	public ChangingLog(String contents, Child child) {
		
		super();
		
		this.contents = contents;
		this.child = child;
		this.created = new Date();
		this.updated();
		
		child.addChanging(this);
	}
	
	
	@NotNull
    @Column(name = "contents")
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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
