/*
Implement pow(A, B) % C.

In other words, given A, B and C,
find (AB)%C.

Input : A = 2, B = 3, C = 3
Return : 2 
2^3 % 3 = 8 % 3 = 2
*/

public class ModularExpression {
    public int Mod(int A, int B, int C) {
        if(A==0) {
            return 0;
        }
        if(B == 0) {
            return 1;
        }
        long y;
        if(B%2 == 0) {
            y = Mod(A, B/2, C);
            y = (y*y) % C;
        }
        else {
            y = A % C;
            y = (y * Mod(A, B-1, C)) % C;
        }
        return (int) (y+C)%C;
    }
}
