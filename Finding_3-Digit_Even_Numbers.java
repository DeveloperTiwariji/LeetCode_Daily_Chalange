class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> st = new HashSet<>();
        int map[] = new int[10];

        for(int i=0;i<n;i++){
            map[digits[i]]++;
        }
        for(int i=1;i<=9;i++){
            if(map[i]==0) continue;
            map[i]--;
            for(int j=0;j<=9;j++){
                if(map[j]==0) continue;
                map[j]--;
                for(int k=0;k<=8;k+=2){
                    if(map[k]==0) continue;
                    map[k]--;
                    int num = (i*100)+(j*10)+k;
                    st.add(num);
                    map[k]++;
                }
                map[j]++;
            }
            map[i]++;
        }

        int ans[] = new int[st.size()];
        int x=0;
        for(int val: st){
            ans[x] = val;
            x++;
        }
         Arrays.sort(ans);
        return ans;
    }
}
