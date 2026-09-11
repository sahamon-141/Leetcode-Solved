class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i] = 0;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int nei : graph[curr]){
                        if(color[nei]==-1){
                            q.add(nei);
                            color[nei] = color[curr]==0?1:0;
                        }
                        else if(color[nei]==color[curr]) return false;
                    }
                }
            }
        }
        return true;
    
    }
}