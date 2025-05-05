class Solution {

    int Mod = 1000000007;
    public int numTilings(int n) {

        if(n==1 || n==2) return n;
        int arr[]  = new int[n+1];

        arr[1] =1;
        arr[2] =2;
        arr[3] =5;

        for(int i=4;i<=n;i++){
            arr[i] = (int)(((2L*arr[i-1])%Mod + (arr[i-3])%Mod)%Mod);
        }

        return arr[n];

    }
}