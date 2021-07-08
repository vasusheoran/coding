// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DirectedGraph
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution 
{
    public boolean util(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[],  boolean recStack[]){

        if(recStack[v]){
            return true;
        }

        if(visited[v]){
            return false;
        }

        recStack[v] = true;
        visited[v] = true;

        List<Integer> list  = adj.get(v);


        for(Integer i: list){

            System.out.println("v: " + v + ", i: " + i + ", visited: " + visited[i]  + ", recStack: " + recStack[i] );
            if (util(i, adj, visited, recStack)){
                System.out.println();
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }
    //Function to detect cycle in an undirected graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here

        boolean visited[] = new boolean[adj.size()];
        boolean recStack[] = new boolean[adj.size()];

        for(int i = 0; i<V; i++){
            if(util(i, adj, visited, recStack)){
                return true;
            }
        }

        return false;
    }
}