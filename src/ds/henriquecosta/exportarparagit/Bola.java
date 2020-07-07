package ds.henriquecosta.exportarparagit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JOptionPane;

public class Bola {
	
		public double x,y;
		public int width,height;
		
		public double dx,dy;
		public double speed = 2;
		
		public Bola(int x, int y){
			this.x = x;
			this.y = y;
			this.width = 4;
			this.height = 4;
			
			//dx = new Random().nextGaussian(); ///nextGaussian Gera um numero de 0 a mil
			int angle = new Random().nextInt(120 - 45) + 45 + 1; ///Foi colado 119 -45 para o numero aleatorio gerar entre 0 a 75, mas como ta somado com 45, fica de 45 a 119, por�m como foi somado +1 ent�o de 45 a 120
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			}
		public void tick() {
			if (x + (dx*speed) + width >= Principal.WIDTH) {
				dx *= -1;
				speed += 0.5;}
			else if(x+(dx*speed) < 0) {
				dx *= -1;
				speed += 0.5;}
			if(y >= Principal.HEIGHT) {
				JOptionPane.showMessageDialog(null,"Inimigo Venceu");
				new Principal();
				return;
			}
			else if (y < 0) {
				JOptionPane.showMessageDialog(null,"Jogador Venceu");
				new Principal();
				return;
			}
			
			Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width,height); ///Testa colis�es
			
			Rectangle boundsPlayer = new Rectangle(Principal.player.x,Principal.player.y,Principal.player.width,Principal.player.height);
			Rectangle boundsEnemy = new Rectangle((int)Principal.enemy.x,(int)Principal.enemy.y,Principal.enemy.width,Principal.enemy.height);
			
			if(bounds.intersects(boundsPlayer)) {
				int angle = new Random().nextInt(359 - 45) + 45 + 1;
				dx = Math.cos(Math.toRadians(angle));
				dy = Math.sin(Math.toRadians(angle));
				if(dy > 0) {
				dy *= -1;
				}
			}
			else if (bounds.intersects(boundsEnemy)) {
				int angle = new Random().nextInt(359 - 45) + 45 + 1;
				dx = Math.cos(Math.toRadians(angle));
				dy = Math.sin(Math.toRadians(angle));
				if(dy < 0) {
				dy *= -1;}
			}
			
		x += dx * speed;
		y += dy * speed;
		}
		
		public void render(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect((int)x,(int)y,width,height);
		}
	}
