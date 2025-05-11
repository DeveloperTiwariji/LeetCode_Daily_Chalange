class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]%2!=0){
                int cnt =1;
                int idx =i+1;
                while(idx<n && arr[idx]%2!=0){
                        cnt++;
                    if(cnt==3){
                        return true;
                    }
                    idx++;
                }
            }
        }
        return false;
    }
}