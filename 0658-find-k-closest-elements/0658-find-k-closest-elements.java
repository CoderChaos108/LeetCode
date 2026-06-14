class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        int p = -1;
        int q = arr.length;

        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] <= x) {
                p = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = 0;
        r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] > x) {
                q = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        int count = 0;

        while (count < k) {
            if (p < 0) {
                q++;
            }
            else if (q >= arr.length) {
                p--;
            }
            else {
                int leftDist = Math.abs(arr[p] - x);
                int rightDist = Math.abs(arr[q] - x);

                if (leftDist <= rightDist) {
                    p--;
                } else {
                    q++;
                }
            }

            count++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = p + 1; i < q; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}