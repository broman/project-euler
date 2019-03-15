import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
        List<String> lines = new ArrayList<String>();
        List<List<Integer>> pyramid = new ArrayList<List<Integer>>();
        /* Grab input from prob18.txt and convert to array of lines */
        String dir = System.getProperty("user.dir") + "\\solutions\\prob18.txt";
        Scanner s = new Scanner(new File(dir));
        while(s.hasNextLine()) lines.add(s.nextLine());
        s.close();
        /* Split each line of the array, convert to integer, and add to the inner array */
        for(String line: lines) {
            List<Integer> inner = new ArrayList<Integer>();
            String[] split = line.split("\\s+");
            for(String cell: split) inner.add(Integer.parseInt(cell));
            pyramid.add(inner);
        }
        System.out.println(maxSum(pyramid));
    }
    public static int maxSum(List<List<Integer>> pyramid) {
        return 0;
    }
}