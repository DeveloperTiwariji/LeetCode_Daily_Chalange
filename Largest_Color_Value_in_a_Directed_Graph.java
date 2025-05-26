class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n =colors.length();

        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
        }
        int indegree[] = new int[n];

        for(int i=0;i<n;i++){
            for(int nbr: map.get(i)){
                indegree[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int cnt[][] = new int[n][26];

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int ans =0;
        int count =0;
        while(!q.isEmpty()){
            int rv = q.poll();
            count++;
            cnt[rv][colors.charAt(rv)-'a']++;
            ans = Math.max(ans, cnt[rv][colors.charAt(rv)-'a']);

            for(int nbr: map.get(rv)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
                for(int j=0;j<26;j++){
                    cnt[nbr][j] = Math.max(cnt[rv][j], cnt[nbr][j]);
                }
            }

        }
        return count==n? ans:-1;
    }
}