package digitalclock;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

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
		
		Timer timer = new Timer();
		timer.schedule(new TextUpdateTimer(g), 0, 1000);
	}

	class TextUpdateTimer extends TimerTask{

		private Graphics g;
		
		public TextUpdateTimer(Graphics g) {
			this.g = g;
		}
		
		@Override
		public void run() {
			LocalDateTime date = LocalDateTime.now();
			g.clearRect(0, 0, 180, 80);
			g.drawChars(date.format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString().toCharArray(), 0, 8, 20, 24);
		}
		
	}
	
}
