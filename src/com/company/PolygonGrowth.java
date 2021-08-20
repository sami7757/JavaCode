package com.company;
//Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.
//
//        A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by taking the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side. You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.
// added personal authentication token for github
public class PolygonGrowth {
    int shapeArea(int n) {
        if(n < 2) return n;
        int sum = 1;
        for(int i = 2; i <= n; i++) {
            sum += (i*i);

            if(i > 2)
                sum -= (i-2)*(i-2);
        }

        return sum;
    }
}
