/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.
*/

public class ZigzagString {
    public String convert(String A, int B) {
        StringBuilder s = new StringBuilder();
        int start = 0;
        int begin = ((B-2) * 2) + 2;
        while(B!=0) {
            int step = 0;
            if(start!=0 && start!=A.length()-1) {
                step = ((start-1) * 2) + 2;
            }
            int diff = ((B-2) * 2) + 2;
            diff = diff==0 ? begin>0 ? begin : 1 : diff;
            for(int i=start; i<A.length(); i=i+diff) {
                s.append(A.charAt(i));
                if(i!=start) {
                    i +=step;
                }
                if(i!=start && step!=0 && i<A.length()) {
                    s.append(A.charAt(i));
                }
            }
            B--;
            start++;
        }
        return s.toString();
    }
}
