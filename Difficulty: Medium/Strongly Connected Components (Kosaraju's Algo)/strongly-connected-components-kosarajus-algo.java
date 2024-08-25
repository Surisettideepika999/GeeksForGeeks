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
    public void dfs1(int i,boolean[] v,ArrayList<ArrayList<Integer>> adj){
        v[i]=true;
        for(Integer x:adj.get(i))
        {
            if(!v[x])
            dfs1(x,v,adj);
        }
        s.push(i);
    }
     public void dfs2(int i,boolean[] v,ArrayList<ArrayList<Integer>> adj){
        v[i]=true;
        for(Integer x:adj.get(i))
        {
            if(!v[x])
            dfs2(x,v,adj);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean vis[]=new boolean[V];
       for(int i=0;i<V;i++){
           if(!vis[i])
           dfs1(i,vis,adj);
       }
       ArrayList<ArrayList<Integer>> adj2=new ArrayList<>();
       for(int i=0;i<V;i++)
       adj2.add(new ArrayList<>());
       for(int i=0;i<V;i++){
           for(Integer x:adj.get(i)){
               adj2.get(x).add(i);
           }
       }
       int c=0;
       boolean v[]=new boolean[V];
       while(!s.isEmpty()){
           int t=s.pop();
           if(!v[t]){
               c++;
               dfs2(t,v,adj2);
           }
       }
       return c;
    }
}
