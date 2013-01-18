import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;




class adminmap implements MouseListener, ActionListener
{
	JButton start;
	static ArrayList<ArrayList<cabs>> a;
	static ArrayList<cabs>innovas;
	static ArrayList<cabs> indicas;
	static ArrayList<cabs> autos;
	JRadioButton inov,indi,aut ;
	JFrame f;
	JPanel p;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	BufferedWriter bw;
	panel1 pan;
	void go()
	{
		start = new JButton("start");
		start.addActionListener(this);
		try{
			fw = new FileWriter("bokka.txt");
			bw = new BufferedWriter(fw);
		}catch(Exception ex){}
		
		a=new ArrayList<ArrayList<cabs>>();
		 innovas = new ArrayList<cabs>();
		 indicas = new ArrayList<cabs>();
		 autos = new ArrayList<cabs>();
		 
		try{
			fr = new FileReader("drivN.txt");
			br = new BufferedReader(fr);
		}catch(Exception ex){}
		
		inov = new JRadioButton();
		inov.setText("Innova");
		indi = new JRadioButton();
		indi.setText("Indica");
		aut = new JRadioButton();
		aut.setText("auto");
		
		ButtonGroup group = new ButtonGroup( );
		 group.add(indi);
		 group.add(inov);
		 group.add(aut);
		
		f = new JFrame();
	//	p = new JPanel();
		pan = new panel1();
	pan.addMouseListener(this);
		//p.add(pan);
		//p.setOpaque(false);
		f.getContentPane().add(BorderLayout.CENTER,pan);
		f.setVisible(true);
		f.setSize(896, 528);
		JPanel pane = new JPanel();
		pane.add(inov);
		pane.add(indi);
		pane.add(aut);
		pane.add(start);
		f.getContentPane().add(BorderLayout.NORTH,pane);
		
		
		
		}
	
	class panel1 extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Image img1 = new ImageIcon("vin.png").getImage();
			g.drawImage(img1,0,0,896,448,this);
			
			
			
			for(int i = 0; i<innovas.size();i++)
			{
				Image img = new ImageIcon("taxi.png").getImage();
				g.drawImage(img,innovas.get(i).currPosX-12,innovas.get(i).currPosY-12,24,24,this);
			}
			
			for(int i = 0; i<indicas.size();i++)
			{
				Image img = new ImageIcon("taxi1.png").getImage();
				g.drawImage(img,indicas.get(i).currPosX-17,indicas.get(i).currPosY-17,34,34,this);
			}
			
			for(int i = 0; i<autos.size();i++)
			{
				Image img = new ImageIcon("auto.png").getImage();
				g.drawImage(img,autos.get(i).currPosX-12,autos.get(i).currPosY-12,24,24,this);
			}
			

		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==pan && inov.isSelected())
		{
			int locx,locy;
			locx = arg0.getX();
			locy = arg0.getY();
			cabs innova = new cabs();
			innova.currPosX = locx;
			innova.currPosY = locy;
			
			
			
			String name = "";
			try{
				name = br.readLine();
			}catch(Exception ex){
				
			}
			innova.driver = name;
    		innova.regNum="AP"+(int)((Math.random()*100))+"VF"+(int)(Math.random()*10000);
    		innova.driverPhno=(int)((Math.random()*100000))+""+(int)((Math.random()*100000));
    		try{
    			bw.append("1");
    			bw.newLine();
    			bw.append(name);
    			bw.newLine();

    			bw.append(locx+"");
    			bw.newLine();

    			bw.append(locy+"");
    			bw.newLine();
    			bw.append(innova.regNum);
    			bw.newLine();
    			bw.append(innova.driverPhno);
    			bw.newLine();
    			bw.flush();
    			
    		}catch(Exception ex)
    		{
    			
    		}
			innovas.add(innova);
			f.repaint();
		}
		
		if(arg0.getSource()==pan && indi.isSelected())
		{
			String name = "";
			try{
				name = br.readLine();
			}catch(Exception ex){
				
			}
			int locx,locy;
			locx = arg0.getX();
			locy = arg0.getY();
			cabs indica = new cabs();
			indica.driver = name;
    		indica.regNum="AP"+(int)((Math.random()*100))+"VF"+(int)(Math.random()*10000);
    		indica.driverPhno=(int)((Math.random()*100000))+""+(int)((Math.random()*100000));
			indica.currPosX = locx;
			indica.currPosY = locy;
			indicas.add(indica);
			try{
				bw.append("0");
    			bw.newLine();
    			bw.append(name);
    			bw.newLine();

    			bw.append(locx+"");
    			bw.newLine();
    			bw.append(locy+"");
    			bw.newLine();
    			
    			bw.append(indica.regNum);
    			bw.newLine();
    			bw.append(indica.driverPhno);
    			bw.newLine();
    			bw.flush();
    			
    		}catch(Exception ex)
    		{
    			
    		}
			f.repaint();
		}
		
		if(arg0.getSource()==pan && aut.isSelected())
		{
			String name = "";
			try{
				name = br.readLine();
			}catch(Exception ex){
				
			}
			
			int locx,locy;
			locx = arg0.getX();
			locy = arg0.getY();
			cabs auto = new cabs();
    		auto.driver = name;
			auto.regNum="AP"+(int)((Math.random()*100))+"VF"+(int)(Math.random()*10000);
    		auto.driverPhno=(int)((Math.random()*100000))+""+(int)((Math.random()*100000));
			auto.currPosX = locx;
			auto.currPosY = locy;
			try{

    			bw.append("2");
    			bw.newLine();
    			bw.append(name);
    			bw.newLine();
    			bw.append(locx+"");
    			bw.newLine();
    			bw.append(locy+"");
    			bw.newLine();
    			bw.append(auto.regNum);
    			bw.newLine();
    			bw.append(auto.driverPhno);
    			bw.newLine();
    			bw.flush();
    			
    		}catch(Exception ex)
    		{
    			
    		}
			autos.add(auto);
			f.repaint();
		}
		a.add(indicas);
		a.add(innovas);
		a.add(autos);
		System.out.println(indicas.size());
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==start)
		{
		////////// left behind
			System.out.println("neabba");
			 Timer timer = new Timer("Printer");
			 MyTask t = new MyTask();
			 for(int dums=0;dums<40;dums++){
			 timer.schedule(t, 0, 5000);
			 }
		}
	}
	
	class MyTask extends TimerTask{
		public void run()
		{
			

				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy/HH:mm:ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				String c = dateFormat.format(date);
				
				String div[] = c.split("/");
				String time[] = div[1].split(":");
				//System.out.println("dums  "+dums);
			try{
				FileReader fr = new FileReader("gps.txt");
				BufferedReader br = new BufferedReader(fr);
				String line ="";
				
				
				while((line=br.readLine())!=null){
					
					//System.out.println("finally");
					String divide[] = line.split("/");
	//innova+"/"+i+"/"+date+"/"+fromhour+"/"+fromminute+"/"+tohour+"/"+tomin+"/"+from+"/"+to+"/"+no.of seats remaing
					//0 to 9
					
					if(Integer.parseInt(divide[0])==0)
					{
						//System.out.println("inside indica "+line);
							int i = Integer.parseInt(divide[1]);
							{
								if(divide[2].equals(div[0]))
								{

									System.out.println("inside date");
									if((Integer.parseInt(time[0]))==Integer.parseInt(divide[3]))
									{

										//System.out.println("inside hour");
										if((Integer.parseInt(time[1]))==Integer.parseInt(divide[4]))   
										{

											//System.out.println("inside min");
											try{
												FileReader fr1 = new FileReader("shortpath.txt");
												BufferedReader br1 = new BufferedReader(fr1);
												String apsp = "";
												while((apsp=br1.readLine())!=null)
												{
													System.out.println("asps+  "+apsp);
													//System.out.println(line+" "+br1.readLine()+"    85233");
													String fromto[] = apsp.split("/");
													String[] from = divide[7].split("-");
													String[] to   = divide[8].split("-");
													       if(Integer.parseInt(from[0])>(Integer.parseInt(fromto[0])-10) && Integer.parseInt(from[0])<(Integer.parseInt(fromto[0])+10) )
													       {
													    	   if(Integer.parseInt(from[1])>(Integer.parseInt(fromto[1])-10) && Integer.parseInt(from[1])<(Integer.parseInt(fromto[1])+10) )
													    	   {
													    		   if(Integer.parseInt(to[0])>(Integer.parseInt(fromto[2])-10) && Integer.parseInt(to[0])<(Integer.parseInt(fromto[2])+10) )
													    		   {
													    			//   System.out.println("neabba "+)
													    			   if(Integer.parseInt(to[1])>(Integer.parseInt(fromto[3])-10) && Integer.parseInt(to[1])<(Integer.parseInt(fromto[3])+10) )
													    			   { 
																			System.out.println("founddddd..:D");
													    				   if(indicas.get(i).dist.size()==0){

												    						   int distance = 0;
													    					   for(int jk = fromto.length - 1 ; jk >= 8;jk=jk-2)
													    					   {
													    						   int dummyx, dummyy;
													    						   dummyy = (Integer.parseInt(fromto[jk])-Integer.parseInt(fromto[jk-2]))*(Integer.parseInt(fromto[jk])-Integer.parseInt(fromto[jk-2]));
													    						   dummyx = (Integer.parseInt(fromto[jk-1])-Integer.parseInt(fromto[jk-3]))*(Integer.parseInt(fromto[jk-1])-Integer.parseInt(fromto[jk-3]));
													    					
													    						   distance = distance+(int) Math.sqrt(dummyy+dummyx);
													    						   indicas.get(i).dist.add(distance);
													    					
													    					   }
													    				   }
													    				   
													    				   
													    				   indicas.get(i).distance=indicas.get(i).distance+5;
													    				   
													    				   for(int tap=0; tap<indicas.get(i).dist.size();tap++)
													    				   {
													    					   if(indicas.get(i).distance<indicas.get(i).dist.get(tap))
													    					   {
													    						   indicas.get(i).count = tap;
													    						   if(tap>0){
													    							   indicas.get(i).difference = indicas.get(i).distance-indicas.get(i).dist.get(tap-1);
													    						   }
													    						   else
													    						   {
													    							   indicas.get(i).difference = indicas.get(i).distance;
													    						   }
													    						   System.out.println("fff "+indicas.get(i).difference);
													    						   break;
													    						   
													    					   }
													    				   }
													    				   
													    				  int locx,locy;
													    				   
													    				   if(Integer.parseInt(fromto[fromto.length-(2*indicas.get(i).count)-2])-Integer.parseInt(fromto[fromto.length-(2*indicas.get(i).count)-4])!=0)
													    				   {
													    					   double slope = ((Integer.parseInt(fromto[fromto.length-2*indicas.get(i).count-3])-Integer.parseInt(fromto[fromto.length-(2*indicas.get(i).count)-1]))+0.0)/(Integer.parseInt(fromto[fromto.length-(2*indicas.get(i).count)-4])-Integer.parseInt(fromto[fromto.length-(2*indicas.get(i).count)-2]));
													    					   
													    					   double math = Math.sqrt((1+(slope*slope)));
													    					   System.out.println(math+"  slope = "+slope);
													    					   
													    					   if(slope>0){
													    						   locx = (int)((Integer.parseInt(fromto[fromto.length-2*indicas.get(i).count-2])+(indicas.get(i).difference/math)));
													    					   }
													    					   else{
													    						   locx = (int)((Integer.parseInt(fromto[fromto.length-2*indicas.get(i).count-2])-(indicas.get(i).difference/math)));
													    					   }
													    					   if(slope>0){
													    						   locy = (int)((Integer.parseInt(fromto[fromto.length-2*indicas.get(i).count-1])+slope*(indicas.get(i).difference/math)));
													    					   }
													    					   else{
													    						   locy = (int)((Integer.parseInt(fromto[fromto.length-2*indicas.get(i).count-1])-slope*(indicas.get(i).difference/math)));
															    					  
													    					   }
													    						

														    				   indicas.get(i).currPosX=locx;
													    					   indicas.get(i).currPosY=locy;
													    				   }
													    				   else{
													    					   
													    					   if(Integer.parseInt(fromto[fromto.length-2*indicas.get(i).count-3])>Integer.parseInt(fromto[fromto.length-2*indicas.get(i).count-1]))
													    					   {
													    						   indicas.get(i).currPosY = indicas.get(i).currPosY+ indicas.get(i).difference;
													    					   }
													    					   else{
													    						   indicas.get(i).currPosY = indicas.get(i).currPosY- indicas.get(i).difference;
													    					   }
													    				   }
													    				   System.out.println(indicas.get(i).currPosX+"  "+indicas.get(i).currPosY);
													    				   
													    			   }
													    		   }
													    	   }
													       }
												}
											}catch(Exception ex)//7 8 
											{
												ex.printStackTrace();
											}
										}
									}
								}
							}
						
						
					}
					if(Integer.parseInt(divide[0])==1)
					{
						//System.out.println("inside indica "+line);
						int i = Integer.parseInt(divide[1]);
						{
							if(divide[2].equals(div[0]))
							{

								//System.out.println("inside date");
								if((Integer.parseInt(time[0]))==Integer.parseInt(divide[3]))
								{

									//System.out.println("inside hour");
									if((Integer.parseInt(time[1]))>=Integer.parseInt(divide[4]))   
									{

										//System.out.println("inside min");
										try{
											FileReader fr1 = new FileReader("shortpath.txt");
											BufferedReader br1 = new BufferedReader(fr1);
											String apsp = "";
											while((apsp=br1.readLine())!=null)
											{
												System.out.println("asps+  "+apsp);
												//System.out.println(line+" "+br1.readLine()+"    85233");
												String fromto[] = apsp.split("/");
												String[] from = divide[7].split("-");
												String[] to   = divide[8].split("-");
												       if(Integer.parseInt(from[0])>(Integer.parseInt(fromto[0])-10) && Integer.parseInt(from[0])<(Integer.parseInt(fromto[0])+10) )
												       {
												    	   if(Integer.parseInt(from[1])>(Integer.parseInt(fromto[1])-10) && Integer.parseInt(from[1])<(Integer.parseInt(fromto[1])+10) )
												    	   {
												    		   if(Integer.parseInt(to[0])>(Integer.parseInt(fromto[2])-10) && Integer.parseInt(to[0])<(Integer.parseInt(fromto[2])+10) )
												    		   {
												    			   if(Integer.parseInt(to[1])>(Integer.parseInt(fromto[3])-10) && Integer.parseInt(to[1])<(Integer.parseInt(fromto[3])+10) )
												    			   { 
																		//System.out.println("founddddd..:D");
												    				   if(innovas.get(i).dist.size()==0){

											    						   int distance = 0;
												    					   for(int jk = fromto.length - 1 ; jk >= 8;jk=jk-2)
												    					   {
												    						   int dummyx, dummyy;
												    						   dummyy = (Integer.parseInt(fromto[jk])-Integer.parseInt(fromto[jk-2]))*(Integer.parseInt(fromto[jk])-Integer.parseInt(fromto[jk-2]));
												    						   dummyx = (Integer.parseInt(fromto[jk-1])-Integer.parseInt(fromto[jk-3]))*(Integer.parseInt(fromto[jk-1])-Integer.parseInt(fromto[jk-3]));
												    					
												    						   distance = distance+(int) Math.sqrt(dummyy+dummyx);
												    						   innovas.get(i).dist.add(distance);
												    					
												    					   }
												    				   }
												    				   
												    				   
												    				   innovas.get(i).distance=innovas.get(i).distance+5;
												    				   
												    				   for(int tap=0; tap<innovas.get(i).dist.size();tap++)
												    				   {
												    					   if(innovas.get(i).distance<innovas.get(i).dist.get(tap))
												    					   {
												    						   innovas.get(i).count = tap;
												    						   if(tap>0){
												    							   innovas.get(i).difference = innovas.get(i).distance-innovas.get(i).dist.get(tap-1);
												    						   }
												    						   else
												    						   {
												    							   innovas.get(i).difference = innovas.get(i).distance;
												    						   }
												    						   System.out.println("fff "+innovas.get(i).difference);
												    						   break;
												    						   
												    					   }
												    				   }
												    				   
												    				  int locx,locy;
												    				   
												    				   if(Integer.parseInt(fromto[fromto.length-(2*innovas.get(i).count)-2])-Integer.parseInt(fromto[fromto.length-(2*innovas.get(i).count)-4])!=0)
												    				   {
												    					   double slope = ((Integer.parseInt(fromto[fromto.length-2*innovas.get(i).count-3])-Integer.parseInt(fromto[fromto.length-(2*innovas.get(i).count)-1]))+0.0)/(Integer.parseInt(fromto[fromto.length-(2*innovas.get(i).count)-4])-Integer.parseInt(fromto[fromto.length-(2*innovas.get(i).count)-2]));
												    					   
												    					   double math = Math.sqrt((1+(slope*slope)));
												    					   System.out.println(math+"  slope = "+slope);
												    					   
												    					   if(slope>0){
												    						   locx = (int)((Integer.parseInt(fromto[fromto.length-2*innovas.get(i).count-2])+(innovas.get(i).difference/math)));
												    					   }
												    					   else{
												    						   locx = (int)((Integer.parseInt(fromto[fromto.length-2*innovas.get(i).count-2])-(innovas.get(i).difference/math)));
												    					   }
												    					   if(slope>0){
												    						   locy = (int)((Integer.parseInt(fromto[fromto.length-2*innovas.get(i).count-1])+slope*(innovas.get(i).difference/math)));
												    					   }
												    					   else{
												    						   locy = (int)((Integer.parseInt(fromto[fromto.length-2*innovas.get(i).count-1])-slope*(innovas.get(i).difference/math)));
														    					  
												    					   }
												    						

													    				   innovas.get(i).currPosX=locx;
												    					   innovas.get(i).currPosY=locy;
												    				   }
												    				   else{
												    					   
												    					   if(Integer.parseInt(fromto[fromto.length-2*innovas.get(i).count-3])>Integer.parseInt(fromto[fromto.length-2*innovas.get(i).count-1]))
												    					   {
												    						   innovas.get(i).currPosY = innovas.get(i).currPosY+ innovas.get(i).difference;
												    					   }
												    					   else{
												    						   innovas.get(i).currPosY = innovas.get(i).currPosY- innovas.get(i).difference;
												    					   }
												    				   }
												    				   System.out.println(innovas.get(i).currPosX+"  "+innovas.get(i).currPosY);
												    				   
												    			   }
												    		   }
												    	   }
												       }
											}
										}catch(Exception ex)//7 8 
										{
											ex.printStackTrace();
										}
									}
								}
							}
						}
					}
					if(Integer.parseInt(divide[0])==2)
					{
						//System.out.println("inside indica "+line);
						int i = Integer.parseInt(divide[1]);
						{
							if(divide[2].equals(div[0]))
							{

								//System.out.println("inside date");
								if((Integer.parseInt(time[0]))==Integer.parseInt(divide[3]))
								{

									//System.out.println("inside hour");
									if((Integer.parseInt(time[1]))==Integer.parseInt(divide[4]))   
									{

										//System.out.println("inside min");
										try{
											FileReader fr1 = new FileReader("shortpath.txt");
											BufferedReader br1 = new BufferedReader(fr1);
											String apsp = "";
											while((apsp=br1.readLine())!=null)
											{
												System.out.println("asps+  "+apsp);
												//System.out.println(line+" "+br1.readLine()+"    85233");
												String fromto[] = apsp.split("/");
												String[] from = divide[7].split("-");
												String[] to   = divide[8].split("-");
												       if(Integer.parseInt(from[0])>(Integer.parseInt(fromto[0])-10) && Integer.parseInt(from[0])<(Integer.parseInt(fromto[0])+10) )
												       {
												    	   if(Integer.parseInt(from[1])>(Integer.parseInt(fromto[1])-10) && Integer.parseInt(from[1])<(Integer.parseInt(fromto[1])+10) )
												    	   {
												    		   if(Integer.parseInt(to[0])>(Integer.parseInt(fromto[2])-10) && Integer.parseInt(to[0])<(Integer.parseInt(fromto[2])+10) )
												    		   {
												    			   if(Integer.parseInt(to[1])>(Integer.parseInt(fromto[3])-10) && Integer.parseInt(to[1])<(Integer.parseInt(fromto[3])+10) )
												    			   { 
																		//System.out.println("founddddd..:D");
												    				   if(autos.get(i).dist.size()==0){

											    						   int distance = 0;
												    					   for(int jk = fromto.length - 1 ; jk >= 8;jk=jk-2)
												    					   {
												    						   int dummyx, dummyy;
												    						   dummyy = (Integer.parseInt(fromto[jk])-Integer.parseInt(fromto[jk-2]))*(Integer.parseInt(fromto[jk])-Integer.parseInt(fromto[jk-2]));
												    						   dummyx = (Integer.parseInt(fromto[jk-1])-Integer.parseInt(fromto[jk-3]))*(Integer.parseInt(fromto[jk-1])-Integer.parseInt(fromto[jk-3]));
												    					
												    						   distance = distance+(int) Math.sqrt(dummyy+dummyx);
												    						   autos.get(i).dist.add(distance);
												    					
												    					   }
												    				   }
												    				   
												    				   
												    				   autos.get(i).distance=autos.get(i).distance+5;
												    				   
												    				   for(int tap=0; tap<autos.get(i).dist.size();tap++)
												    				   {
												    					   if(autos.get(i).distance<autos.get(i).dist.get(tap))
												    					   {
												    						   autos.get(i).count = tap;
												    						   if(tap>0){
												    							   autos.get(i).difference = autos.get(i).distance-autos.get(i).dist.get(tap-1);
												    						   }
												    						   else
												    						   {
												    							   autos.get(i).difference = autos.get(i).distance;
												    						   }
												    						   System.out.println("fff "+autos.get(i).difference);
												    						   break;
												    						   
												    					   }
												    				   }
												    				   
												    				  int locx,locy;
												    				   
												    				   if(Integer.parseInt(fromto[fromto.length-(2*autos.get(i).count)-2])-Integer.parseInt(fromto[fromto.length-(2*autos.get(i).count)-4])!=0)
												    				   {
												    					   double slope = ((Integer.parseInt(fromto[fromto.length-2*autos.get(i).count-3])-Integer.parseInt(fromto[fromto.length-(2*autos.get(i).count)-1]))+0.0)/(Integer.parseInt(fromto[fromto.length-(2*autos.get(i).count)-4])-Integer.parseInt(fromto[fromto.length-(2*autos.get(i).count)-2]));
												    					   
												    					   double math = Math.sqrt((1+(slope*slope)));
												    					   System.out.println(math+"  slope = "+slope);
												    					   
												    					   if(slope>0){
												    						   locx = (int)((Integer.parseInt(fromto[fromto.length-2*autos.get(i).count-2])+(autos.get(i).difference/math)));
												    					   }
												    					   else{
												    						   locx = (int)((Integer.parseInt(fromto[fromto.length-2*autos.get(i).count-2])-(autos.get(i).difference/math)));
												    					   }
												    					   if(slope>0){
												    						   locy = (int)((Integer.parseInt(fromto[fromto.length-2*autos.get(i).count-1])+slope*(autos.get(i).difference/math)));
												    					   }
												    					   else{
												    						   locy = (int)((Integer.parseInt(fromto[fromto.length-2*autos.get(i).count-1])-slope*(autos.get(i).difference/math)));
														    					  
												    					   }
												    						

													    				   autos.get(i).currPosX=locx;
												    					   autos.get(i).currPosY=locy;
												    				   }
												    				   else{
												    					   
												    					   if(Integer.parseInt(fromto[fromto.length-2*autos.get(i).count-3])>Integer.parseInt(fromto[fromto.length-2*autos.get(i).count-1]))
												    					   {
												    						   autos.get(i).currPosY = autos.get(i).currPosY+ autos.get(i).difference;
												    					   }
												    					   else{
												    						   autos.get(i).currPosY = autos.get(i).currPosY- autos.get(i).difference;
												    					   }
												    				   }
												    				   System.out.println(autos.get(i).currPosX+"  "+autos.get(i).currPosY);
												    				   
												    			   }
												    		   }
												    	   }
												       }
											}
										}catch(Exception ex)//7 8 
										{
											ex.printStackTrace();
										}
									}
								}
							}
						}
					}
				}
				f.repaint();
				
			}catch(Exception ex){
				
				ex.printStackTrace();
			}	
			
			
			}	
		}
	}
