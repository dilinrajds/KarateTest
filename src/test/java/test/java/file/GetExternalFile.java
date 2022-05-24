package test.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetExternalFile {
	
	public String getFile() throws IOException
	{
	String name = "";
		
		String filePath = ("\\KarateProjectWithExcel\\data\\testExcel.xlsx");
		
		String userDir = System.getProperty("user.dir");
		String removeProjectName = userDir.substring(0, userDir.lastIndexOf("\\"));
		
		String completePath = removeProjectName+filePath;
		 System.out.print("pathhhhh --->"+completePath);
		 
		File file = new File(completePath);
		
		FileInputStream fis  = new FileInputStream(file);

		if (fis!=null) {
		      System.out.println("EXCEL FILE READED");
		      name = "EXCEL FILE READED";
		      
		    } else {
		    	System.out.println("UNABLE TO READ FILE");
		    	name = "UNABLE TO READ FILE";
		    }
	return name;
	}

}
