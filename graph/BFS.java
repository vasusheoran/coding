// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class BFS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends





class Solution
    {
        //Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // Code here
            int visited[] = new int[adj.size()];
            ArrayList<Integer> result = new ArrayList<Integer>();

            for ( int i= 0; i<visited.length; i++){
                visited[i] = 0;
            }

            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[0] = 1;
            queue.add(0);
            
            while(queue.size() !=0 ){

                int node = queue.poll();
                result.add(node);

                ListIterator<Integer> iter = adj.get(node).listIterator();

                while(iter.hasNext()){
                    int newNode = iter.next();
                    if(visited[newNode] == 0){
                        visited[newNode] = 1;
                        queue.add(newNode);
                    }
                }


            }
            
            return result;

        }

}