
 //shared part include no.of persons and do remaining
import java.io.*;
import java.util.*;


public class cab{
	//int a[]=new int[5];

	static ArrayList<ArrayList<cabs>> a=new ArrayList<ArrayList<cabs>>();
	int status;
   	ArrayList<cabs> indicas= new ArrayList<cabs>();
    ArrayList<cabs> innovas= new ArrayList<cabs>();
    ArrayList<cabs> autos= new ArrayList<cabs>();
    
    //book cabs
    int min[]=new int[5];
    int max[]=new int[5];
    int lastStopx,lastStopy,nextStopx,nextStopy;
    int avgVel=1;
    boolean availableNearly=false;
    boolean availableExactly=false;
    String time[];
    String sharedPoss[];
    	
    cabs cabAvail(int cabno,String date,String from,String to,String type,int hour,int minute,boolean shared,boolean ac) throws IOException{
    	System.out.print(date);
    		cabs nearcab=null;
    		String nearstr="";
    		double dist = findShtDist(from,to);// from file
    	//	FileWriter fw = new FileWriter("gps.txt",true);
		//	BufferedWriter bw = new BufferedWriter(fw);
    		
    		try{
    			FileReader fr = new FileReader("bokka.txt");
    			BufferedReader br = new BufferedReader(fr);
    			String line = "";
    			while((line=br.readLine())!=null)
    			{
    				
    				if(Integer.parseInt(line)==0)
    				{
    					cabs dummy = new cabs();
    					line = br.readLine();
    					dummy.driver = line;
    					line = br.readLine();
    					dummy.currPosX = Integer.parseInt(line);
    					line = br.readLine();
    					dummy.currPosY = Integer.parseInt(line);
    					line = br.readLine();
    					dummy.regNum = line;
    					line = br.readLine();
    					dummy.driverPhno = line;
    					
    					indicas.add(dummy);
    					
    				}
    				else if(Integer.parseInt(line)==1)
    				{
    					cabs dummy = new cabs();
    					line = br.readLine();
    					dummy.driver = line;
    					line = br.readLine();
    					dummy.currPosX = Integer.parseInt(line);
    					line = br.readLine();
    					dummy.currPosY = Integer.parseInt(line);
    					line = br.readLine();
    					dummy.regNum = line;
    					line = br.readLine();
    					dummy.driverPhno = line;
    					
    					innovas.add(dummy);
    				}
    				else if(Integer.parseInt(line)==2)
    				{
    					cabs dummy = new cabs();
    					line = br.readLine();
    					dummy.driver = line;
    					line = br.readLine();
    					dummy.currPosX = Integer.parseInt(line);
    					line = br.readLine();
    					dummy.currPosY = Integer.parseInt(line);
    					line = br.readLine();
    					dummy.regNum = line;
    					line = br.readLine();
    					dummy.driverPhno = line;
    					
    					autos.add(dummy);
    				}
    			}
    			a.add(indicas);
    			a.add(innovas);
    			a.add(autos);
    			System.out.println(" "+indicas.size());
    		}catch (Exception ex){ex.printStackTrace();}
    		
    		
    		try{
    			FileReader fg = new FileReader("gps.txt");
    			BufferedReader bg= new BufferedReader(fg);
    			String line=null;
    			while((line=bg.readLine())!=null){
    				String st[]=line.split("/");
    				a.get(Integer.parseInt(st[0])).get(Integer.parseInt(st[1])).schedule.add(line.substring(4));
    			}
    		}catch(Exception ex){
    			
    		}
    		
    		if(shared == true)
    		{//for shared cars
 			for(int i=0;i<(a.get(cabno)).size();i++)//schedule = date/fromhr/frommin/to hr/to min/fromposi/toposi/no.ofpassengers
 			{	
 				boolean notpresent = whethPresent(date,hour,minute,cabno,i);
 				System.out.print(notpresent+"jaffa");
 					
 					if(notpresent)		
 					{
 							//find before and next dates
 							findbefnex(date,hour,minute,i,cabno);
 							double distance=findShtDist((lastStopx+"-"+lastStopy),from);//laststop to present
 							int dummyhr=(int)distance/(avgVel*3600);
 							int dummymin=(int)(distance%(avgVel*3600))/60;
 							min[3]=min[3]+(min[4]+dummymin)/60;
 								min[4]=(min[4]+dummymin)%60;
 							
 								min[0]=min[0]+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 							
 								min[1]=min[1]+min[0]/31;
 								min[0]=min[0]%31;
 							
 								min[2]=min[2]+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							String DMYuser[]=date.split("-");
 							if((min[2]<Integer.parseInt(DMYuser[2]))||(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<Integer.parseInt(DMYuser[1]))||(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<=Integer.parseInt(DMYuser[1])&&min[0]<=Integer.parseInt(DMYuser[0]))||
 								(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<=Integer.parseInt(DMYuser[1])&&min[0]<=Integer.parseInt(DMYuser[0])&&min[3]<hour)||
 								(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<=Integer.parseInt(DMYuser[1])&&min[0]<=Integer.parseInt(DMYuser[0])&&min[3]<=hour&&min[4]<=minute))
 							{
 								
 									min[0]=Integer.parseInt(DMYuser[0]);
 									min[1]=Integer.parseInt(DMYuser[1]);
 									min[2]=Integer.parseInt(DMYuser[2]);
 									min[3]=hour;
 									min[4]=minute;
 									availableNearly=true;
 								
 							}
 							String nearpos=min[3]+"/"+min[4];
 							 dummyhr=(int)dist/(avgVel*3600);
 							 dummymin=(int)(dist%(avgVel*3600))/60;
 							min[3]=min[3]+(min[4]+dummymin)/60;
 								min[4]=(min[4]+dummymin)%60;
 								
 								min[0]=min[0]+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 								int d= min[3];
 								int e = min[4];
 								min[1]=min[1]+min[0]/31;
 								min[0]=min[0]%31;
 						
 								min[2]=min[2]+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							
 							distance=findShtDist(to,(nextStopx+""+nextStopy));//laststop to present
 							dummyhr=(int)distance/(avgVel*3600);
 							dummymin=(int)(distance%(avgVel*3600))/60;
 							min[3]=min[3]+(min[4]+dummymin)/60;
 								min[4]=(min[4]+dummymin)%60;
 								
 								min[0]=min[0]+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 							
 								min[1]=min[1]+min[0]/31;	
 								min[0]=min[0]%31;
 					
 								min[2]=min[2]+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							if((min[2]<max[2])||(min[2]<=max[2]&&min[1]<max[1])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<max[0])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<max[3])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<=max[3]&&min[4]<=max[4]))
 							{
 								
 									availableExactly=true;
 									
 							}
 							if(availableExactly==true){
 								if(availableNearly==true){
 									//cab available exactly;
 									//if confirmed update cab schedule
 									String toadd = date+"/"+hour+"/"+minute+"/"+d+"/"+e+"/"+from+"/"+to+"/"+4+"/"+ac;
 									a.get(cabno).get(i).schedule.add(toadd);
 									System.out.println(toadd+"jjjjjjjjjjjjjjjjjj");
 									System.out.println(a.get(cabno).get(i).regNum+"  jjjjjjjjjjjjjjjjjj");
 								//	bw.append(cabno+"/"+i+"/"+toadd);
 								//	bw.newLine();
 								//	bw.flush();
 									a.get(cabno).get(i).di=dist;
 									a.get(cabno).get(i).cab=i;
 									a.get(cabno).get(i).cabno=cabno;
 									return a.get(cabno).get(i);
 									
 								}
 								else{
 									//cab available nearly at min[0]...
 									//keep the cab aside and read other cabs  nearcab=thiscab
 									//if confirmed update cab schedule
 									nearcab=a.get(cabno).get(i);
 									nearstr=date+"/"+nearpos+"/"+d+"/"+e+"/"+from+"/"+to+"/"+0+"/"+ac;
 									
 								}
 							}
 							else{
 								//not available;
 							}
 						
 					
 					}
 					else{
 						if(Integer.parseInt(sharedPoss[7])>0){
 						//if present
 						FileReader fr = new FileReader("shortpath.txt");
 							BufferedReader br = new BufferedReader(fr);
 							String line = null;
 							
 							String frompos[]=sharedPoss[5].split("-");
 							String topos[]=sharedPoss[6].split("-");
 							int fromposx=Integer.parseInt(frompos[0]);
 							int fromposy=Integer.parseInt(frompos[1]);
 							int toposx =Integer.parseInt(topos[0]);
 							int toposy = Integer.parseInt(topos[1]);
 							String currposfro[]=from.split("-");
 							String currposto[]=to.split("-");	
 							while((line=br.readLine())!=null){
 								String info[]=line.split("/");
 								if(fromposx<=(Integer.parseInt(info[0])+10)&&fromposx>=(Integer.parseInt(info[0])-10)&&fromposy<=(Integer.parseInt(info[1])+10)&&fromposy>=(Integer.parseInt(info[1])-10)&&
 									toposx<=(Integer.parseInt(info[2])+10)&&toposx>=(Integer.parseInt(info[2])-10)&&toposy<=(Integer.parseInt(info[3])+10)&&toposy>=(Integer.parseInt(info[3])-10))
 									{
 										for(int k=5;k<info.length;k=k+2){
 											if(Integer.parseInt(currposfro[0])<=(Integer.parseInt(info[k])+10)&&Integer.parseInt(currposfro[0])>=(Integer.parseInt(info[k])-10)&&Integer.parseInt(currposfro[1])<=(Integer.parseInt(info[k+1])+10)&&Integer.parseInt(currposfro[1])>=(Integer.parseInt(info[k+1])-10))
 											{
 												for(int kr=5;kr<info.length;kr=kr+2){
 													if(Integer.parseInt(currposto[0])<=(Integer.parseInt(info[kr])+10)&&Integer.parseInt(currposto[0])>=(Integer.parseInt(info[kr])-10)&&Integer.parseInt(currposto[1])<=(Integer.parseInt(info[kr+1])+10)&&Integer.parseInt(currposto[1])>=(Integer.parseInt(info[kr+1])-10))
 													{
 														if(Integer.parseInt(sharedPoss[7])>0){
 															
 															//book the cab. update no.of seats and exit
 															if(ac==Boolean.parseBoolean(sharedPoss[8])){
 																a.get(cabno).get(i).di=dist;
 																a.get(cabno).get(i).cab=i;
 																a.get(cabno).get(i).cabno=cabno;
 															return a.get(cabno).get(i);
 															//keep return statement
 															}
 														}
 													}
 												}	
 											}

 										}
 											
 									}
 							}// completed of sharing
 						}
 						else{//not available
 						}
 						 findbefnex(date,hour,minute,i,cabno);
 						 int dummyhr=(int)dist/(avgVel*3600);
 						 int dummymin=(int)(dist%(avgVel*3600))/60;
 						 String DMYcab[]=time[0].split("-");	
 						 int dummin[]=new int[5];
 						 dummin[4]=(Integer.parseInt(time[4])+dummymin)%60;
 						 dummin[3]=Integer.parseInt(time[3])+(Integer.parseInt(time[4])+dummymin)/60;
 							
 								dummin[3]=(dummin[3]+dummyhr)%24;
 								dummin[0]=Integer.parseInt(DMYcab[0])+(dummin[3]+dummyhr)/24;
 								
 								dummin[0]=dummin[0]%31;
 								dummin[1]=Integer.parseInt(DMYcab[1])+dummin[0]/31;
 							
 								dummin[1]=dummin[1]%12;
 								dummin[2]=Integer.parseInt((DMYcab[2]))+dummin[1]/12;
 							String nearpos = dummin[0]+"-"+dummin[1]+"-"+dummin[2]+"/"+dummin[3]+"/"+dummin[4];
 							
 							min[4]=(Integer.parseInt(time[4])+dummymin)%60;
 								min[3]=Integer.parseInt(time[3])+(Integer.parseInt(time[4])+dummymin)/60;
 								min[0]=Integer.parseInt(DMYcab[0])+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 								int d = min[3];
 								int e = min[4];
 								min[1]=Integer.parseInt(DMYcab[1])+min[0]/31;
 								min[0]=min[0]%31;
 								
 								min[2]=Integer.parseInt((DMYcab[2]))+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							
 							double distance=findShtDist(to,(nextStopx+""+nextStopy));//laststop to present
 							dummyhr=(int)distance/(avgVel*3600);
 							dummymin=(int)(distance%(avgVel*3600))/60;
 							
 								min[4]=(Integer.parseInt(time[4])+dummymin)%60;
 								min[3]=Integer.parseInt(time[3])+(Integer.parseInt(time[4])+dummymin)/60;
 								min[0]=Integer.parseInt(DMYcab[0])+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 								min[1]=Integer.parseInt(DMYcab[1])+min[0]/31;
 								min[0]=min[0]%31;
 							
 								min[2]=Integer.parseInt((DMYcab[2]))+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							if((min[2]<max[2])||(min[2]<=max[2]&&min[1]<max[1])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<max[0])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<max[3])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<=max[3]&&min[4]<=max[4]))
 							{
 								availableExactly=true;
 							}
 							
 							if(availableExactly==true){
 								
 								//found a nearby cab timings are dummin array not dummymin
 								//update nearcab if confirmed
 								
 								nearcab=a.get(cabno).get(i);
 								nearstr=date+"/"+nearpos+"/"+d+"/"+e+"/"+from+"/"+to+"/"+0+"/"+ac;
 								
 									
 							}
 							else{
 								//not available;
 							}
 							
 							
 							
 							
 							
 						
 							
 						
 					}
 					
 						
 			}
    		}
 		else{
 			for(int i=0;i<(a.get(cabno)).size();i++)
 			{
 				int status=0;
 				//schedule = date/fromhr/frommin/to hr/to min/fromposi/toposi/no. of availa seats
 				  boolean notpresent = whethPresent(date,hour,minute,cabno,i);
 				  //String time[]=a.get(cabno).get(i).schedule.get(j).split("/");
 					//unshared
 					if(notpresent)
 					{
 							//find before and next dates
 							findbefnex(date,hour,minute,i,cabno);
 							double distance=findShtDist((lastStopx+"-"+lastStopy),from);//laststop to present
 							int dummyhr=(int)distance/(avgVel*3600);
 							int dummymin=(int)(distance%(avgVel*3600))/60;
 								min[3]=min[3]+(min[4]+dummymin)/60;
 								min[4]=(min[4]+dummymin)%60;
 								
 								min[0]=min[0]+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 							
 								min[1]=min[1]+min[0]/31;
 								min[0]=min[0]%31;
 								
 								min[2]=min[2]+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							String DMYuser[]=date.split("-");
 							if((min[2]<Integer.parseInt(DMYuser[2]))||(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<Integer.parseInt(DMYuser[1]))||(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<=Integer.parseInt(DMYuser[1])&&min[0]<Integer.parseInt(DMYuser[0]))||
 								(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<=Integer.parseInt(DMYuser[1])&&min[0]<=Integer.parseInt(DMYuser[0])&&min[3]<hour)||
 									(min[2]<=Integer.parseInt(DMYuser[2])&&min[1]<=Integer.parseInt(DMYuser[1])&&min[0]<=Integer.parseInt(DMYuser[0]))&&min[3]<=hour&&min[4]<=minute)
 							{
 								if((min[3]<hour)||(min[3]<=hour&&min[4]<=minute)){
 									min[0]=Integer.parseInt(DMYuser[0]);
 									min[1]=Integer.parseInt(DMYuser[1]);
 									min[2]=Integer.parseInt(DMYuser[2]);
 									min[3]=hour;
 									min[4]=minute;
 									availableNearly=true;
 								}
 							}
 							String nearpos=min[3]+"/"+min[4];
 						
 							 dummyhr=(int)dist/(avgVel*3600);
 							 dummymin=(int)(dist%(avgVel*3600))/60;
 							min[3]=min[3]+((min[4]+dummymin)/60);
 							 min[4]=(min[4]+dummymin)%60;
 						
 								min[0]=min[0]+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 							
 								int d =min[3];
 								int e = min[4];
 								min[1]=min[1]+min[0]/31;
 								min[0]=min[0]%31;
 								
 								min[2]=min[2]+min[1]/12;
 								min[1]=min[1]%12;
 							
 								
 						
 							distance=findShtDist(to,(nextStopx+""+nextStopy));//laststop to present
 							dummyhr=(int)distance/(avgVel*3600);
 							dummymin=(int)(distance%(avgVel*3600))/60;
 						
 							min[3]=min[3]+(min[4]+dummymin)/60;
 								min[4]=(min[4]+dummymin)%60;
 								
 								min[0]=min[0]+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 							
 								min[1]=min[1]+min[0]/31;
 								min[0]=min[0]%31;
 								
 								min[2]=min[2]+min[1]/12;
 								min[1]=min[1]%12;
 								
 								System.out.println(min[0]+";"+min[1]+":"+min[2]+";;"+min[3]+";;;"+min[4]+"jiiiiiiiiiiiiiiiiiiiiii");
 							
 							
 							if((min[2]<max[2])||(min[2]<=max[2]&&min[1]<max[1])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<max[0])||
 								(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<max[3])&&(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<=max[3]&&min[4]<=max[4]))
 							{
 								availableExactly=true;
 							}
 							if(availableExactly==true){
 								if(availableNearly==true){
 									//cab available exactly;
 									//if confirmed update cab schedule
 									String toadd = date+"/"+hour+"/"+minute+"/"+d+"/"+e+"/"+from+"/"+to+"/"+0;
 									a.get(cabno).get(i).schedule.add(toadd);
 									System.out.println(toadd+"jjjjjjjjjjjjjjjjjj");
 									System.out.println(a.get(cabno).get(i).regNum+"  jjjjjjjjjjjjjjjjjj");
 								//	bw.append(cabno+"/"+i+"/"+toadd);
 								//	bw.newLine();
 								//	bw.flush();
 									a.get(cabno).get(i).di=dist;
 									a.get(cabno).get(i).cab=i;
 									a.get(cabno).get(i).cabno=cabno;
 									return a.get(cabno).get(i);
 								}
 								else{
 									//cab available nearly at min[0]...
 									//keep the cab aside and read other cabs  nearcab=thiscab
 									//if confirmed update cab schedule
 									nearcab=a.get(cabno).get(i);
 									nearcab.cab=i;
 									nearcab.cabno=cabno;
 									nearstr=date+"/"+nearpos+"/"+d+"/"+e+"/"+from+"/"+to+"/"+0;
 									
 									
 								}
 							}
 							else{
 								//not available;
 							}
 							
 							
 					}
 					else{
 						findbefnex(date,hour,minute,i,cabno);
 						 int dummyhr=(int)dist/(avgVel*3600);
 						 int dummymin=(int)(dist%(avgVel*3600))/60;
 						 String DMYcab[]=time[0].split("-");	
 						 int dummin[]=new int[5];
 					
 								dummin[4]=(Integer.parseInt(time[4])+dummymin)%60;
 								dummin[3]=Integer.parseInt(time[3])+(Integer.parseInt(time[4])+dummymin)/60;
 							
 								dummin[3]=(dummin[3]+dummyhr)%24;
 								dummin[0]=Integer.parseInt(DMYcab[0])+(dummin[3]+dummyhr)/24;
 							
 								dummin[0]=dummin[0]%31;
 								dummin[1]=Integer.parseInt(DMYcab[1])+dummin[0]/31;
 							
 								dummin[1]=dummin[1]%12;
 								dummin[2]=Integer.parseInt((DMYcab[2]))+dummin[1]/12;
 									min[4]=(Integer.parseInt(time[4])+dummymin)%60;
 								min[3]=Integer.parseInt(time[3])+(Integer.parseInt(time[4])+dummymin)/60;
 								min[0]=Integer.parseInt(DMYcab[0])+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 								int d=min[3];
 								int e = min[4];//to store reach time
 								min[1]=Integer.parseInt(DMYcab[1])+min[0]/31;
 								min[0]=min[0]%31;
 								
 								min[2]=Integer.parseInt((DMYcab[2]))+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							
 							
 							double distance=findShtDist(to,(nextStopx+""+nextStopy));//laststop to present
 							dummyhr=(int)distance/(avgVel*3600);
 							dummymin=(int)(distance%(avgVel*3600))/60;
 				
 								min[4]=(Integer.parseInt(time[4])+dummymin)%60;
 								min[3]=Integer.parseInt(time[3])+(Integer.parseInt(time[4])+dummymin)/60;
 								
 								min[0]=Integer.parseInt(DMYcab[0])+(min[3]+dummyhr)/24;
 								min[3]=(min[3]+dummyhr)%24;
 								
 								d=min[3];
 								e = min[4];//to store reach time
 								min[1]=Integer.parseInt(DMYcab[1])+min[0]/31;
 								min[0]=min[0]%31;
 						
 								min[2]=Integer.parseInt((DMYcab[2]))+min[1]/12;
 								min[1]=min[1]%12;
 								
 							
 							if((min[2]<max[2])||(min[2]<=max[2]&&min[1]<max[1])||(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<max[0])
 								&&(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<max[3])&&(min[2]<=max[2]&&min[1]<=max[1]&&min[0]<=max[0]&&min[3]<=max[3]&&min[4]<=max[4]))
 							{
 								availableExactly=true;
 							}
 							
 							if(availableExactly==true){
 								//found a nearby cab timings are dummin array not dummymin
 								//update nearcab if confirmed
 								nearcab=a.get(cabno).get(i);
 								nearcab.cab=i;
 								nearcab.cabno=cabno;
 								nearstr=dummin[0]+"-"+dummin[1]+"-"+dummin[2]+"/"+dummin[3]+"/"+dummin[4]+"/"+d+"/"+e+"/"+from+"/"+to+"/"+0;
 							}
 							else{
 								//not available;
 							}
 							
 							
 							
 							
 							
 							
 					}
 					
 				
    	
    	
   		}
    	}
    	//bw.append(nearstr);
    	//bw.newLine();
    	//bw.flush();
    	System.out.println(nearstr+"kkkkkuuuu");
    	nearcab.nearcab = 1;
    	if(nearcab!=null){
    	nearcab.di=dist;
    	}
    	return nearcab;
    }
    
   void  findbefnex(String date,int hour,int minute,int i,int cabno){
    	
    	max[0]=10000;
    	max[1]=10000;
    	max[2]=10000;
    	max[3]=10000;
    	max[4]=10000;
    	for(int j=0;j<a.get(cabno).get(i).schedule.size();j++)//schedule = date/fromhr/frommin/to hr/to min/fromposi/toposi/no.ofpass
 		{//before date
 			String time[]=a.get(cabno).get(i).schedule.get(j).split("/");//date day-month-year
 			String DMYcab[]=time[0].split("-");
 			String DMYuser[]=date.split("-");
 			if((Integer.parseInt(DMYcab[2])<Integer.parseInt(DMYuser[2]))||(Integer.parseInt(DMYcab[2])<=Integer.parseInt(DMYuser[2])&&Integer.parseInt(DMYcab[1])<Integer.parseInt(DMYuser[1]))||(Integer.parseInt(DMYcab[2])<=Integer.parseInt(DMYuser[2])&&Integer.parseInt(DMYcab[1])<=Integer.parseInt(DMYuser[1])&&Integer.parseInt(DMYcab[0])<=Integer.parseInt(DMYuser[0])))
 			{
 				if((Integer.parseInt(time[3])<hour)||(Integer.parseInt(time[3])==hour&&Integer.parseInt(time[4])<=minute)){
 					if((Integer.parseInt(DMYcab[0])>=min[0])&&(Integer.parseInt(DMYcab[1])>=min[1])&&(Integer.parseInt(DMYcab[2])>=min[2])&&(Integer.parseInt(time[3])>=min[3])&&(Integer.parseInt(time[4])>=min[4]))
 					{
 						min[0]=Integer.parseInt(DMYcab[0]);
 						min[1]=Integer.parseInt(DMYcab[1]);
 						min[2]=Integer.parseInt(DMYcab[2]);
 						min[3]=Integer.parseInt(time[3]);
 						min[4]=Integer.parseInt(time[4]);
 						String x[]=time[6].split("-");
 						lastStopx=Integer.parseInt(x[0]);
 						lastStopy=Integer.parseInt(x[1]);
 						
 					}
 				}
 				
 			}	
 		}
 		
 		for(int j=0;j<a.get(cabno).get(i).schedule.size();j++)//schedule = date/fromhr/frommin/to hr/to min/fromposi/toposi
 		{//next date
 			String time[]=a.get(cabno).get(i).schedule.get(j).split("/");//date day-month-year
 			String DMYcab[]=time[0].split("-");
 			String DMYuser[]=date.split("-");
 			if((Integer.parseInt(DMYcab[2])>Integer.parseInt(DMYuser[2]))||(Integer.parseInt(DMYcab[2])>=Integer.parseInt(DMYuser[2])&&Integer.parseInt(DMYcab[1])>Integer.parseInt(DMYuser[1]))||(Integer.parseInt(DMYcab[2])>=Integer.parseInt(DMYuser[2])&&Integer.parseInt(DMYcab[1])>=Integer.parseInt(DMYuser[1])&&Integer.parseInt(DMYcab[0])>=Integer.parseInt(DMYuser[0])))
 			{
 				if((Integer.parseInt(time[1])>hour)||(Integer.parseInt(time[1])==hour&&Integer.parseInt(time[4])>=minute)){
 					if((Integer.parseInt(DMYcab[0])<=max[0])&&(Integer.parseInt(DMYcab[1])<=max[1])&&(Integer.parseInt(DMYcab[2])<=max[2])&&(Integer.parseInt(time[1])<=max[3])&&(Integer.parseInt(time[2])<=max[4]))
 					{
 						max[0]=Integer.parseInt(DMYcab[0]);
 						max[1]=Integer.parseInt(DMYcab[1]);
 						max[2]=Integer.parseInt(DMYcab[2]);
 						max[3]=Integer.parseInt(time[1]);
 						max[4]=Integer.parseInt(time[2]);
 						String x[]=time[5].split("-");
 						nextStopx=Integer.parseInt(x[0]);
 						nextStopy=Integer.parseInt(x[1]);
 						
 					}
 				}
 				
 			}	
 		}
    
    	
    }
    
    boolean whethPresent(String date,int hour,int minute,int cabno,int i)
    {
    
    	for(int j=0;j<a.get(cabno).get(i).schedule.size();j++){
    		 time=a.get(cabno).get(i).schedule.get(j).split("/");
    	if(!(date.equals(time[0])&&hour>=Integer.parseInt(time[1])&&hour<=Integer.parseInt(time[3])&&minute>=Integer.parseInt(time[2])&&minute<=Integer.parseInt(time[4])))
    	{
    		
    	}
    	else{
    		sharedPoss=a.get(cabno).get(i).schedule.get(j).split("/");
    		return false;
    	}
    	}
    	return true;
    }
    
    double findShtDist(String froms,String tos) throws IOException
    {
    	String from[]=froms.split("-");
    	//System.out.println("gfgfg"+from[0]+"ii"+from[1]);
    	String to[]=tos.split("-");
    	FileReader fr = new FileReader("shortpath.txt");
    	BufferedReader br = new BufferedReader(fr);
    	String line=null;
    	while((line=br.readLine())!=null){
    		String info[]=line.split("/");
    		if((Integer.parseInt(from[0])<(Integer.parseInt(info[0])+10))&&(Integer.parseInt(from[0])>(Integer.parseInt(info[0])-10))&&(Integer.parseInt(from[1])<(Integer.parseInt(info[1])+10))&&(Integer.parseInt(from[1])>(Integer.parseInt(info[1])-10)))
    		{
    			if((Integer.parseInt(to[0])<Integer.parseInt(info[2])+10)&&(Integer.parseInt(to[0])>(Integer.parseInt(info[2])-10))&&(Integer.parseInt(to[1])<(Integer.parseInt(info[3])+10))&&(Integer.parseInt(to[1])>(Integer.parseInt(info[3])-10)))
    			return Double.parseDouble(info[4]);
    			
    		}
    	}
    	return 0;
    }
    
    
    
}



