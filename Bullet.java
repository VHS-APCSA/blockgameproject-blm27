import java.awt.Color;
public class Bullet extends GameObject implements Movable{
	public Bullet(int gameWidth, int gameHeight, Paddle paddle)
	{
		super(gameWidth, gameHeight);
		width = 5;
		height = 20;
		speed = 5;
		color = Color.green;
		x = paddle.getX() + paddle.getWidth() /2;
		y = gameHeight - 30;
	}
	@Override
	public void move()
	{
		y -= speed;
	}
}
