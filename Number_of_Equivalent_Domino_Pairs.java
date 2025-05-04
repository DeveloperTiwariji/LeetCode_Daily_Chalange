class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans =0;

        int n = dominoes.length;
        int m = dominoes[0].length;


        // O(N^2)===========================

        // for(int i=0;i<n;i++){
        //     int arr1[] = dominoes[i];
        //     for(int j=i+1;j<n;j++){
        //         int arr2[] = dominoes[j];
        //         int a = arr1[0];
        //         int b = arr1[1];
        //         int c = arr2[0];
        //         int d = arr2[1];
        //         if((a==c && b==d) || (a==d && b==c)){
        //             ans++;
        //         }
        //     }



        // O(N)=============================

        int[] count = new int[100];

            for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            int key = a < b ? a * 10 + b : b * 10 + a;
            ans += count[key];
            count[key]++;
            }

        return ans;
    }
}