package com.sny.app.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sny.app.departmentService.DepartmentService;
import com.sny.app.employeeService.EmployeeService;
import com.sny.app.payload.ApiResponse;
import com.sny.app.roleModule.RoleService;
import com.sny.app.user.Employee;
import com.sny.app.user.Role;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4100"})
@RestController
public class EmployeeController 
{
	
  Log log = LogFactory.getLog(EmployeeController.class);
	
    
   @Autowired
   EmployeeService eservice;
   
   
   
   @Autowired
   DepartmentService dser; 
    
   
   
   @Autowired
   RoleService rs;
   
   
   
   @GetMapping(value="/user/employee/{id}")
   ResponseEntity<Employee> getEmployee(@PathVariable("id") int id )
   {   
	   // url must be  http://localhost:8001/employee/5
	   return ResponseEntity.ok(eservice.getEmployee(id));
   }
   
   @GetMapping(value="/admin/empnameid")
   public ResponseEntity<List<Object>>  getEmployeeIdName()
   {
	   return ResponseEntity.ok().body(eservice.getEmployeeNameAndId());
   }
   
   @PostMapping(value="/employee/{deptid}")
   ResponseEntity<String> empSave(@RequestBody Employee emp , @PathVariable("deptid") int deptid)
   {   
	   // web service store the employee to  database using  url  http://pc1:8001/employee/{dept} 
	     emp.setDept(dser.getDepartmentByid(deptid));
         List<Role> role = new ArrayList<Role>();
	     role.add(new Role("USER"));
 	     emp.setRoles(role);
	     eservice.addEmploye(emp);
	     log.info("this is employee \t "+emp);
	     return ResponseEntity.ok("your employee store at database "+emp.getEmail());
	     
 }
   
   @GetMapping(value="/admin/employee" , produces = MediaType.APPLICATION_JSON_VALUE)
   @JsonIgnore
   public ResponseEntity<List<Employee>> emplist()
   {   
	   // url must be  http://locahost:8001/admin/employee/
	   return ResponseEntity.ok(eservice.getEmployees());
   }
   
   @PutMapping(value="/user/employee/{id}")
   public ResponseEntity<String> updateEmployee(@RequestBody Employee ee ,@PathVariable("id")int id)
   {   Employee e = eservice.getEmployee(id);
	   e.setAddress(ee.getAddress());
	   e.setName(ee.getName());
	   e.setEmpid(ee.getEmpid());
	   e.setDept(ee.getDept());
	   eservice.updateEmployee(e);
	   return ResponseEntity.ok("you employee updated "+e.getId());
    }
   
   @DeleteMapping(value="/admin/employee/{id}")
   public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id)
   {     // url must be  http://localhost:8001/employee/{id} 
	    eservice.deleteEmployee(id);
	   return ResponseEntity.ok("employee deleted"+eservice.getEmployee(id).getEmpid());
   }
   
   @PatchMapping("/admin/create/admin/{uid}")
   public ResponseEntity<ApiResponse> createAdmin(@PathVariable("uid") int id )
   {
      if(eservice.createAdmin(id) > 0 )
      {
         return  ResponseEntity.ok().body(new ApiResponse(200,"admin add",null ," ",false));
      }
      return  ResponseEntity.ok().body(new ApiResponse(500,"did not created admin",null ,"sometime went wrong ",false));
   }
   
}
