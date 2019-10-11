
public class ArrayStack implements Stack
{
    private Object data[];
    private int top;
    private int size;
    public static final int DEFAULT_INITIAL_SIZE = 100;
    
   
    public ArrayStack() 
    {
	data = new Object[DEFAULT_INITIAL_SIZE];
	top = 0;
	size = DEFAULT_INITIAL_SIZE;
    }

    public ArrayStack(int initsize) 
    {
	data = new Object[initsize];
	top = 0;
	size = initsize;
    }
    
    public boolean empty() 
    {
	return top == 0;
    }

    public void push(Object elem)  
    {
	if (top == size)
	    Grow_Stack();
	data[top++] = elem;
    }

    public Object pop() 
    {
	Object poppedvalue;

        if (top > 0)
	    return data[--top];
	else
	    return null;
    }

    public String toString()
    {
	String result = "[";
	if (top > 0)
	{
	    result = result +  data[top-1];
	}
        for (int i = top - 2; i >= 0; i--)
	{
	    result = result + "," + data[i];
	}
	result = result + "]";
	return result;
    }

    protected void Grow_Stack() 
    {
       int i;
       Object newdata[];

       newdata = new Object[size * 2];
       for (i=0; i<size; i++)
           newdata[i] = data[i];
       data = newdata;
       size = size * 2;
    }
}


