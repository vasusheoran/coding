// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class MedianInStream
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends

class MaxComparator implements Comparator<Integer> {

    public int compare(Integer a, Integer b){
        if (a < b)
            return 1;
        else if(a > b)
            return -1;
        else
            return 0;

    }
}

class Solution
{
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;
    static double median;
    static int count;

    public Solution(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(1, new MaxComparator());
        median = 0D;
        count = 0;
    }
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        if (minHeap.size() > maxHeap.size()){
            if (x > median){
                int top = minHeap.poll();
                maxHeap.add(top);
                minHeap.add(x);
            }else{
                maxHeap.add(x);
            }
        }else if(minHeap.size() < maxHeap.size()){
            if(x < median) {
                int top = maxHeap.poll();
                minHeap.add(top);
                maxHeap.add(x);
            }else{
                minHeap.add(x);
            }
        }else if(x < median){
            maxHeap.add(x);
        }else{
            minHeap.add(x);
        }

        if(minHeap.size() == maxHeap.size())
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        else if(minHeap.size() > maxHeap.size())
            median = minHeap.peek();
        else
            median = maxHeap.peek();


    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        return median;
    }
    
}