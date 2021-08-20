package com.company;

import java.util.*;

public class CriticalConnections {

    private List<Integer>[] graph;
    private int[] visitedTime;
    private int[] lowTime;
    private int time;
    List<List<Integer>> result;

    public List<List<Integer>> findCriticalEdge(int n, int[][] g) {
        graph = new ArrayList[n];
        visitedTime = new int[n];
        lowTime = new int[n];
        result = new ArrayList<>();
        time = 0;
        buildGraph(g);
        boolean[] visited = new boolean[n];
        dfs(visited, 0, -1);
        return result;
    }

    private void dfs(boolean[] visited, int currNode, int parentNode) {
        visited[currNode] = true;
        visitedTime[currNode] = lowTime[currNode] = time++;

        for(int neighbor : graph[currNode]) {
            if(neighbor == parentNode)
                continue;

            if(visited[neighbor]) {
                lowTime[currNode] = Math.min(lowTime[currNode], visitedTime[neighbor]);
            }
            else {
                dfs(visited, neighbor, currNode);
                lowTime[currNode] = Math.min(lowTime[currNode], lowTime[neighbor]);
                if(visitedTime[currNode] < lowTime[neighbor])
                    result.add(Arrays.asList(currNode, neighbor));
            }
        }
    }

    private void buildGraph(int[][] g) {
        for(int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int[] edge : g) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }

}
