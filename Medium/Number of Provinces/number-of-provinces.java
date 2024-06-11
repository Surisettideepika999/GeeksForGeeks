//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void dfs(int i, int[] v,ArrayList<ArrayList<Integer>> adj){
        if(v[i]==1)
        return;
        v[i]=1;
        for(int j=0;j<adj.get(i).size();j++){
            if(adj.get(i).get(j)==1 && v[j]==0)
            dfs(j,v,adj);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        // HashMap<Integer,ArrayList<Integer>> h=new HashMap<>();
        // for(int i=1;i<=V;i++){
        //     h.put(i,new ArrayList<Integer>());
        // }
        // for(int i=0;i<adj.length;i++){
        //     for(int j=0;j<adj.get())
        // }
        int []v=new int[V];
        int i=0,c=0;
        while(i<V){
            if(v[i]==0){
                c++;
                dfs(i,v,adj);
            }
            i++;
        }
        return c;
    }
};