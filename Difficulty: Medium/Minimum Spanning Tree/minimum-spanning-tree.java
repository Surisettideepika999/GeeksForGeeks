//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y) -> x[0]-y[0]);
        pq.add(new int[]{0,0});
        boolean[] visited=new boolean[V];
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int w=arr[0];
            int u=arr[1];
            if(visited[u])
            continue;
            visited[u]=true;
            sum+=w;
            for(int[] a:adj.get(u)){
                if(!visited[a[0]])
                pq.add(new int[]{a[1],a[0]});
            }
        }
        return sum;
    }
}