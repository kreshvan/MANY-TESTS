package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

import java.util.List;

public interface EmployeesService   {

    default Employee addEmployee(Employee employee){
       return addEmployee(employee.getLastName(),
                employee.getFirstName(),
                employee.getSalary(),
                employee.getDepartment());
    }
    default Employee removeEmployee(Employee employee){
        return addEmployee(employee.getLastName(),
                employee.getFirstName(),
                employee.getSalary(),
                employee.getDepartment());
    }
    default Employee findEmployee(Employee employee){
        return findEmployee(employee.getLastName(),
                employee.getFirstName());

    }








    Employee addEmployee(String firstName, String lastName, int i, int i1);

    Employee removeEmployee(String firstName, String lastName);



    List<Employee> fullEmployees();

    Employee findEmployee(String firsName, String lastName);
}






