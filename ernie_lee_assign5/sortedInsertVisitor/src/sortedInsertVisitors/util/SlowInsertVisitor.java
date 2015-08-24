package sortedInsertVisitors.util;


public class SlowInsertVisitor implements Visitor{


	FileProcessor filePrcr;

	/**
	Constructor for the SlowInsertVisitor
	
	@param fileProcessor
	*/
	public SlowInsertVisitor(FileProcessor fileProcessor){

		filePrcr = fileProcessor;

	}

	/**
	Takes an int from the text file and inserts it to the back of the data structure
	It then sorts the data structure until it is in increasing order
	
	@param vst
	*/
	@Override
	public void visit(MyArray vst){

		while(filePrcr.hasNextInt()){
			vst.add(filePrcr.nextInt());
			
			
			int n = vst.size();
			for (int j = 1; j < n; j++) {
				int key = vst.get(j);
				int i = j-1;
				
				while ( (i > -1) && ( vst.get(i) > key ) ) {
					vst.set(i+1, vst.get(i));
					i--;
				}
				vst.set(i+1, key);
			}
		}

		filePrcr.resetReader();

	}

	/**
	Takes an int from the text file and inserts it to the back of the data structure
	It then sorts the data structure until it is in increasing order
	
	@param vst
	*/
	@Override
	public void visit(MyVector vst){

		while(filePrcr.hasNextInt()){
			vst.add(filePrcr.nextInt());
			
			int n = vst.size();
			for (int j = 1; j < n; j++) {
				int key = vst.get(j);
				int i = j-1;
				
				while ( (i > -1) && ( vst.get(i) > key ) ) {
					vst.set(i+1, vst.get(i));
					i--;
				}
				vst.set(i+1, key);
			}
		}

		filePrcr.resetReader();

	}


}
