class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int result[][] = new int[n][m];
         int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int row[]: result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        result[0][0] = 0;
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int time = curr[0];
            int i=curr[1];
            int j= curr[2];

            if(i==n-1 && j==m-1){
                return time;
            }

            for(int dir[]: direction){
                int ni = i+dir[0];
                int nj = j+dir[1];

                if(ni>=0 && ni<n && nj>=0 && nj<m){

                    int mm = (ni+nj)%2==0?2:1;
                    int wait = Math.max(moveTime[ni][nj]-time,0);
                    int actualTime = wait+time+mm;


                    if(actualTime<result[ni][nj]){
                        result[ni][nj] = actualTime;
                        pq.add(new int[]{actualTime, ni,nj});
                    }
                }
            }
        }

        return -1;
    }
}