import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class book {
	public static void main(String args[]) throws IOException
	{
		bk t = new bk();
		t.gui();
	}
}

class bk implements ActionListener
{
	static String Namef,Fromf,Tof,Datef,Timef,VNamef,Phonef,emailf;
	static boolean VTypef,HTypef;
	String fr12,to12;
	JLabel label = new JLabel();
	JButton submit,map,butz;
	JComboBox day,month,year,hours,minutes;
	JTextField firstname,lastname,phoneNo,emailID;
	static JComboBox box1,box2,box3;
	JFrame f;
	Font big,medium;
	int field = 0;
	JRadioButton thWheel;
	JRadioButton foWheel; 
	JComboBox vehicle;
	ButtonGroup bg1,bg3;
	cabs recv;
	
	JRadioButton ac,nonAc,shared,unShared;
	void gui() throws IOException
	{
		VNamef = "";
		label.setForeground(Color.YELLOW);
		JLabel Date = new JLabel("Date");
		Date.setForeground(Color.YELLOW);
		
		JLabel Time = new JLabel("Time");
		Time.setForeground(Color.YELLOW);
		
		
		pan2 banner = new pan2();
		
		Object[] days = {"01","02","03","04","05","06","07","08","09",10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		day = new JComboBox(days);
		
		Object[] months = {"01","02","03","04","05","06","07","08","09",10,11,12};
		month = new JComboBox(months);
		
		Object[] years ={2013,2014,2015,2016,2017,2017,2018,2019,2020};
		year = new JComboBox(years);
		
		Object hour[]={"hours",0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
		hours = new JComboBox(hour);
		
		Object[] minute=new Object[61];
		minute[0] = "minutes";
		for(int i=1;i<61;i++)
		{
			minute[i]=i;
		}
		minutes = new JComboBox(minute);
		
		JPanel time = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		
		time.add(Time);
		time.add(hours);
		time.add(minutes);
		time.setOpaque(false);
		
		JPanel date = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		
		date.add(Date);
		date.add(day);
		date.add(month);
		date.add(year);
		date.setOpaque(false);
		
		map = new JButton("map");
		map.addActionListener(this);
		pan imagePan = new pan();
		
		big = new Font("serif", Font.BOLD,22);
		
		medium = new Font("serif", Font.BOLD,18);
		f = new JFrame("Book Cabs");
		JPanel placesPan = new JPanel();
		 
		 JPanel backPan = new JPanel();
		
		JPanel fromPan = new JPanel();
		fromPan.setLayout(new FlowLayout(FlowLayout.LEFT,50,20));
		
		JPanel toPan = new JPanel();
		toPan.setLayout(new FlowLayout(FlowLayout.LEFT,50,20));
		
		fromPan.setOpaque(false);
		toPan.setOpaque(false);
		
		 JLabel lab1 = new JLabel("From");
		lab1.setForeground(Color.YELLOW);
		 lab1.setFont(big);
		 Date.setFont(big);
			Time.setFont(big);
		 JLabel lab2 = new JLabel("To");
		 lab2.setForeground(Color.YELLOW);
		 lab2.setFont(big);
		 JLabel lab3 = new JLabel("Vehicle Type");
		 lab3.setForeground(Color.YELLOW);
		 lab3.setFont(big);
		 ac=new JRadioButton("A/C");
		 nonAc=new JRadioButton("non A/C");
		 
		 ac.setForeground(Color.YELLOW);
		 nonAc.setForeground(Color.YELLOW);
		 
		 thWheel = new JRadioButton("3 wheeler");
		 foWheel = new JRadioButton("4 wheeler");
		 thWheel.setForeground(Color.YELLOW);
		 foWheel.setForeground(Color.YELLOW);
		 
		 bg1 = new ButtonGroup( );
		 bg1.add(ac);
		 bg1.add(nonAc);
		 
		 bg3 = new ButtonGroup( );
		 bg3.add(thWheel);
		 bg3.add(foWheel);
		 
		 
		 backPan.setLayout(new BoxLayout(backPan, BoxLayout.Y_AXIS));
		 backPan.setOpaque(false);
		 ArrayList<String> places = new ArrayList<String>();
		 
		
		 
		 FileReader fr = new FileReader("file.txt");
		 BufferedReader br = new BufferedReader(fr);
		 String s = null;
		 while((s = br.readLine())!=null)
		 {
			 places.add(s);
		 }
		 
		 Object[] place =  places.toArray();
		 box1 = new JComboBox(place);
		 box2 = new JComboBox(place);
		 box1.setOpaque(false);
		 box1.setFont(medium);
		 box2.setFont(medium);
		 
		 fromPan.add(lab1);
		 fromPan.add(box1);
		 toPan.add(lab2);
		 toPan.add(box2);
		 
		 placesPan.setLayout(new BoxLayout(placesPan,BoxLayout.X_AXIS));
		 placesPan.add(fromPan);
		 placesPan.add(toPan);
		 placesPan.add(map);
		 placesPan.setOpaque(false);
		 backPan.add(placesPan);
		 JPanel radioPan = new JPanel();
		 JPanel typePan = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		 typePan.add(lab3);

		 radioPan.setLayout(new BoxLayout(radioPan,BoxLayout.Y_AXIS));
		 radioPan.add(ac);
		 radioPan.add(nonAc);
		 radioPan.setOpaque(false);
		 ac.setOpaque(false);
		 nonAc.setOpaque(false);
		 ac.setSelected(true);
		 
		 JPanel radio2Pan = new JPanel();
		 radio2Pan.setLayout(new BoxLayout(radio2Pan,BoxLayout.Y_AXIS));
		 radio2Pan.add(thWheel);
		 radio2Pan.add(foWheel);
		 foWheel.setSelected(true);
		 radio2Pan.setOpaque(false);
		 thWheel.setOpaque(false);
		 foWheel.setOpaque(false);
		 
		 
		 
		 
		 typePan.setOpaque(false);
		 typePan.add(radioPan);
		 typePan.add(radio2Pan);
		 backPan.add(typePan);
		 
		 JLabel lab4 = new JLabel("Hire Type     ");
		 lab4.setForeground(Color.YELLOW);
		 lab4.setFont(big);
		 JPanel hirePan = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
		 hirePan.add(lab4);
		 JPanel radio1Pan = new JPanel();
		 radio1Pan.setLayout(new BoxLayout(radio1Pan,BoxLayout.Y_AXIS));
		 shared=new JRadioButton("shared");
		 unShared=new JRadioButton("unshared");
		 
		 shared.setForeground(Color.YELLOW);
		 unShared.setForeground(Color.YELLOW);
		 
		 radio1Pan.add(shared);
		 radio1Pan.add(unShared);
		 unShared.setSelected(true);
		 ButtonGroup bg2 = new ButtonGroup( );
		 bg2.add(shared);
		 bg2.add(unShared);
		 shared.setOpaque(false);
		 unShared.setOpaque(false);
		 radio1Pan.setOpaque(false);
		 hirePan.add(radio1Pan);
		 backPan.add(hirePan);
		 backPan.add(date);
		 backPan.add(time);
		 imagePan.add(backPan);
		 hirePan.setOpaque(false);
		 
		 
		 
		 JPanel submitPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		 submit = new JButton("Submit");
		 submitPan.setOpaque(false);
		 submitPan.add(submit);
		 backPan.add(submitPan);
		
		 submit.addActionListener(this);
		 JPanel panell = new JPanel();
		 panell.setLayout(new BoxLayout(panell,BoxLayout.Y_AXIS));
		 panell.add(banner);
		 panell.add(imagePan);
		 f.add(panell);
		f.setSize(900,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	class pan extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Image img = new ImageIcon("pic.jpg").getImage();
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}
	
	class pan2 extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			
			Image img = new ImageIcon("taxi_banner.png").getImage();
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}
	JButton subbut,backbut;
	JFrame details ;
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==butz)
		{
			
			f.dispose();
		}
		
		
		if(event.getSource()== submit){
			//pan2 banner = new pan2();
			f.setVisible(false);
			JPanel back = new JPanel();
			subbut=new JButton("Submit");
			backbut=new JButton("Back");
			details = new JFrame("User Details");
			pan imagePan = new pan();
			JLabel fname,lname,mailID,phNo,vehicles;
			fname = new JLabel("First Name");
			fname.setFont(big);
			lname = new JLabel("Last Name");
			lname.setFont(big);
			mailID = new JLabel(" Mail ID      ");
			mailID.setFont(big);
			phNo = new JLabel(" Phone        ");
			phNo.setFont(big);
			vehicles = new JLabel(" Vehicle       ");
			vehicles.setFont(big);

			fname.setForeground(Color.YELLOW);
			lname.setForeground(Color.YELLOW);
			mailID.setForeground(Color.YELLOW);
			phNo.setForeground(Color.YELLOW);
			vehicles.setForeground(Color.YELLOW);
			
			JPanel top = new JPanel();
			JPanel finame = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
			JPanel laname = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
			JPanel submit = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel backpan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JPanel dummy = new JPanel();
			
			subbut.addActionListener(this);
			
			dummy.add(label);
			submit.add(subbut);
			submit.add(backbut);
			
			firstname = new JTextField(10);
			lastname = new JTextField(10);
			phoneNo = new JTextField(10);
			emailID = new JTextField(10);
			top.setOpaque(false);
			finame.setOpaque(false);
			laname.setOpaque(false);
			//fname.setOpaque(false);
			//lname.setOpaque(false);
			back.setOpaque(false);
			backpan.setOpaque(false);
			submit.setOpaque(false);
			
			
			finame.add(fname);
			finame.add(firstname);
			laname.add(lname);
			laname.add(lastname);
			JPanel phon=new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
			phon.add(phNo);
			phon.add(phoneNo);
			phon.setOpaque(false);
			
			JPanel email=new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
			email.add(mailID);
			email.add(emailID);
			email.setOpaque(false);
			
			JPanel vehicletype=new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
			vehicletype.add(vehicles);
			vehicletype.setOpaque(false);
			
			
			top.add(finame);
			top.add(laname);
			
			
			String threeWheel[] = {"Auto"};
			String fourWheel[] = {"Indica","Innova"};
			
			if(thWheel.isSelected())
			{
				vehicle = new JComboBox(threeWheel);
				VNamef = 2+""; 
			}
			else{
				vehicle = new JComboBox(fourWheel);
			}
			vehicle.setPreferredSize(new Dimension(120,25));
			
			vehicletype.add(vehicle);
			back.setLayout(new BoxLayout(back,BoxLayout.Y_AXIS));
			back.add(top);
			back.add(phon);
			back.add(email);
			back.add(vehicletype);
			back.add(dummy);
			dummy.setOpaque(false);
			imagePan.add(back);
			back.add(submit);
			back.add(backpan);
			backbut.addActionListener(this);
			JPanel pane = new JPanel();
			pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
	//		pane.add(banner);
			pane.add(imagePan);
			details.add(pane);
			details.setVisible(true);
			details.setSize(900,600);
			details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Fromf = (String)box1.getSelectedItem();
			Tof = (String)box2.getSelectedItem();
			if(ac.isSelected())
			{
				VTypef = true;
			}
			else{
				VTypef = false;
			}
			if(shared.isSelected())
			{
				HTypef = true;
			}
			else
			{
				HTypef = false;
			}
			Datef = (String)(day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()); 
			Timef = (String)(hours.getSelectedItem()+"-"+minutes.getSelectedItem());
			
			
		}
		if(event.getSource()== backbut)
		{
			details.dispose();

			f.setVisible(true);
		}
		if(event.getSource()==subbut)
		{
			field=0;
			String fname = firstname.getText();
			String lname = lastname.getText();
			String phno = phoneNo.getText();
			String mail = emailID.getText();
			
				
				
			if(fname.equals(""))
			{
				field = 1;
				label.setText("enter proper first name");
			}
			else if(lname.equals(""))
			{
				field = 2;
				label.setText("enter proper last name");
			}
			else if(phno.equals(""))
			{
				field=3;
				label.setText("enter proper phone No.");
			}
			else if(mail.equals("")||!(mail.contains("@")))
			{
				field = 4;
				label.setText("enter proper email ID");
			}
			double y;
			try{
				y= Double.parseDouble(phno);
			}catch(Exception ex){
				if(field==0){
					label.setText("Invalid phone number");
					System.out.println("ass");
					field = 3;
				}
			}
			
			if(field==0)
			{
		//		pan2 banner = new pan2();
				boolean c = true;
				label.setText("");
				Namef = fname+" "+lname;
				Phonef = phno;
				emailf = mail;
				if(VNamef.equals(""))
				{
					VNamef = vehicle.getSelectedIndex()+"";
				}
				
				cab obj = new cab();
				//int hours,minutes;
				String[] me1 = Timef.split("-"); 
				//System.out.println(me[0]+" "+me[1]);
				
				try{
					FileReader fr = new FileReader("pts.txt");
					BufferedReader br = new BufferedReader(fr);
					String line = "";
					while((line=br.readLine())!=null)
					{
						String[] me = line.split("/");
						if(me[1].equals(Fromf))
						{
							Fromf = me[0]; 
							fr12 = me[0];
						}
						if(me[1].equals(Tof))
						{
							to12= me[0];
							Tof = me[0]; 
						}
					}
				}catch(Exception ex){}
				
				recv = new cabs();
				try{
				
				recv= obj.cabAvail(Integer.parseInt(VNamef), Datef, Fromf, Tof, Tof, Integer.parseInt(me1[0]), Integer.parseInt(me1[1]),HTypef,VTypef);
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				double cost;
				System.out.println(" dsd "+recv.di);
				if(recv != null){
					
				if(VTypef )
				{
					if(HTypef){
						cost = recv.di*3;
				
					}
					else{
						cost = recv.di*4;
					}
				}			
				else{

					if(HTypef){
						cost = recv.di*2;
				
					}
					else{
						cost = recv.di*3;
					}
				}
				if(recv.nearcab==1){
					String[] vin=recv.schedule.get(recv.schedule.size()-1).split("/");
					String tri = vin[1]+" : "+vin[2];
				if(JOptionPane.showConfirmDialog(null, "Cab available in = "+tri, "Cost", 
					    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
					    == JOptionPane.YES_OPTION)
					    {
					details.dispose();
					f.dispose();
					    }
				}
				else{
					if (JOptionPane.showConfirmDialog(null, "Cost = "+cost, "Cost", 
						    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
						    == JOptionPane.YES_OPTION)
						{

						details.dispose();
						 //Do the request
						JFrame frame = new JFrame();
						pan panel = new pan();
						JPanel back = new JPanel();
						JPanel pane = new JPanel();
						pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
					//	pane.add(banner);
						pane.add(panel);
						panel.add(back);
						frame.add(panel);
						frame.setSize(900,600);
						butz = new JButton("Close");
						//JButton but1 = new JButton("Cancel");
						frame.setVisible(true);
						back.setOpaque(false);
						JLabel lab = new JLabel();
						lab.setForeground(Color.YELLOW);
						JLabel details =	 	new JLabel("Details");
						JLabel drivername = 	new JLabel("DriverName : "+recv.driver);
						JLabel cabname = 		new JLabel("Cabname     : "+(String)vehicle.getSelectedItem());
						JLabel cabno = 			new JLabel("Cabno           : "+recv.regNum);
						JLabel driveph = 		new JLabel("DriverPh       : "+recv.driverPhno);
						
						details.setForeground(Color.YELLOW);
						drivername.setForeground(Color.YELLOW);
						cabname.setForeground(Color.YELLOW);
						cabno.setForeground(Color.YELLOW);
						driveph.setForeground(Color.YELLOW);
						
						back.setLayout(new BoxLayout(back,BoxLayout.Y_AXIS));
						JPanel confirm = new JPanel();
						if(c)
						{
							JPanel labtxt = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
							labtxt.setOpaque(false);
							JPanel detail = new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
							detail.setOpaque(false);
							JPanel dname = new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
							dname.setOpaque(false);
							JPanel cname = new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
							cname.setOpaque(false);
							JPanel cabnumber = new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
							cabnumber.setOpaque(false);
							JPanel driph = new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
							driph.setOpaque(false);
							String labtext;
							labtext = "Hurrayyy "+fname+" "+lname+", your cab has been booked.";
							lab.setFont(big);
							lab.setText(labtext);
							details.setText("Details");
							details.setForeground(Color.YELLOW);
							details.setFont(big);
							labtxt.add(lab);
							detail.add(details);
							dname.add(drivername);
							cname.add(cabname);
							cabnumber.add(cabno);
							driph.add(driveph);
							back.add(labtxt);
							back.add(detail);
							back.add(dname);
							back.add(cname);
							back.add(cabnumber);
							back.add(driph);
							confirm.add(butz);
							confirm.setOpaque(false);
							back.add(confirm);
							butz.addActionListener(this);
						//	confirm.add(but1);
							

							try{
								FileWriter fw=new FileWriter("gps.txt",true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.append(recv.cabno+"/"+recv.cab+"/"+recv.schedule.get(recv.schedule.size()-1));
								bw.newLine();
								bw.flush();
							}catch(Exception ex){
								
							}
						
							try{
							FileWriter fr = new FileWriter("userD.txt",true);
							BufferedWriter br = new BufferedWriter(fr);
							br.append(Namef);
							br.newLine();
							br.append(Phonef);
							br.newLine();
							br.append(emailf);
							br.newLine();
							br.append(fr12);
							br.newLine();
							br.append(to12);
							br.newLine();
							if(VTypef){
								br.append("AC");
								
							}
							else
							{
								br.append("Non AC");
								
							}
							br.newLine();
							if(HTypef)
							{
								br.append("Shared");
								
							}
							else
							{
								br.append("unshared");
							}
							br.newLine();
							br.append(Datef);
							br.newLine();
							br.append(Timef);
							br.newLine();
							br.append(VNamef);
							br.newLine();
							br.flush();
							}catch(Exception ex){}
						}
						
					
					
						
						}
						else
						{
							recv.schedule.remove(recv.schedule.size()-1);
							f.dispose();
							details.dispose();
						 //Go back to normal
						}
					
					
				}
				
				
				
				
				}
				
				else{
					
					JOptionPane.showMessageDialog(details, "Sorry no cab");
					details.dispose();
					f.dispose();
				}
				
			}
			
			
		}
		if(event.getSource()==map)
		{
			map v = new map();
			v.map1();
		}
			
	}

}
