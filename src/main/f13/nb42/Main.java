package main.f13.nb42;

import java.util.Random;


import static main.f13.nb42.ShortestDistance.findShortestDistanceDQ;
import static main.f13.nb42.ShortestDistance.findShortestDistanceItr;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 1000; // Number of points to generate
        Point[] points = new Point[n];

        // Generate random points
        for (int i = 0; i < n; i++) {
            float x = random.nextFloat() * 2 - 1; // Range: -1 to 1
            float y = random.nextFloat() * 2 - 1; // Range: -1 to 1
            points[i] = new Point(x, y);
        }

        // Find shortest distance using both methods
        float bruteForceDistance = findShortestDistanceItr(points);
        float divideConquerDistance = findShortestDistanceDQ(points.clone());

        // Print results
        System.out.println("Shortest distance (brute force): " + bruteForceDistance);
        System.out.println("Shortest distance (divide & conquer): " + divideConquerDistance);
        System.out.println("Results match: " + (Math.abs(bruteForceDistance - divideConquerDistance) < 1e-6));
    }
}
