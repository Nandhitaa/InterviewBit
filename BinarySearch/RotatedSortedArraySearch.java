/*
Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE:- Array A was sorted in non-decreasing order before rotation.

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return index of B in array A, otherwise return -1
Constraints

1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are disitinct.
For Example

Input 1:
    A = [4, 5, 6, 7, 0, 1, 2, 3]
    B = 4
Output 1:
    0
Explanation 1:
 Target 4 is found at index 0 in A.


Input 2:
    A = [5, 17, 100, 3]
    B = 6
Output 2:
    -1
*/

import java.util.List;

public class RotatedSortedArraySearch {
    private int findPivot(List<Integer> A) {
        int low = 0;
        int high = A.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(mid < high && A.get(mid) > A.get(mid+1)) {
                return mid+1;
            }
            else if(mid>low && A.get(mid) < A.get(mid-1)) {
                return mid;
            }
            else if(A.get(mid)>A.get(0)) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
    private int binarySearch(List<Integer> A, int start, int end, int B) {
        while(start<=end) {
            int mid = (start+end)/2;
            if(A.get(mid) == B) {
                return mid;
            }
            else if(B > A.get(mid)) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int pivot = findPivot(A);
        if(pivot == -1) {
            return binarySearch(A, 0, A.size()-1, B);
        }
        if(A.get(pivot) == B) {
            return pivot;
        }
        if(B == A.get(0)) {
            return 0;
        }
        if(B > A.get(0)) {
            return binarySearch(A,1,pivot-1,B);
        }
        return binarySearch(A,pivot+1,A.size()-1,B);
    }
}
