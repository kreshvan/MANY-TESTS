package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public Employee addEmployee(String firstName, String lastName){
        return employeeService.addEmployee(firstName,lastName, 30, 1);
    }

    @RequestMapping("/remove")
    public Employee removeEmployee(String firstName, String lastName){
        return employeeService.removeEmployee(firstName,lastName);
    }

    @RequestMapping("/find")
    public Employee findEmployee(String firstName, String lastName){
        return employeeService.findEmployee(firstName,lastName);
    }

    @RequestMapping("/fullEmployees")
    public Collection<Employee> fullEmployees(){
        return employeeService.fullEmployees();
    }

}
