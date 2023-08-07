import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class rotation extends JFrame implements MouseListener{
	Graphics g;
	int x1,x2,y1,y2;
	
	rotation(){
		setSize(800,800);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		g=getGraphics();
	}
	public void drawaxis(){
		g.drawLine(0,400,800,400);
		g.drawLine(400,0,400,800);
		
	}
	public void mouseClicked(MouseEvent e){
		x1=e.getX();
		y1=e.getY();
		g.setColor(Color.red);
		g.drawLine(0,0,x1,y1);
		
		rotate(30.0);
		g.setColor(Color.black);
		g.drawLine(0,0,x1,y1);  
		
	}
	
	public void rotate(double a){
		double teta=Math.toRadians(a);
		int x=x1,y=y1;
		x1=(int)(x*Math.cos(teta)-y*Math.sin(teta));
		y1=(int)(x*Math.sin(teta)+y*Math.cos(teta));
	}
	
	public void mouseEntered(MouseEvent e){
		drawaxis();
	}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	public static void main(String []arg){
		new rotation();
	}
}