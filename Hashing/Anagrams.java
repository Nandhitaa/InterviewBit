/*
Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
 Note: All inputs will be in lower-case. 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4.
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases within the group. Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    private boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        char c1[] = s1.toCharArray();
        Arrays.sort(c1);
        char c2[] = s2.toCharArray();
        Arrays.sort(c2);
        for(int i=0; i<c1.length; i++) {
            if(c1[i]!=c2[i]) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        boolean visited[] = new boolean[A.size()+1];
        for(int i=0; i<A.size(); i++) {
            if(!visited[i+1]) {
                map.put(i+1, new ArrayList<Integer>());
                visited[i+1] = true;
                for(int j=i+1; j<A.size(); j++) {
                    if(isAnagram(A.get(i), A.get(j))) {
                        ArrayList<Integer> list = map.get(i+1);
                        list.add(j+1);
                        map.put(i+1, list);
                        visited[j+1] = true;
                    }
                }
            }
        }
        for(int i : map.keySet()) {
            ArrayList<Integer> elem = map.get(i);
            elem.add(0,i);
            ans.add(elem);
        }
        return ans;
    }
}
