package postal;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIController implements Initializable{
	final static String xmlFile = "main.fxml";
	final static String programTitle = "郵政列印";
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

	/**
	 * This method load the xml file and shows it.
	 */
	public static boolean createMainScreen(Stage primaryStage) {
		try {
			System.out.println("Program starts");
			Parent root = FXMLLoader.load(Main.class.getResource(xmlFile));
			primaryStage.setTitle(programTitle);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}