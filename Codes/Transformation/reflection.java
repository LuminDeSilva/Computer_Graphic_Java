//draw a square by using press and release and reflect
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class reflection extends JFrame implements MouseListener
{
	Graphics g;
	double [][] coordinates;
	int x1,x2,y1,y2;
	
	reflection(){
		super("reflection");
		setSize(700,700);
		addMouseListener(this);
		setVisible(true);
		g=getGraphics();
		g.setColor(Color.red);
		coordinates=new double[3][4];
	}
	
	public double[][] translateMatrix(double dx,double dy)
	{	
		double array[][]={{1,0,dx},{0,1,dy},{0,0,1}};
		return array;						
	}
	public double[][] relectionYMatrix()
	{
		double r[][]={{-1,0,0},{0,1,0},{0,0,1}};	
		return r;
	}
	public double[][] relectionXMatrix()
	{
		double r[][]={{1,0,0},{0,-1,0},{0,0,1}};	
		return r;
	}
	public void mouseClicked(MouseEvent me)	{}
	
	public void mousePressed(MouseEvent me){
		 x1=me.getX();
		 y1=me.getY();		
	}
	
	public void mouseReleased(MouseEvent me){
		x2=me.getX();
		y2=me.getY();
		coordinates[0][0]=x1;
		coordinates[1][0]=y1;
		coordinates[2][0]=1;
		
		coordinates[0][1]=x2;
		coordinates[1][1]=y1;
		coordinates[2][1]=1;
		
		coordinates[0][2]=x2;
		coordinates[1][2]=y2;
		coordinates[2][2]=1;
		
		coordinates[0][3]=x1;
		coordinates[1][3]=y2;
		coordinates[2][3]=1;	
		
		g.setColor(Color.red);
		drawObject(coordinates);
		reflect();			
	}
	public void mouseEntered(MouseEvent me)	{}
	public void mouseExited(MouseEvent me)	{}	
	
	
	public void drawObject(double [][]points)
	{
		for(int i=1;i<points[0].length;i++)
		{		
			g.drawLine((int)points[0][i-1],(int)points[1][i-1],(int)points[0][i],(int)points[1][i]);
		}
		g.drawLine((int)points[0][0],(int)points[1][0],(int)points[0][points[0].length-1],(int)points[1][points[0].length-1]);
		//System.out.println("plen "+points[0].length);
	}
	
	public void reflect(){
		
		g.setColor(Color.blue);
	
		double [][] tmatrix=new double[3][3];
		double [][] rmatrix=new double[3][3];
		double [][] tmatrix2=new double[3][3];
		double [][] tfinal=new double[3][3];
		
		/*----------------Reflect Y-axis-------------------------------*/
		
		tmatrix=translateMatrix(-350,0);		
		rmatrix=relectionYMatrix();
		tmatrix2=translateMatrix(350,0);

		tfinal=multipleMetrix(rmatrix,tmatrix);
		tfinal=multipleMetrix(tmatrix2,tfinal);		
		
		coordinates=multipleMetrix(tfinal,coordinates);	
		
		g.drawLine(350,0,350,700);
		g.drawLine(0,350,700,350);
		drawObject(coordinates);
		
		/*----------------Reflect X-axis-------------------------------
		
		tmatrix=translateMatrix(0,-350);		
		rmatrix=relectionXMatrix();
		tmatrix2=translateMatrix(0,350);

		tfinal=multipleMetrix(rmatrix,tmatrix);
		tfinal=multipleMetrix(tmatrix2,tfinal);		
		
		coordinates=multipleMetrix(tfinal,coordinates);	
		
		g.drawLine(350,0,350,700);
		g.drawLine(0,350,700,350);
		drawObject(coordinates);
		
		*/
		
	}
	
	
	public double[][] multipleMetrix(double [][]x,double [][]y){
		double ans[][]=new double[x.length][y[0].length];
		for (int i=0;i<x.length;i++)
			for (int k=0;k<y[0].length;k++){
				ans[i][k]=0;
				for (int j=0;j<x[0].length;j++)
					ans[i][k]+=x[i][j]*y[j][k];
			}
			return ans;
	}
	public static void main(String [] args){
		reflection a=new reflection();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
}
