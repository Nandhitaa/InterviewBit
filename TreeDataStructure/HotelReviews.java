/*
Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class HotelReviews {

    public class Node {
        public int count;
        public int index;
        
        Node(int count, int index) {
            this.count = count;
            this.index = index;
        }
    }
    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            if(n1.count==n2.count) return n1.index - n2.index;
            return n2.count-n1.count;
        }
    }
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        if(A==null) return null;
        if(B==null) return null;
        String[] good_words_list = A.split("_");
        HashSet<String> set = new HashSet<String>(Arrays.asList(good_words_list));
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int i=0; i<B.size(); i++) {
            int count = 0;
            for(String word: B.get(i).split("_")) {
                if(set.contains(word)) count++;
            }
            nodes.add(new Node(count,i));
        }
        Collections.sort(nodes,new NodeComparator());
        for(Node node : nodes) {
            ans.add(node.index);
        }
        return ans;
    }
}
