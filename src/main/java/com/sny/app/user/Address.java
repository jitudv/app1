package com.sny.app.user;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="address_table")
public class Address  implements Comparable<Address>
{  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id ;  //  auto generated so dont need to sent by client 

    @Column
    String house;
    
    @Column
    String colony;
    
   @Column
   String city ;
   
   @Column
   String  pin;
   
   
public Address(String city, String pin,String houseno,String colony) 
{
	super();
	this.city = city;
	this.pin = pin;
	this.house=houseno;
	this.colony=colony;
}
public String getHouse() {
	return house;
}
public void setHouse(String house) {
	this.house = house;
}
public String getColony() {
	return colony;
}
public void setColony(String colony) {
	this.colony = colony;
}
public Address() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPin() {
	return pin;
}
public void setPin(String pin) {
	this.pin = pin;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((colony == null) ? 0 : colony.hashCode());
	result = prime * result + ((house == null) ? 0 : house.hashCode());
	result = prime * result + id;
	result = prime * result + ((pin == null) ? 0 : pin.hashCode());
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
	Address other = (Address) obj;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (colony == null) {
		if (other.colony != null)
			return false;
	} else if (!colony.equals(other.colony))
		return false;
	if (house == null) {
		if (other.house != null)
			return false;
	} else if (!house.equals(other.house))
		return false;
	if (id != other.id)
		return false;
	if (pin == null) {
		if (other.pin != null)
			return false;
	} else if (!pin.equals(other.pin))
		return false;
	return true;
}
@Override
public String toString() {
	return "Address [id=" + id + ", house=" + house + ", colony=" + colony + ", city=" + city + ", pin=" + pin + "]";
}
@Override
public int compareTo(Address o) {
	// TODO Auto-generated method stub
	return this.id-o.id;
}
     
}
