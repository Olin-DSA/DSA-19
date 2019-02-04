
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyHashMapTest {

    private Map<String, Integer> map;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        map = new MyHashMap<>();
        map.put("Billy", 1);
        map.put("Milly", 2);
        map.put("Dilly", 3);
        map.put("Gilly", null);
    }

    @Test
    public void testClear() {
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void testContainsKey() {
        assertEquals(true, map.containsKey("Billy"));
        assertEquals(true, map.containsKey("Milly"));
        assertEquals(true, map.containsKey("Dilly"));
        assertEquals(true, map.containsKey("Gilly"));
        assertEquals(false, map.containsKey("Bartholomew"));
    }

    @Test
    public void testContainsValue() {
        assertEquals(true, map.containsValue(3));
        assertEquals(true, map.containsValue(null));
        assertEquals(false, map.containsValue(4));
    }

    @Test
    public void testGet() {
        assertEquals((int) map.get("Billy"), 1);
        assertEquals((int) map.get("Milly"), 2);
        assertEquals((int) map.get("Dilly"), 3);
        assertEquals(null, map.get("Gilly"));
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, map.isEmpty());
        map.clear();
        assertEquals(true, map.isEmpty());
    }

    @Test
    public void testKeySet() {
        Set<String> keySet = map.keySet();
        assertEquals(4, keySet.size());
        assertEquals(true, keySet.contains("Dilly"));
        assertEquals(true, keySet.contains("Gilly"));
        assertEquals(false, keySet.contains("Bartholomew"));
    }

    @Test
    public void testPut() {
        assertEquals(1, (int) map.put("Billy", 11));
        assertEquals(4, map.size());
        assertEquals(11, (int) map.get("Billy"));

        assertEquals(null, map.put("Five", 5));
        assertEquals(5, map.size());
        assertEquals(5, (int) map.get("Five"));
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 10000; i++)  //Prava got tired of naming her 10000 goats
            map.put(Integer.toString(i), i);
        assertEquals(9999, (int) map.get("9999"));
        assertEquals(1, (int) map.get("Billy"));
        MyHashMap temp = (MyHashMap) map;
        assertEquals(16384, temp.buckets.length);
        assertEquals(10004, map.size());
        for (int i = 0; i < 6000; i++)
            map.remove(Integer.toString(i));
        assertEquals(8192, temp.buckets.length);
        for (int i = 6000; i < 9960; i++)
            map.remove(Integer.toString(i));
        assertEquals(128, temp.buckets.length);
        for (int i = 9960; i < 9990; i++)
            map.remove(Integer.toString(i));
        assertEquals(32, temp.buckets.length);
        for (int i = 9990; i < 9998; i++)
            map.remove(Integer.toString(i));
        assertEquals(16, temp.buckets.length);
    }

    @Test
    public void testPutAll() {
        Map<String, Integer> m = new HashMap<>();
        m.put("Silly", 6);
        m.put("Hilly", 7);
        m.put("Lilly", 8);
        map.putAll(m);
        assertEquals(7, map.size());
    }

    @Test
    public void testRemove() {
        assertEquals(1, (int) map.remove("Billy"));
        assertEquals(3, map.size());
        assertEquals(null, map.get("Billy"));
        assertEquals(2, (int) map.remove("Milly"));
        assertEquals(2, map.size());
        assertEquals(3, (int) map.remove("Dilly"));
        assertEquals(1, map.size());
        assertEquals(null, map.remove("Gilly"));
        assertEquals(0, map.size());
    }

    @Test
    public void testSize() {
        assertEquals(4, map.size());
    }


    @Test
    public void testValues() {
        Collection<Integer> keySet = map.values();
        assertEquals(4, keySet.size());
        assertEquals(true, keySet.contains(3));
        assertEquals(true, keySet.contains(null));
        assertEquals(false, keySet.contains(4));
    }
}
