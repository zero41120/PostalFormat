package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileManager implements Validatable{

	@Override
	public void validate(Object target) {
		if (target == null) throw new ValidationException("空白檔案"); 
		if (!(target instanceof File)) throw new ValidationException("非有效檔案"); 
	}
	
	public void validateExtension(Object target, String ext){
		validate(target);
		File myFile = (File)target;
		if (!getExtension(myFile).equals(ext)) 
			throw new ValidationException(myFile.getName()+"並非指定檔("+getExtension(myFile)+":"+ext+")");
	}
		
	public String getName(File target) {
		String name = target.getName();
		if (name.indexOf(".") > 0)
		    name = name.substring(0, name.lastIndexOf("."));
		return name;
	}
	
	public String getExtension(File target) {
		Integer i = target.getName().lastIndexOf('.') + 1;
		return target.getName().substring(i);
	}
	
	public FileOutputStream getOutStreamAt(File workingDirectory, File workingFile, String ext) throws FileNotFoundException {
		return getOutStreamAt(workingDirectory, getName(workingFile), ext);
	}

	public FileOutputStream getOutStreamAt(File selectedDirectory, String name, String ext) throws FileNotFoundException{
		File myFile = createFileAt(selectedDirectory, name, ext);
		return new FileOutputStream(myFile);
	}
	public File createFileAt(File selectedDirectory, String name, String ext){
		String fullPath = selectedDirectory.getAbsolutePath() + "/" + name;
		File myFile = new File(fullPath + ext);
		for(int i = 1; myFile.exists(); i++){
			myFile = new File(fullPath + "(" + i + ")" + ext);
		}
		return myFile;
	}
}
