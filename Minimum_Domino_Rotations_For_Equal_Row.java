class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans =Integer.MAX_VALUE;

        for(int i=1;i<=6;i++){
            int val =numberOfRotations(tops,bottoms,i);
            if(val!=-1){
                ans = Math.min(ans,val);
            }
        }

        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }

    public int numberOfRotations(int tops[], int bottoms[], int val){
        int topRotations =0;
        int bottomRotations=0;
        int n = tops.length;

        for(int i=0;i<n;i++){
            if(tops[i]!=val && bottoms[i]!=val){
                return -1;
            }
            if(tops[i]!=val){
                topRotations++;
            }
            if(bottoms[i]!=val){
                bottomRotations++;
            }
        }

        return Math.min(topRotations, bottomRotations);
    }
}