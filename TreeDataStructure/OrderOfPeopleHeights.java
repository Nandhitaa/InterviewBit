/*
You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input : 
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output : 
actual order is: 5 3 2 1 6 4 
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderOfPeopleHeights {
    class Person {
        int height;
        int infront;
        Person(int height, int infront) {
            this.height = height;
            this.infront = infront;
        }
    }
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Person> persons = new ArrayList<Person>();
        for(int i=0; i<A.size(); i++) {
            Person person = new Person(A.get(i), B.get(i));
            persons.add(person);
        }
        Collections.sort(persons, new Comparator<Person>(){
            public int compare(Person p1, Person p2) {
                if(p1.height < p2.height) return -1;
                else if(p1.height == p2.height){
                    if(p1.infront < p2.infront) return -1;
                    else return 1;
                }
                else return 1;
            }
        });
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<persons.size(); i++) {
            ans.add(-1);
        }
        for(int i=0; i<persons.size(); i++) {
            int count = persons.get(i).infront;
            int height = persons.get(i).height;
            for(int j=0; j<ans.size(); j++) {
                if(count==0 && ans.get(j)==-1) {
                    ans.set(j,height);
                    break;
                }
                if(ans.get(j) == -1) {
                    count--;
                }
            }
        }
        return ans;
    }
}
