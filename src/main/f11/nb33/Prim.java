/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.f11.nb33;

import java.util.Arrays;
import java.util.BitSet;

/**
 *
 * @author bfelt
 */

public class Prim {
	public static void main(String[] args) {
		int X = Integer.MAX_VALUE;
		int[][] w = {	
						{	X, 2, X, X, X, 1, X, X},
						{	2, X, 2, 2, 4, X, X, X},
						{	X, 2, X, X, 3, X, X, 1},
						{	X, 2, X, X, 4, 1, X, X},
						{	X, 4, 3, 4, X, X, 7, X},
						{	1, X, X, 1, X, X, 5, X},
						{	X, X, X, X, 7, 5, X, 6},
						{	X, X, 1, X, X, X, 6, X}};
		int[] p = prim(w);
		System.out.println("Node A var startnode");
		for(int i=1; i<p.length;i++)
			System.out.println("Nod "+(char)(i+'A')+" anslöts via "+(char)(p[i]+'A'));
		int distance =0;
		for(int i=1;i<w.length;i++)
			distance+=w[i][p[i]];
		System.out.println("Totalvikt: "+distance);
	}

	public static int minSpanTree(int[][] w, int[] connections){
		int[] p = prim(w);

		System.arraycopy(p,0,connections,0,connections.length);

		int distance =0;
		for(int i=1;i<w.length;i++)
			distance+=w[i][p[i]];

		return distance;
	}

	// w - förbindelsematris, prim returnerar en array p, där p[i] är den nod som noden i anslöts till (i>0)
	private static int[] prim(int[][] w){
		int[] p = new int[w.length];
		int[] costs = new int[w.length];
		BitSet visited = new BitSet(w.length);

		Arrays.fill(costs, Integer.MAX_VALUE);
		Arrays.fill(p, -1);
		costs[0] = 0;

		for (int i = 0; i < w.length; i++) {
			int next = nextIndex(visited, costs);
			if (next == -1) break;
			visited.set(next);

			for (int j = 0; j < w.length; j++) {
				if (!visited.get(j) && w[next][j] < costs[j]) {
					costs[j] = w[next][j];
					p[j] = next;
				}
			}
		}
		return p;
	}

	private static int nextIndex(BitSet visited, int[] costs) {
		int minIndex = -1, minCost = Integer.MAX_VALUE;
		for (int i = 0; i < costs.length; i++) {
			if (!visited.get(i) && costs[i] < minCost) {
				minCost = costs[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
