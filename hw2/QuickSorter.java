package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;


/**
 * @author Kelly Kla-Diihbah
 */

/**
 *
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 *
 */

public class QuickSorter extends AbstractSorter
{

    // Other private instance variables if you need ...

    /**
     * Constructor takes an array of points.  It invokes the superclass constructor, and also
     * set the instance variables algorithm in the superclass.
     *
     * @param pts   input array of integers
     */
    public QuickSorter(Point[] pts) {
        // TODO
        super(pts);
        this.algorithm = "QuickSort";
    }


    /**
     * Carry out quicksort on the array points[] of the AbstractSorter class.
     *
     */
    @Override
    public void sort() {
        // TODO
        quickSortRec(0,points.length-1);
    }


    /**
     * Operates on the subarray of points[] with indices between first and last.
     *
     * @param first  starting index of the subarray
     * @param last   ending index of the subarray
     */
    private void quickSortRec(int first, int last)
    {
        // TODO
        if(first >= last) // base case this means the list is sorted
        {
            return;
        }
        int pIndex = partition(first,last);
        quickSortRec(first, pIndex -1);
        quickSortRec(pIndex + 1, last);
    }


    /**
     * Operates on the subarray of points[] with indices between first and last.
     *
     * @param first
     * @param last
     * @return
     */
    private int partition(int first, int last) {
        // TODO

        Point pivot = points[last];
        int i = first-1; // our memory inex
        for(int j = first; j< last; ++j)
        {
            if(pointComparator.compare(points[j],pivot) < 0) // j is less than the pivot
            {
                i++;
                swap(i,j);
            }
        }
        swap(i+1, last);
        return i + 1;
    }


    // Other private methods if needed ...
}
