//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String A[] = in.readLine().trim().split(" ");
		    int N = Integer.parseInt(A[0]);
		    A = in.readLine().trim().split(" ");
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isCircle(N, A));
		}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    // Depth-First Search (DFS) function to count nodes in a connected component
    private int dfs(int node, List<Integer>[] g, int[] vis) {
        vis[node] = 1;  // Mark the current node as visited
        int ans = g[node].size();  // Initialize the answer with the number of outgoing edges
        
        // Traverse through all neighbors of the current node
        for (int i : g[node]) {
            if (vis[i] == 0) {  // If the neighbor is not visited
                ans += dfs(i, g, vis);  // Recursively calculate the number of nodes in the component
            }
        }
        
        return ans;  // Return the total number of nodes in the connected component
    }
    
    public int isCircle(int n, String[] A) {
        // Initialize adjacency list for the graph (assuming 26 letters)
        List<Integer>[] g = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            g[i] = new ArrayList<>();
        }
        
        // Arrays to store in-degree and out-degree of each node
        int[] indeg = new int[26];
        int[] outdeg = new int[26];
        
        // Build the graph and calculate in-degree and out-degree
        for (String edge : A) {
            // Extract first and last characters of the string to determine edges
            char from = edge.charAt(0);
            char to = edge.charAt(edge.length() - 1);
            
            // Add the edge to the adjacency list
            g[from - 'a'].add(to - 'a');
            
            // Update in-degree and out-degree
            outdeg[from - 'a']++;
            indeg[to - 'a']++;
        }
        
        // Check if in-degree and out-degree are equal for each node
        for (int i = 0; i < 26; i++) {
            if (indeg[i] != outdeg[i]) {
                return 0;  // If any node has unequal in-degree and out-degree, return false
            }
        }
        
        // Array to mark visited nodes
        int[] vis = new int[26];
        
        // Perform DFS from the first node and check if all nodes are reachable
        
        if(n == dfs(A[0].charAt(0) - 'a', g, vis))
        return 1;
        else
        return  0;
    }
}
