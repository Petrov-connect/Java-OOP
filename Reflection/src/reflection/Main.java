package reflection;
//created by J.M.

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Class reflection = Reflection.class;
        Class supperClass = reflection.getSuperclass();
        Class[] interfaces = reflection.getInterfaces();

        try {
            Constructor<Reflection> constructor = reflection.getDeclaredConstructor();
            Reflection reflectionObject = constructor.newInstance();
            System.out.printf("%s%n%s%n%s%n%s"
                    , reflection
                    , supperClass
                    , Arrays.stream(interfaces).map(String::valueOf).collect(Collectors.joining("\n"))
                    , reflectionObject.toString());
        } catch (NoSuchMethodException
                | InvocationTargetException
                | IllegalAccessException
                | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
