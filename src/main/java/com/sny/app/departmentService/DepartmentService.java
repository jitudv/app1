package com.sny.app.departmentService;
import java.util.List;

import com.sny.app.user.*;

public interface DepartmentService 
{
   public void addDepartment(Department dept);
   public void deleteDepartment(int id);
   public void updateDepartment(Department dept);
   public Department getDepartmentByid(int id);
   public List<Department> departments();
}
