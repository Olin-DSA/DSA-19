import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntCircleTest {

    @Test
    public void testCircle1() {
        //Verified by hand
        int[] arr = new int[]{1,2,3,4,5,6};
        assertEquals(126, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle2() {
        //Verified by brute force
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        assertEquals(4680, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle3() {
        //Verified by brute force
        int[] arr = new int[]{2,4,6,8,9,4,400,2,4,24,67,2,3,34,100};

        assertEquals(2680860, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle4() {
        //Verified by brute force
        int[] arr  = new int[]{2,4,6,8,9,6,4,2,4,24,67,2,3,34,100};

        assertEquals(161548, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle5() {
        //Verified by brute force
        int[] arr = new int[]{342, 136, 255, 461, 154, 243};

        assertEquals(29405886, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle6() {
        //Verified by brute force
        int[] arr = new int[]{98, 293, 353,  92, 474, 471, 293, 243, 403,  75, 179,  36, 359, 220, 270};

        assertEquals(124925525, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle7() {
        //Verified by brute force
        int[] arr =  new int[]{475, 388, 387,  67, 343, 225, 241, 375, 302, 190,  84, 322, 226, 238, 187, 153,  86, 289};

        assertEquals(135643782, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle8() {
        //Verified by brute force
        int[] arr = new int[]{453, 107, 109, 161, 246, 344, 404,  25, 257,  85, 339,  87, 290, 486, 307, 466,  88, 465,
            332, 348, 489};

        assertEquals(243039864, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircle9() {
        //Verified by our solution
        //If you pass tests 1-8 you can still get checked off
        //BUT your code can not run forever on any of the assignements
        //It could possibly be an error in our solution
        //This is mostly to make sure your algorithm is polynomial time
        int[] arr = new int[]{91,35,69,87,84,92,86,0,47,70,75,64,71,67,30,61,69,72,24,81,14,16,28,83,98,97,73,61,59,43,44,32,40,16,55,78,19,6,88,2,24,83,64,20,2,5,84,67,95,5,4,68,67,36,95,26,19,67,15,65};
        assertEquals(4950078, IntCircle.maxValue(arr));
    }

    @Test
    public void testCircleReallyLong() {
        //Verified by our solution
        //If your algorithm brute forces it, if you had
        //Every planet in the universe
        //Each with the compute power of earth
        //That executes a sub problem per clock cycle of an i7
        //You would still need the age of the universe times HALF A MILLION
        //To find the solution
        int[] arr = new int[]{21,1,33,22,8,26,11,33,46,11,10,42,34,47,43,23,31,8,0,4,46,45,9,41,39,42,41,5,4,24,16,1,0,18,15,15,27,35,39,30,45,5,3,17,40,31,36,21,11,14,14,22,38,11,35,41,13,19,36,24,39,20,18,11,5,6,3,44,40,28,13,26,31,40,12,17,4,3,35,49,10,30,6,41,4,34,20,27,39,9,8,29,15,20,46,37,39,31,43,7,34,3,24,21,24,14,49,20,29,35,7,8,5,11,37,44,10,19,30,49};
        assertEquals(989508, IntCircle.maxValue(arr));
    }


    @Test
    public void testCircleNegative() {
        //Verified by our solution
        //If you pass tests 1-8 you can still get checked off
        //It could possibly be an error in our solution, I honestly don't know if our solution works with negatives
        int[] arr = new int[]{-27,48,-4,17,-38,40,2,-42,13,18,-10,-16,34,37,4,-23,40,34,21,-20,-44,39,43,6,-50,-22,-30,-1,-46,-39};
        assertEquals(264272, IntCircle.maxValue(arr));
    }




}
