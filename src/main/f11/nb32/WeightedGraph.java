package main.f11.nb32;

import java.util.*;
import java.io.*;

public class WeightedGraph {

    private Map<String, Map<String, Integer>> adjacencyList; 

    public WeightedGraph(String filename){
        adjacencyList = new HashMap<>();

        try{
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(":");
                String node = parts[0].trim();
                
                adjacencyList.putIfAbsent(node, new HashMap<>());

                if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                    String[] neighbors = parts[1].trim().split(",");
                    for(String neighbor : neighbors){
                        String[] connection = neighbor.trim().split("\\s+");
                        String destination = connection[0];
                        int weight = Integer.parseInt(connection[1]);

                        adjacencyList.get(node).put(destination, weight);
                    }
                }
            }
            scanner.close();
            System.out.println("file read succsenfally.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String node : adjacencyList.keySet()) {
            sb.append(node).append(": ");
            Map<String, Integer> neighbors = adjacencyList.get(node);
            if (!neighbors.isEmpty()) {
                for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                    sb.append(neighbor.getKey())
                      .append(" ")
                      .append(neighbor.getValue())
                      .append(", ");
                }
                sb.setLength(sb.length() - 2);
            }
            sb.append("\n");
        }
        return sb.toString();
    }



    public List<String> shortestPath(String start, String end) {
        // Håll reda på avstånden
        Map<String, Integer> distances = new HashMap<>();
        // Håll reda på föregående nod för att kunna återskapa vägen
        Map<String, String> previous = new HashMap<>();
        // PriorityQueue för att alltid välja noden med minst avstånd
        PriorityQueue<String> queue = new PriorityQueue<>(
            (a, b) -> distances.getOrDefault(a, Integer.MAX_VALUE) - 
                      distances.getOrDefault(b, Integer.MAX_VALUE)
        );
        
        // Initialisera avstånd
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(start);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            // Om vi har nått målnoden kan vi avsluta
            if (current.equals(end)) {
                break;
            }
            
            // Om vi har besökt denna nod redan
            if (!adjacencyList.containsKey(current)) {
                continue;
            }
            
            // Gå igenom alla grannar
            for (Map.Entry<String, Integer> neighbor : adjacencyList.get(current).entrySet()) {
                String next = neighbor.getKey();
                int newDist = distances.get(current) + neighbor.getValue();
                
                if (newDist < distances.get(next)) {
                    distances.put(next, newDist);
                    previous.put(next, current);
                    queue.add(next);
                }
            }
        }
        
        // Återskapa vägen
        List<String> path = new ArrayList<>();
        String current = end;
        
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }
        
        return path;
    }

    public static void main(String[] args) {
        WeightedGraph test = new WeightedGraph("src/main/f11/nb32/test.txt");
        System.out.println(test.toString());
        System.out.println(test.shortestPath("A", "H"));
    }

}
