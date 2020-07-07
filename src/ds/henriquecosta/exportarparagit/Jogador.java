package ds.henriquecosta.exportarparagit;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador {
	
	public boolean right,left;
	public int x,y;
	public int width = 40;
	public int height = 5;
	
	public Jogador(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}

	public void tick() {
		if (right) {
			x+= 2;}
		else if (left){
			x-= 2;
		}
		if (x + width > Principal.WIDTH) {
			x = Principal.WIDTH - width;
		}
		else if(x < 0) {
			x = 0;
		}
	}

	public void render(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 40, 10);
		
		
	}
}
