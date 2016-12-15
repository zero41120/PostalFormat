package postal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args){
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			System.out.println("Program begins");
			Parent root = FXMLLoader.load(getClass().getResource("PostalGUI.fxml"));
			primaryStage.setTitle(GUIController.programTitle);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			GUIController.refStage = primaryStage;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		// Nothing to close as now.
	}
}
