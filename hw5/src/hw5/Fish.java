package hw5;

import javafx.scene.image.*;

public class Fish {
	private ImageView view = new ImageView(); // holds the image and current position
	private FishType ft;
	private FishBehavior fb;
	
	public Fish(FishType ft, FishBehavior fb) {
	   this.ft = ft;
	   this.fb = fb;
	   view.setX((Aquarium.INIT_TANK_WD - ft.rightImage().getWidth()) * fb.getXInitialPos());  // the initial fish location
	   view.setY((Aquarium.INIT_TANK_HT - ft.rightImage().getHeight()) * fb.getYInitialPos());
	}
	
	public void move(double tankheight, double tankwidth) {
      Image image = getImage();
	   view.setImage(image);
		double x = moveXY(view.getX(), fb.getXSpeed(), fb.getXChangePCT());
		double y = moveXY(view.getY(), fb.getYSpeed(), fb.getYChangePCT());
		if (legalMove(x, image.getWidth(), tankwidth))
		   view.setX(x);
		else
		   fb.changeXdirection();
      if (legalMove(y, image.getHeight(), tankheight))
         view.setY(y);
      else
         fb.changeYdirection();
	}
	
	public ImageView getView() {
	   return view;
	}
	
	private Image getImage() {
		return fb.movesRight() ? ft.rightImage() : ft.leftImage();
	}

	private double moveXY(double pos, double speed, double pct) {
	   if (changesDirection(pct) ) 
			return -1;
		else
			return pos + speed;
	}
	 
   private boolean legalMove(double pos, double size, double limit) {
      return (pos >=0) && (pos + size <= limit);
   }
   
   
   private boolean changesDirection(double frequency) {
		return Math.random() * 100 < frequency;
   }
}
