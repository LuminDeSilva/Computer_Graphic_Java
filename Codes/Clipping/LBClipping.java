import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LBClipping extends JFrame implements MouseListener
{
	int Xmin=50,Ymin=50,Xmax=450,Ymax=450;
	int x1,y1,x2,y2,i;
	
	double dx,dy;
	double p[]=new double[4];
	double q[]=new double[4];
	
	double t1,t2;
	Graphics g;
	
	LBClipping()
	{
		super("Liang Barsky Line Clipping");
		setSize(600,600);
		addMouseListener(this);
		setVisible(true);
		g=getGraphics();
		
	}
	
	public void paint(Graphics g)
	{
		
		g.setColor(Color.red);
		g.drawRect(Xmin,Ymin,(Xmax-Xmin),(Ymax-Ymin));
	}
	
	
	public void mouseClicked(MouseEvent me)	{}
	
	public void mousePressed(MouseEvent me)
	{
		x1=me.getX();
		y1=me.getY();		
	}
	public void mouseReleased(MouseEvent me)
	{
		x2=me.getX();
		y2=me.getY();
		lBClipp();
		
	}
	public void lBClipp()
	{
		t1=0;t2=1;
		
		dx = x2 - x1;
		dy = y2 - y1;
		
		p[0]=-dx; p[1]=dx; p[2]=-dy; p[3]=dy;	
		
		q[0] =x1 - Xmin; q[1]=Xmax - x1; q[2]=y1 - Ymin; q[3] =Ymax - y1;
		
		for(i=0;i<4;i++)
		{
			if(p[i]==0 && q[i]<0)
			{
				System.out.println("Line is outside the boundry,it is not a clipping candidate\n");
				//System.exit(0);
			}
			else
			{
				double t = (double) q[i] / p[i];
				if (p[i] < 0)
					t1 = Math.max(t, t1);
				else 
					t2 = Math.min(t, t2);
				
			}
		}
		System.out.println("t1: " + t1 + ", t2: " + t2);
		if (t1 > t2)
		{
			System.out.println("Line is outside the boundry,it is not a clipping candidate\n");
			//System.exit(0);			
		}
		else
		{
			//System.out.println("It is clipping candidate\n");
			int nx1, ny1, nx2, ny2;
			nx1 = (int) (x1 + t1 * dx);
			ny1 = (int) (y1 + t1 * dy);
			nx2 = (int) (x1 + t2 * dx);
			ny2 = (int) (y1 + t2 * dy);			
			g.drawLine(nx1,ny1,nx2,ny2);
		}		
	}
	
	public void mouseEntered(MouseEvent me)	{}
	public void mouseExited(MouseEvent me)	{}
	public void mouseDragged(MouseEvent me)	{}
	public void mouseMoved(MouseEvent me)	{}
	public static void main(String [] args)
	{
		LBClipping a=new LBClipping();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
