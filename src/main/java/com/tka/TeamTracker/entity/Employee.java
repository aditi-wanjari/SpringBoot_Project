package com.tka.TeamTracker.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String gender;
	private String mobileno;
	private String department;
	private String status;
	private String emailid;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Country country;
	
	

}
