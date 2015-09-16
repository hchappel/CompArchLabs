import java.util.*;



public class Cache{
	private static int cache_size;
	private static int block_size;
	private static int hit_rate;
	private static boolean fifo;
	private static Queue<Address> cache_Associative;
	private static ArrayList<Address> cache_Direct_Mapped;
	private static boolean mapping_type;
	private static Long addressBits;



	Cache(int c, int b, boolean f, boolean type)
	{
	cache_size = c;
	block_size = b;
	hit_rate = 0;
	fifo = f;
	mapping_type = type;
	addressBits = 0L;	
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

	public static Long getAddressBits()
	{
		return addressBits;
	}

	public static void setAddressBits(Long i)
	{
		addressBits = i;
	}

	public static boolean getFIFO()
	{
		return fifo;
	}

	public static void setFIFO(boolean f)
	{
		fifo = f;
	}

	public static Queue<Address> getCache_Associative()
	{
		return cache_Associative;
	}

	public static void setCache_Associative(Queue<Address> c)
	{
		cache_Associative = c;
	}

	public static ArrayList<Address> getCache_Direct_Mapped()
	{
		return cache_Direct_Mapped;
	}

	public static void setCache_Direct_Mapped(ArrayList<Address> c)
	{
		cache_Direct_Mapped = c;
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