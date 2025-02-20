package main.f13.nb42;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Skriv en funktion som tar en array med punkter (använd en klass för att representera en 2D-punkt
 * med float för koordinaterna) och returnerar det kortaste avståndet mellan två punkter. Funktionen
 * ska använda en effektiv söndra och härska algoritm enligt föreläsningen (dvs inte jämföra onödiga
 * punkter över mittlinjen). Skriv också en funktion som löser problemet med genom att jämföra varje
 * punkt med varje annan punkt och som då blir O(n2). Skriv nu en main som slumpar fram n punkter
 * som ligger i intervallet: -1<x<1 och -1<y<1 med lika stor sannolikhet för alla värden. Anropa dina
 * funktioner med de framslumpade punkterna och kontrollera att du får samma resultat.
 */

public class ShortestDistance  {

    public static float findShortestDistanceItr(Point[] points) {
        float minDistance = Float.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                float distance = points[i].distanceTo(points[j]);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }


    public static float findShortestDistanceDQ(Point[] points) {
        Arrays.sort(points, (a, b) -> Float.compare(a.x, b.x));
        return findShortestDistanceRecursive(points, 0, points.length - 1);
    }


    private static float findShortestDistanceRecursive(Point[] points, int left, int right) {
        // Base cases
        if (right - left <= 2) {
            float minDist = Float.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    minDist = Math.min(minDist, points[i].distanceTo(points[j]));
                }
            }
            return minDist;
        }

        // Divide
        int mid = (left + right) / 2;
        float leftMin = findShortestDistanceRecursive(points, left, mid);
        float rightMin = findShortestDistanceRecursive(points, mid + 1, right);
        float minDistance = Math.min(leftMin, rightMin);

        // Find points around the middle line
        float midX = points[mid].x;
        ArrayList<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midX) < minDistance) {
                strip.add(points[i]);
            }
        }

        // Sort strip by y-coordinate
        strip.sort((a, b) -> Float.compare(a.y, b.y));

        // Check points in strip
        for (int i = 0; i < strip.size(); i++) {
            // Only need to check 7 points ahead due to geometric properties
            for (int j = i + 1; j < strip.size() && j <= i + 7; j++) {
                float distance = strip.get(i).distanceTo(strip.get(j));
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }
}
