/*
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov

 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
*/

import java.util.ArrayList;

public class ShortestUniquePrefix {
    static final int MAX = 26;
    static final int MAX_WORD_LEN = 500;
    static ArrayList<String> ans;
    static TrieNode root;
    static class TrieNode {
        TrieNode child[] = new TrieNode[MAX];
        int freq;
        TrieNode() {
            freq = 1;
            for(int i=0; i<MAX; i++) {
                child[i] = null;
            }
        }
    }
    static void insert(String str) {
        TrieNode crawl = root;
        for(int i=0; i<str.length(); i++) {
            int ind = str.charAt(i) - 'a';
            if(crawl.child[ind] == null) {
                crawl.child[ind] = new TrieNode();
            }
            else {
                crawl.child[ind].freq++;
            }
            crawl = crawl.child[ind];
        }
    }
    static int findPrefix(TrieNode root, String word) {
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.child[index]!=null && root.child[index].freq==1) return i++;
            else root = root.child[index];
        }
        return -1;
    }
    public ArrayList<String> prefix(ArrayList<String> A) {
        root = new TrieNode();
        root.freq=0;
        ans = new ArrayList<String>();
        for(int i=0; i<A.size(); i++) {
            insert(A.get(i));
        }
        for(int i=0; i<A.size(); i++) {
            int index = findPrefix(root, A.get(i));
            ans.add(A.get(i).substring(0,index+1));
        }
        return ans;
    }
}
