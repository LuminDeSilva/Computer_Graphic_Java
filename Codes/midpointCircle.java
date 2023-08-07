//midpoint
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class midpointCircle extends JFrame implements MouseListener
{ 
	  int x1,y1,x2,y2,r,x,y,xend,d;
	
	Graphics g;
	midpointCircle()
	{
		super("midpointCircle");
		setSize(500,500);
		addMouseListener(this);	

	}

	public static void main(String args[])
	{
		midpointCircle b=new midpointCircle();
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.setVisible(true);
	}
	public void mouseClicked(MouseEvent me)
	{
		 
	}
	public void mousePressed(MouseEvent me)
	{
		 x1=me.getX();
		 y1=me.getY();
		
	}
	public void mouseReleased(MouseEvent me)
	{
		 x2=me.getX();
		 y2=me.getY();
		
			r=(int)Math.sqrt((x1-x2)*(x1-x2)+(y2-y1)*(y2-y1));
			procedure(x1,y1,r);	
	}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{
	}	
	public void mouseDragged(MouseEvent me)
	{
		
	}
	public void mouseMove(MouseEvent me)
	{
	}
	public void procedure(int h,int k,int r)
	{
		x=0;
		y=r;
		d=1-r;
		plotcircle(h,k,x,y);
		double s2=Math.sqrt(2);
		xend=(int)Math.round((r/s2)+.5);
		for(x1=x;x1<=xend;x1++)
		{
			if(d<0)
				d+=(2*x1+1);
			else
				{
					y--;
					d+=(2*(x1-y)+1);
				}
			plotcircle(h,k,x1,y);
		}
	}
	public void plotcircle(int h,int k,int x,int y)
	{
		g=getGraphics();
		g.setColor(Color.red);
		g.drawLine((x+h),(y+k),(x+h),(y+k));
		g.drawLine((y+h),(x+k),(y+h),(x+k));
		g.drawLine((-y+h),(x+k),(-y+h),(x+k));
		g.drawLine((-x+h),(y+k),(-x+h),(y+k));
		g.drawLine((-x+h),(-y+k),(-x+h),(-y+k));
		g.drawLine((-y+h),(-x+k),(-y+h),(-x+k));
		g.drawLine((y+h),(-x+k),(y+h),(-x+k));
		g.drawLine((x+h),(-y+k),(x+h),(-y+k));
	}
}