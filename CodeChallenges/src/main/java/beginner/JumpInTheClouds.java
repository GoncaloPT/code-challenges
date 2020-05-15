package beginner;

public class JumpInTheClouds {
    /**
     * Using Recurrence
     * @param c
     * @param position
     * @return
     */
    static int jumpingOnClouds(int[] c, int position) {
        if (position == (c.length - 1)) {
            //reached the end
            return 0;
        }
        if (position >= c.length || c[position] == 1) {
            //return a big value since this is not a valid path
            return c.length + 1;
        }
        int jumpOne = jumpingOnClouds(c, position + 1);
        int jumpTwo = jumpingOnClouds(c, position + 2);
        return jumpOne < jumpTwo ? jumpOne + 1 : jumpTwo + 1;
    }

    /**
     * Using dynamic programming to solve the same problem
     * @param c
     * @param position
     * @return
     */
    static int jumpingOnCloudsDp(int[] c, int position) {
        int jumps = 0;
        while ( ( position +2) < c.length) {
            // +2 case
            jumps++;
            if (position + 2 < c.length && c[position + 2] == 0) {
                position += 2;
            } else if (position + 1 < c.length && c[position + 1] == 0) {
                position += 1;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] c = {0, 0, 0, 0, 1, 0};
        //int [] c = {0, 0, 0, 1, 0, 0};
        int result = jumpingOnCloudsDp(c, 0);
        System.out.println("result is " + result);

    }
}