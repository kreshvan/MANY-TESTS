


package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalLong;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface {
    private final EmployeesService employeeService;

    public DepartmentService(EmployeesService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeService.fullEmployees()
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartment()==departmentId)
                .toList();

    }

    @Override
    public Long getSalarySumByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .stream()
                .mapToLong(Employee::getSalary)
                .sum();
    }

    @Override
    public  Long getSalaryMaxByDepartment(int departmentId) {
        return  getEmployeesByDepartment(departmentId)
                .stream()
                .mapToLong(Employee::getSalary)
                .max()
                .orElseThrow();

    }

    @Override
    public Long getSalaryMinByDepartment(int departmentId) {
        return  getEmployeesByDepartment(departmentId)
                .stream()
                .mapToLong(Employee::getSalary)
                .min()
                .orElseThrow();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartment() {
        return employeeService.fullEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
