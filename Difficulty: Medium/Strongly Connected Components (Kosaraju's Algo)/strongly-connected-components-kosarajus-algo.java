//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    Stack<Integer> s=new Stack<>();
    public void dfs1(ArrayList<ArrayList<Integer>> adj,int i,boolean[] v){
        v[i]=true;
        for(Integer x:adj.get(i)){
            if(!v[x])
            dfs1(adj,x,v);
        }
        s.add(i);
    }
    public void dfs2(ArrayList<ArrayList<Integer>> adj,int i,boolean[] v){
        v[i]=true;
        for(Integer x:adj.get(i)){
            if(!v[x])
            dfs2(adj,x,v);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] v=new boolean[V];
        for(int i=0;i<V;i++){
            if(!v[i]){
                dfs1(adj,i,v);
            }
        }
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<V;i++){
            ar.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(Integer x:adj.get(i)){
                ar.get(x).add(i);
            }
        }
        int c=0;
         boolean[] vis=new boolean[V];
        while(!s.isEmpty()){
            int i=s.pop();
            if(!vis[i]){
                c++;
                dfs2(ar,i,vis);
            }
        }
        return c;
    }
}
