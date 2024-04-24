'''
Created on Apr 23, 2024

@author: downtownwonton
'''
def minCostToSupplyWater(n, wells: list[int], pipes: list[list[int]]) -> int:
    adjList = [[] for _ in range(n + 1)]
    
    for edge in pipes:
        adjList[edge[0]].append((edge[1], edge[2]))
        adjList[edge[1]].append((edge[0], edge[2]))
        
    for i, cost in enumerate(wells):
        adjList[i + 1].append((0, cost))
        adjList[0].append((i + 1, cost))
        
    return primImplementation(adjList)

def primImplementation(weightedGraph):
    visited = [False] * len(weightedGraph)
    minCosts = [float('inf')] * len(weightedGraph)
    
    minCost = 0
    minCosts[0] = 0 
    minVertex = 0
    
    for _ in range(len(weightedGraph)):
        for j in range(len(weightedGraph)):
            if not visited[j] and (minVertex == -1 or minCosts[j] < minCosts[minVertex]):
                minVertex = j
                
        visited[minVertex] = True 
        minCost += minCosts[minVertex]
        
        for neighbor, weight in weightedGraph[minVertex]:
            if not visited[neighbor] and weight < minCosts[neighbor]:
                minCosts[neighbor] = weight
                
    return minCost
    
def main():
    wells = [1, 1]
    pipes = [[1, 2, 1], [1, 2, 2]]
    print(minCostToSupplyWater(len(wells) + 1, wells, pipes))
    
if __name__ == '__main__':
    main()