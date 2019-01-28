import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayListTest {
    MyArrayList cows = new MyArrayList();

    private static final Cow DELILAH = new Cow("Delilah", 10, "blue");
    private static final Cow GEORGY = new Cow("Georgy", 8, "green");
    private static final Cow LILY = new Cow("Lily", 4, "yellow");
    private static final Cow JIMY = new Cow("Jimi", 13, "black");
    private static final Cow JAQUAN = new Cow("Jaquan", 10, "transparent");
    private static final Cow LEGOS = new Cow("Legos", 400, "rainbow");

    @BeforeEach
    public void setUp() throws Exception{
        cows = new MyArrayList(4);
        cows.add(DELILAH);
        cows.add(GEORGY);
        cows.add(LILY);
        cows.add(JIMY);
    }

    @Test
    public void testSize(){
        assertEquals(4,cows.size());
    }

    @Test
    public void testGet(){
        assertEquals(DELILAH,cows.get(0));
        assertEquals(GEORGY,cows.get(1));
        assertEquals(LILY,cows.get(2));
        assertEquals(JIMY,cows.get(3));
    }

    @Test
    public void testRemove(){
        cows.remove(1);
        assertEquals(3,cows.size());
        assertEquals(LILY,cows.get(1));
        cows.remove(1);
        assertEquals(2,cows.size());
        assertEquals(JIMY,cows.get(1));
    }

    @Test
    public void testAddIndex(){
        cows.add(1,JAQUAN);
        assertEquals(5,cows.size());
        assertEquals(GEORGY,cows.get(2));
        cows.add(1,LEGOS);
        assertEquals(6,cows.size());
        assertEquals(JAQUAN,cows.get(2));
    }

    @Test
    public void testAddIndexThrows(){
        cows.add(4,JAQUAN);
        assertEquals(5,cows.size());
        boolean error = false;
        try {
            cows.add(6,JAQUAN);
        } catch(IndexOutOfBoundsException e) {
            error = true;
        }
        assertTrue(error);
    }

    @Test
    public void testRemoveThrows(){
        boolean error = false;
        try {
            cows.remove(4);
        } catch(IndexOutOfBoundsException e) {
            error = true;
        }
        assertTrue(error);
    }

    @Test
    public void testResize(){
        MyArrayList resizeCows = new MyArrayList();
        for (int i = 0; i < 1000; i++) {
            String name = "Cow" + i;
            int age = i;
            String color = "Color" + i;
            resizeCows.add(new Cow(name,age,color));
        }

        assertEquals(1000,resizeCows.size());
        assertEquals(new Cow("Cow996", 996, "Color996"),resizeCows.get(996));
    }

}
