package com.sny.app.user;
import javax.persistence.*;
import com.sny.app.task.*;
import java.util.List;

@Entity
@Table(name="employee_table")
public class Employee  implements Comparable<Employee>
{  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	int id; // its a auto generated field  
	
    @Column
	String name ;
    
    @Column
	String empid;
	
    @OneToOne(cascade = CascadeType.ALL)
	Department dept;  // its a  class one to one   association  
	
    @OneToOne(cascade = CascadeType.ALL)
	Address address;  // its a class one to one association  
    
    @ManyToMany(cascade = CascadeType.ALL)
    List<Task> taskList ;
    
    public Employee(int id, String name, String empid, Department dept, Address address, List<Task> taskList) {
		super();
		this.id = id;
		this.name = name;
		this.empid = empid;
		this.dept = dept;
		this.address = address;
		this.taskList= taskList;
	}

	public Employee(String name, String empid) 
	{
		super();
		this.name = name;
		this.empid = empid;
	}
	
	public Employee()
	{
		//  empty constuctor
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTask(List<Task> task) {
		this.taskList = task;
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
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empid=" + empid + ", dept=" + dept + ", address=" + address
				+ ", task=" + taskList + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
	
      
}
