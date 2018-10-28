package slotmachine_pcd;

import javax.swing.ImageIcon;

public class Reel extends Thread {

	private SlotMachine slot;
	private int id;
	private ImageIcon currentImage;

	public Reel(SlotMachine slot, int id) {
		this.slot = slot;
		this.id = id;
	}

	private void displayImage() {
		int n = (int) (1 + Math.random() * 3);
		currentImage = new ImageIcon("imagens/im" + n + ".jpg");
		slot.getLabel(id).setIcon(currentImage);
	}

	public void run() {
		try {
			while (!isInterrupted()) {
				displayImage();
				sleep((long) (100 + Math.random() * 200));
			}
		} catch (InterruptedException e) {
			slot.verificaVitoria(currentImage);
		}

	}

}
