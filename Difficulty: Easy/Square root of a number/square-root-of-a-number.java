//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        long mid,l=0,r=n,p=1;
        while(l<=r){
            mid=(l+r)/2;
            p=mid*mid;
            if(p==n)
            return mid;
            else if(p>n)
            r=mid-1;
            else l=mid+1;
        }
        return l-1;
    }
}
