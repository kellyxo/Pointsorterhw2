package edu.iastate.cs228.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kellyxo
 */
class  MergeSorterTest {

    private MergeSorter sorter;
    private Point[] points;

    @BeforeEach
    public void setUp() {
        // Create an array of points for testing
        points = new Point[]{
                new Point(3, 5),
                new Point(1, 2),
                new Point(4, 3),
                new Point(2, 4),
                new Point(5, 1)
        };
    }

    @Test
    public void testSortByX() {
        // Create a SelectionSorter instance
        sorter = new MergeSorter(points);

        // Set comparator to sort by x-coordinate
        sorter.setComparator(0);

        // Perform the sorting
        sorter.sort();

        // Expected result after sorting by x-coordinate
        Point[] expected = new Point[]{
                new Point(1, 2),
                new Point(2, 4),
                new Point(3, 5),
                new Point(4, 3),
                new Point(5, 1)
        };

        // Assert that the points array is sorted by x-coordinate
        assertArrayEquals(expected, sorter.points);
    }

    @Test
    public void testSortByY() {
        // Create a SelectionSorter instance
        sorter = new MergeSorter(points);

        // Set comparator to sort by y-coordinate
        sorter.setComparator(1);

        // Perform the sorting
        sorter.sort();

        // Expected result after sorting by y-coordinate
        Point[] expected = new Point[]{
                new Point(5, 1),
                new Point(1, 2),
                new Point(4, 3),
                new Point(2, 4),
                new Point(3, 5)
        };

        // Assert that the points array is sorted by y-coordinate
        assertArrayEquals(expected, sorter.points);
    }
    @Test
    public void testSortByXBreak()
    {
        Point[] EmptySet = new Point[0];

        assertThrows(IllegalArgumentException.class,() ->{
            sorter = new MergeSorter(EmptySet); // make new sorter
        });

    }
    @Test
    public void testSortSinglePointbyX() {
        Point[] singlePointArray = new Point[]{new Point(1, 1)};
        sorter = new MergeSorter(singlePointArray);
        sorter.setComparator(0); // Set comparator to sort by x-coordinate
        sorter.sort();
        assertArrayEquals(singlePointArray, sorter.points);
    }

    @Test
    public void testSortDuplicatePointsbyX() {
        Point[] duplicatePointsArray = new Point[]{new Point(2, 3), new Point(1, 1), new Point(2, 3)};
        sorter = new MergeSorter(duplicatePointsArray);
        sorter.setComparator(0); // Set comparator to sort by x-coordinate
        sorter.sort();
        Point[] expected = new Point[]{new Point(1, 1), new Point(2, 3), new Point(2, 3)};
        assertArrayEquals(expected, sorter.points);
    }

    @Test
    public void testSortNegativeCoordinatesbyY() {
        Point[] negativeCoordinatesArray = new Point[]{new Point(-1, -2), new Point(-3, -1), new Point(-2, -3)};
        sorter = new MergeSorter(negativeCoordinatesArray);
        sorter.setComparator(1); // Set comparator to sort by y-coordinate
        sorter.sort();
        Point[] expected = new Point[]{new Point(-2, -3), new Point(-1, -2), new Point(-3, -1)};
        assertArrayEquals(expected, sorter.points);
    }
    @Test
    public void testAlgname()
    {
        sorter = new MergeSorter(points);
        assertEquals("MergeSort",sorter.algorithm);
    }
}