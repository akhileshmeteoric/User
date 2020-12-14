package com.usersbooking.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mynt6
 *
 */
@Entity
public class UserOfferings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	long id;

	@Column
	long userid;

	@Column
	long offeringid;	

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Date createdate;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getOfferingid() {
		return offeringid;
	}

	public void setOfferingid(long offeringid) {
		this.offeringid = offeringid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	
}
