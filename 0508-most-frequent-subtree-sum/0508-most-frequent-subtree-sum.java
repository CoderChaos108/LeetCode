class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int maxFreq = 0;

    public int sumf(TreeNode node) {
        if (node == null) return 0;

        int left = sumf(node.left);
        int right = sumf(node.right);
        int sum = node.val + left + right;

        int freq = hm.getOrDefault(sum, 0) + 1;
        hm.put(sum, freq);

        maxFreq = Math.max(maxFreq, freq);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        sumf(root);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
