//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for(int i=0; i<ptr.size(); i++)
            {
                for(int j=0; j<ptr.get(i).size(); j++)
                {
                    if(j==ptr.get(i).size()-1)
                        System.out.print(ptr.get(i).get(j));
                    else
                        System.out.print(ptr.get(i).get(j) + " ");
                }
                System.out.print(",");
            }
            System.out.println();
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.
    public void dfs1(int i,ArrayList<ArrayList<Integer>> adj,boolean[] v,int V,Stack<Integer> s){
        v[i]=true;
        for(Integer x:adj.get(i)){
            if(!v[x])
            dfs1(x,adj,v,V,s);
        }
        s.add(i);
    }
     public void dfs2(int i,ArrayList<ArrayList<Integer>> adj,boolean[] v,int V,ArrayList<Integer> ans){
        v[i]=true;
        ans.add(i);
        for(Integer x:adj.get(i)){
            if(!v[x])
            dfs2(x,adj,v,V,ans);
        }
    }
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        boolean[] v=new boolean[V];
        ArrayList<ArrayList<Integer>> t= new ArrayList<ArrayList<Integer>>();
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<V;i++){
            if(!v[i]){
                dfs1(i,adj,v,V,s);
            }
        }
        for(int i=0;i<V;i++)
        t.add(new ArrayList<Integer>());
        for(int i=0;i<V;i++){
            for(Integer x: adj.get(i)){
                t.get(x).add(i);
            }
        }
        int c=0;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        boolean v2[]=new boolean[V];
        while(!s.isEmpty()){
            int x=s.pop();
            if(!v2[x]){
                ArrayList<Integer> d=new ArrayList<>();
                c++;
                dfs2(x,t,v2,V,d);Collections.sort(d); ans.add(d);
            }
        }
        Collections.sort(ans, (x, y) -> Integer.compare(x.get(0), y.get(0)));
        return ans;
    }
}