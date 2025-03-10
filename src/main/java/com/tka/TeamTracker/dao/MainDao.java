package com.tka.TeamTracker.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.TeamTracker.entity.Country;
import com.tka.TeamTracker.entity.Employee;
import com.tka.TeamTracker.entity.Registration;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		 
		Session session=null;
		Transaction trans=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			trans=session.beginTransaction();
			session.persist(c);
			trans.commit();
			msg="Country added successfully..";
			
		}catch(Exception e) {
			
			if(trans!=null) {
				trans.rollback();
				
			}e.printStackTrace();
			
		}finally {
			if(session!=null)
				session.close();
			
		}
		
		
		return msg;
	}

	public String updateCountry(Country c, int cid) {
	 
		Session session=null;
		Transaction trans=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			trans=session.beginTransaction();
		    Country c1 =session.get(Country.class,cid);
		    c1.setCname(c.getCname());
		    session.merge(c1);
		    trans.commit();
		    msg="Country updated Succesfully";
		}catch(Exception e) {
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return msg;
	}

	public String deleteCountry(int cid) {
		
		 Session session=null;
		 Transaction trans=null;
		 String msg=null;
		 
		 try {
			 
			 session=factory.openSession();
			 trans=session.beginTransaction();
			 Country country=session.get(Country.class,cid);
			 session.remove(country);
			 trans.commit();
			 msg="Country deleted successfully";
		 }catch(Exception e) {
			 if(trans!=null) {
				 trans.rollback();
			 }
			 e.printStackTrace();
		 }
			 finally {
				 if(session!=null)
					 session.close();
			 }
			 
		 return msg;
	}

	public List<Country> getallCountry() {
		
		 Session session=null;
		 Transaction trans=null;
		 String msg=null;
		 List<Country> list=null;
		 String hqlquery="from Country";
		 
		 try {
			 
			 session=factory.openSession();
			 trans=session.beginTransaction();
			 Query<Country> query=session.createQuery(hqlquery,Country.class);
			 
			 list=query.list();
			 trans.commit();
		 }catch(Exception e) {
			 if(trans!=null) {
				 trans.rollback();
			 }
			 e.printStackTrace();
		 }finally {
			 if(session!=null)
				 session.close();
		 }
		return list;
	}

	public Country getparticularCountrybyid(int cid) {
		
		 Session session=null;
		 Transaction trans=null;
		 
	     Country con=null;
		 
           try {
			 
			 session=factory.openSession();
			 trans=session.beginTransaction();
			 con = session.get(Country.class,cid);
			 trans.commit();
           }catch(Exception e) {
	        if(trans!=null) {
		    trans.rollback();
	         }
	        e.printStackTrace();
            }finally {
	        if(session!=null)
		      session.close();
              }
	      
		return con;
	       }

	public String addEmployee(Employee emp) {
		
		Session session=null;
		Transaction trans=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			trans=session.beginTransaction();
			session.persist(emp);
			trans.commit();
			msg="Employee added succesfully";
		}catch(Exception e) {
			if(trans!=null) {
				trans.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return msg;
	}

	public String updateEmployee(Employee emp, long id) {
		
		Session session=null;
		Transaction trans=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			trans=session.beginTransaction();
		    Employee e1 =session.get(Employee.class,id);
		    e1.setName(emp.getName());
		    e1.setCountry(emp.getCountry());
		    e1.setDepartment(emp.getDepartment());
		    e1.setEmailid(emp.getEmailid());
		    e1.setMobileno(emp.getMobileno());
		    e1.setSalary(emp.getSalary());
		    e1.setStatus(emp.getStatus());
		    e1.setUpdatedBy(emp.getUpdatedBy());
		    e1.setUpdatedDate(emp.getUpdatedDate());
		    e1.setGender(emp.getGender());
		    session.merge(e1);
		    trans.commit();
		    msg="Employee updated Succesfully";
		}catch(Exception e) {
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return msg;
		
	
	}

	public String deleteEmployee(long id) {
		
		Session session=null;
		Transaction trans=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			trans=session.beginTransaction();
			Employee e1=session.get(Employee.class,id);
			session.remove(e1);
			msg="Employee deleted successfully";
			trans.commit();
		}catch(Exception e) {
			if(trans!=null) {
				trans.rollback();
		}e.printStackTrace();
		}
			finally {
			if(session!=null)
				session.close();
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
		Session session=null;
		Transaction trans=null;
		List<Employee> list=null;
		String hqlquery="from Employee";
		try {
			session=factory.openSession();
			trans=session.beginTransaction();
			Query<Employee> query=session.createQuery(hqlquery,Employee.class);
			list=query.list();
			trans.commit();
			
			}catch(Exception e) {
				if(trans!=null) {
					trans.rollback();
				}e.printStackTrace();
			}finally {
				if(session!=null)
					session.close();
			}
		return list;
	}

	public Employee getParticularbyid(long id) {
		
		 Session session=null;
		 Transaction trans=null;
		 Employee emp=null;
		 
		 try {
			 
			 session=factory.openSession();
			 trans=session.beginTransaction();
			 emp=session.get(Employee.class,id);
			 trans.commit();
		 }catch(Exception e) {
			 if(trans!=null) {
				 trans.rollback();
			 }e.printStackTrace();
		 }finally {
			 if(session!=null)
				 session.close();
		 }
		
		return emp;
	}

	public Registration loginApi(Registration rg) {
		
		Session session=null;
		Transaction trans=null;
		String hqlquery="from Registration where emailid=:emailid and password=:password";
		Registration r1=null;
		
		try {
			session=factory.openSession();
			trans=session.beginTransaction();
			Query<Registration> query=session.createQuery(hqlquery, Registration.class);
			query.setParameter("emailid",rg.getEmailid());
			query.setParameter("password",rg.getPassword());
			r1=query.uniqueResult();
			trans.commit();
			
		}catch(Exception e) {
			if(trans!=null) {
				trans.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return r1;
	}

	public List<Employee> getList_Salary(double s1, double s2) {
		
		Session session=null;
		Transaction trans=null;
		String hqlqury="from Employee where salary between :s1 and :s2";
		List<Employee> list=null;
		
		try {
			session=factory.openSession();
			trans=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlqury, Employee.class);
			query.setParameter("s1", s1);
			query.setParameter("s2",s2);
			list=query.list();
			trans.commit();
		}catch(Exception e) {
			if(trans!=null) {
				trans.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null);
			session.close();
		}
		return list;
	}

	public List<Employee> getList_status(String status) {
		
		Session session=null;
		Transaction trans=null;
		String hqlqury="from Employee where status=:status";
		List<Employee> list=null;
		
		try {
			session=factory.openSession();
			trans=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlqury, Employee.class);
			query.setParameter("status",status);
			list=query.list();
			trans.commit();
		}catch(Exception e) {
			if(trans!=null) {
				trans.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null);
			session.close();
		}
		return list;
	
	}

	public String changeStatus(long id) {
	
		Session session=null;
		Transaction trans=null;
		String msg=null;
		Employee emp=null;
		try {
			
			session=factory.openSession();
			trans=session.beginTransaction();
			
			emp=session.get(Employee.class,id);
			
			if(emp.getStatus().equals("active")) {
				emp.setStatus("Inactive");
				msg="Status was active and now successfully changed to inactive";
				
			}else if(emp.getStatus().equals("Inactive")) {
				emp.setStatus("active");
				msg="Status was inactive and now successfully changed to active";
			 }else{
				msg="Employee is suspended";
			}
			
	    	session.merge(emp);
	    	trans.commit();
		
			}catch(Exception e) {
				if(trans!=null) {
					trans.rollback();
				}e.printStackTrace();
			}finally {
				if(session!=null)
					session.close();
			}
		return msg;
	}
	
    }
