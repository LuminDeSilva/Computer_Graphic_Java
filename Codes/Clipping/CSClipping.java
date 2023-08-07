import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CSClipping extends JFrame implements MouseListener
{
	int Xmin=100,Ymin=100,Xmax=400,Ymax=400;
	int x1,y1,x2,y2;
	
	boolean oc1[]=new boolean[4];
	boolean oc2[]=new boolean[4];
	
	Graphics g;
	
	CSClipping()
	{
		super("Cohen Sutherland Clipping");
		setSize(500,500);
		addMouseListener(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void paint(Graphics g)
	{
		g=getGraphics();
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
		Clip();
	}
	
	public void mouseEntered(MouseEvent me)	{}
	public void mouseExited(MouseEvent me)	{}
	public void mouseDragged(MouseEvent me)	{}
	public void mouseMoved(MouseEvent me)	{}


	public void Clip()
	{
		g=getGraphics();
		boolean accept,reject,done;
		accept=false;
		reject=false;
		done=false;
		
		while(!done)
		{
			oc1=getoutcode(x1,y1);
			oc2=getoutcode(x2,y2);
			reject=rejectCheck(oc1,oc2);
			accept=acceptCheck(oc1,oc2);
			if(reject)
				done=true;
			else if(accept)
			{
				done=true;
				g.drawLine(x1,y1,x2,y2);
			}
			else 
			{
				if(!(oc1[0]||oc1[1]||oc1[2]||oc1[3]))
				swap();
				if(oc1[0])
				{
					x1+=(x2-x1)*(Ymax-y1)/(y2-y1);
					y1=Ymax;
				}
				else if(oc1[1])
				{
					y1+=(y2-y1)*(Xmin-x1)/(x2-x1);
					x1=Xmin;
				}
				else if(oc1[2])
				{
					x1+=(x2-x1)*(Ymin-y1)/(y2-y1);
					y1=Ymin;
				}
				else if(oc1[3])
				{
					y1+=(y2-y1)*(Xmax-x1)/(x2-x1);
					x1=Xmax;
				}
			}
		}
	}
	
	public boolean[] getoutcode(int x,int y)
	{
		boolean oc[]=new boolean[4];
		if(y>Ymax) oc[0]=true;
		if(x<Xmin) oc[1]=true;
		if(y<Ymin) oc[2]=true;
		if(x>Xmax) oc[3]=true;
		return oc;
	}
	
	public boolean rejectCheck(boolean[] oc1,boolean[] oc2)
	{
		boolean rej=false;
		for(int i=0;i<4;i++)
		{
			if(oc1[i] && oc2[i]) {
				rej=true;
			System.out.println(rej);	
			}
		}
		return rej;
	}
	
	public boolean acceptCheck(boolean[] oc1,boolean[] oc2)
	{
		boolean acc=true;
		for(int i=0;i<4;i++)
		{
			if(oc1[i]||oc2[i]) {
				acc=false;
			//System.out.println(acc);	
			}
		}
		return acc;
	}
	
	public void swap()
	{
		int temp;
		temp=x1;x1=x2;x2=temp;
		temp=y1;y1=y2;y2=temp;
		boolean[] tempoc=new boolean[4];
		for(int i=0;i<4;i++)
		{
			tempoc[i]=oc1[i];
			oc1[i]=oc2[i];
			oc2[i]=tempoc[i];
		}
	}
	
	public static void main(String [] args)
	{
		CSClipping a=new CSClipping();	
	}
	
}
