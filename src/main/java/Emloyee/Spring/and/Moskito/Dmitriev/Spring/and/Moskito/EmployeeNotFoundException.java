package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String sms){
        super(sms);
    }
}
