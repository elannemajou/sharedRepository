package com.katas.question4;

public class FalseSharing implements Runnable {

	public final static int NUM_THREADS = 4;
	public final static long ITERATIONS = 500L * 1000L * 1000L;
	private final int arrayIndex;
	
	private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];
	static
    {
        for (int i = 0; i < longs.length; i++)
        {
            longs[i] = new VolatileLong();
        }
    }
	
	public FalseSharing(final int arrayIndex)
    {
        this.arrayIndex = arrayIndex;
    }
	
	 public void run()
	    {
	        long i = ITERATIONS + 1;
	        while (0 != --i)
	        {
	            longs[arrayIndex].value = i;
	        }
	    }
	
	
	
}
