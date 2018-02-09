import java.awt.Color;

public class Paddle extends GameObject implements Movable {
    private Dir dir;
    public Paddle(int gwidth, int gheight) {
        super(gwidth, gheight);
        //size of the paddle
        width = 80;
        height = 10;
        //initial position of the paddle
        x = (gameWidth - width) / 2;
        y = gameHeight - height - 20;
        dir = Dir.NONE;
        speed = 5;
        color = Color.orange;
    }
    @Override
    public void move()
    {
    	if(dir == Dir.LEFT)
        {
        	x -= speed;
        }
        else if(dir == Dir.RIGHT)
        {
        	x += speed;
        }
        if(x + width > gameWidth)
        {
        	x = gameWidth - width;
        	dir = Dir.NONE;
        }
        else if(x < 0)
        {
        	x = 0;
        	dir = Dir.NONE;
        }
    }
    public void setDir(Dir dir)
    {
    	this.dir = dir;
    }
}