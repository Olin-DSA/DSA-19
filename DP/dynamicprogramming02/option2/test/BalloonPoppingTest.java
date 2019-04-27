import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BalloonPoppingTest {
    @Test
    public void testBalloons1(){
        int[] input = new int[]{2,4,3,5};
        assertEquals(115,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons2(){
        int[] input = new int[]{2,5,7,1};
        assertEquals(98,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons3(){
        int[] input = new int[]{9,2,7,6};
        assertEquals(567,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons4(){
        int[] input = new int[]{1,2,3,4,5,6,7,8};
        assertEquals(912,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons5(){
        int[] input = new int[]{1,2,1};
        assertEquals(6,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons6(){
        int[] input = new int[]{1,200,1,1};
        assertEquals(800,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons7(){
        int[] input = new int[]{4,5,6,7,8,200,1,1};
        assertEquals(31000,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons8(){
        int[] input = new int[]{100,456,734,675,1,356};
        assertEquals(352011856,BalloonPopping.maxPoints(input));
    }

    @Test
    public void testBalloons9(){
        int[] input = new int[]{3,4,60,5,22,10000,3,11};
        assertEquals(20139416,BalloonPopping.maxPoints(input));
    }

    @Test
    public void testBalloons10(){
        int[] input = new int[]{1,546,7,65,3,657,8,6,1,5,36,6,2,1,6,75,42,67,42,1,13,24};
        assertEquals(57953565,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons11(){
        int[] input = new int[]{12,55,54,7,84,1,10,15435,6,3,7};
        assertEquals(140985234,BalloonPopping.maxPoints(input));
    }
    @Test
    public void testBalloons12(){
        int[] input = new int[]{4, 2, 7, 5, 9, 2, 1, 6, 7, 2, 3, 5, 1, 10, 2, 9, 15, 4, 8, 19, 2, 20, 8, 1, 2};
        assertEquals(20979,BalloonPopping.maxPoints(input));
    }
}