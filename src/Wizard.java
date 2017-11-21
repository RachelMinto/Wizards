import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject {
	private boolean left = false, down = false, right = false, up = false;
	
	Handler handler;

	public Wizard(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(this.isUp()) velY = -5;
		else if (!this.isDown()) velY = 0;
		
		if(this.isDown()) velY = 5;
		else if (!this.isUp()) velY = 0;		
		
		if(this.isRight()) velX = 5;
		else if (!this.isLeft()) velX = 0;
		
		if(this.isLeft()) velX = -5;
		else if (!this.isRight()) velX = 0;			
	}

	public void renderColor(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 48);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
