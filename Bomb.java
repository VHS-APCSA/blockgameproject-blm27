import java.awt.Color;
public class Bomb extends GameObject implements Movable{
	public Bomb(int gameWidth, int gameHeight, Paddle paddle)
	{
		super(gameWidth, gameHeight);
		width = 25;
		height = width;
		speed = 10;
		color = Color.red;
		x = paddle.getX() + paddle.getWidth() /2;
		y = gameHeight - 30;
	}
	@Override
	public void move()
	{
		y -= speed;
	}
}