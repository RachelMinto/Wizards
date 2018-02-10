import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject {
	
	Handler handler;
	Game game;

	public Wizard(int x, int y, ID id, Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		if(handler.isUp()) velY = -5;
		else if (!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if (!handler.isUp()) velY = 0;		
		
		if(handler.isRight()) velX = 5;
		else if (!handler.isLeft()) velX = 0;
		
		if(handler.isLeft()) velX = -5;
		else if (!handler.isRight()) velX = 0;			
	}

	public void renderColor(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 48);
		
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds()) ) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			if (tempObject.getId() == ID.Crate) {
				if(getBounds().intersects(tempObject.getBounds()) ) {
					game.ammo += 10;
					handler.removeObject(tempObject);
				}
			}			
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
