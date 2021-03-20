package validPerson;
//created by J.M.

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    private void isNullOrEmpty(String name, String type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The " + type + " name cannot be null or empty");
        }
    }

    private void setFirstName(String firstName) {
        isNullOrEmpty(firstName, "first");
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        isNullOrEmpty(lastName, "last");
        this.lastName = lastName;
    }

    private void setAge(int age) {

        if (age > 1 || age < 120){
            throw new IllegalArgumentException("Age should be in range [1...120");
        }
            this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
