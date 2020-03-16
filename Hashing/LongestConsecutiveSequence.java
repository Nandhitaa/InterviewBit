/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example:
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<A.size(); i++) {
            set.add(A.get(i));
        }
        for(int i=0; i<A.size(); i++) {
            if(!set.contains(A.get(i)-1)) {
                int j = A.get(i);
                while(set.contains(j)) {
                    j++;
                }
                ans = Math.max(ans, j-A.get(i));
            }
        }
        return ans;
    }
}
