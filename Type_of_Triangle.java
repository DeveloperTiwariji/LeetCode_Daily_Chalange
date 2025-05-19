class Solution {
    public String triangleType(int[] nums) {
        int l = nums[0];
        int h = nums[1];
        int b = nums[2];
        if(l==h && l==b){
            return "equilateral";
        }

        int sum1 =l+h;
        int sum2 = h+b;
        int sum3 = l+b;
        if(sum1>b && sum2>l && sum3>h){
            if(l==h || h==b || l==b){
                return "isosceles";
            }else{
                return "scalene";
            }
        }else{
            return "none";
        }
    }
}