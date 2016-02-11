package Algorytmy;

import java.util.Random;

public class Addytywny {
	private long M;
	private long c;
	private long[]arrayA;
	private long[]arrayX;

	private long genRand(int k){
		long temp = 0;
		for(int i = 0;i<k;i++){
			temp+=arrayA[i]*arrayX[i];
		}
		long x =  ((temp + c) % M);
		System.out.println(x);
		return x;
	}
	
	/**
	* generowanie liczb pseudolosowych LCG
	* @param m - wspolczynnik
	* @param a - wspolczynnik
	* @param c - wspolczynnik
	* @param x - wartosc ziarna x[1]
	* @param n - ile liczb pseudolosowych wylosowac
	* @param low - dolna wartosc zakresu generowanych liczb
	* @param high - gorna wartosc zakresu generowanych liczb
	*/
	public double[] main(long c,long M,long x,int n,long low,long high) {
		this.M = M;
		this.c = c;
		
		double[]k = new double[n];
		
		arrayA = generateArrayA(n);
		arrayX = new long[n];
		arrayX[0] = x;
		
		for (int i=0; i<n; i++) {
			if(i!=0) 
				arrayX[i] = genRand(i+1);
			k[i] = (double) (low + (arrayX[i] % (high - low + 1)));
		}
		return k;
	}
	
	private long[] generateArrayA(int size){
		long[] arrayA = new long[size];
		Random random = new Random();
		int a;
		for (int i=0; i<size; i++) {
			if(random.nextBoolean()) a = 1;
			else a = 0;
			arrayA[i] = a;
		}
		return arrayA;
		
	}
}