package sortedInsertVisitors.util;


public class SortedInsertVisitor implements Visitor{

	FileProcessor filePrcr;

	/**
	Constructor for the SortedInsertVisitor
	
	@param fileProcessor
	*/
	public SortedInsertVisitor(FileProcessor fileProcessor){

		filePrcr = fileProcessor;

	}

	/**
	Takes an int from the text file and 
	inserts it to the correct index of the data structure
	
	@param vst
	*/
	@Override
	public void visit(MyArray vst){

		int element = 0;

		while(filePrcr.hasNextInt()){
			element = filePrcr.nextInt();
			
			if(vst.size() == 0){
				vst.add(element);
			}else if(vst.get(0) > element){
				vst.add(0, element);
			}else if(vst.back() < element){
				vst.add(element);			
			}else{
			
				for(int i=0;i<vst.size();i++){
					if(vst.get(i) < element && vst.get(i+1) > element){
						vst.add(i+1, element);
						break;
					}
				}
			}
			
		}

		filePrcr.resetReader();

	}

	/**
	Takes an int from the text file and 
	inserts it to the correct index of the data structure
	
	@param vst
	*/
	@Override
	public void visit(MyVector vst){

		int element = 0;

		while(filePrcr.hasNextInt()){
			element = filePrcr.nextInt();
			
			if(vst.size() == 0){
				vst.add(element);
			}else if(vst.get(0) > element){
				vst.add(0, element);
			}else if(vst.get(vst.size()-1) < element){
				vst.add(element);			
			}else{
			
				for(int i=0;i<vst.size();i++){
					if(vst.get(i) < element && vst.get(i+1) > element){
						vst.add(i+1, element);
						break;
					}
				}
			}
		}

		filePrcr.resetReader();

	}


}
