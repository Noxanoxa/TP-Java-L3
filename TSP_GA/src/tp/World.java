package tp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JPanel;
import javax.swing.Timer;

public class World extends JPanel {

	private final AtomicInteger generation;
	static final int width = 800;
	static final int height = 600;

	protected World() {
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.BLACK);
		this.generation = new AtomicInteger(0);
		final Timer timer = new Timer(5, (ActionEvent e) -> {
			repaint();
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		final Graphics2D gr = (Graphics2D) g;
		gr.setColor(Color.CYAN);
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gr.drawString("gen : " + this.generation.incrementAndGet(), 350, 15);

	}

}
