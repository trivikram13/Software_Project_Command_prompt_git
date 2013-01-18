import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

import javax.swing.*;



public class map implements MouseListener, ActionListener {
	int shiftx=0,shifty=0;
	int startx=0,starty=0,stopx=0,stopy=0;
	double zoom=1;
	JLabel lab,lab2,labelw;
	panel p;
	JFrame f;
	JTextField tf1,tf2;
	JButton zoomin,zoomout,reset,submit;


	int count=0;
	void map1()
	{
		JPanel west = new JPanel();
		labelw = new JLabel();
		labelw.addMouseListener(this);
		submit = new JButton("Submit");
		reset = new JButton("Reset");
		reset.addActionListener(this);
		submit.addActionListener(this);
		f = new JFrame("Map");
		p = new panel();
		JPanel pan = new JPanel();
		tf1 = new JTextField(18);
		tf2 = new JTextField(18);
		JPanel p12 = new JPanel();
		JPanel p13 = new JPanel();
		p12.add(tf1);
		p13.add(tf2);
		pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
		
		p.addMouseListener(this);
		lab = new JLabel("From");
		lab2 = new JLabel("To");
		f.getContentPane().add(BorderLayout.CENTER,p);
		f.getContentPane().add(BorderLayout.EAST,pan);
		f.setSize(1096,513);
		f.setVisible(true);
		zoomin = new JButton("zoomIn");
		zoomout = new JButton("zoomOut");
		zoomin.addActionListener(this);
		zoomout.addActionListener(this);
		JPanel pane = new JPanel();
		pane.add(zoomin);
		pane.add(zoomout);
		pan.setSize(200,513 );
		pan.add(lab);
		pan.add(p12);
		pan.add(lab2);
		pan.add(p13);
		JPanel part = new JPanel();
		part.add(submit);
		part.add(reset);
		pan.add(part);
		f.getContentPane().add(BorderLayout.NORTH,pane);
		
	}
	

	class panel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Image img = new ImageIcon("vin.png").getImage();
			g.drawImage(img,shiftx,shifty,(int)((896)*zoom),(int)((448)*zoom),this);
		}
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()== p)
		{
			int x = (int)((arg0.getX()-(shiftx))/zoom);
			int y = (int)((arg0.getY()-(shifty))/zoom);
			System.out.println(x+"  "+y);
			FileReader fr;
			BufferedReader br;
			try{
				
				fr = new FileReader("pts.txt");
				br = new BufferedReader(fr);
				String line = null;
				String s[];
				int count = 1;
				while((line = br.readLine())!=null)
				{
					String c[] = line.split("-");
					s = c[1].split("/");
					if(Integer.parseInt(c[0])<=x+5 && Integer.parseInt(c[0])>=x-5)
					{
						if(Integer.parseInt(s[0])<=y+5 && Integer.parseInt(s[0])>=y-5)
						{

							System.out.println(c[0]+"  "+c[1]+" "+s[0]+" "+s[1]);
							//lab.setText(s[1]+"    "+x+"  "+y  );
							if(tf1.getText().equals("")&& count==1)
							{
								tf1.setText(s[1]);
								
								count=2;
								
							}
							else if(tf2.getText().equals("") && count == 1)
							{
								tf2.setText(s[1]);
								count = 2;

								
							}
							f.repaint();
						}
					}
								
				}
				if(tf1.getText().equals("")&& (count!=2))
				{
					tf1.setText(x+" , "+y);

				
				}
				else if(tf2.getText().equals("")&&(count!=2))
				{
					tf2.setText(x+" , "+y);
					
					
				}
	
			}catch(Exception ex){}
			try{
			FileWriter fw = new FileWriter("oops.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = x+"-"+y;
			if(count==0)
			{
				count++;
				bw.append(line);
				bw.append(",");
				bw.flush();
			}
			else{
				count=0;
				bw.append(line);
				bw.newLine();
				bw.flush();
			}
			}catch(Exception ex){}
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
		startx = arg0.getX();
		starty = arg0.getY();
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		stopx = arg0.getX();
		stopy = arg0.getY();
		shiftx = shiftx+stopx-startx;
		shifty = shifty+stopy-starty;
		System.out.println(shiftx+" "+shifty);
		f.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==zoomin)
		{
			if(zoom<3.3){
				zoom  = zoom+0.3;
				f.repaint();
			}
			
		}
		if(arg0.getSource()==zoomout)
		{
			if(zoom>.6)
			{
				zoom=zoom-0.3;
				f.repaint();
			}
		}
		if(arg0.getSource()==reset)
		{
			tf1.setText("");
			tf2.setText("");
		}
		
		if(arg0.getSource()==submit)
		{
			//System.out.println("neabbaaa");
			bk.box1.setSelectedItem(tf1.getText());
			bk.box2.setSelectedItem(tf2.getText());
			f.dispose();
		}
	}
}
