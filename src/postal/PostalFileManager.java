package postal;


import java.io.File;

import util.FileManager;

public class PostalFileManager extends FileManager{
	
	public void validateExtension(File workingDirection){
		validateExtension(workingDirection, "xlsx");
	}
	
}
