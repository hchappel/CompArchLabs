public class Address{
	private static int full_address;
	private static boolean valid;
	private static int block_address;


	Address()
	{
		full_address = 0;
		valid = false;
		block_address = 0;
	}

	public static int getFull_address()
	{
		return full_address;
	}

	public static void setFull_address(int add)
	{
		full_address = add;
	}


	public static boolean getValid()
	{
		return valid;
	}

	public static void setValid(boolean val)
	{
		valid = val; 
	}
	public static int BlockAddressTag()
	{
		return block_address;
	}

	public static void setBlockAddress(int t)
	{
		block_address = t;	
	}

	public String toString()
	{
		return Integer.toString(full_address) + Boolean.toString(valid) + Integer.toString(block_address);
	}
}