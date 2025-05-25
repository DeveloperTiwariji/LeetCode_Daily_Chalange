class Solution {
    public int longestPalindrome(String[] words) {
        int maxLen =0;
        int n = words.length;
        Map<String,Integer> map = new HashMap<>();

        for(String word: words){
            String reverce = ""+word.charAt(1)+word.charAt(0);

            if(map.getOrDefault(reverce,0)>0){
                map.put(reverce, map.get(reverce)-1);
                maxLen+= 4;
            }else{
                if(map.containsKey(word)){
                    map.put(word, map.get(word)+1);
                }else{
                    map.put(word, 1);
                }
            }
        }

        for(String word: words){
            if(word.charAt(0)==word.charAt(1) && map.get(word)>0){
                maxLen+= 2;
                break;
            }
        }


        return maxLen;
    }
}