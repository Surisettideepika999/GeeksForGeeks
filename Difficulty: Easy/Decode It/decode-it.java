//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t,i;
	    t=Integer.parseInt(br.readLine());
	    while(t-->0){
	        
	        String str=br.readLine();
	        int k=Integer.parseInt(br.readLine());
	        Solution ob = new Solution();
            System.out.println(ob.decodeIt(str, k));
            
	    }
	}
}
// } Driver Code Ends


class Solution{

    static char decodeIt(String str,int k){
        // Write your code here
        int t=0,n=str.length();
        String s="";
        for(int i=0;i<n;i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                s+=str.charAt(i);
            }
            else{
            int count=str.charAt(i)-'0';
            String res=s;
            for(int j=0;j<count-1;j++){
                s+=res;
            }
            }
        }
        // System.out.println(s);
        return s.charAt(k-1);
    }
}