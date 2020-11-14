import java.util.*;
import java.util.HashMap;
import javafx.util.Pair;
import java.util.Collections;

/**
 * Sorting
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k should be greater than 0");
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }

        if (k > freq.size()) {
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer key : freq.keySet()) {
            res.add(key);
        }

        Collections.sort(res, (a, b) -> {
            if (freq.get(a) != freq.get(b)) {
                return freq.get(b) - freq.get(a);
            }
            return a - b;
        });
        return res.subList(0, k);
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
        printList((new Solution2()).topKFrequent(nums, k));
    }
}
