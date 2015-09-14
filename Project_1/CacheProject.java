import java.util.*;
import java.io.*;



public class CacheProject{
	
	public static void main(String[] args)
	{
		Cache c;
		c = init(new Cache(16,64,true,true));
		try
		{
			FileReader f = new FileReader("address.txt");
			start(c,f);
		}catch(IOException e){System.out.println(e.toString());}
		
	}


	public static Cache init(Cache i)
	{
		Queue<Address>cache = new LinkedList<Address>();
		int num_blocks = 0;
		if (i.getBlock_size() > 4)
		{
			num_blocks = i.getCache_size() * 1024 / i.getBlock_size();
		}
		else
		{
			num_blocks = i.getCache_size()  / i.getBlock_size();
		}

		for(int j = 0; j < num_blocks; j++)
		{
			Address check = new Address();
			cache.add(check);
		}

		i.setCache_mapping(cache);
		return i;
	}




	public static void start(Cache i, FileReader f)
	{
		try {
			String s = "";
         	 BufferedReader br = new BufferedReader(f);
         	 while((s = br.readLine()) != null)
         	 {
         	    Long address =  Long.parseLong(s.substring(2), 16);
         	    if(i.getFIFO())
         	     	i = FIFO(i, address);
         	    else
         	     	i = LRU(i,address);
         	 }

         	 System.out.println(Integer.toString(i.getMiss_rate()));

      		}catch(IOException e){System.out.println(e.toString());}
	}

	public static Cache FIFO(Cache i, Long a)
	{
		if(i.getMapping_type())
		{
			Iterator<Address> itr = i.getCache_mapping().iterator();
			while(itr.hasNext()){
				System.out.println(Boolean.toString(itr.next().getValid()));
			}
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