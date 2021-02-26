package pointInRectangle;
//created by J.M.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Reader {

    private static final BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));


    public static int[] readIntegerArray(String pattern) throws IOException {

        return Arrays.stream(reader.readLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }

    public static int readInteger() throws IOException {

        return Integer.parseInt(reader.readLine());
    }
}

