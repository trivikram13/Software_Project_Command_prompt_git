import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.*;
import java.util.*;


public class ui {
	public static void main(String[] args)
	{
		adminUI u = new adminUI();
		u.gui();
	}
}

class adminUI implements ActionListener, ListSelectionListener
{
	JFrame frame;
	JPanel back ;
	JButton but1,but2,but3,but4;
	panzt main;
	panz backz = new panz(),vbackz= new panz();
	JPanel layout= new JPanel(),vlayout= new JPanel();
	JList list,vlist;
	JTextField 	Namef,Fromf,Tof,VTypef,HTypef,Datef,Timef,VNamef,Phonef,emailf;
	JTextField Vehiclename,Drivername,Regno,Drivph;
	ArrayList<udetails> userdet = new ArrayList<udetails>();
	ArrayList<vdetails> vehdet = new ArrayList<vdetails>();
	
	void gui()
	{
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		
		
		frame = new JFrame("adminUI");
		//frame.add(back);
		but1 = new JButton("Home");
		but2 = new JButton("User Details");
		but3 = new JButton("Driver details");
		but4 = new JButton("Map");
		JPanel left = new JPanel();
		main = new panzt();
		
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		
		Dimension dime = new Dimension(110,40);
		
		p1.add(but1);
		p2.add(but2);
		p3.add(but3);
		p4.add(but4);
		
		
		left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
		left.add(p1);
		left.add(p2);
		left.add(p3);
		left.add(p4);
		
		but1.setPreferredSize(dime);
		but2.setPreferredSize(dime);
		but3.setPreferredSize(dime);
		but4.setPreferredSize(dime);
		
		
		frame.getContentPane().add(BorderLayout.WEST,left);
		frame.getContentPane().add(BorderLayout.CENTER,main);
		frame.setVisible(true);
		frame.setSize(940,400);
	}
	
	class panz extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Image img = new ImageIcon("TaxiB.jpg").getImage();
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}

	class panzt extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Image img = new ImageIcon("vin.png").getImage();
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==but1)
		{

			main.setVisible(true);
			
		}
		
		if(arg0.getSource()==but2)
		{	

			vlayout.setVisible(false);
			vbackz.setVisible(false);
			
			layout = new JPanel();
			Font big = new Font("serif", Font.BOLD,18);
			Font medium = new Font("serif", Font.BOLD,16);
			backz = new panz();
			JPanel pan = new JPanel();
			pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT,50,0);
			JPanel Name = new JPanel(fl);
			Name.setOpaque(false);
			 Namef = new JTextField(10);
			 Namef.setOpaque(false);
			 Namef.setEditable(false);
			 Namef.setForeground(Color.RED);
			 Namef.setFont(big);
			JPanel From = new JPanel(fl);
			From.setOpaque(false);
			 Fromf = new JTextField(10);
			 Fromf.setEditable(false);
			 Fromf.setOpaque(false);
			 Fromf.setForeground(Color.RED);
			 Fromf.setFont(big);
			 JPanel To = new JPanel(fl);
			 To.setOpaque(false);
			Tof = new JTextField(10);
			Tof.setEditable(false);
			Tof.setOpaque(false);
			Tof.setForeground(Color.RED);
			Tof.setFont(big);
			JPanel VType = new JPanel(fl);
			VType.setOpaque(false);
			VTypef = new JTextField(10);
			VTypef.setEditable(false);
			VTypef.setOpaque(false);
			VTypef.setForeground(Color.RED);
			VTypef.setFont(big);
			JPanel HType = new JPanel(fl);
			HType.setOpaque(false);
			HTypef = new JTextField(10);
			HTypef.setEditable(false);
			HTypef.setOpaque(false);
			HTypef.setForeground(Color.RED);
			HTypef.setFont(big);
			JPanel Date = new JPanel(fl);
			Date.setOpaque(false);
			Datef = new JTextField(10);
			Datef.setEditable(false);
			Datef.setOpaque(false);
			Datef.setForeground(Color.RED);
			Datef.setFont(big);
			JPanel Time = new JPanel(fl);
			Time.setOpaque(false);
			Timef = new JTextField(10);
			Timef.setEditable(false);
			Timef.setOpaque(false);
			Timef.setForeground(Color.RED);
			Timef.setFont(big);
			JPanel VName = new JPanel(fl);
			VName.setOpaque(false);
			VNamef = new JTextField(10);
			VNamef.setEditable(false);
			VNamef.setOpaque(false);
			VNamef.setForeground(Color.RED);
			VNamef.setFont(big);
			JPanel Phone = new JPanel(fl);
			Phone.setOpaque(false);
			Phonef = new JTextField(10);
			Phonef.setEditable(false);
			Phonef.setOpaque(false);
			Phonef.setForeground(Color.RED);
			Phonef.setFont(big);
			JPanel email = new JPanel(fl);
			email.setOpaque(false);
			emailf = new JTextField(10);
			emailf.setEditable(false);
			emailf.setOpaque(false);
			emailf.setForeground(Color.RED);
			emailf.setFont(big);

			emailf.setHorizontalAlignment(JTextField.CENTER);
			
			JLabel lab1 = new JLabel("Name             :");
			lab1.setOpaque(false);
			JLabel lab2 = new JLabel("From              :");
			lab2.setOpaque(false);
			JLabel lab3 = new JLabel("To                  :");
			lab3.setOpaque(false);
			JLabel lab4 = new JLabel("Vehicle Type   :");
			lab4.setOpaque(false);
			JLabel lab5 = new JLabel("Hire Type       :");
			lab5.setOpaque(false);
			JLabel lab6 = new JLabel("Date               :");
			lab6.setOpaque(false);
			JLabel lab7 = new JLabel("Time               :");
			lab7.setOpaque(false);
			JLabel lab8 = new JLabel("Vehicle Name :");
			lab8.setOpaque(false);
			JLabel lab9 = new JLabel("Phone            :");
			lab9.setOpaque(false);
			JLabel lab10 = new JLabel("Email             :");
			lab10.setOpaque(false);
			lab1.setForeground(Color.RED);
			lab2.setForeground(Color.RED);
			lab3.setForeground(Color.RED);
			lab4.setForeground(Color.RED);
			lab5.setForeground(Color.RED);
			lab6.setForeground(Color.RED);
			lab7.setForeground(Color.RED);
			lab8.setForeground(Color.RED);
			lab9.setForeground(Color.RED);
			lab10.setForeground(Color.RED);
			
			
			lab1.setFont(big);
			lab2.setFont(big);
			lab3.setFont(big);
			lab4.setFont(big);
			lab5.setFont(big);
			lab6.setFont(big);
			lab7.setFont(big);
			lab8.setFont(big);
			lab9.setFont(big);
			lab10.setFont(big);
			
			Name.add(lab1);
			Name.add(Namef);
			Phone.add(lab9);
			Phone.add(Phonef);
			email.add(lab10);
			email.add(emailf);
			From.add(lab2);
			From.add(Fromf);
			To.add(lab3);
			To.add(Tof);
			VName.add(lab8);
			VName.add(VNamef);
			VType.add(lab4);
			VType.add(VTypef);
			HType.add(lab5);
			HType.add(HTypef);
			Date.add(lab6);
			Date.add(Datef);
			Time.add(lab7);
			Time.add(Timef);
			
			pan.add(Name);
			pan.add(Phone);
			pan.add(email);
			pan.add(From);
			pan.add(To);
			pan.add(VName);
			pan.add(VType);
			pan.add(HType);
			pan.add(Date);
			pan.add(Time);
			
			frame.add(backz);
			pan.setOpaque(false);
			backz.add(pan);
			//frame.add(pan);
			pan.setPreferredSize(new Dimension(600,400));
			//layout.setPreferredSize(new Dimension(150,200));
			//layout.add(lab6);
			
			
			try{
				FileReader fr = new FileReader("userD.txt");
				BufferedReader br = new BufferedReader(fr);
				String line=br.readLine();
				while(line != null){
					udetails det = new udetails();

					
					for(int i = 0; i<10;i++)
					{
						//System.out.println("neabba"+line);
						if(i==0)
						{
							det.name = line;
						}
						if(i==1)
						{
							det.Phone = line;
						}
						if(i==2)
						{
							det.Email = line;
						}
						if(i==3)
						{
							det.From = line;
						}
						if(i==4)
						{
							det.To = line;
						}
						if(i==5)
						{
							det.VType = line;
						}
						if(i==6)
						{
							det.HType = line;
						}
						if(i==7)
						{
							det.Date = line;
						}
						if(i==8)
						{
							det.Time = line;
						}
						if(i==9)
						{
							det.VName = line;
						}
						line = br.readLine();
						if(line==null)
						{
							break;
						}
					}
					userdet.add(det);
					if(line==null)
					{
						break;
					}
				}
			}catch(Exception ex){}
			
			String[] uname = new String[userdet.size()];
			
			for(int i = 0;i<userdet.size();i++)
			{
				uname[i] = userdet.get(i).name;
			}
			
			list = new JList(uname);
			list.addListSelectionListener(this); 
			layout.add(list);
			list.setBackground(Color.GRAY);
			list.setFont(medium);
			//layout.setBackground(Color.white);
			list.setPreferredSize(new  Dimension(120,400));
			
			
			
			frame.getContentPane().add(BorderLayout.EAST,layout);
			
			main.setVisible(false);
			
		}
		
		if(arg0.getSource()==but3)
		{
			layout.setVisible(false);
			backz.setVisible(false);
			vlayout = new JPanel();
			Font big = new Font("serif", Font.BOLD,18);
			Font medium = new Font("serif", Font.BOLD,16);
			vbackz = new panz();
			JPanel pan = new JPanel();
			pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT,50,0);
			JPanel Name = new JPanel(fl);
			Name.setOpaque(false);
			 Drivername = new JTextField(10);
			 Drivername.setOpaque(false);
			 Drivername.setEditable(false);
			 Drivername.setForeground(Color.RED);
			 Drivername.setFont(big);
			JPanel Vehname = new JPanel(fl);
			Vehname.setOpaque(false);
			
			 Vehiclename = new JTextField(10);
			 Vehiclename.setEditable(false);
			 Vehiclename.setOpaque(false);
			 Vehiclename.setForeground(Color.RED);
			 Vehiclename.setFont(big);
			JPanel Phone = new JPanel(fl);
			Phone.setOpaque(false);
			Drivph = new JTextField(10);
			Drivph.setEditable(false);
			Drivph.setOpaque(false);
			Drivph.setForeground(Color.RED);
			Drivph.setFont(big);
			JPanel email = new JPanel(fl);
			email.setOpaque(false);
			Regno = new JTextField(10);
			Regno.setEditable(false);
			Regno.setOpaque(false);
			Regno.setForeground(Color.RED);
			Regno.setFont(big);

		//	Regno.setHorizontalAlignment(JTextField.CENTER);
			
			JLabel lab1 = new JLabel("Name             :");
			lab1.setOpaque(false);
			JLabel lab2 = new JLabel("Vehicle name   :");
			lab2.setOpaque(false);
			JLabel lab3 = new JLabel("Driver Ph        :");
			lab3.setOpaque(false);
			JLabel lab4 = new JLabel("Vehicle RegNo.  :");
			lab4.setOpaque(false);
			lab1.setForeground(Color.RED);
			lab2.setForeground(Color.RED);
			lab3.setForeground(Color.RED);
			lab4.setForeground(Color.RED);
			
			
			lab1.setFont(big);
			lab2.setFont(big);
			lab3.setFont(big);
			lab4.setFont(big);
			
			Name.add(lab1);
			Name.add(Drivername);
			Phone.add(lab4);
			Phone.add(Drivph);
			email.add(lab3);
			email.add(Regno);
			Vehname.add(lab2);
			Vehname.add(Vehiclename);
			
			
			
			pan.add(Name);
			pan.add(Phone);
			pan.add(email);
			pan.add(Vehname);
			
			frame.add(vbackz);
			pan.setOpaque(false);
			vbackz.add(pan);
			//frame.add(pan);
			pan.setPreferredSize(new Dimension(600,400));
			//vlayout.setPreferredSize(new Dimension(150,200));
			//vlayout.add(lab6);
			
			
			try{
				FileReader fr = new FileReader("bokka.txt");
				BufferedReader br = new BufferedReader(fr);
				String line=br.readLine();
				while(line != null){
					vdetails det = new vdetails();

					
					for(int i = 0; i<6;i++)
					{
						//System.out.println("neabba"+line);
						if(i==1)
						{
							det.name = line;
						}
						if(i==0)
						{
							if(Integer.parseInt(line)==1)
							{
								det.VName = "Innova";
							}
							if(Integer.parseInt(line)==2)
							{
								det.VName = "Auto";
							}if(Integer.parseInt(line)==0)
							{
								det.VName = "Indica";
							}
						}
						if(i==2)
						{
							//det.Email = line;
						}
						if(i==3)
						{
							//det.From = line;
						}
						if(i==4)
				
						{
							det.regNo = line;
						}
						if(i==5)
						{
							det.ph = line;
						}
						if(i==6)
						{
							//det.HType = line;
						}
					
						line = br.readLine();
						if(line==null)
						{
							break;
						}
					}
					vehdet.add(det);
					if(line==null)
					{
						break;
					}
				}
			}catch(Exception ex){ex.printStackTrace();}
			
			String[] uname = new String[vehdet.size()];
			

			System.out.println(vehdet.size()+"asdasd");
			for(int i = 0;i<vehdet.size();i++)
			{
				uname[i] = vehdet.get(i).name;
			}
			
			vlist = new JList(uname);
			vlist.addListSelectionListener(this); 
			vlayout.add(vlist);
			vlist.setBackground(Color.GRAY);
			vlist.setFont(medium);
			//vlayout.setBackground(Color.white);
			vlist.setPreferredSize(new  Dimension(120,400));
			
			
			
			frame.getContentPane().add(BorderLayout.EAST,vlayout);
			
			main.setVisible(false);
			
		}
		
		if(arg0.getSource()==but4)
		{
			adminmap p = new adminmap();
			p.go();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// 
		if(arg0.getSource()==list)
		{
			int x = list.getSelectedIndex();
			System.out.println(x);

			Namef.setText(userdet.get(x).name);
			Fromf.setText(userdet.get(x).From);
			Tof.setText(userdet.get(x).To);
			VTypef.setText(userdet.get(x).VType);
			HTypef.setText(userdet.get(x).HType);
			Datef.setText(userdet.get(x).Date);
			Timef.setText(userdet.get(x).Time);
			VNamef.setText(userdet.get(x).VName);
			Phonef.setText(userdet.get(x).Phone);
			emailf.setText(userdet.get(x).Email);
			
		}
		
		if(arg0.getSource()==vlist)
		{
			int x = vlist.getSelectedIndex();

			//JTextField Vehiclename,Drivername,Regno,Drivph;
			
			Vehiclename.setText(vehdet.get(x).VName);
			Drivername.setText(vehdet.get(x).name);
			Regno.setText(vehdet.get(x).regNo);
			Drivph.setText(vehdet.get(x).ph);
			
		}
	}
}
