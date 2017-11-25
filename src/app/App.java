package app;

import java.util.Iterator;

import Queue.Queue;

public class App {

	public static void main(String[] args) {
		Queue<String> names = new Queue<String>(5);
		
		try {
			names.enQueue("Jose");
			names.enQueue("Ana");
			names.enQueue("Ricar2");
			names.enQueue("Aaron");
			names.enQueue("Milton");
			
			
			System.out.println("Remove: " + names.deQueue());
			System.out.println("Remove: " + names.deQueue());
			System.out.println();
			System.out.println("Front: " + names.front());
			
			System.out.println();
			//names.clear();

			Iterator<String> iterator =names.iterator();
			
			
			System.out.println("Size: " + names.size());
			
			System.out.println("Search: "+names.search("Aaron"));
			
			System.out.println("Agregar: Frodo");
			names.enQueue("Frodo");
			
			System.out.println("-----------------");
			System.out.println();
			for(Iterator<String> it=iterator; it.hasNext(); ) {
				System.out.println(iterator.next());
			}
			
			names.clear();
			System.out.println();
			System.out.println("Size: "+names.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
