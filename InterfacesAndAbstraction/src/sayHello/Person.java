package sayHello;
//created by J.M.

public interface Person {

    String getName();

    default String sayHello(){
        return "Hello";
    }
}
