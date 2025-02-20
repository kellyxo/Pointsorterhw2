package edu.iastate.cs228.hw2;

/**
 * @author Kelly Kla-Diihbah
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 *
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class PointScanner {
    private Point[] points;
    private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of
    // the x coordinates and y coordinates of those points in the array points[].
    private Algorithm sortingAlgorithm;
    String outputfilename;

    protected long scanTime;           // execution time in nanoseconds.

    /**
     * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy
     * the points into the array points[].
     *
     * @param  pts  input array of points
     * @throws IllegalArgumentException if pts == null or pts.length == 0.
     */
    public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
    {
        if(pts == null || pts.length == 0)
        {
            throw new IllegalArgumentException();
        }
        this.sortingAlgorithm = algo;
        points = new Point[pts.length];
        System.arraycopy(pts,0, points,0,pts.length);
    }

    /**
     * This constructor reads points from a file.
     *
     * @param  inputFileName
     * @throws FileNotFoundException
     * @throws InputMismatchException   if the input file contains an odd number of integers
     */
    protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException {
        // TODO
        sortingAlgorithm = algo;
        int count = 0;
        try {
            File inputFile = new File(inputFileName);
            Scanner scan = new Scanner(inputFile);
            int t;
            while (scan.hasNext()) {
                t = scan.nextInt();
                count++;
            }
            scan.close();
            if (count % 2 != 0) {
                throw new InputMismatchException();
            }
            points = new Point[count / 2];
            Scanner scan2 = new Scanner(inputFile);

            int i = 0;
            while(scan2.hasNext())
            {
                int x = scan2.nextInt();
                int y = scan2.nextInt();
                points[i] = new Point(x, y);
                i++;
            }
            scan2.close();
        }
        catch (FileNotFoundException e)
        {
            throw new FileNotFoundException();
        }
    }


    /**
     * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:
     *
     *     a) Sort points[] by the x-coordinate to get the median x-coordinate.
     *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
     *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.
     *
     * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
     * or QuickSorter to carry out sorting.
     *
     * @return
     */
    public void scan() {
        // TODO
        // create an object to be referenced by aSorter according to sortingAlgorithm. for each of the two
        // rounds of sorting, have aSorter do the following:
        //
        //     a) call setComparator() with an argument 0 or 1.
        //
        //     b) call sort().
        //
        //     c) use a new Point object to store the coordinates of the medianCoordinatePoint
        //
        //     d) set the medianCoordinatePoint reference to the object with the correct coordinates.
        //
        //     e) sum up the times spent on the two sorting rounds and set the instance variable scanTime.

        AbstractSorter aSorter = null;
        long startTime;
        long endTime;
        if(sortingAlgorithm == Algorithm.MergeSort)
        {
            aSorter = new MergeSorter(points);
        }
       else if(sortingAlgorithm == Algorithm.InsertionSort)
        {
            aSorter = new InsertionSorter(points);
        }
       else if(sortingAlgorithm == Algorithm.SelectionSort)
        {
            aSorter = new SelectionSorter(points);
        }
       else  if(sortingAlgorithm == Algorithm.QuickSort)
        {
            aSorter = new QuickSorter(points);
        }
        //Compare by X
        assert aSorter != null;
        aSorter.setComparator(0);
        startTime = System.nanoTime();
        aSorter.sort();
        endTime = System.nanoTime();
        long xtime = endTime - startTime;


        int x = aSorter.getMedian().getX();

        //Compare by Y
        aSorter.setComparator(1);
        startTime = System.nanoTime();
        aSorter.sort();
        endTime = System.nanoTime();
        long ytime = endTime - startTime;

        scanTime = xtime +ytime;


        int y = aSorter.getMedian().getY();



        medianCoordinatePoint = new Point(x,y);

    }


    /**
     * Outputs performance statistics in the format:
     *
     * <sorting algorithm> <size>  <time>
     *
     * For instance,
     *
     * selection sort   1000	  9200867
     *
     * Use the spacing in the sample run in Section 2 of the project description.
     */
    public String stats() {
        // TODO
        String stats = null;
        if(sortingAlgorithm == Algorithm.MergeSort)
        {
            stats = "<merge sort>" + "         " + points.length + "  " + scanTime;
        }
        if(sortingAlgorithm == Algorithm.InsertionSort)
        {
            stats = "<insertion sort>" + "     " + points.length + "  " + scanTime;
        }
        if(sortingAlgorithm == Algorithm.SelectionSort)
        {
            stats = "<selection sort>" + "     " + points.length + "  " + scanTime;
        }
        if(sortingAlgorithm == Algorithm.QuickSort)
        {
            stats = "<quick sort>" + "         " + points.length + "  " + scanTime;
        }
        return stats;
    }


    /**
     * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space
     * in between.
     */
    @Override
    public String toString() {
        // TODO
        return medianCoordinatePoint.toString();

    }


    /**
     *
     * This method, called after scanning, writes point data into a file by outputFileName. The format
     * of data in the file is the same as printed out from toString().  The file can help you verify
     * the full correctness of a sorting result and debug the underlying algorithm.
     *
     * @throws FileNotFoundException
     */
    public void writeMCPToFile() throws FileNotFoundException {
        // TODO
        try {
            outputfilename = "/Users/kellyxo/Downloads/edu 2/iastate/cs228/hw2/edu/iastate/cs228/hw2/cordoutput.txt";
            FileWriter file = new FileWriter(outputfilename);

            file.write(toString());

            file.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }


    }

}
