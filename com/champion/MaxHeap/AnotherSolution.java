package com.champion.MaxHeap;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.List;
import java.util.PriorityQueue;

public class AnotherSolution {

    private class Freq {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        // use a map to count the frequency of each num
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        // choose the k num that have the most frequency and add them into a priorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b)->map.get(a)-map.get(b)
        );
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else {
                if (map.get(key) > pq.peek()) {
                    pq.remove();
                    pq.add(key);
                }
            }
        }
        List<Integer> retList = new LinkedList<>();
        while (!pq.isEmpty()) {
            retList.add(pq.remove());
        }
        return retList;
    }

}


