package edu.iastate.cs228.hw2;


/**
 * @author Kelly Kla-Diihbah
 */

/**
 *
 * This class implements selection sort.   
 *
 */

public class SelectionSorter extends AbstractSorter
{
    // Other private instance variables if you need ...

    /**
     * Constructor takes an array of points.  It invokes the superclass constructor, and also
     * set the instance variables algorithm in the superclass.
     *
     * @param pts
     */
    public SelectionSorter(Point[] pts)
    {
        // TODO
        super(pts);
        algorithm = "SelectionSort";
    }



    /**
     * Apply selection sort on the array points[] of the parent class AbstractSorter.
     *
     */
    @Override
    public void sort()
    {

        // TODO
        for (int i = 0; i < points.length; ++i)
        {
            int minIndex = i;
            for (int j = i + 1; j < points.length; ++j)
            {
                if (pointComparator.compare(points[j], points[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            if (minIndex != i)
            {
                swap(i,minIndex);
//                Point temp = points[i];
//                points[i] = points[minIndex];
//                points[minIndex] = temp;
            }

        }

    }
}
