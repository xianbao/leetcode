package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] re = new int[1][];
            re[0] = new int[]{newInterval[0], newInterval[1]};
            return re;
        }
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>(){{
            add(intervals[0][0]);
            add(intervals[0][1]);
        }});
        boolean hasSet = false;
        if (intervals.length == 1) {
            setInterval(lists, newInterval, lists.get(0));
            hasSet = true;
        }
        for (int row = 1; row < intervals.length; ) {
            int size = lists.size();
            List<Integer> temp = lists.get(size - 1);
            if (!hasSet) {
                if (newInterval[0] > intervals[row][0]) {
                    setInterval(lists, intervals[row], temp);
                    row += 1;
                } else {
                    setInterval(lists, newInterval, temp);
                    hasSet = true;
                }
            } else {
                setInterval(lists, intervals[row], temp);
                row += 1;
            }
        }
        if (!hasSet)
            setInterval(lists, newInterval, lists.get(lists.size() - 1));
        int[][] result = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> temp = lists.get(i);
            result[i] = new int[]{temp.get(0), temp.get(1)};
        }
        return result;
    }


    private void setInterval(List<List<Integer>> lists,int[] newInterval, List<Integer> temp) {
        if (temp.get(1) < newInterval[0]) {
            lists.add(new ArrayList<Integer>() {{
                add(newInterval[0]);
                add(newInterval[1]);
            }});
        } else if (temp.get(0) <= newInterval[0] && temp.get(1) <= newInterval[1]) {
            temp.set(1, newInterval[1]);
        } else if (temp.get(0) > newInterval[1]) {
            lists.add(0, new ArrayList<Integer>() {{
                add(newInterval[0]);
                add(newInterval[1]);
            }});
        } else if (temp.get(0) >= newInterval[0] && temp.get(1) >= newInterval[1]) {
            temp.set(0, newInterval[0]);
        } else if (temp.get(0) > newInterval[0] && temp.get(1) < newInterval[1]) {
            temp.set(0, newInterval[0]);
            temp.set(1, newInterval[1]);
        }
    }


    public static void main(String[] args) {
        InsertInterval test = new InsertInterval();
        int[][] intervals = new int[2][];
        intervals[0] = new int[]{2,6};
        intervals[1] = new int[]{7, 9};
//        intervals[2] = new int[]{6, 7};
//        intervals[3] = new int[]{8, 10};
//        intervals[4] = new int[]{12, 16};

        int[] newInterval = new int[]{15, 18};
        test.insert(intervals, newInterval);
    }
}
