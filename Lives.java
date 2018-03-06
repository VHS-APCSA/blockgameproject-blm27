import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Lives extends GameObject {
	private int lives;
	public Lives(int gameWidth, int gameHeight) {
		super(gameWidth, gameHeight);
		lives = 5;
		x = gameWidth - 50;
		y = 50;
		color = Color.yellow;
	}
	public void die()
	{
		lives--;
	}
	public int getLives()
	{
		return lives;
	}
	@Override
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 24));
		g.drawString(lives + "", x, y);
	}
}
