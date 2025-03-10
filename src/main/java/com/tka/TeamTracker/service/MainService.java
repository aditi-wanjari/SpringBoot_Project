package com.tka.TeamTracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.TeamTracker.dao.MainDao;
import com.tka.TeamTracker.entity.Country;
import com.tka.TeamTracker.entity.Employee;
import com.tka.TeamTracker.entity.Registration;

@Service
public class MainService {
   
	@Autowired
	MainDao dao;
    
	public String addCountry(Country c) {
		
	String msg=	dao.addCountry(c);
	
	if(Objects.isNull(msg)) {
		msg="Country not added successfully...";
	}
	return msg;
	}

	public String updateCountry(Country c,int cid) {
		 String msg=dao.updateCountry(c,cid);
		 
		 if(Objects.isNull(msg)) {
			 msg="Country not added successfully";
		 }
		return msg;
	}

	public String deleteCountry(int cid) {
		
		String msg=dao.deleteCountry(cid);
		 
		if(Objects.isNull(msg)) {
			msg="Country not found";
		}
		return msg;
	}

	public List<Country> getallCountry() {
		
		List<Country> list=dao.getallCountry();
		return list;
	}

	public Country getparticularCountrybyid(int cid) {
		Country c=dao.getparticularCountrybyid(cid);
		return c;
	}

	public String addEmployee(Employee emp) {
	 String msg=dao.addEmployee(emp);
		return msg;
	}

	public String updateEmployee(Employee emp, long id) {
		
		String msg=dao.updateEmployee(emp,id);
		return msg;
	}

	public String deleteEmployee(long id) {
		
		String msg=dao.deleteEmployee(id);
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
	List<Employee> list=dao.getAllEmployee();
		return list;
	}

	public Employee getParticularbyid(long id) {
		
		Employee emp=dao.getParticularbyid(id);
		return emp;
	}

	public Map loginApi(Registration rg) {
		
		Registration r1=dao.loginApi(rg);
		Map map=new HashMap();
		
		if(Objects.isNull(r1)) {
			map.put("msg", "Invalid User");
			map.put("user",r1);}
		else {
			map.put("msg","Valid User");
			map.put("user",r1);
		}
		return map;
	}

	public List<Employee> getList_Salary(double s1, double s2) {
		
	List<Employee>	list=dao.getList_Salary(s1,s2);
		return list;
	}

	public List<Employee> getList_status(String status) {
		List<Employee> list=dao.getList_status(status);
		return list ;
	}

	public String changeStatus(long id) {
		String msg=dao.changeStatus(id);
		return msg;
	}

}
