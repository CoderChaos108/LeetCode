class Solution {
    int oddMin = Integer.MAX_VALUE;
    int evenMin = Integer.MAX_VALUE;

    public boolean helper(int i, boolean odd, int[] nums1) {
        if (i == nums1.length)
            return true;

        if (odd) {
            if (nums1[i] % 2 != 0)
                return helper(i + 1, odd, nums1);
            if (oddMin==Integer.MAX_VALUE||nums1[i] - oddMin < 1)
                return false;

            return helper(i + 1, odd, nums1);
        } else {
            if (nums1[i] % 2 == 0)
                return helper(i + 1, odd, nums1);
            if (oddMin==Integer.MAX_VALUE||nums1[i] - oddMin < 1)
                return false;

            return helper(i + 1, odd, nums1);
        }
    }

    public boolean uniformArray(int[] nums1) {

        for (int i : nums1) {
            if (i % 2 == 0)
                evenMin = Math.min(evenMin, i);
            else
                oddMin = Math.min(oddMin, i);
        }


        return helper(0, true, nums1)||helper(0,false,nums1);
    }
}