class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;
        int[] presum = new int[n+1];
        for (int i = 0; i < n; i++) {
            presum[i+1] = presum[i] + A[i];
        }
        int res = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : presum) {
            res += counter.getOrDefault(x, 0);
            counter.put(x+S, counter.getOrDefault(x+S, 0) + 1);
        }
        return res;
    }
}