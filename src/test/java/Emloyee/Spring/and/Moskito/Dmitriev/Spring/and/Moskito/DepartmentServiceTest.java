
    @DisplayName("получение сотрудника c пустым хранилищем")
    @Test
    void addEmptyEmployeeByDepartmentTest() {
        //дано или что будет ожидаться
        int requestByDepartment = 1;

        when(employeeService.fullEmployees())
                .thenReturn(EMPTY_LIST);
        //далее
        Collection<Employee> actual = departmentService.getEmployeesByDepartment(requestByDepartment);
//ТОГДА
        verify(employeeService, times(1)).fullEmployees();
        assertTrue(actual.isEmpty());

    }

    @DisplayName("сумма зарплат по департаменту")
    @ParameterizedTest
    @MethodSource("provideDataForSum")
    void getSalarySumByDepartmentTest(int departmentId, long expected) {
        //дано или что будет ожидаться

        when(employeeService.fullEmployees())
                .thenReturn((List<Employee>) employeeList);
        //далее
        long actual = departmentService.getSalarySumByDepartment(departmentId);
//ТОГДА
        verify(employeeService, times(1)).fullEmployees();
        assertEquals(expected, actual);

    }

    private static Stream<Arguments> provideDataForSum() {
        return Stream.of(
                Arguments.arguments(1, 100),
                Arguments.arguments(100, 0),
                Arguments.arguments(9, 55));
    }

    @DisplayName("получение максимальной суммы по департаменту")
    @ParameterizedTest
    @MethodSource("provideDataForMax")
    void getMaxSalaryByDepartmentTest(int departmentId, long expected) {
        //дано или что будет ожидаться

        when(employeeService.fullEmployees())
                .thenReturn((List<Employee>) employeeList);
        //далее
        long actual = departmentService.getSalaryMaxByDepartment(departmentId);
//ТОГДА
        verify(employeeService, times(1)).fullEmployees();
        assertEquals(expected, actual);

    }

    private static Stream<Arguments> provideDataForMax() {
        return Stream.of(
                Arguments.arguments(100, 1),
                Arguments.arguments(90, 2),
                Arguments.arguments(80, 2));
    }

    @DisplayName("получение максимальной зарплаты по департаменту")
    @Test
    void getMaxSalaryEmployeeByDepartmentTest(int departmentId, long expected) {
        //дано или что будет ожидаться
        int requestDepartment = 100;
        when(employeeService.fullEmployees())
                .thenReturn((List<Employee>) employeeList);
        //далее
        assertThrows(EmployeeStorageIsFullException.class, () -> departmentService.getSalaryMaxByDepartment(requestDepartment));
//ТОГДА
        verify(employeeService, times(1)).fullEmployees();


    }
}