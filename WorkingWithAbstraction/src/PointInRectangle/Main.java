package PointInRectangle;
//created by J.M.

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Rectangle rectangle = GeometryFactory.createRectangle(Reader.readIntegerArray("\\s+"));
        int countNextLines = Reader.readInteger();
        while (countNextLines-- > 0) {
            System.out.println(rectangle.contains(GeometryFactory.createPoint2D(Reader.readIntegerArray("\\s+"))));
        }
    }
}
