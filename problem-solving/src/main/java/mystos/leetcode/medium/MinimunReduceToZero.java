package mystos.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimunReduceToZero {

	public static void main(String args[]) {
		int[] nums = new int[] { 1, 1, 4, 2, 3 };
		int x = 5;

		System.out.println("Solution: " + minOperations(nums, x));

	}

	public static int minOperations(int[] nums, int x) {

		Map<Integer, Integer> valueMap = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			valueMap.put(sum, i);
		}

		if (x > sum) {
			return -1;
		}

		valueMap.put(0, 0);

		int longest = 0;
		sum -= x;
		int val = 0;

		for (int i = 0; i < nums.length; i++) {

			val += nums[i];

			if (valueMap.containsKey(val - sum)) {
				if (val - sum == 0) {
					longest = Math.max(longest, i - valueMap.get(val - sum) + 1);
				} else {
					longest = Math.max(longest, i - valueMap.get(val - sum));
				}
			}
		}

		return longest == 0 ? (sum == 0 ? nums.length : -1) : nums.length - longest;
	}

}
