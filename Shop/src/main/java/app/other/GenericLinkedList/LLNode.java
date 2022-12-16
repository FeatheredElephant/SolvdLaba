package app.other.GenericLinkedList;

public class LLNode <T>{
	T data;
	LLNode<T> next;
	
	LLNode(T data)
	{
		this.data = data;
		this.next = null;
	}
}