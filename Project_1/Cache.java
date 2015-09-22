import java.util.*;



public class Cache{
	private static int cache_size;// int cache size
	private static int block_size;// int block size for each block
	private static int hit_rate;// int number of cache hits
	private static boolean fifo; // boolean if first in first out or Least Recently used
	private static Queue<Address> cache_Associative; // Queue of Addresses for fully associative cache
	private static ArrayList<Address> cache_Direct_Mapped;// ArrayList for Addresses for Direct Mapped cache
	private static boolean mapping_type;// boolean for Fully associative true or direct mapped false
	private static Long addressBits;// Long for the length of address tag
/*
Method:Constructor - creates a cache object and initilizes all cache variables
Input: int c for cache_size, int b for block size, boolean f for FIFO/LRU, boolean type for direct/fully associative
OutPut:none
*/
	Cache(int c, int b, boolean f, boolean type)
	{
	cache_size = c;
	block_size = b;
	hit_rate = 0;
	fifo = f;
	mapping_type = type;
	addressBits = 0L;	
	}
/*
Method:getCache_size - getter for cache_size
Input:none
OutPut: int for the cache size
*/
	public static int getCache_size()
	{
		return cache_size;
	}


/*
Method:setCache_size - setter for cache_size
Input: int c for the cache_size
OutPut:void
*/

	public static void setCache_size(int c)
	{
		cache_size = c;
	}


/*
Method:getBlock_size - getter for block size
Input:none
OutPut: int for the cache's
*/
	public static int getBlock_size()
	{
		return block_size;
	}


/*
Method:setBlock_size - setter for block size
Input:
OutPut:void
*/
	public static void setBlock_size(int b)
	{
		block_size = b;
	}


/*
Method:get - getter for
Input:none
OutPut:
*/
	public static int getHit_rate()
	{
		return hit_rate;
	}


/*
Method:set - setter for
Input:
OutPut:void
*/

	public static void setHit_rate()
	{
		hit_rate++;
	}


/*
Method:get - getter for
Input:none
OutPut:
*/
	public static Long getAddressBits()
	{
		return addressBits;
	}


/*
Method:set - setter for
Input:
OutPut:void
*/
	public static void setAddressBits(Long i)
	{
		addressBits = i;
	}


/*
Method:get - getter for
Input:none
OutPut:
*/
	public static boolean getFIFO()
	{
		return fifo;
	}


/*
Method:set - setter for
Input:
OutPut:void
*/
	public static void setFIFO(boolean f)
	{
		fifo = f;
	}


/*
Method:get - getter for
Input:none
OutPut:
*/
	public static Queue<Address> getCache_Associative()
	{
		return cache_Associative;
	}


/*
Method:set - setter for
Input:
OutPut:void
*/
	public static void setCache_Associative(Queue<Address> c)
	{
		cache_Associative = c;
	}


/*
Method:get - getter for
Input:none
OutPut:
*/
	public static ArrayList<Address> getCache_Direct_Mapped()
	{
		return cache_Direct_Mapped;
	}


/*
Method:set - setter for
Input:
OutPut:void
*/
	public static void setCache_Direct_Mapped(ArrayList<Address> c)
	{
		cache_Direct_Mapped = c;
	}


/*
Method:get - getter for
Input:none
OutPut:
*/
	public static boolean getMapping_type()
	{
		return mapping_type;
	}


/*
Method:set - setter for
Input:
OutPut:void
*/
	public static void setMapping_type(boolean type)
	{
		mapping_type = type;
	}	

}
