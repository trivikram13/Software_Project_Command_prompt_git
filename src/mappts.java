import java.io.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class mappts {
	public static void main(String args[])
	{
		pts1 p = new pts1();
		p.pts();
		
	}
}
class pts1 implements MouseListener{
	JFrame f= new JFrame();
	FileWriter fw,fw1 ;
	BufferedWriter bw,bw1;
	pan2 pan;
	int count=1;
	void pts() 
	{
		
		pan = new pan2();
		f.add(pan);
		f.setSize(896,448);
		f.setVisible(true);
		pan.addMouseListener(this);
	}
	
	class pan2 extends JPanel
	{

		
		public void paintComponent(Graphics g)
		{
			try{
				//fw = new FileWriter("pts.txt",true);
				fw1 = new FileWriter("edges.txt",true);
			//	bw = new BufferedWriter(fw);
				bw1 = new BufferedWriter(fw1);
			}catch (Exception ex){System.out.println("neabbaass");}
			Image img = new ImageIcon("pic1.jpg").getImage();
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==pan)
		{

			String v = arg0.getX()+"-"+arg0.getY();
			
			System.out.println(v);
			
			
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
