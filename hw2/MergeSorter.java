package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;

/**
 * @author Kelly Kla-diihbah
 */

/**
 *
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter {
    // Other private instance variables if needed

    /**
     * Constructor takes an array of points.  It invokes the superclass constructor, and also
     * set the instance variables algorithm in the superclass.
     *
     * @param pts   input array of integers
     */
    public MergeSorter(Point[] pts) {
        // TODO
        super(pts);
        this.algorithm = "MergeSort";

    }


    /**
     * Perform mergesort on the array points[] of the parent class AbstractSorter.
     *
     */
    @Override
    public void sort() {
        // TODO
        mergeSortRec(points);
    }


    /**
     * This is a recursive method that carries out mergesort on an array pts[] of points. One
     * way is to make copies of the two halves of pts[], recursively call mergeSort on them,
     * and merge the two sorted sub arrays into pts[].
     *
     * @param pts    point array
     */
    private void mergeSortRec(Point[] pts)
    {
        int length = pts.length;
        if(length < 2)  // the length is 1 you can do less than equal to 1 but its the same thing this our base case
        {
            return;
        }
        int midIndex = length /2;
        Point [] leftHalf = new Point[midIndex];
        Point [] rightHalf = new Point[length - midIndex];
        System.arraycopy(pts, 0, leftHalf, 0, midIndex);
        int finsher = 0;
       for(int j = midIndex; j < length; ++j)
       {
           rightHalf[finsher] = pts[j];
           ++finsher;
        }
        mergeSortRec(leftHalf);
        mergeSortRec(rightHalf);
        merge(pts,leftHalf,rightHalf);

    }
    private  Point[] merge(Point[] pts, Point[] leftHalf, Point[] rightHalf )
    {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0,j = 0, k = 0; // i iterator for left j iterator for right half k iterator for merger array
        while(i< leftSize && j < rightSize)
        {
            if(pointComparator.compare(leftHalf[i],rightHalf[j]) < 0) // if the leftsie elment is less than the right element
            {
                pts[k] = leftHalf[i];
                i++;
           }
            else // the right eleent is larger
            {
                pts[k] = rightHalf[j];
                ++j;
            }
            k++;
        }
        while(i < leftSize)
        {
            pts[k] = leftHalf[i];
            ++i;
            ++k;
        }
        while(j < rightSize)
        {
            pts[k] = rightHalf[j];
            ++j;
            ++k;
        }

        return  pts;
    }


    // Other private methods if needed ...

}
