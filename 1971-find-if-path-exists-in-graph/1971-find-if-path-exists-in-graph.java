class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        if(source==destination) return true;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];
        q.add(source);
        visited[source] = 1;
        while(!q.isEmpty()){
            int curr = q.remove();
            
                for(int neighbour:adj.get(curr)){
                    if(neighbour==destination) return true;
                    if(visited[neighbour]==0){
                        q.add(neighbour);
                        visited[neighbour]=1;
                    }
                }
            
        }
        return false;
    }
}