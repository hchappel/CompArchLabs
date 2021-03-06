/*
CacheProject is a simulator program that counts the number of hits to a cache over 1,000,000 random addresses.
The CacheProject creates a Cache object and inject Address objects according to the size of the cache along with
the block size.
*/
import java.util.*;
import java.io.*;
import java.lang.Math;

public class CacheProject{
	/*
	Method:Main- creates a cache and calls methods to simulate 1,000,000 address accesses
	Input:String of args = [int cache size in KB, int block size in bytes and KB, boolean fifo, boolean type]
	Output: If a bad file is accessed then a IOException error is raised
	*/
	public static void main(String[] args)
	{
		Cache c;
		c = init(new Cache(Integer.parseInt(args[0]),Integer.parseInt(args[1]),
			Boolean.parseBoolean(args[2]),Boolean.parseBoolean(args[3])));//intilizes the cache
		try
		{
			FileReader f = new FileReader("address.txt");// file of 1,000,000 randomly generated addresses in hex
			start(c,f);// starts the simulation
		}catch(IOException e){System.out.println(e.toString());}
		
	}

	/*
	Method:Init - intilizes the cache converts KB to bytes and finds the size of the cache then 
		      injects address objects to the rightful file structer Queue/ArrayList
	Input:Cache i - an intilized cache object
	Output:Cache - a cache object filled with addresses
	*/
	public static Cache init(Cache i)
	{
		int num_blocks = 0;
		//converts KB to bytes and return the number of index in the cache
		if (i.getBlock_size() > 4)
			num_blocks = (i.getCache_size() * 1024 / i.getBlock_size());
		else
			num_blocks = i.getCache_size()  / i.getBlock_size();
	
		//intilizes the cache file structure Queue(Fully associative) or ArrayList(Direct Mapped)
		if(i.getMapping_type())
		{
			Queue<Address> cache = new LinkedList<Address>();
			for(int j = 0; j < num_blocks; j++)
				cache.offer(new Address());
			i.setCache_Associative(cache);

		}
		else
		{		
			ArrayList<Address> cache = new ArrayList<Address>();
			for(int j = 0; j < num_blocks; j++)
				cache.add(new Address(j,false,0L));
			int tag = (int) (Math.log10(num_blocks) / Math.log10(2));
			String tag_and = ""; // is used to and a block address to access the index
			for (int j = 0; j < tag; j++)
			{
				tag_and += "1";
			}
			i.setAddressBits(Long.parseLong(tag_and, 2));
			i.setCache_Direct_Mapped(cache); 
		}
		
		return i;
	}



	/*
	Method:start - starts the cache simulation 
	Input: Cache i of cache that is fully intilized, FileReader f for address file to read in
	Output: Println the final state of the cache along with the totalnumber of hits
	*/
	public static void start(Cache i, FileReader f)
	{
		try {
			String s = "";
			// creates the offset size
			int offset = 0;
			if (i.getBlock_size() > 4)
				offset = (int) (Math.log10(i.getBlock_size()) / Math.log10(2));
			else
				offset = (int) (Math.log10(i.getBlock_size() * 1024) / Math.log10(2));

		
         	BufferedReader br = new BufferedReader(f);//used to red in addresses
         	while((s = br.readLine()) != null)
         	{
         	   Long address =  Long.parseLong(s.substring(2), 16);// converts string hex to int
         	  //removes the offset and calls the cache replacment protocol algo
         	   if(i.getFIFO()){
         	    	i = FIFO(i, address >>> offset); 
         	    }
         	    else
         	    	i = LRU(i,address >>> offset);
         	}
         	if(i.getMapping_type())
         	{
	        	System.out.println(Arrays.toString(i.getCache_Associative().toArray()));	
         	}
         	else
         	{
         		System.out.println(Arrays.toString(i.getCache_Direct_Mapped().toArray()));
         	}
         	System.out.println(Integer.toString(i.getHit_rate()));

      		}catch(IOException e){System.out.println(e.toString());}
	}



	/*
	Method:FIFO - replacement algo used to access a hit or if a miss happens then the address is put at the first
		      available or remove the earlist used address and inserts the new address 
	Input:Cache i for current cache, Long a for block address
	Output: Cache with the new block address in the cache or hit rate couter incremented
	*/
	public static Cache FIFO(Cache i, Long a)
	{
		if(i.getMapping_type())
		{
			// fully associative looks through each queue in the cache for a hit or miss
   			Iterator<Address> it = i.getCache_Associative().iterator();
   			while(it.hasNext())
   				{
   					Address l = it.next();
					if(l.getBlockAddress().equals(a))
   					{
   						i.setHit_rate();
   						return i;//if hit 
   					}
   				}
   				
   				Address l = new Address(0,true,a);
   				i.getCache_Associative().remove();
   				i.getCache_Associative().add(l);
   				return i;//if miss
		}
		else
		{
			// Direct mapped looks through each ArrayList in the cache for a hit or miss
			if (i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).getValid())// ands index size if valid bit true
			{
				if(i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).getBlockAddress().equals(a))
				{
					i.setHit_rate();//if hit
					return i;
				}
				else
				{
					i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setBlockAddress(a);
					i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setValid(true);
					return i; // if conflict miss
				}
			}
			else
			{
				i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setBlockAddress(a);
				i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setValid(true);
				return i; //if miss compulsory miss
			}
		}
	}

	/*
	Method:LRU - Least recently used algo for replacment if hit the address is removed from the cache and placed in the 
		    rear of the queue is only used for fully associative 
	Input:Cache i for current cache, Long a for block address
	Output: Cache with the new block address in the cache or hit rate couter incremented
	*/
	public static Cache LRU(Cache i, Long a)
	{
		if(i.getMapping_type())
		{
			int j = 0;
   			for (Iterator<Address> it = i.getCache_Associative().iterator(); it.hasNext(); j++)
   			{
   				Address l = it.next();
				if(l.getBlockAddress().equals(a))
   				{
         			i.getCache_Associative().remove(l);
   					i.getCache_Associative().add(l);
   					i.setHit_rate();
   					return i;//hit
   				}
   			}
   			Address l = new Address(0,true,a);
   			i.getCache_Associative().remove();
   			i.getCache_Associative().add(l);
   			return i;//miss
		}
		else
		{

		}
		return i;
	}
}
