package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Controller implements Initializable {

    @FXML
    private ImageView ball;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		RotateTransition rotateTransition=new RotateTransition();
		rotateTransition.setNode(ball);
		rotateTransition.setDuration(Duration.millis(500));
		rotateTransition.setFromAngle(0);
		rotateTransition.setToAngle(360);
		rotateTransition.setAutoReverse(true);
		//rotateTransition.play();
		
		/*ScaleTransition transition=new ScaleTransition();
		transition.setNode(ball);
		transition.setDuration(Duration.millis(500));
		//transition.setFromX(0.5);
		//transition.setFromY(0.5);
		//transition.setToX(1.5);
		transition.setToY(2);
		
		transition.setAutoReverse(true);
		*/
		TranslateTransition translateTransition=new TranslateTransition();
		translateTransition.setNode(ball);
		translateTransition.setDuration(Duration.millis(200));
		translateTransition.setToY(-300);
		translateTransition.setCycleCount(2);
		translateTransition.setAutoReverse(true);
		
		

		ball.setOnMouseClicked(e->{
			
				rotateTransition.play();
			
			translateTransition.play();
		   
		
			
			
		});
		
	}

}