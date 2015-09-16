import java.util.*;
import java.io.*;
import java.lang.Math;

public class CacheProject{
	
	public static void main(String[] args)
	{
		Cache c;
		c = init(new Cache(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Boolean.parseBoolean(args[2]),Boolean.parseBoolean(args[3])));
		try
		{
			FileReader f = new FileReader("address.txt");
			start(c,f);
		}catch(IOException e){System.out.println(e.toString());}
		
	}


	public static Cache init(Cache i)
	{
		int num_blocks = 0;

		if (i.getBlock_size() > 4)
			num_blocks = (i.getCache_size() * 1024 / i.getBlock_size());
		else
			num_blocks = i.getCache_size()  / i.getBlock_size();
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
			String tag_and = ""; 
			for (int j = 0; j < tag; j++)
			{
				tag_and += "1";
			}
			i.setAddressBits(Long.parseLong(tag_and, 2));
			i.setCache_Direct_Mapped(cache);
		}
		return i;
	}




	public static void start(Cache i, FileReader f)
	{
		try {
			String s = "";
			int offset = 0;

			if (i.getBlock_size() > 4)
				offset = (int) (Math.log10(i.getBlock_size()) / Math.log10(2));
			else
				offset = (int) (Math.log10(i.getBlock_size() * 1024) / Math.log10(2));

         	BufferedReader br = new BufferedReader(f);
         	while((s = br.readLine()) != null)
         	{
         	   Long address =  Long.parseLong(s.substring(2), 16);
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




	public static Cache FIFO(Cache i, Long a)
	{
		if(i.getMapping_type())
		{
   			Iterator<Address> it = i.getCache_Associative().iterator();
   			while(it.hasNext())
   				{
   					Address l = it.next();
					if(l.getBlockAddress().equals(a))
   					{
   						i.setHit_rate();
   						return i;
   					}
   				}
   				Address l = new Address(0,true,a);
   				i.getCache_Associative().remove();
   				i.getCache_Associative().add(l);
   				return i;
		}
		else
		{
			if (i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).getValid())
			{
				if(i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).getBlockAddress().equals(a))
				{
					i.setHit_rate();
					return i;
				}
				else
				{
					i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setBlockAddress(a);
					i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setValid(true);
					return i;
				}
			}
			else
			{
				i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setBlockAddress(a);
				i.getCache_Direct_Mapped().get((int)(a & i.getAddressBits())).setValid(true);
				return i;
			}
		}
	}

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
   					return i;
   				}
   			}
   			Address l = new Address(0,true,a);
   			i.getCache_Associative().remove();
   			i.getCache_Associative().add(l);
   			return i;
		}
		else
		{

		}
		return i;
	}
}