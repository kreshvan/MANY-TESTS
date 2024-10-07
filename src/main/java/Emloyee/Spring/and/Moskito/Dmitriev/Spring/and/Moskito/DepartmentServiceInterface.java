package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    List<Employee>getEmployeesByDepartment(int departmentId );



    Long getSalarySumByDepartment(int departmentId);
     Long getSalaryMaxByDepartment(int departmentId);

   Long getSalaryMinByDepartment(int departmentId);

    Map<Integer, List<Employee>> getEmployeesGroupByDepartment();

}
