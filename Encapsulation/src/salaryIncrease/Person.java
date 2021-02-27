package salaryIncrease;
//created by J.M.

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",getFirstName(),getLastName(),getSalary());
    }

    public void increaseSalary(double percentage){
        if(this.age<30){
            this.setSalary(this.getSalary()+this.getSalary()*percentage/200);
        }
        else{
            this.setSalary(this.getSalary()+this.getSalary()*percentage/100);
        }
    }
}
