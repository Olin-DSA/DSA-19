import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrequencyPrintTest {

    @Test
    public void testFrequencyPrint1() {
        String str = "to be or not to be";
        String re = FrequencyPrint.frequencyPrint(str);
        assertStringsHaveEqualsCounts(str, re);
        stringisSorted(re);
    }

    @Test
    public void testFrequencyPrint2() {
        String str = "look what you made me do";
        String re = FrequencyPrint.frequencyPrint(str);
        assertStringsHaveEqualsCounts(str, re);
        stringisSorted(re);
    }

    @Test
    public void testFrequencyPrint3() {
        String str = "can you can a can as a canner can can a can";
        String re = FrequencyPrint.frequencyPrint(str);
        assertStringsHaveEqualsCounts(str, re);
        stringisSorted(re);
    }

    @Test
    public void testFrequencyPrint4() {
        String str = "how many cookies could a good cook cook If a good cook could cook cookies";
        String re = FrequencyPrint.frequencyPrint(str);
        assertStringsHaveEqualsCounts(str, re);
        stringisSorted(re);
    }

    @Test
    public void testFrequencyPrint5() {
        String str = "apple apple peach peach banana banana";
        String re = FrequencyPrint.frequencyPrint(str);
        assertStringsHaveEqualsCounts(str, re);
        stringisSorted(re);
    }

    @Test
    public void testFrequencyPrint6() {
        String str = "what up";
        String re = FrequencyPrint.frequencyPrint(str);
        assertStringsHaveEqualsCounts(str, re);
        stringisSorted(re);
    }

    @Test
    public void testFrequencyPrint7() {
        char[] temp = new char[100];
        for(int i= 0; i < 20;i+=3){
            temp[i] = 'a';
        }
        for(int i= 30; i < 60;i+=5){
            temp[i] = 'b';
        }
        for(int i= 70; i < 100;i+=2){
            temp[i] = 'c';
        }
        temp[99] = 'd';
        String space10 = new String(temp);
        space10 = space10.replace("a", "goat ");
        space10 = space10.replace("b", "pig ");
        space10 = space10.replace("c", "cow ");
        space10 = space10.replace("d", "Farmer Nick");
        space10 = space10.replace("\0", "sheep ");
        String re = FrequencyPrint.frequencyPrint(space10);
        assertStringsHaveEqualsCounts(space10, re);
        stringisSorted(re);
    }

    private void stringisSorted(String s) {
        // this is to make sure that the words in the string is positioned in order
        // for example [to do do] will pass, and [to to do] will not pass
        String[] words = s.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            // if we've seen this word before, ensure that it came directly before current index
            if (map.containsKey(words[i])) {
                if (i != 0) assertTrue(words[i].equals(words[i - 1]));
                map.put(words[i], map.get(words[i]) + 1);
            } else map.put(words[i], 1);
        }
        // make sure counts are in ascending order
        for (int i = 1; i < words.length; i++)
            assertTrue(map.get(words[i]) >= map.get(words[i - 1]));
    }


    private void assertStringsHaveEqualsCounts(String a, String b) {
        // this is to make sure that the words in the string is positioned in order
        // for example [to do do] will pass, and [to to do] will not pass
        String[] words1 = a.split("\\s+");
        String[] words2 = b.split("\\s+");
        Arrays.sort(words1);
        Arrays.sort(words2);
        assertArrayEquals(words1, words2);
    }

}
