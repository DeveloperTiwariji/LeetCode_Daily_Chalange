class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        
        long sum1 =0;
        long sum2 =0;
        int zeroNum1 =0;
        int zeroNum2 =0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        for(int i=0;i<n1;i++){
            sum1+=nums1[i];
            if(nums1[i]==0){
                zeroNum1++;
            }
        }
            for(int i=0;i<n2;i++){
            sum2+=nums2[i];
            if(nums2[i]==0){
                zeroNum2++;
            }
        }
        sum1+=zeroNum1;
        sum2+=zeroNum2;

        if(sum1<sum2 && zeroNum1==0){
            return -1;
        }else if(sum2<sum1 && zeroNum2==0){
            return -1;
        }else{
            return Math.max(sum1,sum2);
        }
    }
}