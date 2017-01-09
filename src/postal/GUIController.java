package postal;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.*;

public class GUIController implements Initializable{
	final static String XMLFILE = "PostalGUI.fxml";
	final static String TITLE = "郵政列印";
	static Stage refStage = null;
	static File workingDirectory = null;
	static File workingFile = null;
	@FXML Button buttonGetEmpty, buttonBrowse, buttonGetLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}

	/**
	 * This method responds to a button click, which generates a postal
	 * shipping label word file for printing purpose.
	 */
	public void actionGetLabel(){
		System.out.println("Clicked Get Label");
		DirectoryChooser chooser = new DirectoryChooser();
		PostalFileManager fManager = new PostalFileManager();
		
		try {
			PostalPDFManager pManager = new PostalPDFManager(workingFile);
			fManager.validate(workingFile);
			workingDirectory = chooser.showDialog(refStage);
			fManager.validate(workingDirectory);
			pManager.createLabelAt(workingDirectory, false);
			new AlertController("建立影印標籤成功", "建立於"+workingDirectory.getName(), AlertType.INFORMATION);

		} catch (ValidationException e){
			new AlertController("資訊", e.getMessage(), AlertType.INFORMATION);
		} catch (Exception e){
			new AlertController(e);
		} finally {
			workingDirectory = null;
		}
		System.out.println("_Completed Get Label");
	}	
	
	/**
	 * This method responds to a button click, which selects an excel file
	 * with shipping information.
	 */
	public void actionBrowse(){
		System.out.println("Clicked Browse");
		FileChooser chooser = new FileChooser();
		PostalExcelManager eManager = new PostalExcelManager();
		PostalFileManager fManager = new PostalFileManager();
		
		try {
			workingFile = null;
			workingFile = chooser.showOpenDialog(refStage);
			fManager.validateExtension(workingFile);
			eManager.validate(workingFile);
		} catch (ValidationException e){
			new AlertController("資訊", e.getMessage(), AlertType.INFORMATION);
			workingFile = null;
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("_Completed Browse");
	}
	
	/**
	 * This method responds to a button click, which generates a postal
	 * label excel file for user to input shipping information.
	 */
	public void actionGetEmpty(){
		System.out.println("Click Get Empty");
		DirectoryChooser chooser = new DirectoryChooser();
		PostalExcelManager eManager = new PostalExcelManager();
		PostalFileManager fManager = new PostalFileManager();
		
		try {
			chooser.setTitle("選擇儲存地點");
			workingDirectory = chooser.showDialog(refStage);
			fManager.validate(workingDirectory);
			eManager.createDefaultAt(workingDirectory);
			new AlertController("建立空白總表成功", "已在"+workingDirectory.getName()+"建立空白總表", AlertType.INFORMATION);
		} catch (ValidationException e){
			// User probably choose to close the directory selection window
		} catch (Exception e){
			new AlertController(e);
		} finally { 
			workingDirectory = null;
		}
		
		System.out.println("_Completed Get Empty");
	}
}

