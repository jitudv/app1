package com.sny.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sny.app.departmentService.DepartmentService;
import com.sny.app.user.Department;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4100"})
@RestController
public class DepartmentController {
  
	
	@Autowired
	DepartmentService dse;
	
	 @GetMapping(value="/department/{id}")
	public ResponseEntity<Department> getDepartent(@PathVariable int id)
	{  // wil return  single department object based on the  id  
	   return ResponseEntity.ok(dse.getDepartmentByid(id));
	}
	
	
	@PostMapping(value="/admin/department")
	public ResponseEntity<String> addDepartment(@RequestBody Department dept)
	{   // add department  in database  
		dse.addDepartment(dept);
		
		return ResponseEntity.ok(" emplolyee save ");
	}
	
	@PutMapping(value="/admin/department/{id}")
	public ResponseEntity<String> updateDepartment(@RequestBody Department dept, @PathVariable("id") int id	)
	{   // update department   
		Department d = dse.getDepartmentByid(id);
		d.setName(dept.getName());
		dse.addDepartment(d);
		return ResponseEntity.ok("department updated "+d.getId());
	}
	
	
	@DeleteMapping(value="/admin/department/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") int id) {
		 // will delete the department  based on the  id   
		 dse.deleteDepartment(id);
		 return ResponseEntity.ok("department deleted ");
	}
	
	
	@GetMapping(value ="/department")
	public ResponseEntity<List<Department>> getAllDepartments()
	{ 
		// return all the department  url must be http://localhost:8001/department
		return ResponseEntity.ok(dse.departments());
	}
	
	
}
