public class MoveBlock extends Block implements Movable {
	private int time;
	private boolean flag;
	public MoveBlock(int x, int y, int width)
	{
		super(x, y, width);
		time = (int)(Math.random() * 2500) + 500;
		flag = false;
	}
	@Override
	public void move() 
	{
		
		if(time > 0)
		{
			time --;
		}
		else if(!flag)
		{
			flag = true;
			y = (int)(Math.random() * 481) + 200;
			x = (int)(Math.random() * 581);
		}
	}
}
