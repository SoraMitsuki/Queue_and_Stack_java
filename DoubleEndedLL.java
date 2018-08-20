package hw4;

/**
 * Name: Jiaqi Fan
 * ID: A12584051
 * Login: cs12sju
 * Date: 4/18/2016
 */
import java.util.NoSuchElementException;
/**
 * @author Jiaqi Fan
 * @version 1.0
 * @since 4/18/2016
 * @param <E> type of data passed in
 */
public class DoubleEndedLL<E> implements DoubleEndedLLInterface<E> {
	
	private int index; // the index of the elements in the list
	private Node head; // the head of the list
	private Node tail; // the tail of the list

	protected class Node{
		E data;
		Node next;
		/**
		 * ctor to make a node
		 * @param element set the element to data
		 */
		public Node(E element){
			data = element;
			next = null;
		}
		/**
		 * ctor that make a node
		 * @param element element for add
		 * @param prevN previous node
		 * @param nextN next node
		 */
		public Node(E element, Node prevN, Node nextN){
			this.data = element;
			this.next = nextN;
			prevN.next = this;
		}
		/**
		 * method that set the next node in the list
		 * @param toSet the node to set to next
		 */
		public void setNext(Node toSet){
			this.next = toSet;
		}
	}
	/**
	 * check the list is empty or not
	 * @return true for list is empty
	 * @return false for list is not empty
	 */
	@Override
	public boolean isEmpty() {
		if(index == 0){
			return true;	
		}
		else{
		return false;
		}
	}
	/**
	 * return the size of the list
	 * @return the size of the list
	 */
	@Override
	public int size() {
		return index;
	}

	/**
	 * add the element to the list
	 * @param newItem the element to add
	 */
	@Override
	public void addFirst(E newItem) {
		if(newItem == null){ //check for null pointer exception
			throw new NullPointerException();
		}
		Node addHead = new Node(newItem); // if the list is empty
		if(head == null){
			head = addHead;//then the first element is 
			tail = addHead;//head and tail is the same node
		}
		else{
			addHead.next = head; //list is not empty the add to he front
			head = addHead;
		}
		index++;
	}
	/**
	 * add element to the last position
	 * @param newItem to add in the last position
	 */
	@Override
	public void addLast(E newItem) {
		if(newItem == null){ //check the list is null or not
			throw new NullPointerException();
		}
		Node addTail = new Node(newItem);
		if(tail == null && head == null){ //if the list is null
			tail = addTail;
			head = addTail;//set the tail element to the head and tail
		}
		else{
			tail.next = addTail; //list is not empty
			tail = addTail;//set the node to the tail
		}
		index++;
	}
	/**
	 * remove the first element in the list
	 * @return return the element that been removed
	 * @throws NoSuchElementException
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		if(isEmpty() == true){ //check for the list is empty or not
			throw new NoSuchElementException();
		}
		E rFirst = head.data; //the returned element is the head element
		head = head.next; // shift the list make the second node the new head
		index--; //list size decrease
		return rFirst;
	}
	/**
	 * remove the last element in the list
	 * @return return the element that been removed
	 */
	@Override
	public E removeLast() throws NoSuchElementException {
		if(isEmpty() == true){ //check for the list is empty or not
			throw new NoSuchElementException();
		}
		E rLast = tail.data; //the returned element is the head element
		int indexB4tail = index - 2;
		tail = getNth(indexB4tail); // make the element before tail the new tail
		index--; //list size decrease
		return rLast;
	}
	/**
	 * helper method to get to the element before tail
	 * @param the index of the element before tail
	 * @return return the element in that position
	 * @throws IndexOutOfBoundsException
	 */
	private Node getNth(int indexB4tail) throws IndexOutOfBoundsException{
		if(indexB4tail + 1 > index || indexB4tail < -1){ // check for the index out of bound
			throw new IndexOutOfBoundsException();
		}
		Node nodeB4tail = head; //let the temp node become head
		for(int i = 0; i < indexB4tail; i++)//loop through the index
		{
			nodeB4tail = nodeB4tail.next; //to the element that is before tail
		}
		return nodeB4tail; //return the element
		
	}

}
