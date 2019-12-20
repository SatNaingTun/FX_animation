package application;
	
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @FXML
    private ImageView ball;
    
    @FXML
    private VBox root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("Football.fxml"));
			Scene scene=new Scene(parent);
			
			
			
		
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		public static void main(String[] args) {
		launch(args);
	}
}
