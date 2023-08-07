import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DDAAlgorithm extends JFrame implements MouseListener
{
	
	int x1,y1,x2,y2;
	Graphics g;
	DDAAlgorithm()
	{
		setSize(800,8000);
		setTitle("DDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		addMouseListener(this);
		g=getGraphics();
		
		
	}
	public void DDA(int x1,int y1,int x2,int y2)
	{
		int dx,dy,x,y,xinc,yinc,step;
		
		dx=x2-x1;
		dy=y2-y1;
		
		if(Math.abs(dx)>Math.abs(dy))
		{
			step=Math.abs(dx);
		}
		else
		{
			step=Math.abs(dy);
		}
		
		xinc=dx/step;
		yinc=dy/step;
		
		x=x1;
		y=y1;
		
		for(int i=0;i<=step;i++)
		{
			x=x+xinc;
			y=y+yinc;
			g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		}
	}
	public void mouseEntered(MouseEvent m){}
	public void mousePressed(MouseEvent m){
		x1=m.getX();
		y1=m.getY();
	}
	public void mouseReleased(MouseEvent m){
		x2=m.getX();
		y2=m.getY();
		
		DDA(x1,y1,x2,y2);
	}
	public void mouseClicked(MouseEvent m){}
	public void mouseExited(MouseEvent m){}
	
	public static void main(String []args)
	{
		DDAAlgorithm da =new DDAAlgorithm();
		
	}
}