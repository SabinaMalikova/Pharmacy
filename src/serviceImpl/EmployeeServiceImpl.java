package serviceImpl;

import dataBase.DataBase;
import enums.Position;
import models.Employee;
import models.MyException;
import models.Pharmacy;
import service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String saveEmployee(Employee employee) {
        DataBase.employees.add(employee);
        return "успешно добавлен";
    }

    @Override
    public String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    for (Employee employee : DataBase.employees) {
                        if (employee.getId() == employeeId) {
                            pharmacy.getEmployees().add(employee);
                            return "Сотрудник " + employee.getFullName() + " успешно назначен в аптеку";
                        }
                    }
                    throw new MyException("Сотрудник с указанным ID не найден");
                }
            }
            throw new MyException("Аптека с указанным ID не найдена");
        } catch (MyException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Employee> getAllEmployee(Long id) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies){
                if (pharmacy.getId()==id){
                    return pharmacy.getEmployees();
                }
            }
            throw new MyException("Аптека с указанным ID не найдена");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Employee getByIdEmployee( Long employeeId) {
        try {
            for (Employee employee : DataBase.employees){
                if (employee.getId()==employeeId){
                    return employee;
                }
            }
            throw new MyException("сотрудник с таким ID не найден");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateEmployeeById(Long pharmacyId, Long employeeId, Employee newEmployee) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    try {
                        for (int i = 0; i < pharmacy.getEmployees().size(); i++) {
                            Employee employee = pharmacy.getEmployees().get(i);
                            if (employee.getId() == employeeId) {
                                pharmacy.getEmployees().set(i, newEmployee);
                                return "успешно обновлен";
                            }
                        }
                        throw new MyException("сотрудник с таким ID не найден");
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteEmployeeById(Long pharmacyId, Long employeeId) {
        try {
            for (Pharmacy pharmacy : DataBase.pharmacies) {
                if (pharmacy.getId() == pharmacyId) {
                    try {
                        for (Employee employee : pharmacy.getEmployees()) {
                            if (employee.getId() == employeeId) {
                                pharmacy.getEmployees().remove(employee);
                                return "успешно удален";
                            }
                        }
                        throw new MyException("сотрудник с таким ID не найден");
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            throw new MyException("аптека с таким ID не найдена");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> filterEmployeeByPosition(String position) {
        List<Employee> admins = new ArrayList<>();
        List<Employee> pharmacists = new ArrayList<>();
        List<Employee> tellers = new ArrayList<>();
        if (position.equals("1")) {
            for (Employee employee : DataBase.employees) {
                if (employee.getPosition().equals(Position.ADMIN)) {
                    admins.add(employee);
                }
            }
            return admins;
        } else if (position.equals("2")) {
            for (Employee employee : DataBase.employees) {
                if (employee.getPosition().equals(Position.PHARMACIST)) {
                    pharmacists.add(employee);
                }
            }
            return pharmacists;
        } else if (position.equals("3")) {
            for (Employee employee : DataBase.employees) {
                if (employee.getPosition().equals(Position.TELLER)) {
                    tellers.add(employee);
                }
            }
            return tellers;
        }
        return null;
    }
}

