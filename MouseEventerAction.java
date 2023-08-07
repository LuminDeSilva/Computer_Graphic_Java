import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventerAction extends JFrame implements MouseListener
{
	MouseEventerAction()
	{
		setTitle("Mouse Events");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		Graphics g=getGraphics();
		g.setColor(Color.blue);
		g.fillOval(e.getX(),e.getY(),20,20);
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}

	public static void main(String[] args)
	{
		new MouseEventerAction();
	}
	
}