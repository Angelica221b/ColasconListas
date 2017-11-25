package Queue;

import java.util.Iterator;

import node.node;


public class Queue<T extends Comparable<T>> implements iQueue<T>, Iterable<T> {
	
	private node<T> start=null, end=null;
	//private int top = -1;
	node<T> front;
	node<T> back;
	private int count = 0;
	private int tamaño;
	
	public Queue(int i){
		
		tamaño=i;
		start = new node<T>();
		end = new node<T>();
		
		start.setIndex(-1);
		end.setIndex(-1);
		
		node<T> nuevo = new node<T>();
		start.setNext(nuevo);
		nuevo.setBack(start);
		node<T> tmp = start.getNext();
		for (int j = 1; j < tamaño; j++) {
			node<T> _nuevo = new node<T>();
			tmp.setNext(_nuevo);
			_nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		
		end.setBack(tmp);
		front = start.getNext();
		back = start.getNext();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			node<T> tmp = back.getBack();
			int i=0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if(tmp.getNext()==null)
					tmp=start.getNext();
				else
					tmp=tmp.getNext();
				return (i++ != count)?true:false;
			}
			@Override
			public T next() {
				// TODO Auto-generated method stub
				return tmp.getValue();
			}
		};
	}

	@Override
	public void enQueue(T value) throws QueueFullException {
		// TODO Auto-generated method stub
		if(isFull())throw new QueueFullException("No se pueden agregar mas elementos");
		
		front.setValue(value);
		count ++;
		
		if(front.getNext()!=null)
		//if(isEmpty())
			front=front.getNext();
			
		else
			front=start.getNext();
	}

	@Override
	public T deQueue() throws QueueEmptyException {
		if(isEmpty()) throw new QueueEmptyException("La lista esta vacia");
		
		T tmp = back.getValue();
		
		if(isFull())
			back.setValue(null);
		
		
		back=back.getNext();
		count--;
		
		return tmp;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (count == tamaño);
	}

	@Override
	public T front() throws QueueEmptyException {
		if(isEmpty()) throw new QueueEmptyException("La lista esta vacia");
		
		return back.getValue();
	}

	@Override
	public T search(T value) throws QueueEmptyException {
		if(isEmpty()) throw new QueueEmptyException("La lista esta vacia");
		node<T> tmp=back;
		
		while(tmp !=end.getBack()){
			
			
			if(tmp.getValue().equals(value))
				return tmp.getValue();
			
			tmp=tmp.getNext();
		}
		
		return null;
	}
	

	@Override
	public void clear() {
		start.setNext(null);
		end.setBack(null);
		count=0;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
}