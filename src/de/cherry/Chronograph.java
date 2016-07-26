package de.cherry;

public class Chronograph 
{
	private long millis;
	
	public Chronograph()
	{
		millis = -1L;
	}
	
	public void start()
	{
		millis = System.currentTimeMillis();
	}
	
	public long stop()
	{
		long endmillis = System.currentTimeMillis();
		long time = endmillis-millis;
		return time;
	}
}