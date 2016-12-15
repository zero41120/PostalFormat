package util;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AlertController {
	
	Alert dialog;
	AlertType type;
	String header, message;

	public AlertController(String header, String message, AlertType type) {
		this.init(header, message, type);
		this.showAndWait();
	}

	private void init(String header, String message, AlertType type) {
		dialog = new Alert(type);
		dialog.setTitle(type.toString());
		dialog.setHeaderText(header);
		dialog.setContentText(message);
	}
	
	public AlertController(Exception e) {
		e.printStackTrace();
		init("Java exception", 
			 "Java operation fail to execute.", 
			 AlertType.ERROR);
		

		// Gets the exception and loads it into the writer.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		Label label = new Label("Exception stacktrace:");

		// Adds the exception the expandable text area.
		TextArea textArea = new TextArea(sw.toString());
		textArea.setEditable(true);
		textArea.setWrapText(true);
		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		dialog.getDialogPane().setExpandableContent(expContent);

		this.showAndWait();
	}

	private void showAndWait() {
		try {
			dialog.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
