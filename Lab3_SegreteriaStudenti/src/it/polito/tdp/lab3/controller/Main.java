package it.polito.tdp.lab3.controller;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SegreteriaStudenti.fxml"));
			Scene scene = new Scene(root,primaryStage.getHeight(),primaryStage.getWidth());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Segreteria Studenti");
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
			//Image applicationIcon = new Image(getClass().getResourceAsStream("logeo black-02.png"));
			//primaryStage.getIcons().add(new Image("logeo black-02.png"));
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
