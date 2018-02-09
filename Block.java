import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Block extends GameObject {
	public final static int HEIGHT = 30;
	/**
	 * @param x The x-coordinate of the upper left corner of the block.
	 * @param y The y-coordinate of the upper right corner of the block.
	 * @param width The width of the block, in pixels.
	 */
	public Block(int x, int y, int width) {
		super(0, 0);
		this.x = x;
		this.y = y;
		this.width = width;
		height = HEIGHT;
		this.color = getRandomColor();
	}
	protected Color getRandomColor() {
		return new Color((int)(Math.random() * 2 + 2) * 255 / 4, (int)(Math.random() * 2 + 2) * 255 / 4, (int)(Math.random() * 2 + 2) * 255 / 4);
	}
	/**
	 * @return A dark color of the same hue as the current color.
	 */
	private Color getDarkColor() {
		int red = color.getRed() * 4 / 255;
		int blue = color.getBlue() * 4 / 255;
		int green = color.getGreen() * 4 / 255;
		return new Color(red / 2 * 255, green / 2 * 255, blue / 2 * 255);
	}
	 /**
	 * @return True
	 */
	public boolean destroyedBy(Ball ball) {
		return true;
	}
	/**
	 * Draws the block.
	 * @param g A Graphics object from the paintComponent method in GamePanel.
	 */
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		//cast the Graphics object to a 2D graphics object so we can change the line width
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getDarkColor());
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(x, y, width, height);
	}
}