
package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private static final Random RANDOM = new Random();

    private final EmployeesService employeeService = new EmployeeService();

    @DisplayName("тест на добавление сотрудника")
    @Test
    void addEmployeeTest() {
        //дано
        int initialSize = employeeService.fullEmployees().size();
        int expectedSize = ++initialSize;
        Employee NewEmployee = new Employee("R", "R", 30, 0);
        //далее
        employeeService.addEmployee(NewEmployee);
//ТОГДА
        int actualSize = employeeService.fullEmployees().size();
        assertEquals(expectedSize, actualSize);

        boolean isAdded = employeeService.fullEmployees()
                .stream()
                .anyMatch(NewEmployee::equals);
        assertTrue(isAdded);

    }

    @DisplayName("максимальное количество сотрудников")
    @Test
    void addEmployeeMaxEmployeesCountTest() {
        //дано
        int maxFullEmployee = 20;
        Stream.generate(EmployeeServiceTest::getRandomEmployee)

                .limit(maxFullEmployee - 1)
                .forEach(employeeService::addEmployee);
        //далее
        assertDoesNotThrow(() ->
                employeeService.addEmployee(getRandomEmployee()));
        assertThrows(EmployeeStorageIsFullException.class, () ->
                employeeService.addEmployee(getRandomEmployee()));
//ТОГДА
        int actualSize = employeeService.fullEmployees().size();
        assertEquals(maxFullEmployee, actualSize);


    }

    @DisplayName("тест такой сотрудник уже есть")
    @Test
    void addEmployeeAnalogEmployeeTest() {
        //дано
        Employee employee = getRandomEmployee();
        //далее
        assertDoesNotThrow(() ->
                employeeService.addEmployee(employee));
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.addEmployee(employee));
//ТОГДА


    }


    private static Employee getRandomEmployee() {
        return new Employee("Q" + RANDOM.nextInt(),
                "Q" + RANDOM.nextInt(),
                3, 1);
    }


    @DisplayName("тест на удаление сотрудника ")
    @Test
    void removeEmployeeTest() {
        //дано
        int initialSize = employeeService.fullEmployees().size();
        int expectedSize = --initialSize;
        Employee NewEmployee = new Employee("R", "R", 30, 0);
        //далее
        employeeService.removeEmployee(NewEmployee);//новый метод(default) в employeeServiceInterface
//ТОГДА
        int actualSize = employeeService.fullEmployees().size();
        assertEquals(expectedSize, actualSize);

        boolean isRemove = employeeService.fullEmployees()
                .stream()
                .anyMatch(NewEmployee::equals);
        assertTrue(isRemove);
    }

    @DisplayName("удаление,тест такого сотрудника уже нет")
    @Test
    void removeEmployeeAnalogEmployeeTest() {
        //дано
        Employee employee = getRandomEmployee();
        //далее
        assertDoesNotThrow(() ->
                employeeService.removeEmployee(employee));
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.removeEmployee(employee));


    }
    @DisplayName("поиск сотрудника")
    @Test
    void findEmployeeAnalogEmployeeTest() {
        //дано
        Employee employee = getRandomEmployee();
        //далее
        assertDoesNotThrow(() ->
                employeeService.findEmployee(employee));
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.findEmployee(employee));
//ТОГДА


    }
}


