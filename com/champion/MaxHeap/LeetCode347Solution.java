package com.champion.MaxHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


/**
 * Created by CP on 02/09/2018.
 */
public class LeetCode347Solution {
    private class Freq implements Comparable<Freq> {
        int e;
        int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
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
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else {
                if (map.get(key) > pq.getFront().freq) {
                    pq.dequeue();
                    pq.enqueue(new Freq(key, map.get(key)));
                }
            }
        }
        List<Integer> retList = new LinkedList<>();
        while (!pq.isEmpty()) {
            retList.add(pq.dequeue().e);
        }
        return retList;
    }
}
