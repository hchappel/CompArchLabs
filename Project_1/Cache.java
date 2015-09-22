/*
Cache object simulates the structur of a cache. The cache can be direct mapped or fully associative 
with replacmet that is FIFO or LRU. The Cache is set and is by bytes, along with the block size.
An arraylist is used for direct mapped and a queue is used for fully associative.
*/
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
Input: int b for the size of the block
OutPut:void
*/
	public static void setBlock_size(int b)
	{
		block_size = b;
	}


/*
Method:getHit_rate - getter for number of hits in the cache
Input:none
OutPut: returns the number of hits the cache recieves
*/
	public static int getHit_rate()
	{
		return hit_rate;
	}


/*
Method:setHit_rate - setter for
Input:increments the hit_rate variable when a hit is identified
OutPut:void
*/

	public static void setHit_rate()
	{
		hit_rate++;
	}


/*
Method:getAddressBits - getter for
Input:none
OutPut:
*/
	public static Long getAddressBits()
	{
		return addressBits;
	}


/*
Method:setAddressBits - setter for
Input:
OutPut:void
*/
	public static void setAddressBits(Long i)
	{
		addressBits = i;
	}


/*
Method:getFIFO - returns true if First in First out and false if LeastRecently Used
Input:none
OutPut: return boolean for replacement format
*/
	public static boolean getFIFO()
	{
		return fifo;
	}


/*
Method:setFIFO - setter for fifo var
Input:boolean f true if FIFO false if LRU
OutPut:void
*/
	public static void setFIFO(boolean f)
	{
		fifo = f;
	}


/*
Method:getCache_Associative - getter for Queue if Fully associative if not is empty and uninitelized
Input:none
OutPut: Queue of address for the Cache
*/
	public static Queue<Address> getCache_Associative()
	{
		return cache_Associative;
	}


/*
Method:setCache_Associative - setter if cache is fully associative
Input: Queue of Address for cache
OutPut:void
*/
	public static void setCache_Associative(Queue<Address> c)
	{
		cache_Associative = c;
	}


/*
Method:getCache_Direct_Mapped - getter for Arraylist of addresses if direct mapped if not is unintilized
Input:none
OutPut: ArrayList of Addresses for a direct mapped cache
*/
	public static ArrayList<Address> getCache_Direct_Mapped()
	{
		return cache_Direct_Mapped;
	}


/*
Method:setCache_Direct_Mapped - setter for Direct mapped cache
Input: Array List of Addresses for Direct mapped cache
OutPut:void
*/
	public static void setCache_Direct_Mapped(ArrayList<Address> c)
	{
		cache_Direct_Mapped = c;
	}


/*
Method:getMapping_type - getter for Mapping type
Input:none
OutPut: returns boolean true if fully associative false if direct mapped
*/
	public static boolean getMapping_type()
	{
		return mapping_type;
	}


/*
Method:setMapping_type - setter for Mapping type
Input:boolean type for true if fully associative false if direct mapped
OutPut:void
*/
	public static void setMapping_type(boolean type)
	{
		mapping_type = type;
	}	

}
