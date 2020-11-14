import java.util.*;
import java.util.HashMap;

/**
 * Priority Queue
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
class Solution3 {

    private class Pair implements Comparable<Pair> {
        public int num, freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair another) {
            return this.freq - another.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k should be greater than 0");
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int value : nums) {
            if (freq.containsKey(value)) {
                freq.put(value, freq.get(value) + 1);
            } else {
                freq.put(value, 1);
            }
        }

        if (k > freq.size()) {
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Integer num : freq.keySet()) {
            int numFreq = freq.get(num);
            if (pq.size() == k && numFreq > pq.peek().freq) {
                pq.poll();
            }
            if (pq.size() < k) {
                pq.add(new Pair(num, numFreq));
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().num);
        }

        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution3()).topKFrequent(nums, k));
    }
}