/*
Given an array A, count the number of inversions in the array.

Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j

Example:

A : [2, 4, 1, 3, 5]
Output : 3
as the 3 inversions are (2, 1), (4, 1), (4, 3).
*/

import java.util.ArrayList;

public class INVERSIONS {
    static int count;
    public void merge(ArrayList<Integer> A, int left, int mid, int right) {
        int p=left;
        int q=mid+1;
        int length = right-left+1;
        int sortedList[] = new int[length];
        for(int i=0; i<length; i++) {
            if(p>mid) {
                sortedList[i] = A.get(q++);
            }
            else if(q>right) {
                sortedList[i] = A.get(p++);
            }
            else if(A.get(p) <= A.get(q)) {
                sortedList[i] = A.get(p++);
            }
            else {
                sortedList[i] = A.get(q++);
                count += mid-p+1;
            }
        }
        for(int i=0; i<length; i++) {
            A.set(left++, sortedList[i]);
        }
    }
    public void mergesort(ArrayList<Integer> A, int left, int right) {
        if(left < right) {
            int mid = (left + right)/2;
            mergesort(A, left, mid);
            mergesort(A, mid+1, right);
            merge(A, left, mid, right);
        }
    }
    public int countInversions(ArrayList<Integer> A) {
        count = 0;
        mergesort(A, 0, A.size()-1);
        return count;
    }
}
