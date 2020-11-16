package it.unibo.oop.lab.nesting2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class OneListAcceptable<T> implements Acceptable<T>{
	
	private List<T> list;
	
	public OneListAcceptable(List <T> list) {
		this.list = list;
	}
	
	public Acceptor<T> acceptor() {
		final Iterator<T> iterator = this.list.iterator();
		return new Acceptor<T>() {

			public void accept(T newElement) throws ElementNotAcceptedException {
				try {
					if(newElement.equals(iterator.next())) {
						System.out.println(newElement);
						return;
					}
				}catch (Exception e){
					System.out.println("No more element evaluated");
				}
				throw new Acceptor.ElementNotAcceptedException(newElement);
			}

			public void end() throws EndNotAcceptedException {
				try {
					if(!iterator.hasNext()) {
						return;
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				throw new Acceptor.EndNotAcceptedException();
			}
			
		};
	}
}
