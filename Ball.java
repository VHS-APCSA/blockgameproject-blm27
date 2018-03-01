import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Ball extends GameObject implements Movable {
	private int vx, vy;
	private Lives lives;
	public Ball(int gwidth, int gheight, Lives lives) {
		super(gwidth, gheight);
		width = 25;
		height = width;
		speed = 12;
		this.lives = lives;
		regenBall();
	}
	private Color getRandomColor() {
		switch ((int)(Math.random() * 3)) {
		case 0:
			return Color.red;
		case 1:
			return Color.yellow;
		default:
			return Color.blue;
		}
	}
	/**
	 * Creates a new ball when the old one has gone off screen.
	 */
	protected void regenBall() {
		color = getRandomColor();
		x = (gameWidth - width) / 2;
		//y = height - width - 30;
		y = gameHeight - 5 * width;
		vx = 0;
		vy = 0;
	}
	/**
	 * Checks the intersection Rectangle of the ball and the block and 
	 * determines which way to bounce off of the block. The width parameter is included
	 * to give some slop to the intersection since the speed of the ball can vary.
	 * Ball location is changed immediately after changing direction to prevent double collisions.
	 * Note that vertical collisions are prioritized over horizontal collisions.
	 * @param block The Block object that the ball has collided with.
	 * @return The Rectangle object defined by the intersection of the ball and the block.
	 */
	public Rectangle bounce(Block block) {
		Rectangle collision = getRect().intersection(block.getRect());
		//moving up
		if(vy < 0 && collision.getCenterY() > block.getY() + width)
		{
			vy = -vy;
			y += vy;
		}
		//moving down
		else if (vy > 0 && collision.getCenterY() < block.getY() + width)
		{
			vy = -vy;
			y += vy;
		}
		//moving right
		else if (vx > 0 && collision.getCenterX() < block.getX() + width)
		{
			vx = -vx;
			x += vx;
		}
		//moving left
		else if (vx < 0 && collision.getCenterX() > block.getX() + width)
		{
			vx = -vx;
			x += vx;
		}
		return collision;
	}
	//bounces the ball off of the paddle setting direction based on where it hits on the paddle.
	public void bounce(Paddle paddle)
	{
		Rectangle collision = getRect().intersection(paddle.getRect());
		//get the x coordinate of the center of the collision rectangle
		double colX = collision.getCenterX();
		double relativeXPos = colX - paddle.getX();
		double angle = 3 * Math.PI / 4 - relativeXPos / paddle.getWidth() * Math.PI / 2;
		fire(angle);
	}
	/**
	 * Gives the ball a velocity.
	 * @param angle The angle to fire the ball at, in radians.
	 */
	public void fire(double angle) {
		vx = (int)(Math.cos(angle) * speed);
		vy = -(int)(Math.sin(angle) * speed);
		//don't just let it bounce straight up and down forever
		if(vx == 0)
			vx += (int)(Math.random() * 3) - 1;
	}
	//this prevents the space bar from changing the angle of a moving ball
	public void launch(double angle)
	{
		if(vx == 0 && vy == 0)
			fire(angle);
	}
	/**
	 * Updates the position of the ball. If the ball goes off screen below the paddle it regenerates a new ball.
	 * Bounces the ball off the walls and ceiling.
	 */
	@Override
	public void move()
	{
		x += vx;
		y += vy;
		if(y > gameHeight) {
			regenBall();
			lives.die();
		}
		/*  The extra x += vx is intentional. 
		 *  If the ball is moving fast enough (vx or vy > ball diameter) then the ball will be completely off screen  when it bounces.
		 *  That line puts the ball back on screen.
		 */
		if(x < 0 || x > gameWidth - width) {
			vx = -vx;
			x += vx;
		}
		if(y <= 0)
		{
			vy = -vy;
			y += vy;
		}
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, width);
	}
}
