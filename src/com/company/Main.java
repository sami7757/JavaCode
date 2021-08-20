package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    int n = 4;
	    int[][] connections = { {0,1}, {0,2}, {1,2}, {1,3} };
	    CriticalConnections cc = new CriticalConnections();
	    List<List<Integer>> criticalEdges = cc.findCriticalEdge(n, connections);
	    System.out.println(criticalEdges.toString());
    }
}
