class Solution {
    int timer = 1;

    public void dfs(int curr,int parent,List<List<Integer>> adj,List<List<Integer>> bridges,int[] time,int low[],boolean[] visited){
        visited[curr] = true;

        low[curr] = time[curr] = timer;
        timer++;

        for(int nei : adj.get(curr)){
            if(parent==nei) continue;
            
            if(!visited[nei]){
                dfs(nei,curr,adj,bridges,time,low,visited);

                low[curr] = Math.min(low[nei],low[curr]);

                if(low[nei]>time[curr]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(curr);
                    bridge.add(nei);
                    bridges.add(bridge);
                }
            }
            else{
                low[curr] = Math.min(low[nei],low[curr]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> E) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> e : E){
            int u = e.get(0);
            int v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int[] time = new int[V];
        int[] low = new int[V];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,adj,bridges,time,low,visited);

        return bridges;
    }
}

