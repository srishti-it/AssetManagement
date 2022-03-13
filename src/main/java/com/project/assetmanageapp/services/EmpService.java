/*
 * package com.project.assetmanageapp.services;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.project.assetmanageapp.dao.Empdao; import
 * com.project.assetmanageapp.entities.Employee;
 * 
 * @Service public class EmpService {
 * 
 * @Autowired private Empdao empDao; public Employee createEmp(Employee
 * employee) { return empDao.save(employee); }
 * 
 * public List<Employee> createEmp(List<Employee> employees) { return
 * empDao.saveAll(employees); }
 * 
 * public Employee getEmpById(int id) { return empDao.findById(id).orElse(null);
 * }
 * 
 * public List<Employee> getEmployees() { return empDao.findAll(); }
 * 
 * public Employee updateEmp(Employee employee) { Optional<Employee>
 * optionalEmp=empDao.findById(employee.getId()); Employee oldEmp=null;
 * if(optionalEmp.isPresent()) { oldEmp=optionalEmp.get();
 * oldEmp.setName(employee.getName()); oldEmp.setId(employee.getId());
 * oldEmp.setDesign(employee.getDesign()); empDao.save(oldEmp); } else { return
 * new Employee(); }
 * 
 * return oldEmp; }
 * 
 * public String removeEmpById(int id) { empDao.deleteById(id); return
 * "User got deleted"; } }
 */