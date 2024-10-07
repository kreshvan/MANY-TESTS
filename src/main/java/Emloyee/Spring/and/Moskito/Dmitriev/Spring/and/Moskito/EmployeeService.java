package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Component
public class EmployeeService implements EmployeesService {
    private static int MaxEmployees = 1000;
   private final List<Employee> employeesList = new ArrayList<>();

    @Override
    public Employee addEmployee(String firsName, String lastName, int i, int i1) {
        Employee employee = new Employee(lastName, firsName, 30, 1);
        if (employeesList.size() > MaxEmployees) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников!");
        }
        if (employeesList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
        employeesList.add(employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String firsName, String lastName) {
        Employee employee = new Employee(lastName, firsName, 30, 1);
        if (employeesList.contains(employee)) {
            employeesList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("EmployeeNotFoundException");
    }

    @Override
    public List<Employee> fullEmployees() {
        return Collections.unmodifiableList(employeesList) ;
    }

    @Override
    public Employee findEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName, 30, 1);
        if (employeesList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("EmployeeNotFoundException");
    }






}
