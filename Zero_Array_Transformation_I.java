class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n+1];

        for(int arr[]: queries){
            int a = arr[0];
            int b = arr[1];
            diff[a]-= 1;
            if(b+1<n){
                diff[b+1]+= 1;
            }
        }

        int sum = 0;

        for(int i=0;i<n;i++){
            sum+= diff[i];
            nums[i]+= sum;
            if(nums[i]>0){
                return false;
            }
        }
        return true;
    }
}