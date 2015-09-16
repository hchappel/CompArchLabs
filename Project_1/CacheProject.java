import java.util.*;
import java.io.*;
import java.lang.Math;

public class CacheProject{
	
	public static void main(String[] args)
	{
		Cache c;
		c = init(new Cache(16,256,true,true));
		try
		{
			FileReader f = new FileReader("address.txt");
			start(c,f);
		}catch(IOException e){System.out.println(e.toString());}
		
	}


	public static Cache init(Cache i)
	{
		Queue<Address> cache = new LinkedList<Address>();
		int num_blocks = 0;
		if (i.getBlock_size() > 4)
		{
			num_blocks = (i.getCache_size() * 1024 / i.getBlock_size());
		}
		else
		{
			num_blocks = i.getCache_size()  / i.getBlock_size();
		}
		for(int j = 0; j < num_blocks; j++)
		{
			cache.offer(new Address());
		}

		i.setCache_mapping(cache);
		return i;
	}




	public static void start(Cache i, FileReader f)
	{
		try {
			String s = "";
			int offset = (int) (Math.log10(i.getBlock_size()) / Math.log10(2));
         	BufferedReader br = new BufferedReader(f);
         	while((s = br.readLine()) != null)
         	{
         	   Long address =  Long.parseLong(s.substring(2), 16);
         	   if(i.getFIFO()){
         	    	i = FIFO(i, address >>> offset);
         	    }
         	    else
         	    	i = LRU(i,address >>> i.getBlock_size());
         	}

         	System.out.println(Arrays.toString(i.getCache_mapping().toArray()));
         	System.out.println(Integer.toString(i.getHit_rate()));

      		}catch(IOException e){System.out.println(e.toString());}
	}




	public static Cache FIFO(Cache i, Long a)
	{
		if(i.getMapping_type())
		{

   			Iterator<Address> it = i.getCache_mapping().iterator();
   			while(it.hasNext())
   				{
   					Address l = it.next();
   					if (!l.getValid())
   					{
   						l.setValid(true);
   						l.setBlockAddress(a);
   						i.getCache_mapping().remove();
   						i.getCache_mapping().add(l);
   						return i;
   					}
   					else if(l.getBlockAddress() == a)
   					{
   						System.out.println("Im here");
   						i.setHit_rate();
   						return i;
   					}
   				}
   				Address l = new Address(0,true,a);
   				i.getCache_mapping().remove();
   				i.getCache_mapping().add(l);
   				return i;
		}
		else
		{

		}
		return i;
	}

	public static Cache LRU(Cache i, Long a)
	{
		if(i.getMapping_type())
		{

		}
		else
		{

		}
		return i;
	}
}