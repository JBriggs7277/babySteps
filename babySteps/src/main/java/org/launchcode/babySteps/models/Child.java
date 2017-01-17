package org.launchcode.babySteps.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "child")
public class Child extends AbstractEntity {

	private String name;
	private String sex;
	private String birthday;
	private User parent;
	
	private List<ChangingLog> changinglogs;
	private List<FeedingLog> feedinglogs;
	private List<MeasurementsLog> measurementslogs;
	private List<MedicationLog> medicationlogs;
	private List<EventLog> eventlogs;
	
	public Child() {}
	
	public Child(String name, String sex, String birthday, User parent) {
		
		super();
		
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.parent = parent;
	}
	
	@NotNull
	@Column(name = "name", unique = false)
	public String getName() {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	@NotNull
	@Column(name = "sex")
	public String getSex() {
		return sex;
	}
	
	public void setSex (String sex) {
		this.sex = sex;
	}
	
	@NotNull
	@Column(name = "birthday")
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday (String birthday) {
		this.birthday = birthday;
	}
	
	@ManyToOne
	public User getParent() {
		return parent;
	}
	
	@SuppressWarnings("unused")
	private void setParent(User parent) {
		this.parent = parent;
	}
	
	protected void addChanging(ChangingLog changinglog) {
		changinglogs.add(changinglog);
	}
	
	@OneToMany
    @JoinColumn(name = "child_uid")
    public List<ChangingLog> getChangingLogs() {
        return changinglogs;
    }
	
	public void setChangingLogs(List<ChangingLog> changinglogs) {
		this.changinglogs = changinglogs;
	}
	
	protected void addFeeding(FeedingLog feedinglog) {
		feedinglogs.add(feedinglog);
	}
	
	@OneToMany
    @JoinColumn(name = "child_uid")
    public List<FeedingLog> getFeedingLogs() {
        return feedinglogs;
    }
	
	public void setFeedingLogs(List<FeedingLog> feedinglogs) {
		this.feedinglogs = feedinglogs;
	}
	
	protected void addMeasurements(MeasurementsLog measurementslog) {
		measurementslogs.add(measurementslog);
	}
	
	@OneToMany
    @JoinColumn(name = "child_uid")
    public List<MeasurementsLog> getMeasurementsLogs() {
        return measurementslogs;
    }
	
	public void setMeasurementsLogs(List<MeasurementsLog> measurementslogs) {
		this.measurementslogs = measurementslogs;
	}
	
	protected void addEvent(EventLog eventlog) {
		eventlogs.add(eventlog);
	}
	
	@OneToMany
    @JoinColumn(name = "child_uid")
    public List<EventLog> getEventLogs() {
        return eventlogs;
    }
	
	public void setEventLogs(List<EventLog> eventlogs) {
		this.eventlogs = eventlogs;
	}
	
	protected void addMedication(MedicationLog medicationlog) {
		medicationlogs.add(medicationlog);
	}
	
	@OneToMany
    @JoinColumn(name = "child_uid")
    public List<MedicationLog> getMedicationLogs() {
        return medicationlogs;
    }
	
	public void setMedicationLogs(List<MedicationLog> medicationlogs) {
		this.medicationlogs = medicationlogs;
	}
}
