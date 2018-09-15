package hw10;

import java.util.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.*;



public class ScoreService {
	private List<Client> observers = new ArrayList<>();
	
	public void addObserver(Client obs){
		observers.add(obs);
	}
	
	public void removeObserver(Client obs){
		observers.remove(obs);
	}

	public Parent getRoot() {
		
		Border bAll = new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, null, null));
		Border bBottom =  new Border(new BorderStroke(null, null, null,null, null,null, BorderStrokeStyle.SOLID, null, null, null, null));
		Background backG = new Background(new BackgroundFill(Color.GRAY, null, null));
		
		
		VBox p2 = new VBox(8);
		p2.setBorder(bAll);
		p2.setId("p2");
		p2.setMinWidth(250);
		Label l2 = new Label("Home Team");
		l2.setId("label");
		this.makeLabel(l2, bBottom, backG, 250);
		
		GridPane g2 = new GridPane();
	    TextField hName = new TextField ();
		this.setGrid(g2, "Name ", hName);
	    
	    GridPane g3 = new GridPane();
	    TextField hScore = new TextField ();
	    this.setGrid(g3, "Score ", hScore);
	    p2.getChildren().addAll(l2, g2, g3);
		
		
	    VBox p3 = new VBox(8);
		p3.setBorder(bAll);
		p3.setId("p3");
		p3.setMinWidth(250);
		Label l3 = new Label("Away Team");
		l3.setId("label");
		this.makeLabel(l3, bBottom, backG, 250);
		
	    GridPane g4 = new GridPane();
		TextField aName = new TextField ();
		this.setGrid(g4, "Name ", aName);
	    
		GridPane g5 = new GridPane();
	    TextField aScore = new TextField ();
	    this.setGrid(g5, "Score ", aScore);

		p3.getChildren().addAll(l3, g4, g5);
		
		VBox p4 = new VBox(8);
		p4.setId("p4");
		p4.setAlignment(Pos.CENTER);
		
		VBox p5 = new VBox(8);
		p5.setBorder(bAll);
		p5.setMinWidth(150);
		Label l4 = new Label("Sport");
		this.makeLabel(l4, bBottom, backG, 150);
		l4.setId("label");
		
		GridPane g7 = new GridPane();
		g7.setPadding(new Insets(5));
		g7.setAlignment(Pos.BASELINE_CENTER);
		TextField sName = new TextField ();
	    sName.setMaxWidth(100);
	    g7.getChildren().add(sName);
		
	    
	    Button btn = new Button("Submit");
	    btn.setOnAction(event -> observers.forEach(obs -> 
		    obs.newScore(
		    		sName.getText(), 
		    		hName.getText(), 
		    		aName.getText(), 
		    		hScore.getText(), 
		    		aScore.getText())));
		    
		p5.getChildren().addAll(l4, g7);
		p4.getChildren().addAll(p5, btn);
		
		
		HBox p1 = new HBox(8);
		p1.setAlignment(Pos.CENTER);
		p1.setPadding(new Insets(10));
		
		p1.getChildren().addAll(p2,p3,p4);
		
		return p1;
	}
	
	private void makeLabel(Label l, Border b, Background back, int w) {
		l.setBorder(b);
		l.setMinWidth(w);
		l.setPadding(new Insets(1));
		l.setFont(Font.font("verdana", 20));
		l.setTextFill(Color.WHITE);
		l.setBackground(back);
	}
	
	private void setGrid(GridPane g, String val, TextField txt) {	
		g.setVgap(5);
	    g.setHgap(10);
	    g.setPadding(new Insets(5));
	    g.add(new Label(val), 0, 0);
	    g.add(txt, 1, 0);
	}
}