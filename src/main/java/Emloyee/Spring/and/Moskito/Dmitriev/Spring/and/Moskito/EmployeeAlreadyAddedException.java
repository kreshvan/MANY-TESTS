package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;


    public class EmployeeAlreadyAddedException extends RuntimeException {
        public EmployeeAlreadyAddedException(String sms) {
            super(sms);
        }
    }

