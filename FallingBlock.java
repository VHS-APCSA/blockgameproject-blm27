
public class FallingBlock extends Block implements Movable {
	private int time;
	public FallingBlock(int x, int y, int width)
	{
		super(x, y, width);
		speed = 5;
		time = (int)(Math.random() * 1000) + 500;
	}
	@Override
	public void move() 
	{
		if(time > 0)
		{
			time --;
		}
		else
		{
			y += speed;
		}
	}
}
