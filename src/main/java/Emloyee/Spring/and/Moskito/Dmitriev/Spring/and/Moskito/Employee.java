package Emloyee.Spring.and.Moskito.Dmitriev.Spring.and.Moskito;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;
    private int id;
    private static int count = 0;

    public Employee(String firstName, String lastName, int i, int i1) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.id = count++;
    }

public static int id( int i){
        return i++;
}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return firstName.equals(other.firstName)&&lastName.equals(other.lastName) && department == (other.department) && salary == (other.salary) && id == (other.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName, department, salary, id);
    }
}
