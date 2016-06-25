
public class Deque {
	private class Node {
		protected int data;
		protected Node prev;
		protected Node next;
	}

	private Node head;
	private Node tail;

	public Deque() {
		head = null;
		tail = null;
	}

	public void pushFront(int x) {
		if (isEmpty()) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.prev = null;
			newNode.next = null;

			head = newNode;
			tail = newNode;
		} else {
			Node newNode = new Node();
			newNode.data = x;
			newNode.prev = null;
			newNode.next = head;

			head.prev = newNode;
			head = newNode;
		}
	}

	public void pushBack(int x) {
		if (isEmpty()) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.prev = null;
			newNode.next = null;

			head = newNode;
			tail = newNode;
		} else {
			Node newNode = new Node();
			newNode.data = x;
			newNode.prev = tail;
			newNode.next = null;

			tail.next = newNode;
			tail = newNode;
		}
	}

	public int popFront() {
		if (isEmpty()) {
			return 0;
		} else {
			int result = head.data;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head.next.prev = null;
				head = head.next;
			}

			return result;
		}
	}

	public int popBack() {
		if (isEmpty()) {
			return 0;
		} else {
			int result = head.data;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				tail.prev.next = null;
				tail = tail.prev;
			}

			return result;
		}
	}

	public boolean isEmpty() {
		return (head == null && tail == null);
	}

	public void print() {
		Node iter = head;
		for (iter = head; iter != null; iter = iter.next) {
			System.out.print(iter.data + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque newDQ = new Deque();
		newDQ.print();

		newDQ.popBack();
		newDQ.print();
		newDQ.popFront();
		newDQ.print();

		newDQ.pushFront(1);
		newDQ.pushFront(2);
		newDQ.pushFront(3);
		newDQ.pushBack(100);
		newDQ.pushBack(150);
		newDQ.print();

		newDQ.popBack();
		newDQ.popFront();

		newDQ.print();

		newDQ.popBack();
		newDQ.popBack();
		newDQ.popBack();
		newDQ.popFront();
		newDQ.popFront();
		newDQ.popFront();

		newDQ.print();
	}

}
