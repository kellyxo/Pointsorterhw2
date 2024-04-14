package edu.iastate.cs228.hw2;

/**
 * @author Kelly Kla-diihbah
 */

import java.util.Arrays;
import java.util.Comparator;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

/**
 *
 * This abstract class is extended by SelectionSort, InsertionSort, MergeSort, and QuickSort.
 * It stores the input (later the sorted) sequence.
 *
 */
public abstract class AbstractSorter{

    protected Point[] points;    // array of points operated on by a sorting algorithm.
    // stores ordered points after a call to sort().

    protected String algorithm = null; // "selection sort", "insertion sort", "mergesort", or
    // "quicksort". Initialized by a subclass constructor.

    protected Comparator<Point> pointComparator = null;


    // Add other protected or private instance variables you may need.


    protected AbstractSorter() {
        // No implementation needed. Provides a default super constructor to subclasses.
        // Removable after implementing SelectionSorter, InsertionSorter, MergeSorter, and QuickSorter.
    }


    /**
     * This constructor accepts an array of points as input. Copy the points into the array points[].
     *
     * @param  pts  input array of points
     * @throws IllegalArgumentException if pts == null or pts.length == 0.
     */
    protected AbstractSorter(Point[] pts) throws IllegalArgumentException
    {
        // TODO
        if(pts == null || pts.length == 0)
        {
            throw new IllegalArgumentException();
        }

        points = new Point[pts.length]; // Initialize points array
        // made a mistake by not doing this right and it was not working.

        for (int i = 0; i < pts.length; ++i) {
            assert pts[i] != null; // Check if element is not null
            points[i] = pts[i];
        }
    }



    /**
     * Generates a comparator on the fly that compares by x-coordinate if order == 0, by y-coordinate
     * if order == 1. Assign the
     * comparator to the variable pointComparator.
     *
     *
     * @param order  0   by x-coordinate
     * 				 1   by y-coordinate
     *
     *
     * @throws IllegalArgumentException if order is less than 0 or greater than 1
     *
     */
    public void setComparator(int order)throws IllegalArgumentException
    {
        // TODO
        if(order < 0 || order > 1) // check if order is the right arrugment
        {
            throw new IllegalArgumentException();
        }
        if(order == 0) // compare by x
        {
            pointComparator = new Comparator<Point>()
            {
                @Override
                public int compare(Point p1, Point p2)
                {
                    if (p1.getX() > p2.getX())
                        return 1;
                    else if (p1.getX() < p2.getX())
                    {
                        return -1;
                    }
                    else
                        return 0;
                }
            };
        }
        else
        {
            pointComparator = new Comparator<Point>()
            {
                @Override
                public int compare(Point p1, Point p2)
                {
                    if (p1.getY() > p2.getY())
                        return 1;
                    else if (p1.getY() < p2.getY())
                    {
                        return -1;
                    }
                    else
                        return 0;
                }
            };
        }


    }


    /**
     * Use the created pointComparator to conduct sorting.
     * Should be protected. Made public for testing.
     */
    protected abstract void sort();


    /**
     * Obtain the point in the array points[] that has median index
     *
     * @return median point
     */
    public Point getMedian()
    {
        return points[points.length / 2];
    }


    /**
     * Copys the array points[] onto the array pts[].
     *
     * @param pts
     */
    public void getPoints(Point[] pts) {
        // TODO
        System.arraycopy(points, 0, pts, 0, pts.length);
    }


    /**
     * Swaps the two elements indexed at i and j respectively in the array points[].
     *
     * @param i
     * @param j
     */
    protected void swap(int i, int j)
    {
        // TODO
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;

    }
}
