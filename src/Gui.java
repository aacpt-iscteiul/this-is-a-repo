import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
	
	private static List<Image> images;
	private static List<Integer> wheel0, wheel1, wheel2;
	private ImageView imageViewSlot00, imageViewSlot01, imageViewSlot02, 
	imageViewSlot10, imageViewSlot11, imageViewSlot12, imageViewSlot20, imageViewSlot21, imageViewSlot22;
	private Image imageDiamond, imageClover, imageCherries, imageLemon, imageOrange;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane frame = new GridPane();
		
		imageDiamond = new Image(new FileInputStream("slotmachine/Diamond.png"));  // 0
		imageClover = new Image(new FileInputStream("slotmachine/Clover.png"));    // 1
		imageCherries = new Image(new FileInputStream("slotmachine/Cherries.png"));// 2
		imageLemon = new Image(new FileInputStream("slotmachine/Lemon.png"));      // 3
		imageOrange = new Image(new FileInputStream("slotmachine/Orange.png"));    // 4
		
//		images.add(imageDiamond);
//		images.add(imageClover);
//		images.add(imageCherries);
//		images.add(imageLemon);
//		images.add(imageOrange);
		
		getWheels();

		imageViewSlot00 = new ImageView();
		GridPane.setConstraints(imageViewSlot00, 0, 0);
		frame.getChildren().add(imageViewSlot00);
		imageViewSlot01= new ImageView();
		GridPane.setConstraints(imageViewSlot01, 0, 1);
		frame.getChildren().add(imageViewSlot01);
		imageViewSlot02 = new ImageView();
		GridPane.setConstraints(imageViewSlot02, 0, 2);
		frame.getChildren().add(imageViewSlot02);
		imageViewSlot10= new ImageView();
		GridPane.setConstraints(imageViewSlot10, 1, 0);
		frame.getChildren().add(imageViewSlot10);
		imageViewSlot11 = new ImageView();
		GridPane.setConstraints(imageViewSlot11, 1, 1);
		frame.getChildren().add(imageViewSlot11);
		imageViewSlot12 = new ImageView();		
		GridPane.setConstraints(imageViewSlot12, 1, 2);
		frame.getChildren().add(imageViewSlot12);
		imageViewSlot20= new ImageView();
		GridPane.setConstraints(imageViewSlot20, 2, 0);
		frame.getChildren().add(imageViewSlot20);
		imageViewSlot21 = new ImageView();
		GridPane.setConstraints(imageViewSlot21, 2, 1);
		frame.getChildren().add(imageViewSlot21);
		imageViewSlot22 = new ImageView();
		GridPane.setConstraints(imageViewSlot22, 2, 2);
		frame.getChildren().add(imageViewSlot22);
		
//		setWheels(0, 0, 0);
		
		
		
//		Button buttonSpin = new Button("Spin!");
//		buttonSpin.getOnAction(e -> );
		
		
		primaryStage.setScene(new Scene(frame, 600, 400));
		primaryStage.show();
	}

	private void setWheels(int i, int j, int k) {
		int a1 = wheel0.indexOf(i), b1 = wheel0.indexOf(j), c1 = wheel0.indexOf(k),
				a2 = (a1+1==4)?0:(a1+1), b2 = (b1+1==4)?0:(b1+1), c2 = (c1+1==4)?0:(c1+1),
				a0 = (a1==0)?4:(a1-1), b0 = (b1==0)?4:(b1-1), c0 = (c1==0)?4:(c1-1);

		imageViewSlot00.setImage(images.get(wheel0.indexOf(a0)));
		imageViewSlot10.setImage(images.get(wheel1.indexOf(b0)));
		imageViewSlot20.setImage(images.get(wheel2.indexOf(c0)));
		imageViewSlot01.setImage(images.get(wheel0.indexOf(a1)));
		imageViewSlot11.setImage(images.get(wheel1.indexOf(b1)));
		imageViewSlot21.setImage(images.get(wheel2.indexOf(c1)));
		imageViewSlot02.setImage(images.get(wheel0.indexOf(a2)));
		imageViewSlot12.setImage(images.get(wheel1.indexOf(b2)));
		imageViewSlot22.setImage(images.get(wheel2.indexOf(c2)));		
	}

	private void getWheels() {
		wheel0 = new ArrayList<>();
		wheel1 = new ArrayList<>();
		wheel2 = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			wheel0.add(i);	
			wheel2.add(4 - i);
		}
		wheel1.add(3);	
		wheel1.add(4);	
		wheel1.add(1);	
		wheel1.add(2);	
		wheel1.add(0);	

	}
	
}
