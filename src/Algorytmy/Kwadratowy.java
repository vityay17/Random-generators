package Algorytmy;

public class Kwadratowy {
	private long M;
	private long a;
	private long b;
	private long c;
	private long x;

	private long genRand(){
		x = (long) ((a*Math.pow(x, 2) + b*x + c) % M);
		return x;
	}
	
	/**
	* generowanie liczb pseudolosowych LCG
	* @param a - wspolczynnik
	* @param b - wspolczynnik
	* @param c - wspolczynnik
	* @param m - wspolczynnik
	* @param x - wartosc ziarna x[1]
	* @param n - ile liczb pseudolosowych wylosowac
	* @param low - dolna wartosc zakresu generowanych liczb
	* @param high - gorna wartosc zakresu generowanych liczb
	*/
	public double[] main(long a,long b,long c,long M,long x,int n,long low,long high) {
		this.M = M;
		this.a = a;
		this.b = b;
		this.c = c;
		this.x = x;
		double[]k = new double[n];
		for (int i=0; i<n; i++) {
			k[i] = (double) (low + (genRand() % (high - low + 1)));
		}
		return k;
	
	}

}