import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score extends GameObject {
	private int score;
	public Score(int gameWidth, int gameHeight) {
		super(gameWidth, gameHeight);
		score = 0;
		x = gameWidth - gameWidth;
		y = 50;
		color = Color.red;
	}
	public void increaseScore()
	{
		score++;
	}
	public int getScore()
	{
		return score;
	}
	@Override
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 24));
		g.drawString(score + "", x, y);
	}
}