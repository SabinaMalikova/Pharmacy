package service;

import models.Employee;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(Employee employee);
    String assignEmployeeToPharmacy(Long pharmacyId,Long employeeId);
    List<Employee> getAllEmployee(Long id);
    Employee getByIdEmployee(Long employeeId);
    String updateEmployeeById(Long pharmacyId,Long employeeId,Employee newEmployee);
    String deleteEmployeeById(Long pharmacyId,Long employeeId);

    List<Employee> filterEmployeeByPosition(String position);


}
