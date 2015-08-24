package sortedInsertVisitors.driver;

import sortedInsertVisitors.util.FileProcessor;
import sortedInsertVisitors.util.MyArray;
import sortedInsertVisitors.util.MyVector;
import sortedInsertVisitors.util.SortedInsertVisitor;
import sortedInsertVisitors.util.SlowInsertVisitor;

public class Driver{

	/**
	Main driver code for the sirtedInsertVisitor program
	
	@param args
	*/
	public static void main (String []args){


		String fileName = "";

		try{
			if(args.length == 1)
				fileName = args[0];
		
		}catch(NullPointerException e){
			e.printStackTrace();		
			System.exit(0);
		}catch(IllegalArgumentException e){
			e.printStackTrace();
			System.exit(0);
		}

		FileProcessor filePrcr = new FileProcessor(fileName);
		filePrcr.openFile();
		
		SortedInsertVisitor sortedVstr = new SortedInsertVisitor(filePrcr);
		SlowInsertVisitor slowVstr = new SlowInsertVisitor(filePrcr);
		
		MyArray myArr = new MyArray();
		MyVector myVec = new MyVector(); 

		myArr.accept(sortedVstr);
		myVec.accept(sortedVstr);

		myArr.display();
		myVec.display();

		myArr.clear();
		myVec.clear();

		myArr.accept(slowVstr);
		myVec.accept(slowVstr);

		myArr.display();
		myVec.display();
		
		myArr.clear();
		myVec.clear();
		
		filePrcr.closeFile();
	}
}
