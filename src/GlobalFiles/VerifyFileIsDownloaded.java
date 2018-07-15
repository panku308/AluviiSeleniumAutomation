package GlobalFiles;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class VerifyFileIsDownloaded {
	 public static boolean isFileDownloaded(String downloadPath, String fileName) {
			boolean flag = false;
		    File dir = new File(downloadPath);
		    File[] dir_contents = dir.listFiles();
		  	    
		    for (int i = 0; i < dir_contents.length; i++) {
		    	System.out.println(dir_contents[i].getName());		    	
		    	
		        if (dir_contents[i].getName().equals(fileName))
		            return flag=true;
		            }
		    

		    return flag;
		}
	 
	 public static int getNumberOfPagesFromPDFFile(String fileNameWithPath) throws Exception
	 {
		 PDDocument doc = PDDocument.load(new File(fileNameWithPath));
		 int count = doc.getNumberOfPages();
		 System.out.println("count = " + count); 
		 return count;
	 }

}
