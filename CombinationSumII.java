package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		int[] candidates = { 2, 5, 2, 1, 2 };
		int target = 5;
		Arrays.sort(candidates);
		List<List<Integer>> l1 = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		sum(candidates, target, l, l1, 0);
		System.out.println(l1);

	}

	private static void sum(int[] arr, int target, List<Integer> l, List<List<Integer>> l1, int lastcoinused) {

		if (target == 0) {
			l1.add(new ArrayList<Integer>(l));
			return;
		}
		if (target < 0)
			return;

		for (int i = lastcoinused; i < arr.length; i++) {
			if (i == lastcoinused || arr[i] != arr[i - 1]) {
				l.add(arr[i]);
				sum(arr, target - arr[i], l, l1, i + 1);
				l.remove(l.size() - 1);
			}
		}
	}

}
