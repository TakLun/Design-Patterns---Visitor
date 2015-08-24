package sortedInsertVisitors.util;

import java.util.List;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProcessor{

	private BufferedReader reader;
	private FileReader file;
	
	private String line;

	/**
	File processor constructor
	*/
	public FileProcessor(){

		reader = null;
		file = null;

		line = null;

	}

	/**
	
	
	File processor constructor that takes the name of the file to be opend later
	
	@param fileName
	*/
	public FileProcessor(String fileName){
		try{
			file = new FileReader(fileName);
			reader = null;
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	Opens the file to be read
	
	*/
	public void openFile(){

		try{		
			reader = new BufferedReader(file);
			reader.mark(8192);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	Closes the file
	
	*/
	public void closeFile(){
		try{
			if(reader != null){
				reader.close();
			}
		}catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	
	Reset the bufferedreader pointer back to the beginning of the file
	*/
	public void resetReader(){

		try{
			reader.reset();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	/**
	Returns the if there is a next integer in the text file
	
	@return boolean
	*/
	public boolean hasNextInt(){

		boolean hasNext = true;

		try{		

			if((line = reader.readLine()) == null)
				hasNext = false;			
	
		} catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}

		return hasNext;

	}
	
	
	/**
	Returns the next integer in the text file
	
	@return int
	*/
	public int nextInt(){

		int input_int = 0;

		try{
			input_int = Integer.parseInt(line);		

		} catch(NullPointerException e){
			closeFile();
			e.printStackTrace();
			System.exit(0);
		} catch(NumberFormatException e){
			closeFile();
			e.printStackTrace();
			System.exit(0);
		}

		return input_int;
	}
}
