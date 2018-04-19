package cst8284.lab6;

public class Counters {

	private static int counter = 0;

	public static int getCurrentCtr() {return counter;}
	private static void setCurrentCtr(int ctr) {counter = ctr;}
	public static void resetCtr() {setCurrentCtr(0);}	
	public static int getNextCtr() {
		setCurrentCtr(++counter); 
		return getCurrentCtr();
	}

}