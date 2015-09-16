import java.util.*;



public class Cache{
	private static int cache_size;
	private static int block_size;
	private static int hit_rate;
	private static boolean fifo;
	private static Queue<Address> cache_mapping;
	private static boolean mapping_type;



	Cache(int c, int b, boolean f, boolean type)
	{
	cache_size = c;
	block_size = b;
	hit_rate = 0;
	fifo = f;
	mapping_type = type;	
	}

	public static int getCache_size()
	{
		return cache_size;
	}

	public static void setCache_size(int c)
	{
		cache_size = c;
	}

	public static int getBlock_size()
	{
		return block_size;
	}

	public static void setBlock_size(int b)
	{
		block_size = b;
	}

	public static int getHit_rate()
	{
		return hit_rate;
	}

	public static void setHit_rate()
	{
		hit_rate++;
	}

	public static boolean getFIFO()
	{
		return fifo;
	}

	public static void setFIFO(boolean f)
	{
		fifo = f;
	}

	public static Queue<Address> getCache_mapping()
	{
		return cache_mapping;
	}

	public static void setCache_mapping(Queue<Address> c)
	{
		cache_mapping = c;
	}

	public static boolean getMapping_type()
	{
		return mapping_type;
	}

	public static void setMapping_type(boolean type)
	{
		mapping_type = type;
	}	

}