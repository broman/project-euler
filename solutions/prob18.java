import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math.max;
// Find the maximum total from top to bottom of the triangle

/*
 * We can use the following algorithm to dynamically produce calculate the
 * most optimal route:
 *  a
 * b c
 * Given the triangle above, the route that will produce the largest sum is: a + max(b, c).
 * For our input triangle, we can start at line 14 and work our way up. As an example:
 *    9
 *   7 3
 *  6 3 4
 * 1 5 4 6
 * Starting at the 6 on the left side of the 2nd to last...
 *    9
 *   7 3
 * 11 8 10
 * 
 *   9
 * 18 13
 * 
 * 23 <- Our answer.
 * Now we just have to, yknow, actually write the code for that. That's always the dumb part.
 */

public class prob18 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
         * Generate a 2D array and pass it to maxSum().
         * Split the file by each newline, split the line into individaul numbers,
         * and add the parseInt() result to the inner 2D array.
         */
        List<List<Integer>> pyramid = getInput();
        long start = System.nanoTime();
        int max = maxSum(pyramid);
        long end = System.nanoTime();

        System.out.printf("The maximum sum is %d, it took %xms\n", max, (end - start) / 100000);
    }

    private static List<List<Integer>> getInput() throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        List<List<Integer>> pyramid = new ArrayList<List<Integer>>();
        /* Grab input from prob18.txt and convert to array of lines */
        String dir = System.getProperty("user.dir") + "/solutions/prob18.txt";
        Scanner s = new Scanner(new File(dir));
        while (s.hasNextLine())
            lines.add(s.nextLine());
        s.close();
        /* Split each line of the array, convert to integer, and add to the inner array */
        for (String line : lines) {
            List<Integer> inner = new ArrayList<Integer>();
            String[] split = line.split("\\s+");
            for (String cell : split)
                inner.add(Integer.parseInt(cell));
            pyramid.add(inner);
        }
        return pyramid;
    }
    public static int maxSum(List<List<Integer>> pyramid) {
        /*
         * The "coordinates" to this grid are .get(y).get(x)
         * To go to the right of (x, y), .get(y+1).get(x+1)
         * To go to the left  of (x, y), .get(y+1).get(x)
         * 
         * Fill an array with the bottom line of values, then simply run the "a + max(b, c)" algorithm
         * from the bottom up.
         */
        int length = pyramid.get(0).size();
        int[] largest_vals = new int[length];
        for(int i = 0; i < length; i++) largest_vals[i] = pyramid.get(length - 1).get(i);
        for(int i = length - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                largest_vals[j] = pyramid.get(i).get(j) + Math.max(largest_vals[j], largest_vals[j + 1]);
            }
        }
        return largest_vals[0];
    }
}