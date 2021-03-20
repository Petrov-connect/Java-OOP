package customException;
//created by J.M.

public class Student {

    private String name;
    private String email;

    public Student(String name, String email)  {
        this.setName(name);
        this.setEmail(email);
    }

    private void setName(String name)  {
        if(!name.matches("^[^0-9]+$")){
            throw new InvalidPersonNameException("Name must not contains digits");
        }
        this.name=name;
    }

    private void setEmail(String email)  {
        if(!email.contains("@")){
            throw new InvalidPersonNameException("invalid email");
        }
        this.email=email;
    }
}
