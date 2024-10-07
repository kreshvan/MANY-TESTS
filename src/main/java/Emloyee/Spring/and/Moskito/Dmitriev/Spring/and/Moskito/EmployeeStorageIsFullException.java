package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

public class EmployeeStorageIsFullException extends RuntimeException {
   public EmployeeStorageIsFullException(String sms){
       super(sms);
   }

}
