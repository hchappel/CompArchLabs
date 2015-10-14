/*
The Address object simulates a block location within the cache. 
When in CacheProject Main is created the Address Object 
is created and is intialized with the index,
the validity bit is set to false and the block address is empty.
*/
public class Address{
	private int index;//int for index and will be zero is the cache is fully associative
	private boolean valid;// Boolean for validity bit
	private Long block_address;// int of block address




/*
Method:Constructor - Creates a fully associative cache block
Input:None
Output:None
*/
	public Address()
	{
		index = 0;
		valid = false;
		block_address = 0L;
	}

/*
Method: Constructor - Creates an Address object that is fully inilized
Input: Int i for block address; boolean v for valid bit; Long b for block address
Output:None
*/
	public Address(int i, boolean v, Long b)
	{
		index = i;
		valid = v;
		block_address = b;	
	}

/*
Method: getIndex - getter for the address's index
Input:none
Output:int of Address's Index
*/
	public int getIndex()
	{
		return index;
	}

/*
Method: setIndex - setter for address's index
Input: int of Address's Index
Output: void
*/
	public void setIndex(int add)
	{
		index = add;
	}


/*
Method: getValid - getter for address's validity bit
Input: none 
Output: boolean true if address has been intilized; false for not intilaized
*/
	public boolean getValid()
	{
		return valid;
	}

/*
Method:setValid - setter for address's validity bit
Input: boolean val sets the validity bit
Output: void
*/
	public void setValid(boolean val)
	{
		valid = val; 
	}


/*
Method: getBlockAddres - getter for address's block address
Input: none
Output: Long of address's block address
*/
	public Long getBlockAddress()
	{
		return block_address;
	}

/*
Method:setBlockAddres - setter for address's block address
Input:Long t for address's block address
Output:void
*/
	public void setBlockAddress(Long t)
	{
		block_address = t;	
	}

/*
Method: toString - String reprsentation of the address for testing
Input: none
Output: The String rep of the block address
*/
	public String toString()
	{
		return Long.toString(block_address);
	}
}
