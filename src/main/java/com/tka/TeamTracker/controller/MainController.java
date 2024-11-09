package com.tka.TeamTracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.TeamTracker.entity.Country;
import com.tka.TeamTracker.entity.Employee;
import com.tka.TeamTracker.service.MainService;

@RestController
@RequestMapping("API")
public class MainController {
	
	@Autowired
	MainService service;
	
	@PostMapping("addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c) {
		
		String msg= service.addCountry(c);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateCountry/{cid}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c,@PathVariable int cid) {
		
		String msg=service.updateCountry(c,cid);
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteCountry/{cid}")
	public ResponseEntity<String> deleteCountry(@PathVariable int cid){
		
		String msg=service.deleteCountry(cid);
		return ResponseEntity.ok(msg);
		
	}
	
	@GetMapping("getallCountry")
	public ResponseEntity<List<Country>> getallCountry(){
		List<Country> list=service.getallCountry();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(" /{cid}")
	public ResponseEntity<Country> getparticularCountrybyid(@PathVariable int cid){
		Country c=service.getparticularCountrybyid(cid);
		return ResponseEntity.ok(c);
	}
	
	@PostMapping("addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
		
		String msg=service.addEmployee(emp);
		return ResponseEntity.ok(msg);
		
	}
	
	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp,@PathVariable long id){
		
		String msg=service.updateEmployee(emp,id);
		return ResponseEntity.ok(msg);
		
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id){
		
		String msg=service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
		
		
	}
	
	@GetMapping("getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> list=service.getAllEmployee();
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("getParticularEmployee/{id}")
	public ResponseEntity<Employee> getParticularbyid(@PathVariable long id){
		
		Employee emp=service.getParticularbyid(id);
		return ResponseEntity.ok(emp);
		
	}
	
	@PostMapping("loginAPI")
	public ResponseEntity<Map> loginApi(@RequestBody Employee emp){
		
		Map map=service.loginApi(emp);
		return ResponseEntity.ok(map);
		
	}
	
	@GetMapping("getList_Salary/{s1}/{s2}")
	public ResponseEntity<List<Employee>> getList_Salary(@PathVariable double s1,@PathVariable double s2){
		
	 List<Employee> list=service.getList_Salary(s1,s2);
	 return ResponseEntity.ok(list);
	}
	
	@GetMapping("getList_status/{status}")
	public ResponseEntity<List<Employee>> getList_status(@PathVariable String status){
		
		List<Employee> list=service.getList_status(status);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("changedStatus/{id}")
	public ResponseEntity<String> changeStatus(@PathVariable long id) {
		
		String msg=service.changeStatus(id);
			return ResponseEntity.ok(msg);
			
		
	}
}
