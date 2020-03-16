/*
Given a number N >= 0, find its representation in binary.

Example:
if N = 6,
binary form = 110
*/

public class BinaryRepresentation {
    public String findDigitsInBinary(int A) {
        StringBuilder s = new StringBuilder();
        if(A==0) {
            s.append(0);
            return s.toString();
        }
        while(A>=1) {
            s.append(A%2);
            A = (int) A/2;
        }
        return s.reverse().toString();
    }
}
