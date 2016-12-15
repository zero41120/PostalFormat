package postal;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GUIController implements Initializable{
	final static String xmlFile = "PostalGUI.fxml";
	final static String programTitle = "郵政列印";
	@FXML Button buttonGetEmpty, buttonBrowse, buttonGetLabel;
	

	static Stage refStage = null;
	
	
	
	/**
	 * Disables the buttons.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		disalbeButtons(true, true);
	}

	/**
	 * This method disable Generate and View button.
	 */
	private void disalbeButtons(Boolean disableRun, Boolean disableView) {
	
	}
	
	public void actionGetLabel(){
		System.out.println("GetLable");
	}	
	public void actionBrowse(){
		System.out.println("Browse");

	}
	public void actionGetEmpty(){
		System.out.println("GetEmpty");

	}
}