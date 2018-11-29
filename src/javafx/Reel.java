package javafx;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class Reel {
	
	private Slot[] slots = new Slot[3];
	private VBox reel;
	
	public Reel(int[] order, int middlePosition) {
		reel = new VBox();		
		slots[0] = new Slot(order, Slot.beforeInt(middlePosition));
		slots[1] = new Slot(order, middlePosition);
		slots[2] = new Slot(order, Slot.nextInt(middlePosition));
		for (Slot s : slots) {
			reel.getChildren().add(s.getSlot());
		}
	}
	
	public void setNextPosition() {
		for (Slot s : slots) {
			s.nextSlot();
		}
	}
	
	public Node getReel() {
		return reel;
	}
	
}
