import java.util.*;

public class practice1 {
    public int majorityElement(int[] nums) { // O(N2)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int freq = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                }

            }
            if (freq > n / 2) {
                return nums[i];
            }

        }
        return -1;
    }

    public int majorityElement1(int[] nums) { // O(LOGN)
        Arrays.sort(nums);
        int n = nums.length;
        int freq = 1, ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                freq++;
            } else {
                if (freq > n / 2) {
                    return ans;
                }
                ans = nums[i];
                freq = 1;
            }
        }
        if (freq > n / 2) {
            return ans;
        }
        return -1;

    }

    public int mooreVotingAlgo(int[] nums) { // O(N)
        int freq = 0, ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (freq == 0) {
                ans = nums[i];
            }
            if (ans == nums[i]) {
                freq++;
            } else {
                freq--;
            }
        }
        int count = 0;
        for (int val = 0; val < n; val++) {
            if (val == ans) {
                count++;
            }

        }
        if (count > n / 2) {
            return ans;
        } else {
            return -1;
        }

    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int n = grid.length;
        int a = -1, b = -1;
        int actualSum = 0, expSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];

                if (set.contains(grid[i][j])) {
                    a = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        expSum = (n * n) * (n * n + 1) / 2;
        b = expSum + a - actualSum;
        return new int[] { a, b };
    }

    public void mergeSort(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[idx--] = nums1[i--];

            } else {
                nums1[idx--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }

    public double myPow(double x, int n) {
        long binForm = n;
        if (n < 0) {
            x = 1 / x;
            binForm = -binForm;
        }

        double ans = 1;
        while (binForm > 0) {
            if (binForm % 2 == 1) {
                ans = ans * x;
            }
            x *= x;
            binForm /= 2;
        }
        return ans;
    }

    public int maxSubarray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);

            if (currSum < 0) {
                currSum = 0;
            }

        }
        return maxSum;

    }

    public int maxArea(int[] height) { // TLE Brute-Force-Approach
        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int wt = j - i;
                int ht = Math.min(height[i], height[j]);
                int area = wt * ht;

                maxWater = Math.max(maxWater, area);
            }
        }
        return maxWater;
    }

    public int maxArea1(int[] height) {
        int n = height.length;
        int lp = 0, rp = n - 1, ans = 0, maxWater = 0;
        while (lp < rp) {
            int w = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int currWt = w * ht;
            maxWater = Math.max(maxWater, currWt);

            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }

        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = { 1, 1 };
        practice1 obj = new practice1();
        System.err.println(obj.maxArea1(height));

    }
}
