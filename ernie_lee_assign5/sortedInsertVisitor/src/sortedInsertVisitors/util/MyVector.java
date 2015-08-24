package sortedInsertVisitors.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class MyVector implements MyADT{

	private List<Integer> myVec;

	/**
	*
	* MyVector constructor
	* Internally stores a vector of Integers
	*
	*/
	public MyVector(){
		myVec = new Vector<Integer>();

	}

	/**
	
	returns the size of the vector
	
	@return int
	*/
	public int size() {
		
		return myVec.size();
	}

	
	/**
	
	Returns a boolean 
	Returns true if the data structure is empty
	
	@return boolean
	*/	
	public boolean isEmpty() {
		
		return myVec.isEmpty();
	}

	/**
	
	returns a boolean
	returns true of the data structure contains the element in the parameters
	
	@param o
	@return boolean
	
	*/	
	public boolean contains(int o) {
		
		return myVec.contains(o);
	}

	/**
	Adds an element to the data structure
	
	returns a boolean if the add is successful
	
	@param e
	@return boolean
	
	*/
	public boolean add(int e) {
		
		return myVec.add((Integer)e);
	}

	
	/**
	determines if the data structure contains data structure 
	
	returns a boolean if true
	
	@param c
	@return boolean
	*/
	public boolean containsAll(Collection c) {
		
		return myVec.containsAll(c);
	}

	/**
	
	Clears data structure of its elements
	
	*/
	public void clear() {
		
		myVec.clear();
	}

	/**
	Returns the element from the index in the data structure
	
	@param index
	@return int
	*/	
	public int get(int index) {
		
		return myVec.get(index);
	}

	/**
	
	Sets the index of the datat structure to the element specified in the parameters
	
	@param index element
	@return int
	
	*/
	public int set(int index, int element) {
		
		return myVec.set(index, (Integer)element);
	}

	/**
	Adds an element to the datat structure at the index.
	All elements after in the index is shifted to the right by one index
	
	@param index element
	*/
	public void add(int index, int element) {
		
		myVec.add(index, (Integer)element);
	}

	/**
	Removes the element in the specified index in the data structure
	Returns the removed element
	
	@param index
	@return int
	*/
	public int remove(int index) {
		
		return myVec.remove(index);
	}

	
	/**
	
	Returns the index of the element specified in the parameter
	
	@param o
	@return int
	
	*/
	public int indexOf(int o) {
		
		return myVec.indexOf(o);
	}

	/**
	
	Displays the contents of the data structure	
	
	*/
	public void display(){

		try{
			for(int v: myVec){
				System.out.print(v + " ");
			}
			System.out.println();
		} catch(NullPointerException e){
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	Visitor function that accepts a visitor to perform an algorithm to this object
	
	@param vstr
	*/
	public void accept(Visitor vstr){
		vstr.visit(this);
	}


}
