//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color =new int[v];
        Arrays.fill(color,-1);
        Queue<Integer>q =new LinkedList<>();
        q.add(0);
         for(int j=0;j<v;j++){
            if(color[j]==-1){
            q.add(j);
            color[j]=1;
        while(!q.isEmpty()){
            int u=q.poll();
            for(Integer t:adj.get(u)){
                if(color[t]==-1){
                    color[t]=1-color[u];
                    q.add(t);
                }
                else if(color[t]==color[u])
                return false;
            }
        }
            }
         }
        return true;
    }
}