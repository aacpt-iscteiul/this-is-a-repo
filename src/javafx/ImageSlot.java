package javafx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public enum ImageSlot {
	CHERRIES("Cherries.png"), //0
	CLOVER("Clover.png"),   //1
	DIAMOND("Diamond.png"),  //2
	ORANGE("Orange.png"),   //3
	LEMON("Lemon.png");    //4

	private Image imageSlot;
//	private String nameFile;
	
	private ImageSlot(String nameFile) {
//		this.nameFile = nameFile;
		try {
			imageSlot = new Image(new FileInputStream("slotmachine/"+ nameFile), 75, 75, false, false);
		} catch (FileNotFoundException e) {
			System.out.println("Erro a carregar a imagem " + nameFile);
		}
	}
	
	public Image getImage(){
		return imageSlot;
	}
	
}
