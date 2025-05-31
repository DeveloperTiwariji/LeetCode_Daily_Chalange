class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[][]visited = new boolean[n][n];
        int steps =0;
        visited[n-1][0] =true;

        q.add(1);
        while(!q.isEmpty()){
            int N = q.size();
            while(N>0){
                int rv = q.poll();
                if(rv ==n*n) return steps;

                for(int i=1;i<=6;i++){
                    int val = rv+i;
                    if(val>n*n) break;

                    int a[] = getCoordinate(n,val);
                    int r = a[0];
                    int c = a[1];
                    if(visited[r][c]==true) continue;
                    visited[r][c] = true;
                    if(board[r][c]==-1){
                        q.add(val);
                    }else{
                        q.add(board[r][c]);
                    }
                }
                N--;
            }
            steps++;
        }
        return -1;
    }

    public int[] getCoordinate(int n, int num){
        int RT = (num-1)/n;
        int RB = (n-1)-RT;

        int col = (num-1)%n;

        if((n%2==1 && RB%2==1) ||(n%2==0 && RB%2==0)){
            col = (n-1)-col;
        }

        int a[] = new int[2];
        a[0] = RB;
        a[1] = col;
        return a;
    }
}