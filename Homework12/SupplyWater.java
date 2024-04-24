package homeWork12;
import java.util.*;

public class SupplyWater {

	public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes)
	{
		List<List<int[]>> adjList = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
		{
			adjList.add(new ArrayList<>());
		}
		
		//Get all the weighted edges from pipes.
		for (int[] edge : pipes)
		{
			
			//Get all the weighted edges from pipes.
			adjList.get(edge[0]).add(new int[] {edge[1],edge[2]});
			adjList.get(edge[1]).add(new int[] {edge[0], edge[2]});
		}
		
		//0 is the virtual node which contains the edge of wells for a house.
		for (int i = 0; i < wells.length; i++)
		{
			adjList.get(i + 1).add(new int[] {0, wells[i]});
			
			//0 is the virtual node
			adjList.get(0).add(new int[] {i, wells[i]});
		}
		
		int minCost = primImplementation(adjList);
		return minCost;
	}
	
	private static int primImplementation(List<List<int[]>> weightedGraph)
	{
		//visited keeps track of whether a vertex is visited or not.
		boolean[] visited = new boolean[weightedGraph.size()];
		//minCost begins initialized as max integer value, replaced with minimum weight edge over time.
		int[] minCosts = new int[weightedGraph.size()];
		
		Arrays.fill(minCosts, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		
		int minCost = 0;
		minCosts[0] = 0;
		int minVertex;
		
		for (int i = 0; i < weightedGraph.size(); i++)
		{
			minVertex = -1;
			for (int j = 0; j < weightedGraph.size(); j++)
			{
				if (!visited[j] && (minVertex == -1 || minCosts[j] < minCosts[minVertex]))
				{
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			minCost += minCosts[minVertex];
			
			for (int[] neighbor : weightedGraph.get(minVertex))
			{
				if (!visited[neighbor[0]] && neighbor[1] < minCosts[neighbor[0]])
				{
					minCosts[neighbor[0]] = neighbor[1];
				}
			}
		}
		
		return minCost;
	}
	
	public static void main(String[] args)
	{
		int[] wells = {1, 1};
		int[][] pipes = {{1, 2, 1}, {1, 2, 2}};
		
		System.out.println(minCostToSupplyWater(wells.length + 1, wells, pipes));
	}
}
