import javax.swing.*;
public class Firstframe
{
	public static void main(String[] args)
	{
		JFrame frm=new JFrame();
		frm.setSize(400,300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocation(new java.awt.Point(600,300));
		frm.setTitle("My First Frame");
		
		frm.setLayout(null);
		frm.setVisible(true);
	}
}