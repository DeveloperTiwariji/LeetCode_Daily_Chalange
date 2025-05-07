

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        result[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (i == m - 1 && j == n - 1) {
                return currTime;
            }

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int wait = Math.max(moveTime[ni][nj] - currTime, 0);
                    int arrTime = currTime + wait + 1;

                    if (arrTime < result[ni][nj]) {
                        result[ni][nj] = arrTime;
                        pq.offer(new int[]{arrTime, ni, nj});
                    }
                }
            }
        }

        return -1;
    }
}
