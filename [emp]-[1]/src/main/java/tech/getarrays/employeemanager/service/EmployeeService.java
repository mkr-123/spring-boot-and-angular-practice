package tech.getarrays.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

@Component
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo ;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id)
	{
		return  employeeRepo.findEmployeedById(id).
				orElseThrow(()-> new UserNotFoundException("User by Id"+id));  
	}
	
	public void deleteEmployee(Long id)
	{
		employeeRepo.deleteById(id);
	}

}
