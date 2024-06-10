//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean dfs(int i, int j, char board[][], String s,int ind){
        if(ind==s.length())
        return true;
        if(i>=board.length || j>=board[0].length || i<0 || j<0 || board[i][j]!=s.charAt(ind))
        return false;
        char t=board[i][j];
        board[i][j]='*';
        boolean res = dfs(i+1,j,board,s,ind+1) ||
                      dfs(i+1,j-1,board,s,ind+1) ||
                      dfs(i,j-1,board,s,ind+1) ||
                      dfs(i-1,j-1,board,s,ind+1) ||
                      dfs(i-1,j,board,s,ind+1) ||
                      dfs(i-1,j+1,board,s,ind+1) ||
                      dfs(i,j+1,board,s,ind+1) ||
                      dfs(i+1,j+1,board,s,ind+1);
        board[i][j]=t;
        return res;
    }
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        ArrayList<String> a=new ArrayList<>();
        int m=0,n=0,k=0;
        for(String s : dictionary){
            char c=s.charAt(0);
                for(int i=0;i<board.length;i++){
                    for(int j=0;j<board[0].length;j++){
                        if(board[i][j]==c && dfs(i,j,board,s,0)){
                            if(!a.contains(s))
                            a.add(s);
                            break;
                        }
                }
            }
        }
        return a.toArray(new String[0]);
    }
}









