package com.Learn.BT;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-26 14:35
 **/
public class Leetcode855 {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.getTreeSet());

    }

    static class ExamRoom {
        // 座位个数
        private int N;
        // <i,[v0,v1]>以i为区间下界的区间，v0到v1
        private Map<Integer, int[]> mapWithStart;
        // <i,[v0,v1]>以i为区间上界的区间，v0到v1
        private Map<Integer, int[]> mapWithEnd;
        // 根据区间长度从小到大排列的有序集合
        private TreeSet<int[]> treeSet;

        public Map<Integer, int[]> getMapWithStart() {
            return mapWithStart;
        }

        public Map<Integer, int[]> getMapWithEnd() {
            return mapWithEnd;
        }

        public TreeSet<int[]> getTreeSet() {
            return treeSet;
        }

        // 构造函数，传入座位总数 N
        public ExamRoom(int N) {
            this.N = N;
            mapWithStart = new HashMap<>();
            mapWithEnd = new HashMap<>();
            treeSet = new TreeSet<>((a, b) -> {
                int lenA = distance(a);
                int lenB = distance(b);

                if (lenA == lenB) return a[0] - b[0];
                return lenB - lenA;
            });
            addInterval(new int[]{-1, N});
        }

        // 来了一名考生，返回你给他分配的座位
        public int seat() {
            int[] longest = treeSet.pollFirst();
            int x = longest[0];
            int y = longest[1];
            int seat;
            if (x == -1) {
                seat = 0;
            } else if (y == N) {
                seat = N - 1;
            } else {
                seat = x + (y - x) / 2;
            }

            int[] left = new int[]{x, seat};
            int[] right = new int[]{seat, y};
            removeInterval(longest);
            addInterval(left);
            addInterval(right);
            return seat;
        }

        // 坐在 p 位置的考生离开了
        // 可以认为 p 位置一定坐有考生
        public void leave(int p) {
            int[] right = mapWithStart.get(p);
            int[] left = mapWithEnd.get(p);
            int[] merge = new int[]{left[0], right[1]};
            removeInterval(left);
            removeInterval(right);
            addInterval(merge);
        }

        private void addInterval(int[] intv) {
            treeSet.add(intv);
            mapWithStart.put(intv[0], intv);
            mapWithEnd.put(intv[1], intv);
        }

        private void removeInterval(int[] intv) {
            treeSet.add(intv);
            mapWithStart.put(intv[0], intv);
            mapWithEnd.put(intv[1], intv);
        }

        // 返回区间的长度
        private int distance(int[] intv) {
            if (intv[0] == -1) return intv[1];
            if (intv[0] == N) return N - intv[0] - 1;
            return (intv[1] - intv[0]) / 2;
        }
    }
}
