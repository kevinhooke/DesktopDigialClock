package digitalclock;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DigitalClockApp extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		DigitalClockApp app = new DigitalClockApp();
		app.createFrame();
	}

	private void createFrame() {
		Canvas canvas = new Canvas();
		
		this.setBounds(new Rectangle(180, 80));
		this.add(canvas);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		Graphics g = canvas.getGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 28));
		g.drawChars("09:00:00".toCharArray(), 0, 8, 20, 24);
	}

}
