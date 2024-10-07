

package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)//это говорит о заглушках
public class DepartmentServiceTest {

    private static final Random RANDOM = new Random();
    private static final Collection<Employee> employeeList = List.of(
            new Employee("w", "w", 10, 1));


    @Mock //формат заглушки
    private EmployeesService employeeService;
    @InjectMocks//формат заглушки
    private DepartmentService departmentService;

    @DisplayName("тест на добавление сотрудника по департаменту")
    @Test
    void addEmployeeByDepartmentTest() {
        //дано или что будет ожидаться
        int requestByDepartment = 1;
        Collection<Employee> expected = employeeList.stream()
                .filter(e -> e.getDepartment() == requestByDepartment)
                .toList();
        when(employeeService.fullEmployees())
                .thenReturn((List<Employee>) employeeList);
        //далее
        Collection<Employee> actual = departmentService.getEmployeesByDepartment(requestByDepartment);
//ТОГДА
        verify(employeeService, times(1)).fullEmployees();
        assertEquals(expected, actual);

    }


    @DisplayName("сотрудник из отдела которого нет")
    @Test
    void addEmployeeNotByDepartmentTest() {
        //дано или что будет ожидаться
        int requestByDepartment = 100;

        when(employeeService.fullEmployees())
                .thenReturn((List<Employee>) employeeList);
        //далее
        Collection<Employee> actual = departmentService.getEmployeesByDepartment(requestByDepartment);
//ТОГДА
        verify(employeeService, times(1)).fullEmployees();
        assertTrue(actual.isEmpty());

    }
}