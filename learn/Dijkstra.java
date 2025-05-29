import java.io.*;
import java.lang.*;
import java.util.*;

public class Dijkstra {

		    static  int nodes;
		    static int edges;
		    static int src;
		    
		    static void print(int dist[])
		    {
		        System.out.println(
		            "Source \t\t->\t Node \t=\tTotal weight of the Shortest Distance starting from ["  +src+"]");
		        for (int i = 1; i < nodes; i++)
		            System.out.println(src + " \t\t->\t " + i +"\t=\t" + dist[i]);
		    }
			

		    static void dijkstra(int graph[][], int src)
		    {
		        int distance[] = new int[nodes]; 

		        Boolean sptSet[] = new Boolean[nodes];
		
		        for (int i = 0; i < nodes; i++) {
		            distance[i] = Integer.MAX_VALUE;
		            sptSet[i] = false;
		        }
		 
	
		        distance[src] = 0;
		 
					
		        //loop to array
		        for (int count = 0; count < nodes - 1; count++) {
		        	
		        	//get shortest distance
			        int min = Integer.MAX_VALUE, min_index = -1;
			        for (int v = 0; v < nodes; v++) {
			            if (sptSet[v] == false && distance[v] <= min) {
			                min = distance[v];
			                min_index = v;
			            }
			        }
			       
			        
		            sptSet[min_index] = true;

		            for (int v = 0; v < nodes; v++)
		 
		                if (!sptSet[v] && graph[min_index][v] != 0
		                    && distance[min_index] != Integer.MAX_VALUE
		                    && distance[min_index] + graph[min_index][v] < distance[v])
		                	distance[v] = distance[min_index] + graph[min_index][v];
		        }

		        print(distance);
		    }
    		    
		    public static void main(String[] args)
		    {

		    	int to,from,weight;
		    	
		    	Scanner sc = new Scanner(System.in);
		    	System.out.print("How many nodes? \n->");
		    	nodes = sc.nextInt()+1;
		    	System.out.print("edges? \n->");
		    	edges = sc.nextInt();
		    	System.out.print("Enter the source node [Node starts with 1] \n->");
		    	src = sc.nextInt();
		    	System.out.println("Please Input: <Node_from> <Node_to> <weight> [Node starts with 1]");
		    	
		    	int[][] graph= new int[nodes][edges];

		    	for(int i =0; i<edges; i++)
		    	{
		    		from = sc.nextInt();
		    		to = sc.nextInt();
		    		weight = sc.nextInt();
		    			
		    			graph[from][to]=weight;	
		    			graph[to][from]=weight;
		    		
		    	}   
		    	
		        dijkstra(graph, src);
		    }
		    

}
