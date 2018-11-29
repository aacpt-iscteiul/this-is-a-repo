package javafx;
import com.sun.glass.ui.InvokeLaterDispatcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SlotMachine extends Application {

	private int[] order0 = { 0, 1, 2, 3, 4 }, order1 = { 3, 0, 2, 4, 1 }, order2 = { 4, 3, 2, 1, 0 };
	private Scene scene;
	private Reel[] reels = new Reel[3];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		reels[0] = new Reel(order0, 2); // always starts on diamond
		reels[1] = new Reel(order1, 2);
		reels[2] = new Reel(order2, 2);

		HBox grid = new HBox();
		for (Reel r : reels) {
			grid.getChildren().add(r.getReel());
		}

		Button spin = new Button("Spin!");
		spin.setOnAction(e -> spin());

		BorderPane root = new BorderPane();
		root.setCenter(grid);
		root.setBottom(spin);
		
		scene = new Scene(root);
		primaryStage.setTitle("Slotmachine 9000R");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void spin() {
		for (int i = 0; i < 1; i++) {
			for (Reel r : reels) {
				if (Math.random() < 0.8)
					r.setNextPosition();
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
