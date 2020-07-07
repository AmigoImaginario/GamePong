package ds.henriquecosta.exportarparagit;

import java.awt.Color;
import java.awt.Graphics;

public class Inimigo {

	public double x,y;
	public int width,height;
	
	
	
	public Inimigo(int x, int y){
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
		}
	public void tick() {
	x += (Principal.ball.x - x - 6) * 0.2;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)x,(int)y,width,height);
	}
}
