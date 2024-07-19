//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        boolean[] ar=new boolean[N+1];
        Arrays.fill(ar,true);
        ar[0]=false;
        ar[1]=false;
        for(int i=2;i<=N;i++){
            if(ar[i]){
                for(int j=2*i;j<=N;j=j+i){
                    ar[j]=false;
                }
            }
        }
        for(int i=2;i<=N;i++){
            if(ar[i])
            a.add(i);
        }
        return a;
    }
}