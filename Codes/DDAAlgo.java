import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DDAAlgo extends JFrame implements MouseListener
{
	Graphics g;
	int x1,y1,x2,y2;
	
	DDAAlgo()
	{
		setTitle("DDA Algorithm");
		setSize(800,600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		g=getGraphics();
	}
	public void DDA(int x1,int y1,int x2,int y2)
	{
		int dx,dy;
		double steps,xinc,yinc,x,y;
		dx=x2-x1;
		dy=y2-y1;
		
		if(Math.abs(dx)>Math.abs(dy))
		{
			steps=Math.abs(dx);
		}
		else
		{
			steps=Math.abs(dy);
		}
		xinc=dx/steps;
		yinc=dy/steps;
		
		x=x1;
		y=y1;
		
		for(int i=1;i<=steps;i++)
		{
			x=x+xinc;
			y=y+yinc;
			g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		}
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e)
	{
		x1=e.getX();
		y1=e.getY();
	}
	public void mouseReleased(MouseEvent e)
	{
		x2=e.getX();
		y2=e.getY();
		
		DDA(x2,y2,x1,y1);
	}

	public static void main(String[] args)
	{
		new DDAAlgo();
	}
}