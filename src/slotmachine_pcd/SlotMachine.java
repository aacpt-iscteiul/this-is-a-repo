package slotmachine_pcd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SlotMachine {

	private JFrame frame;
	private JPanel panelButtons;
	private JPanel panelImages;
	private ImageIcon[] listOfImages;
	private JLabel[] labels;
	private JButton startButton;
	private JButton stopButton;
	private List<Reel> reels;
	private int contador;

	public SlotMachine() {

		listOfImages = new ImageIcon[3];
		contador = -1;

		reels = new ArrayList<Reel>();
		for (int i = 0; i < 3; i++) {
			Reel w = new Reel(this, i);
			reels.add(w);
		}

		frame = new JFrame("Juicy Slots!");
		frame.setLayout(new BorderLayout());
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		panelImages = new JPanel();
		panelButtons = new JPanel();

		labels = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			labels[i] = new JLabel(new ImageIcon("imagens/im1.jpg"));
		}

		startButton = new JButton("start");
		stopButton = new JButton("stop");

		addFrameContents();
	}

	private void addFrameContents() {
		panelImages.setSize(190, 65);
		for (JLabel lbl : labels) {
			Dimension dim = new Dimension(60, 60);
			lbl.setSize(dim);
			panelImages.add(lbl);
		}
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSpinninBaby();
			}
		});

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopSpinnin();
			}
		});

		panelButtons.add(startButton);
		panelButtons.add(stopButton);

		frame.add(panelImages, BorderLayout.CENTER);
		frame.add(panelButtons, BorderLayout.SOUTH);

	}

	private void stopSpinnin() {
		for (Reel w : reels)
			w.interrupt();
	}

	private void startSpinninBaby() {
		for (Reel w : reels)
			w.start();
	}

	public JLabel getLabel(int i) {
		return labels[i];
	}

	private void open() {
		frame.setVisible(true);
	}

	public synchronized void verificaVitoria(ImageIcon img) {
		listOfImages[++contador] = img;
		if (contador == 2) {
			if (listOfImages[0].toString().equals(listOfImages[1].toString())
					&& listOfImages[1].toString().equals(listOfImages[2].toString()))
				System.out.println("BAZINGA!");
			else
				System.out.println("no dice =(");
		}
	}

	public static void main(String[] args) {
		SlotMachine s = new SlotMachine();
		s.open();
	}

}
