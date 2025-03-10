package com.tka.TeamTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Registration {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	private String name;
	private String gender;
	private String emailid;
	private String password;
	
	


}
