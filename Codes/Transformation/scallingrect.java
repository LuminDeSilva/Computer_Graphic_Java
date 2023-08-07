import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class scallingrect extends JFrame implements MouseListener
{
	Graphics g;
	int x1,x2,y1,y2,dx,dy,x1new,y1new,x2new,y2new;
	 
	scallingrect()
	{
		setSize(500,500);
		addMouseListener(this);	
		setVisible(true);
		g=getGraphics();
		g.setColor(Color.red);
	}
	public static void main(String a[])
	{
		scallingrect b=new scallingrect();
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void translateLine(int x1,int y1,int x2,int y2,int dx,int dy)
	{
		x1new=x1+dx;
		x2new=x2+dx;
		y1new=y1+dy;
		y2new=y2+dy;
	}
	public void mouseClicked(MouseEvent me)
	{
	}
	public void scale(int x1,int y1,int x2,int y2,int dx,int dy)
	{
		g.setColor(Color.red);
		g.drawRect(x1,y1,x2-x1,y2-y1);
		g.setColor(Color.blue);
		translateLine(x1,y1,x2,y2,-x1,-y1);
		int x11,y11,x22,y22;
		x11=x1new*dx;
		y11=y1new*dy;
		x22=x2new*dx;
		y22=y2new*dy;
		translateLine(x11,y11,x22,y22,x1,y1);
		g.drawRect(x1new,y1new,x2new-x1new,y2new-y1new);
		
	}
	public void mouseReleased(MouseEvent me)
	{
		 x2=me.getX();
		 y2=me.getY();
		 scale(x1,y1,x2,y2,2,3);

	}
	public void mousePressed(MouseEvent me)
	{
		 x1=me.getX();
		 y1=me.getY();
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

}