package sortedInsertVisitors.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class MyArray implements MyADT{

	private Integer []myArr;

	int back;

	public MyArray(){

		myArr = new Integer[1];

		back = 0;

	}

	/**
	returns the size of the data structure
	
	@return int
	*/	
	public int size() {

		return back;
	}

	/**
	
	Returns a boolean 
	Returns true if the data structure is empty
	
	@return boolean
	*/	
	public boolean isEmpty() {

		boolean isEmpty = false;

		if(myArr == null || myArr.length < 1)		
			isEmpty = true;

		return isEmpty;
	}

	/**
	
	returns a boolean
	returns true of the data structure contains the element in the parameters
	
	@param o
	@return boolean
	
	*/	
	public boolean contains(int o) {

		boolean arrHasElement = false;

		for(int i=0;i<back;i++){
			if(myArr[i] == o){
				arrHasElement = true;
				break;
			}
		}		

		return arrHasElement;
	}

	/**
	
	returns the last element in the data structure
	
	
	@return int
	*/
	public int back(){

		return myArr[back-1];			

	}
	
	/**
	Adds an element to the data structure
	
	returns a boolean if the add is successful
	
	@param e
	@return boolean
	
	*/
	public boolean add(int e) {

		boolean isInserted = false;
		
		if(myArr == null){
			myArr = new Integer[1];

		}

		if( myArr[myArr.length-1] != null && back >= myArr.length){
			Integer[] tempArr = new Integer[(myArr.length)*2];
			for(int i =0;i<myArr.length;i++)
				tempArr[i] = myArr[i];
			
			tempArr[back] = e;

			myArr = tempArr;
			tempArr = null;
			isInserted = true;

		}else{
			myArr[back] = e;
			isInserted = true;
			
		}

		back++;

		return isInserted;
	}

	/**
	
	Clears data structure of its elements
	
	*/
	public void clear() {
		
		back = 0;
		myArr = null;
	}

	/**
	Returns the element from the index in the data structure
	
	@param index
	@return int
	*/		
	public int get(int index) {
		
		return myArr[index];
	}

	/**
	
	Sets the index of the datat structure to the element specified in the parameters
	
	@param index element
	*/
	public void set(int index, int element) {

		myArr[index] = element;		

	}

	/**
	Adds an element to the datat structure at the index.
	All elements after in the index is shifted to the right by one index
	
	@param index element
	*/
	public boolean add(int index, int element) {
		
		boolean isInserted = false;

		if(myArr == null){
			myArr = new Integer[1];

		}

		if( myArr[myArr.length-1] != null && back >= myArr.length){
			Integer[] tempArr = new Integer[(myArr.length)*2];
			for(int i = 0;i<index;i++)
				tempArr[i] = myArr[i];
			
			tempArr[index] = element;

			for(int i = index+1;i<=back;i++)
				tempArr[i] = myArr[i-1];
			

			myArr = tempArr;
			tempArr = null;
			isInserted = true;

		}else{
			Integer[] tempArr = new Integer[(myArr.length)];
			for(int i = 0;i<index;i++)
				tempArr[i] = myArr[i];
			
			tempArr[index] = element;

			for(int i = index+1;i<=back;i++)
				tempArr[i] = myArr[i-1];
			

			myArr = tempArr;
			tempArr = null;
			isInserted = true;

			
		}

		back++;

		return isInserted;
		
	}

	/**
	
	Displays the contents of the data structure	
	
	*/
	@Override
	public void display(){
		try{		
			for(int i=0;(myArr != null) && (i<back);i++){
				System.out.print(myArr[i] + " ");
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
	@Override
	public void accept(Visitor vstr){
		vstr.visit(this);
	}
	
}
