class Solution {
    private long sum;
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        sum =0;
        int count    =    0;
        int mimNuksan =Integer.MAX_VALUE;

        for(int val: nums){
            if((val^k)>val){
                sum+= (val^k);
                count++;
            }else{
                sum+= val;
            }

            mimNuksan = Math.min(mimNuksan, Math.abs(val-(val^k)));
        }

        if(count%2==0) return sum;
        else{
            return sum-mimNuksan;
        }
    }
}