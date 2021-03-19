package reflection;
//created by J.M.

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            Class reflection = Reflection.class;
            Constructor<Reflection> constructor = reflection.getDeclaredConstructor();
            Reflection reflectionObject = constructor.newInstance();
            System.out.printf("%s%n%s%n%s%n%s"
                    , reflection
                    , reflection.getSuperclass()
                    , Arrays.stream(reflection.getInterfaces()).map(String::valueOf).collect(Collectors.joining("\n"))
                    , reflectionObject.toString());
        } catch (NoSuchMethodException
                | InvocationTargetException
                | IllegalAccessException
                | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
