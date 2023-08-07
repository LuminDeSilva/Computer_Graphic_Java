import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BresenhamCircle2 extends JFrame implements MouseListener
{
	int x1,y1,x2,y2,r;
	Graphics g;
	
	BresenhamCircle2(){
		setTitle("Bresenham Circle Algorithm Implementation ");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		g=getGraphics();		
	}
	
	public void mouseClicked(MouseEvent e){
		x1=e.getX();
		y1=e.getY();
		r=30;
		drawob(x1,y1,r);
		
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}
	public void drawob(int Xc,int Yc,int r)
	{
		g.setColor(Color.blue);	
		bresenhamCircle(x1,y1,r);
		g.setColor(Color.green);	
		bresenhamCircle(x1,y1,r*2);
	}
	public void bresenhamCircle(int Xc,int Yc,int r){
		//Xc,Yc - center of circle
		//r-radius
		int x=0, y=r, d=3-2*r;
		while(x<=y){
			plotCircle(Xc,Yc,x,y);
			if(d<0)
				d=d+4*x+6;
			else{
				d=d+4*(x-y)+10;
				y--;
			}
			x++;
		}			
	}
	
	public void plotCircle(int h,int k,int x,int y){
		g.drawLine(h+x,k+y,h+x,k+y);
		g.drawLine(h+y,k+x,h+y,k+x);
		g.drawLine(h-y,k+x,h-y,k+x);
		g.drawLine(h-x,k+y,h-x,k+y);
		
		g.drawLine(h-x,k-y,h-x,k-y);
		g.drawLine(h-y,k-x,h-y,k-x);
		g.drawLine(h+y,k-x,h+y,k-x);
		g.drawLine(h+x,k-y,h+x,k-y);		
	}
	
	
	
	
	public static void main(String args[])
	{
		new BresenhamCircle2();
	}
}