package edu.iastate.cs228.hw2;

import edu.iastate.cs228.hw2.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kellyxo
 */
class PointTest {
    Point p = new Point(0, 1);

    @Test
    @DisplayName("simple getter method")
    void getX() {
        assertEquals(0, p.getX());
    }

    @Test
    @DisplayName("simple getter method")
    void getY() {
        assertEquals(1, p.getY());
    }

    @Test
    void testEquals() {
        Point A = new Point(0, 1);
        assertEquals(p, A);
    }

    @Test
    void compareTo() {
        Point a = new Point(0, 7);
        assertEquals(-1, p.compareTo(a));
    }
    @Test
    void compareToBreak()
    {
        Point a = new Point(9000000, 20000000);
        int result = p.compareTo(a);
        assertEquals(-1,result);
    }

    @Test
    void testToString() {
        System.out.println(p);
    }
}