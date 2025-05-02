class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int leftNearestR[] = new int[n];
        int rightNearestL[] = new int[n];
        if(dominoes.charAt(0)=='R') leftNearestR[0] =0;
        else leftNearestR[0] =-1;

        for(int i=1;i<n;i++){
            if(dominoes.charAt(i)=='L'){
                leftNearestR[i] =-1;
            }else if(dominoes.charAt(i)=='R'){
                leftNearestR[i] =i;
            }else{
                leftNearestR[i] = leftNearestR[i-1];
            }
        }


        if(dominoes.charAt(n-1)=='L') rightNearestL[n-1] =n-1;
        else rightNearestL[n-1] =-1;

        for(int i=n-2;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                rightNearestL[i] =i;
            }else if(dominoes.charAt(i)=='R'){
                rightNearestL[i] =-1;
            }else{
                rightNearestL[i] = rightNearestL[i+1];
            }
        }

        String ans ="";

        for(int i=0;i<n;i++){

            int leftNearest = Math.abs(i-leftNearestR[i]);
            int rightNearest = Math.abs(i-rightNearestL[i]);
            if(leftNearestR[i]==rightNearestL[i]){
                ans+=".";
            }else if(leftNearestR[i]==-1){
                ans+="L";
            }else if(rightNearestL[i]==-1){
                ans+="R";
            }else{
                if(leftNearest<rightNearest){
                    ans+="R";
                }else if(rightNearest<leftNearest){
                    ans+="L";
                }else{
                    ans+=".";
                }
            }
        }

        return ans;
    }
}