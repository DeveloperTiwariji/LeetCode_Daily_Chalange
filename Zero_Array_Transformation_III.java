class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;

        PriorityQueue<Integer> past = new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        int j = 0;               // Pointer to queries
        int usedCount = 0;       // Number of queries used

        for (int i = 0; i < n; i++) {
            while (j < queries.length && queries[j][0] == i) {
                maxHeap.offer(queries[j][1]);  // Push only end index
                j++;
            }

            nums[i] -= past.size();

            while (nums[i] > 0 && !maxHeap.isEmpty() && maxHeap.peek() >= i) {
                int r = maxHeap.poll();
                past.offer(r);
                usedCount++;
                nums[i]--;
            }

            if (nums[i] > 0)
                return -1;

            while (!past.isEmpty() && past.peek() == i) {
                past.poll();
            }
        }

        return queries.length - usedCount;
    }
}