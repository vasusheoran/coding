// { Driver Code Starts
import java.util.*;
class HeapSort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        HeapSort hs = new HeapSort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}


// } Driver Code Ends




class Solution
{

    int size;
    int cur;


    int parent(int pos) {
        return (pos - 1)/2;
    }

    int lc(int pos){
        return (pos * 2) + 1;
    }

    int rc(int pos){
        return (pos * 2) + 2;
    }

    void swap(int []arr, int f, int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    void insert(int arr[], int x) {
        if (cur > size - 1){
            return;
        }

        int index = cur;
        int parent = parent(index);

        // System.out.println("x: " + x + ", cur: " + cur + ", parent: " + parent);

        while(index != 0 && arr[parent] > arr[index]){
            // System.out.print("index: " + index + ", parent: " + parent + ", index val: " + arr[index] + ", parent val: " + arr[parent] + "\n");
            swap(arr, parent, index);
            index = parent;
            parent = parent(parent);
        }

        cur++;
    }

    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        this.cur = 0;
        this.size = n;
        // Your code here

        for (int i = 0; i< n;i++){
            insert(arr, i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int smallest = arr[i];
        int lc = lc(i);
        int rc = rc(i);

        if (!(i < size && lc < size)){
            return;
        }

        if (rc >= size) {
            if(arr[i] > arr[lc])
                swap(arr, lc, i);
            return;
        }

        if(arr[i] > arr[lc] && arr[lc] < arr[rc]){
            swap(arr, lc, i);
            heapify(arr, n, lc);
        }else if(arr[i] > arr[rc]){
            swap(arr, rc, i);
            heapify(arr, n, rc);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);
        // System.out.println();
        int temp[] = new int[n];
        for (int i=0; i<n; ++i)
            temp[i] = arr[i];

        
        // arr[0] = Integer.MAX_VALUE;
        // heapify(arr, n , 0);
        for(int i = 0; i< n; i++){
            arr[i] = temp[0];
            temp[0] = Integer.MAX_VALUE;
            heapify(temp, n , 0);

        }
    }
 }
 
 
