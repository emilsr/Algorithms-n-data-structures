package main.tentaPrep.ten.ten5_220610.losningar.uppgift6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static class Edge {
        private final int endNode, weight;

        public Edge(int endNode, int weight) {
            this.endNode = endNode;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(".\\src\\uppgift6\\graf.txt"));
            //i linux: "./src/uppgift1/graph.txt"
            String[] numbers;
            String line;
            List<Edge>[] graph = new ArrayList[Integer.parseInt(in.readLine())];
            while((line = in.readLine())!=null) {
                numbers = line.split(" +");
                int node1 = Integer.parseInt(numbers[0]);
                int node2 = Integer.parseInt(numbers[1]);
                int weight = Integer.parseInt(numbers[2]);
                if(graph[node1]==null) graph[node1] = new ArrayList<>();
                graph[node1].add(new Edge(node2,weight));
                if(graph[node2]==null) graph[node2] = new ArrayList<>();
                graph[node2].add(new Edge(node1,weight));
            }
            for(int i=0;i<graph.length;i++) {
                for(int j=0;j<graph.length;j++)
                    System.out.println("Kortaste vägen från " + i + " till " + j + ": " + travelTime(i, j, graph));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int travelTime(int start, int end, List<Edge>[] graph){
        if(start<0 || start>=graph.length || end<0 || end>=graph.length) return -1;
        int[] d =new int[graph.length];
        int u;
        Arrays.fill(d,Integer.MAX_VALUE);
        d[start] = 0;
        BitSet taken = new BitSet(graph.length);
        while(true){
            u = next(d,taken);
            if(u==end) return d[u];
            taken.set(u);
            for(Edge e:graph[u]){
                if(d[u]+e.weight<d[e.endNode]){
                    d[e.endNode] = d[u]+e.weight;
                }
            }

         }
    }

    static int next(int[] d, BitSet taken){
        int dMin=Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=0;i<d.length;i++)
            if(d[i]<dMin&&!taken.get(i)){
                dMin = d[i];
                minIndex = i;
            }
        return minIndex;
    }
}
