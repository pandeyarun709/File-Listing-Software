package fileListing;


import java.io.BufferedReader;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileListingSoftware {
	/*#################### WRITTING THE PATH AND SAVING IN abc.txt##################################*/
		
		public static void writePath(File file) throws IOException
		{
			//FileOutputStream fout = new FileOutputStream(file);

			FileWriter fout =  new FileWriter(file);
			
			if(!file.exists())
			{
				file.createNewFile();
			}
			
		      String s = "";
			
		
			Scanner sc = new Scanner(System.in);
			
			int numPath;
			System.out.println("Enter number of path you want : ");
			
			numPath = sc.nextInt();
			sc.nextLine();
			while(numPath != 0)
			{
				System.out.println("Enter the path file get List of File in that Directory  : ");
				s += sc.nextLine();
				s += "\n";
				
				numPath--;
			}
			
			fout.write(s);
		
		
			
			System.out.println("Path written success fully");
			
			sc.close();
			fout.close();
			
		}
		
		
	/*	####################################### GET FILE LIST #########################################################################*/
		
		public static ArrayList<File> fileListing(File file) throws IOException
		{
			
			
			/*
			while(in != '\n' )
			{
				path = path + (char)in;
				
				in = f.read();
				
			}
			*/
			 
			ArrayList<File> list = new ArrayList<File>();
			
			String line ;
			BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
               
			 getFileList(line , list);  //CALL THE RECCURSION FUNCTION
			 
			 
            }
			 
			//System.out.println(path);
			
			
		//	f.close();
			br.close();
			return list;
			
			
		}
		
		

	/*	######################################  RECCURSIVE PART TO GET LIST ##########################################################################*/
		
		public static  void getFileList(String path , ArrayList<File> list)
		{
			
			File file = new File(path);
			
			File f [] = file.listFiles();
			
//			ArrayList<File> list = new ArrayList<File>();
			
			
			for(File fx : f)
			{
				if(fx.isFile())
				{
					list.add(fx);
				}
				else if(fx.isDirectory())
				{
					getFileList(fx.getAbsolutePath() , list);
				}
			}
			
			
			//return list;
			
		}
		

	/*	####################################### SAVING LIST IN PATH IN .csv FILE #########################################################################*/

		
		public static void saveFileListPath(File finalFile, ArrayList<File> fileList) throws IOException {
			// TODO Auto-generated method stub
			///---------------reading path of csv file-------------------------
		
			
			
			
			File file = new File("F:/arun/Acadview java/File Listing software/src/fileListing/fileLists.csv");
			//File file = new File(path);
			
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileWriter w = new FileWriter(file);
			
			for(File f : fileList)
			{
				w.write(f.getName()+" , "+f.getAbsolutePath() + "\n");
			
			}
			
			
			FileWriter fw = new FileWriter(finalFile,true);
			
			fw.append(file.getPath());
			
			fw.close();
			w.close();
		}
		
		public static void main(String [] args) throws IOException
		{
			
			File file = new File("F:/arun/Acadview java/File Listing software/src/fileListing/abc.txt");
			
			writePath(file);
			
			
			ArrayList<File> fileList = new ArrayList<File>();
			
			fileList = fileListing(file);
			
			saveFileListPath(file , fileList);
			
			
			
		}


}



