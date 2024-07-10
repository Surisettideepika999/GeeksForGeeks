//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
        int res=0,cs=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(char c:S.toCharArray()){
            if(Character.isLowerCase(c))
            cs--;
            else
            cs++;
            if(cs==0)
            res++;
            if(hm.containsKey(cs))
            res+=hm.get(cs);
            hm.put(cs,hm.getOrDefault(cs,0)+1);
        }
        return res;
    }
} 
