//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.encode(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String encode(String s) {
        // code here
        int c=1;
        char c1=s.charAt(0),c2=s.charAt(0);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<s.length();i++){
             c1=s.charAt(i);c2=s.charAt(i-1);
            if(c1==c2)
            c++;
            else{
                sb.append(c2);
                sb.append(Integer.toString(c));
                c=1;
            }
        }
        sb.append(c1);
        sb.append(Integer.toString(c));
        return sb.toString();
    }
}
    