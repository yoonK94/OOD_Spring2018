package hw10;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;

public class HW10Program extends Application {
	public void start(Stage stage) {
		ScoreService service = new ScoreService();
		Client c1 = new SportClient("chess", service);
		Client c2 = new SportClient("golf", service);
		Client c3 = new TeamClient("bc", service);
		//service.removeObserver(c3);
		
		stage.setScene(new Scene(service.getRoot()));
		stage.setTitle("Score Service");stage.show();
		}

	public static void main(String[] args) {
		Application.launch(args);
		}
	
}
