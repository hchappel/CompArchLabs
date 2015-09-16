public class Address{
	private int index;
	private boolean valid;
	private Long block_address;


	public Address()
	{
		index = 0;
		valid = false;
		block_address = 0L;
	}

	public Address(int i, boolean v, Long b)
	{
		index = i;
		valid = v;
		block_address = b;	
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int add)
	{
		index = add;
	}


	public boolean getValid()
	{
		return valid;
	}

	public void setValid(boolean val)
	{
		valid = val; 
	}
	public Long getBlockAddress()
	{
		return block_address;
	}

	public void setBlockAddress(Long t)
	{
		block_address = t;	
	}

	public String toString()
	{
		return Long.toString(block_address);
	}
}