/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        if(intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        if(end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        if(end == intervals.get(0).start) {
            Interval i = new Interval(start, intervals.get(0).end);
            intervals.set(0,i);
            return intervals;
        }
        if(start > intervals.get(intervals.size()-1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        if(start == intervals.get(intervals.size()-1).end) {
            Interval i = new Interval(intervals.get(intervals.size()-1).start, end);
            intervals.set(intervals.size()-1,i);
            return intervals;
        }
        if(start <= intervals.get(0).start && end >= intervals.get(intervals.size()-1).end) {
            intervals.clear();
            intervals.add(newInterval);
            return intervals;
        }
        if(start <= intervals.get(0).start) {
            intervals.add(0,newInterval);
        }
        else if (start >= intervals.get(intervals.size()-1).end) {
            intervals.add(newInterval);
        }
        else {
            for(int j=0; j<intervals.size()-1; j++) {
                if(start > intervals.get(j).start && start < intervals.get(j+1).start) {
                    intervals.add(j+1, newInterval);
                    break;
                }
            }
        }
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals.get(0));
        for(int j=1; j<intervals.size(); j++) {
            Interval i = intervals.get(j);
            if(stack.peek().end < i.start) {
                stack.push(i);
            }
            else if(stack.peek().end < i.end) {
                Interval top = stack.pop();
                top.end = i.end;
                stack.push(top);
            }
        }
        intervals.clear();
        while(!stack.isEmpty()) {
            intervals.add(stack.pop());
        }
        Collections.reverse(intervals);
        return intervals;
    }
}
