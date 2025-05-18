class Solution {

    private List<String> columnSet = new ArrayList<>();
    private int mod = (int)(1e9+7);
    int db[][];

    public void generateColumnStates(String currentColumn, int rowRemaining, char prevColor){
        if(rowRemaining==0){
            columnSet.add(currentColumn);
            return;
        }

        for(char nextColor: new char[]{'R','G','B'}){
            if(nextColor==prevColor) continue;
            generateColumnStates(currentColumn+nextColor, rowRemaining-1, nextColor);
        }
    }

    public int solve(int remainingCol, int prevColIdx, int m){
        if(remainingCol==0) return 1;

        if(db[remainingCol][prevColIdx]!=-1) return db[remainingCol][prevColIdx];

        int total =0;
        String prevColumn = columnSet.get(prevColIdx);

        for(int i=0;i<columnSet.size();i++){
            String nextColumn = columnSet.get(i);

            boolean flag =true;

            for(int r =0;r<m;r++){
                if(prevColumn.charAt(r)==nextColumn.charAt(r)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                total = (total+solve(remainingCol-1, i, m))%mod;
            }


        }
        return db[remainingCol][prevColIdx]=total;
    }


    public int colorTheGrid(int m, int n) {
        
        generateColumnStates("", m, '#');

        int result =0;
        int len = columnSet.size();
        db = new int[n][len];

        for(int row[]: db){
            Arrays.fill(row, -1);
        }

        for(int i=0;i<columnSet.size();i++){
            result = (result+solve(n-1, i, m))%mod;
        }

        return result;
    }
}