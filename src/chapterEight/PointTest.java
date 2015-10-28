package chapterEight;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PointTest {

    @Test
    public void testMoveRightBy() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);

        assertEquals(15, p2.getX());
        assertEquals(5, p2.getY());
    }

    @Test
    public void testMoveAllPointsRightBy() throws Exception{
        List<Point> points =
                Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints =
                Arrays.asList(new Point(15, 5), new Point(20, 5));

        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
        assertEquals(expectedPoints, newPoints);
    }


}
