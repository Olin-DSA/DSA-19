import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO
        // https://introcs.cs.princeton.edu/java/42sort/
        // Runtime: O(N)
        // Sort String array
        String[] words = s.split("\\s+");

        // Words to their frequencies
        HashMap<String, Integer> mapWordToFreq = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            mapWordToFreq.put(words[i], mapWordToFreq.getOrDefault(words[i], 0) + 1);

        // Map frequencies words
        Map<Integer, List<String>> mapFreqToWords = new HashMap<>();
        for (String str : mapWordToFreq.keySet()) {
            int freq = mapWordToFreq.get(str);
            List<String> l = mapFreqToWords.getOrDefault(freq, new ArrayList<>());
            l.add(str);
            mapFreqToWords.put(freq, l);
        }
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= words.length; i++) {
            List<String> l = mapFreqToWords.getOrDefault(i, new ArrayList<>());
            // Add each word to the result freq times
            for (String str : l) for (int j = 0; j < i; j++) result.add(str);
        }
        return String.join(" ", result);
    }

}
