package main.tentaPrep.ten.ten4_230315.Losningar.uppgift7;

import java.util.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) {
        char[][] streetsEx1 = {
                {'o','s','o','o','o','o'},
                {'o','o','o','o','s','s'},
                {'o','o','h','o','o','o'},
                {'s','o','o','o','o','s'},
                {'o','o','o','s','o','o'}};
        char[][] streetsEx2 = {
                {'s','o','o','o','o','o'},
                {'o','s','s','o','s','o'},
                {'o','s','o','o','o','o'},
                {'o','h','o','o','o','s'}};
        char[][] streetsEx3 = {
                {'s','o','o','o','o','s'},
                {'o','o','o','o','o','o'},
                {'o','s','o','o','o','s'},
                {'o','o','o','o','o','o'},
                {'h','o','o','o','o','o'}};
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx1));
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx2));
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx3));
    }

    private static int shortestPath(char[][] streets) {
        List<Point> nodes = new ArrayList<>();
        for(int y=0;y<streets.length;y++){
            for(int x=0;x<streets[0].length;x++){
                if(streets[y][x]=='s') nodes.add(new Point(x,y));
                if(streets[y][x]=='h') nodes.add(0,new Point(x,y));
            }
        }
        int[][] w =new int[nodes.size()][nodes.size()];
        for(int i=0;i<nodes.size();i++){
            for(int j=0;j< nodes.size();j++){
                w[i][j] = Math.abs( nodes.get(i).x - nodes.get(j).x ) + Math.abs( nodes.get(i).y - nodes.get(j).y );
            }
        }
        //System.out.println(nodes);
        //System.out.println(Arrays.toString(w[0]));
        BitSet visited = new BitSet(nodes.size());
        visited.set(0);
        //return shortestPath(w,0, visited); //Tillräckligt för A
        PartPath startPath = new PartPath(visited,0);
        HashMap<PartPath,Integer> memo = new HashMap<>();
        return shortestPath(w,startPath,memo);
    }

    private static int shortestPath(int[][] w, int currentNode, BitSet visited) {//utan dynamisk programmering, ok för A, på denna uppgift. Obs att det kan behövas på andra uppgifter som jag bedömer som lättare.
        if(visited.cardinality()==w[0].length){
            return 0;
        }else{
            int distance, minDistance = Integer.MAX_VALUE;
            for(int i=0;i<w[0].length;i++){
                if(!visited.get(i)){
                    visited.set(i);
                    distance = w[currentNode][i]+shortestPath(w,i,visited);
                    if(distance<minDistance) minDistance=distance;
                    visited.clear(i);
                }
            }
            return minDistance;
        }
    }

    private static int shortestPath(int[][] w, PartPath currentPath, HashMap<PartPath, Integer> memo) {
        if(memo.containsKey(currentPath))
            return memo.get(currentPath);
        if(currentPath.visited.cardinality() == w[0].length){
            memo.put(currentPath,0);
            return 0;
        }else{
            int distance;
            int minDistance = Integer.MAX_VALUE;
            for(int i=0;i<w[0].length;i++){
                if(!currentPath.visited.get(i)){
                    PartPath newPath = currentPath.add(i);
                    distance = w[currentPath.currentNode][i]+shortestPath(w,newPath,memo);
                    if(distance<minDistance) minDistance=distance;
                }
            }
            memo.put(currentPath,minDistance);
            return minDistance;
        }
    }
    private static class PartPath {
        private BitSet visited;
        private int currentNode;

        public PartPath(BitSet s, int currentNode) {
            this.visited = s;
            this.currentNode = currentNode;
        }

        public PartPath add(int newCurrentNode){
            BitSet s = (BitSet)visited.clone();
            s.set(newCurrentNode);
            return new PartPath(s,newCurrentNode);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PartPath partPath = (PartPath) o;
            return currentNode == partPath.currentNode &&
                    visited.equals(partPath.visited);
        }

        @Override
        public int hashCode() {
            return Objects.hash(visited, currentNode);
        }
    }
}
