public class MoveBlock extends Block implements Movable {
	private int time;
	public MoveBlock(int x, int y, int width)
	{
		super(x, y, width);
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
			y = (int)(Math.random() * 701);
			x = (int)(Math.random() * 601);
		}
	}
}
