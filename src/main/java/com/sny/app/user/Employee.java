package com.sny.app.user;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sny.app.task.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="employee_master")
public class Employee  implements Comparable<Employee>
{  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
	int id; // its a auto generated field  
	
	@Column
	String dob;
	 
	 
    @Column(name="emp_name")
	String name ;
    
    @Column
    String lastname;
    
   
    @Column //(columnDefinition = "varchar(20) default 'emp101'; ")
	String empid;
    
    @Column
    String password;
    
    @Column(unique = true,nullable = false )
    @Email
    String email;
    
    @Column
    String gender;
    
   
    @OneToMany(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)  // roles  of the user  its one to many association  
    @Fetch(value=FetchMode.SUBSELECT)
    List<Role> roles;   
    
    @OneToOne (cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name="department_id")
	Department department;   // its a  class one to one   association     
	
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name="address_id")
	Address address;  // its a class one to one association  
    
    
        @ManyToMany(cascade = CascadeType.PERSIST , fetch=FetchType.EAGER)
        @JoinTable(name = "employee_task",
    	joinColumns = { @JoinColumn(name = "employee_id") },
    	inverseJoinColumns = { @JoinColumn(name = "task_id") })
        Set<Task> tasks;  //  tasks for the every employee and  its  a many to many association   one employee can have multiple task and  and signle task can assign to multiple employee  
    
    public Employee(int id, String name, String lastname, String empid, String password, @Email String email,
		String gender, String  dob, List<Role> roles, Department department, Address address, Set<Task> taskList) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.empid = empid;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.roles = roles;
		this.department = department;
		this.address = address;
		this.tasks = taskList;
	}


	public Employee(String name, String empid ,String pass, String email,List<Role> roles) 
	{
		super();
		this.password=pass;
		this.email=email;
		this.name = name;
		this.empid = empid;
		this.roles=roles;
	}
	
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob =dob;
	}


	public Employee()
	{
		//  empty constuctor
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setTaskList(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	@JsonIgnore
	public Set<Task> getTaskList() {
		return tasks;
	}

	public void setTask(Set<Task> task) {
		this.tasks = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid)
	{
		this.empid = empid;
	}

	public Department getDept() {
		return department;
	}

	public void setDept(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastname=" + lastname + ", empid=" + empid + ", password="
				+ password + ", email=" + email + ", gender=" + gender + ", dob is \t=" + dob + ", roles="
				+ roles + ", dept=" + department + ", address=" + address + ", taskList=" + tasks + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
	
}
