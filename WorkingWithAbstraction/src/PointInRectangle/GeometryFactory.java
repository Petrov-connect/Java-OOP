package PointInRectangle;
//created by J.M.

public class GeometryFactory {

    public static Rectangle createRectangle(int[] rectangleInfo) {
        return new Rectangle(createPoint2D(rectangleInfo[0], rectangleInfo[1]),
                createPoint2D(rectangleInfo[2], rectangleInfo[3]));
    }

    public static Point2D createPoint2D(int x, int y) {
        return new Point2D(x, y);
    }

    public static Point2D createPoint2D(int[] pointInfo) {
        return new Point2D(pointInfo[0], pointInfo[1]);
    }

}
