class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        int i =0;
        for(String s : words){
            if(s.indexOf(x)!=-1){
                ans.add(i);
            }
            i++;
        }
        return ans;
    }
}