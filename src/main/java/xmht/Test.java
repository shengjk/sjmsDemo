package xmht;

import java.util.HashMap;

/**
 * @author shengjk1
 * @date 2020/2/29
 */
public class Test {
	public static void main(String[] args) {
		int[] a = {2, 7, 11, 15};
		for (int i : twoSum(a, 9)) {
			System.out.println(i);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				return new int[]{map.get(diff), i};
			}
		}
		return new int[]{};
	}
}
