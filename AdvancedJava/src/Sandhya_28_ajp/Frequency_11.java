package Sandhya_28_ajp;
import java.util.HashMap;

public class Frequency_11 {
    public static void main(String[] args) {
        String s = "IloveNepal";
        HashMap<Character, Integer> h = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (h.containsKey(c)) {
                h.put(c, h.get(c) + 1);
            } else {
                h.put(c, 1);
            }
        }

        System.out.println(h);
    }
}
