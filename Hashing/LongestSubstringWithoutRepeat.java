/*
Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        int count = 0;
        int maxLen = 0;
        int visited[] = new int[256];
        for(int i=0; i<visited.length; i++) {
            visited[i] = -1;
        }
        for(int i=0; i<A.length(); i++) {
            int character = A.charAt(i);
            int prevPos = visited[character];
            if(prevPos == -1) {
                count++;
            }
            else {
                if(prevPos < i-count) {
                    count++;
                }
                else {
                    if(count>maxLen) {
                        maxLen = count;
                    }
                    count = i-prevPos;
                }
            }
            visited[character] = i;
        }
        return Math.max(maxLen,count);
    }
}
