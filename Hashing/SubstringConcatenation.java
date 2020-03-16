/*
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        int word_size = B.get(0).length();
        int word_count = B.size();
        int substring_length = word_size * word_count;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(A.length()<substring_length) {
            return ans;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<word_count; i++) {
            String s = B.get(i);
            if(map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            }
            else {
                map.put(s,1);
            }
        }
        HashMap<String, Integer> temp_map = new HashMap<String, Integer>();
        for(int i=0; i<A.length()-substring_length+1; i++) {
            temp_map.putAll(map);
            int j=i;
            int count = word_count;
            while(j<i+substring_length) {
                String word = A.substring(j,j+word_size);
                if(!temp_map.containsKey(word) || temp_map.get(word) == 0 ) {
                    break;
                }
                else {
                    temp_map.put(word, temp_map.get(word)-1);
                    count--;
                }
                j += word_size;
            }
            if(count==0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
