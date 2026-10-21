import java.util.*;

class Solution { 
    static class Edge { 
        int time; 
        int src; 
        int dest; 
        
        Edge(int src, int dest, int time) { 
            this.src = src; 
            this.dest = dest; 
            this.time = time; 
        } 
    } 

    public int networkDelayTime(int[][] times, int n, int k) { 
        int[] dist = new int[n + 1]; 
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[k] = 0; 

        List<List<Edge>> adj = new ArrayList<>(); 
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>()); 
        } 

        for (int[] time : times) { 
            int u = time[0]; 
            int v = time[1]; 
            int w = time[2]; 
            adj.get(u).add(new Edge(u, v, w)); 
        } 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); 
        pq.offer(new int[]{0, k}); 

        while (!pq.isEmpty()) { 
            int[] top = pq.poll();
            int dis = top[0]; 
            int curr = top[1]; 
            if (dis > dist[curr]) continue; 

            for (Edge e : adj.get(curr)) { 
                int nei = e.dest; 
                int wt = e.time; 
                if (dis + wt < dist[nei]) { 
                    dist[nei] = dis + wt; 
                    pq.offer(new int[]{dist[nei], nei}); 
                } 
            } 
        } 

        int max = 0; 
        
        for (int i = 1; i <= n; i++) { 
            if (dist[i] == Integer.MAX_VALUE) return -1; 
            max = Math.max(max, dist[i]); 
        } 

        return max; 
    } 
}
