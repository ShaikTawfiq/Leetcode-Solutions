class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(freq::get));
        for (int n : freq.keySet()) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
        
    }
}