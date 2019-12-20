package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller implements Initializable{

	 @FXML
	    private Rectangle rect;

	    @FXML
	    private Canvas canvas;

	    @FXML
	    private ImageView ball;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 GraphicsContext gc = canvas.getGraphicsContext2D();
         //drawTestShapes(gc);
		
		/* canvas.setOnMouseDragged((event) -> {
	            gc.setFill(Color.BLACK);
	            gc.fillRect(event.getX(), event.getY(), 1, 1);
	        });
		
		 canvas.setOnMouseMoved((event)->{
			 gc.setFill(Color.LIGHTGRAY);
		        gc.setStroke(Color.BLACK);
		        gc.setLineWidth(5);

		        gc.fill();
		        gc.strokeRect(event.getX(), event.getY(), 1, 1);

		        gc.setFill(Color.RED);
		        gc.setStroke(Color.BLUE);
		        gc.setLineWidth(1);
			 
		 });
	
		 */
		 canvas.setOnMouseMoved((event)->{
		   
			/*gc.beginPath();
			gc.setLineWidth(3.5);
			 gc.lineTo(event.getX(), event.getX());
			 gc.stroke();
			 gc.closePath();
			 */
			 
			 gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			 gc.setStroke(Color.BLUE);
			 gc.setLineWidth(5);
			 gc.strokeLine(canvas.getWidth()/2,  canvas.getHeight(), event.getX(), event.getY());
			 gc.closePath();
			
			 
			// drawLine(gc, 180, 400, event.getX(), event.getX());
			 
		 });
		 
		 canvas.setOnMouseClicked((event)->{
			 ScaleTransition scaleTransition=new ScaleTransition();
			 scaleTransition.setNode(ball);
			 scaleTransition.setDuration(Duration.millis(200));
			 scaleTransition.setToX(0.5f);
			 scaleTransition.setToY(0.5f);
			 //scaleTransition.setCycleCount(2);
			 scaleTransition.setAutoReverse(true);
			 scaleTransition.play();
			 
			 TranslateTransition translateTransition=new TranslateTransition();
				translateTransition.setNode(ball);
				translateTransition.setDuration(Duration.millis(200));
				translateTransition.setToX(event.getX()-canvas.getWidth()/2);
				translateTransition.setToY(event.getY()-630);
				//MessageBox.show(event.getY());
				//translateTransition.setCycleCount(2);
				translateTransition.setAutoReverse(true);
				
				translateTransition.play();
			 
		 });
		 
		 
		/* canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, 
			        new EventHandler<MouseEvent>(){
			    @Override
			    public void handle(MouseEvent event) {
			        gc.beginPath();
			        gc.moveTo(event.getX(), event.getY());
			        gc.stroke();

			    }
			});

			canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
			        new EventHandler<MouseEvent>(){
			    @Override
			    public void handle(MouseEvent event) {
			        gc.lineTo(event.getX(), event.getY());
			        gc.stroke();
			        gc.closePath();
			        gc.beginPath();
			        gc.moveTo(event.getX(), event.getY());
			    }
			});

			canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, 
			        new EventHandler<MouseEvent>(){
			    @Override
			    public void handle(MouseEvent event) {
			        gc.lineTo(event.getX(), event.getY());
			        gc.stroke();
			        gc.closePath();
			    }
			});
			*/
	}
	
	private void drawTestShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
	
	
	 private void initDrawRect(GraphicsContext gc){
	        double canvasWidth = gc.getCanvas().getWidth();
	        double canvasHeight = gc.getCanvas().getHeight();

	        gc.setFill(Color.LIGHTGRAY);
	        gc.setStroke(Color.BLACK);
	        gc.setLineWidth(5);

	        gc.fill();
	        gc.strokeRect(
	                0,              //x of the upper left corner
	                0,              //y of the upper left corner
	                canvasWidth,    //width of the rectangle
	                canvasHeight);  //height of the rectangle

	        gc.setFill(Color.RED);
	        gc.setStroke(Color.BLUE);
	        gc.setLineWidth(1);

	    }
	 private void drawLine(GraphicsContext gc, double x1, double y1, double x2, double y2) {
	        double lineWidth = gc.getLineWidth();
	        Color color = (Color) gc.getStroke();
	        PixelWriter pw = gc.getPixelWriter();

	        double k = (y2 - y1) / (x2 - x1);
	        double b = (x1 * y2 - x2 * y1) / (x1 - x2);

	        int val;
	        for (int x = (int) x1; x <= (int) x2; x++) {
	            val = (int) (k * x + b);
	            for (int y = (int) (val - (lineWidth-1) / 2); y < val + lineWidth / 2; y++) {
	                pw.setColor(x, y, color);
	            }
	        }

	    }



}
