package app.other.GenericLinkedList;

class list<T> {

	// Generic LLNode instance
	LLNode<T> head;
	// Data member to store length of list
	private int length = 0;

	// Default constructor
	list() {
		this.head = null;
	}

	void add(T data) {

		// Create new node with given value
		LLNode<T> temp = new LLNode<>(data);

		if (this.head == null) {
			head = temp;
		}

		// If list already exists
		else {

			// Temporary LLNode for traversal
			LLNode<T> X = head;

			// Iterating till end of the List
			while (X.next != null) {
				X = X.next;
			}

			// Adding new valued LLNode at the end of the list
			X.next = temp;
		}

		// Increasing length after adding new LLNode
		length++;
	}

	// dd new node at any given position
	void add(int position, T data) {

		// Checking if position is valid
		if (position > length + 1) {

			// Display message only
			System.out.println("Position Unavailable in LinkedList");
			return;
		}

		// If new position is head then replace head LLNode
		if (position == 1) {

			// Temporary LLNode that stores previous head
			// value
			LLNode<T> temp = head;

			// New valued LLNode stored in head
			head = new LLNode<T>(data);

			// New head LLNode pointing to old head LLNode
			head.next = temp;

			return;
		}

		// Temporary LLNode for traversal
		LLNode<T> temp = head;

		// Dummy LLNode with null value that stores previous
		// LLNode
		LLNode<T> prev = new LLNode<T>(null);
		// iterating to the given position
		while (position - 1 > 0) {
			// assigning previous LLNode
			prev = temp;
			// incrementing next LLNode
			temp = temp.next;
			// decreasing position counter
			position--;
		}
		// previous LLNode now points to new value
		prev.next = new LLNode<T>(data);
		// new value now points to former current LLNode
		prev.next.next = temp;
	}

	// remove a node from list
	void remove(T key) {

		// Dummy LLNode with null value
		LLNode<T> prev = new LLNode<>(null);

		// Dummy LLNode pointing to head LLNode
		prev.next = head;

		// Next LLNode that points ahead of current LLNode
		LLNode<T> next = head.next;

		// Temporary LLNode for traversal
		LLNode<T> temp = head;

		// Boolean value that checks whether value to be
		// deleted exists or not
		boolean exists = false;

		// If head LLNode needs to be deleted
		if (head.data == key) {
			head = head.next;

			// LLNode to be deleted exists
			exists = true;
		}

		// Iterating over LinkedList
		while (temp.next != null) {

			// We convert value to be compared into Strings
			// and then compare using
			// String1.equals(String2) method

			// Comparing value of key and current LLNode
			if (String.valueOf(temp.data).equals(String.valueOf(key))) {

				// If LLNode to be deleted is found previous
				// LLNode now points to next LLNode skipping the
				// current LLNode
				prev.next = next;
				// LLNode to be deleted exists
				exists = true;

				// As soon as we find the LLNode to be deleted
				// we exit the loop
				break;
			}

			// Previous LLNode now points to current LLNode
			prev = temp;

			// Current LLNode now points to next LLNode
			temp = temp.next;

			// Next LLNode points the LLNode ahead of current
			// LLNode
			next = temp.next;
		}

		// Comparing the last LLNode with the given key value
		if (exists == false && String.valueOf(temp.data).equals(String.valueOf(key))) {

			// If found , last LLNode is skipped over
			prev.next = null;

			// LLNode to be deleted exists
			exists = true;
		}

		// If LLNode to be deleted exists
		if (exists) {

			// Length of LinkedList reduced
			length--;
		}

		// If LLNode to be deleted does not exist
		else {

			// Print statement
			System.out.println("Given Value is not present in linked list");
		}
	}

	// To clear the entire LinkedList
	void clear() {

		// Head now points to null
		head = null;
		// length is 0 again
		length = 0;
	}

	// Returns whether List is empty or not
	boolean empty() {

		// Checking if head LLNode points to null
		if (head == null) {
			return true;
		}
		return false;
	}

	// Returning the length of LinkedList
	int length() {
		return this.length;
	}

	@Override
	public String toString() {

		String S = "{ ";

		LLNode<T> X = head;

		if (X == null)
			return S + " }";

		while (X.next != null) {
			S += String.valueOf(X.data) + " -> ";
			X = X.next;
		}

		S += String.valueOf(X.data);
		return S + " }";
	}
}