//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
     private boolean isSafe(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] != 0) {
            return state[node] == 2;
        }
        state[node] = 1; // mark as visiting

        for (int nextNode : graph.get(node)) {
            if (!isSafe(graph, state, nextNode)) {
                return false;
            }
        }

        state[node] = 2; // mark as safe
        return true;
    }


    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {


          List<Integer> safeNodes = new ArrayList<>();
        int[] state = new int[V]; // 0: unvisited, 1: visiting, 2: visited and safe

        for (int i = 0; i < V; i++) {
            if (isSafe(adj, state, i))
                safeNodes.add(i);
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
