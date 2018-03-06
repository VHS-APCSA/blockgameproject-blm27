public class MoveWhenHitBlock extends MoveBlock {
	private boolean hasHit;
	public MoveWhenHitBlock(int x, int y, int width)
	{
		super(x, y, width);
		hasHit = false;
	}
	@Override
	public boolean destroyedBy(Ball ball)
	{
		if(!hasHit)
		{
			y = (int)(Math.random() * 481) + 200;
			x = (int)(Math.random() * 581);
			hasHit = true;
			return false;
		}
		return true;
	}
}
