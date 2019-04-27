import java.util.HashMap;

public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {
        // TODO
        //https://discuss.leetcode.com/topic/25465/longest-continous-zero-sum-subarray/6
        //Runtime: O(N)
        int[] maxArr = {0, 0};
        //Change 0s to -1s. This problem is now finding largest subarray with sum 0
        for (int i = 0; i < nums.length; i++) nums[i] = nums[i] * 2 - 1;

        // Accumulate the nums
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) sum[i] = nums[i - 1] + sum[i - 1];

        //If two indexes have the same sum, then there is a valid array between them
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            int s = sum[i];
            if (!sumToIndex.containsKey(s)) sumToIndex.put(s, i);
            int range = i - sumToIndex.get(s) - 1;
            if (range > maxArr[1] - maxArr[0]) maxArr = new int[]{sumToIndex.get(s), i - 1};
        }
        return maxArr;
    }
}
