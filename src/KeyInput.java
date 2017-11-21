import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	Handler handler;
	Wizard wizard;
	
	public KeyInput(Wizard wizard, Handler handler) {
		this.wizard = wizard;
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); 
			
			if(tempObject.getId() == ID.Player) {
				if(key ==  KeyEvent.VK_W) wizard.setUp(true);
				if(key ==  KeyEvent.VK_A) wizard.setLeft(true);
				if(key ==  KeyEvent.VK_S) wizard.setDown(true);
				if(key ==  KeyEvent.VK_D) wizard.setRight(true);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); 
			
			if(tempObject.getId() == ID.Player) {
				if(key ==  KeyEvent.VK_W) wizard.setUp(false);
				if(key ==  KeyEvent.VK_A) wizard.setLeft(false);
				if(key ==  KeyEvent.VK_S) wizard.setDown(false);
				if(key ==  KeyEvent.VK_D) wizard.setRight(false);
			}
		}		
	}	
}
