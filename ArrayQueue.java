public class ArrayQueue<AnyType> implements  Queue, Stack
{
	private static final int DEFAULT_CAPACITY = 10;
	private int cap,	
                  cur,		
                  front,  	
                  back;		
	private AnyType[] A;


	public ArrayQueue ()
	{
		cap = DEFAULT_CAPACITY;
		A = (AnyType[]) new Object[DEFAULT_CAPACITY];
		back = -1; front = 0;
	}

	public boolean isEmpty()
	{
		return cur == 0;
	}
	public void enqueue (AnyType value)
	{
		if (isFull()) doubleSize();

		back++;
		A[back%cap] = value;
		cur++;
	}

	public AnyType getFront()
	{
		if (isEmpty())
			throw new QueueException();
		else
			return A[front%cap];
	}

	*/
	public AnyType dequeue()
	{
		AnyType e = getFront();
		A[front%cap] = null; // for garbage collection
		front++;
		cur--;
		return e;
	}
	public void clear()
	{
		for(int i = 0; i < cap; i++) A[i] = null;

		cur = 0; back = -1; front = 0;
	}
	public boolean isFull()
	{
		return cur == cap;
	}

	private void doubleSize()
	{
		AnyType[] newArray = (AnyType[]) new Object[2*cap];

		for(int i = front; i <= back; i ++)
			newArray[i-front] = A[i%cap];

		A = newArray;
		front = 0;
		back = cur-1;
		cap *= 2;
	}