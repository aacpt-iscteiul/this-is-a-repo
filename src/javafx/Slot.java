package javafx;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Slot {
	
	private ImageView slot;
	private int[] order;
	private int arrayPosition;
	

	public Slot(int[] order, int arrayPosition) {
		this.order = order;
		this.arrayPosition = arrayPosition;
		slot = new ImageView();
		setSlot(ImageSlot.values()[order[arrayPosition]]);
	}
	
	public void nextSlot() {
		arrayPosition = nextInt(arrayPosition);
		setSlot(ImageSlot.values()[order[arrayPosition]]);		
	}

	private void setSlot(ImageSlot imageSlot) {
		slot.setImage(imageSlot.getImage());
	}
	
	public Node getSlot() {
		return slot;
	}
	
	//aux functions
	public static int nextInt(int input) {
		return input + 1 > 4 ? 0 : input + 1;
	}
	
	public static int beforeInt(int input) {
		return input - 1 < 0 ? 4 : input - 1;		
	}
}
