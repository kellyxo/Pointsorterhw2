package edu.iastate.cs228.hw2;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class PointScannerTest {
    // Test constructor with valid points
    @Test
    void testConstructorWithValidPoints() {
        Point[] points = {new Point(3, 5), new Point(1, 2), new Point(4, 3)};
        assertDoesNotThrow(() -> new PointScanner(points, Algorithm.InsertionSort));
    }

    // Test constructor with null points
    @Test
    void testConstructorWithNullPoints() {
        Point[] points = null;
        assertThrows(IllegalArgumentException.class, () -> new PointScanner(points, Algorithm.InsertionSort));
    }

    // Test constructor with empty points
    @Test
    void testConstructorWithEmptyPoints() {
        Point[] points = {};
        assertThrows(IllegalArgumentException.class, () -> new PointScanner(points, Algorithm.InsertionSort));
    }

    // Test constructor with valid file
    @Test
    void testConstructorWithValidFile() {
        String fileName = "/Users/kellyxo/Downloads/edu 2/iastate/cs228/hw2/edu/iastate/cs228/hw2/testPointsEasier.txt";
        assertDoesNotThrow(() -> new PointScanner(fileName, Algorithm.InsertionSort));
    }

    // Test constructor with invalid file path
    @Test
    void testConstructorWithInvalidFile() {
        String fileName = "invalid.txt";
        assertThrows(FileNotFoundException.class, () -> new PointScanner(fileName, Algorithm.InsertionSort));
    }

    // Test constructor with file containing mismatched points
    @Test
    void testConstructorWithMismatchedFile() {
        String fileName = "/Users/kellyxo/Downloads/edu 2/iastate/cs228/hw2/edu/iastate/cs228/hw2/testPointsMismatched.txt";
        assertThrows(InputMismatchException.class, () -> new PointScanner(fileName, Algorithm.InsertionSort));
    }

    // Test scan method
    @Test
    void testScan() {
        Point[] points = {new Point(3, 5), new Point(1, 2), new Point(4, 3)};
        PointScanner scanner = new PointScanner(points, Algorithm.InsertionSort);
        assertDoesNotThrow(scanner::scan);
        System.out.println();
    }

    // Test stats method
    @Test
    void testStats() {
        Point[] points = {new Point(3, 5), new Point(1, 2), new Point(4, 3)};
        PointScanner scanner = new PointScanner(points, Algorithm.InsertionSort);
        assertDoesNotThrow(scanner::scan);
        String stats = scanner.stats();
        System.out.println(stats);
        assertNotNull(stats);
    }

    // Test toString method
    @Test
    void testToString() {
        Point[] points = {new Point(3, 5), new Point(1, 2), new Point(4, 3)};
        PointScanner scanner = new PointScanner(points, Algorithm.InsertionSort);
        assertDoesNotThrow(scanner::scan);
        String mcpString = scanner.toString();
        System.out.println(mcpString);
        assertNotNull(mcpString);
    }

    // Test writeMCPToFile method
    @Test
    void testWriteMCPToFile() {
        Point[] points = {new Point(3, 5), new Point(1, 2), new Point(4, 3)};
        PointScanner scanner = new PointScanner(points, Algorithm.InsertionSort);
        assertDoesNotThrow(scanner::scan);
        assertDoesNotThrow(scanner::writeMCPToFile);
    }

}