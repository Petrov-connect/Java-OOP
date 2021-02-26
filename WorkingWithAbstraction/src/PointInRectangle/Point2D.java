package PointInRectangle;
//created by J.M.

public class Point2D {

    private final int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterOrEqualsByX(Point2D other) {
        return this.x >= other.x;
    }

    public boolean isLessOrEqualsByX(Point2D other) {
        return this.x <= other.x;
    }

    public boolean isGreaterOrEqualsByY(Point2D other) {
        return this.y >= other.y;
    }

    public boolean isLessOrEqualsByY(Point2D other) {
        return this.y <= other.y;
    }
}


