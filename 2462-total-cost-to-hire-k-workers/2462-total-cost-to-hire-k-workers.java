class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int n = costs.length;

        if (n <= 2 * candidates) {
            Arrays.sort(costs);
            long s = 0;

            for (int i = 0; i < k; i++)
                s += costs[i];

            return s;
        }

        int l = candidates;
        int r = n - candidates - 1;

        for (int i = 0; i < l; i++)
            left.add(costs[i]);

        for (int i = r + 1; i < n; i++)
            right.add(costs[i]);

        long s = 0;

        while (k-- > 0) {
            if (right.isEmpty() ||
                (!left.isEmpty() && left.peek() <= right.peek())) {

                s += left.poll();

                if (l <= r)
                    left.add(costs[l++]);

            } else {
                s += right.poll();

                if (l <= r)
                    right.add(costs[r--]);
            }
        }

        return s;
    }
}