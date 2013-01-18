
import java.io.*;
import java.util.*;
public class shortpaths {
    //void func() throws IOException{
    	public static void main (String[] args) throws IOException{

    	ArrayList<places> allPlaces = new ArrayList<places>();
    	FileWriter fw = new FileWriter("shortpath.txt");
   		BufferedWriter bw = new BufferedWriter(fw);
    	
    	FileReader fr = new FileReader("oop.txt"); // constructing graph
    	BufferedReader br = new BufferedReader(fr);
    	String lines = null;
    	int status3=0;
    	while((lines = br.readLine())!= null)
    	{
    		System.out.println(allPlaces.size()+"kkk");
    		int status1=0;
    		int status2=0;
    		String info[]=lines.split("/");//info[1] is distance
    		String positions[]=info[0].split(",");
    		String pos1[]=positions[0].split("-");
    		String pos2[]=positions[1].split("-");
    		if(status3==0){
    			places pla1=new places();
    			places pla2=new places();
    			pla1.x=Integer.parseInt(pos1[0]);
    			pla1.y=Integer.parseInt(pos1[1]);
    			pla2.x=Integer.parseInt(pos2[0]);
    			pla2.y=Integer.parseInt(pos2[1]);
    			pla1.adjacent.add(pla2);
    			pla2.adjacent.add(pla1);
    			pla1.distances.add(Double.parseDouble(info[1]));
    			pla2.distances.add(Double.parseDouble(info[1]));
    			allPlaces.add(pla1);
    			allPlaces.add(pla2);
    			status3=1;
    		}
    		
    		for(int i=0;i<allPlaces.size();i++)
    		{
    			
    			//System.out.println(allPlaces.size()+"kkk");
    			if(allPlaces.get(i).x<(Integer.parseInt(pos1[0])+10)&&allPlaces.get(i).x>(Integer.parseInt(pos1[0])-10)&&allPlaces.get(i).y<(Integer.parseInt(pos1[1])+10)&&allPlaces.get(i).y>(Integer.parseInt(pos1[1])-10))
    			{
    				status1=1;
    				for(int j=0;j<allPlaces.size();j++)
    				{
    					if(allPlaces.get(j).x<(Integer.parseInt(pos2[0])+10)&&allPlaces.get(j).x>(Integer.parseInt(pos2[0])-10)&&allPlaces.get(j).y<(Integer.parseInt(pos2[1])+10)&&allPlaces.get(j).y>(Integer.parseInt(pos2[1])-10))//if both places are already initialized
    					{
    						status2 = 1;
    						allPlaces.get(i).adjacent.add(allPlaces.get(j));
    						allPlaces.get(i).distances.add(Double.parseDouble(info[1]));
    						allPlaces.get(j).adjacent.add(allPlaces.get(i));
    						allPlaces.get(j).distances.add(Double.parseDouble(info[1]));
    						break;
    					}		
    				}
    				
    				if(status2==0){
    					places newplace = new places();
    					newplace.x = Integer.parseInt(pos2[0]);
    					newplace.y = Integer.parseInt(pos2[1]);
    					newplace.adjacent.add(allPlaces.get(i));
    					newplace.distances.add(Double.parseDouble(info[1]));
    					allPlaces.get(i).adjacent.add(newplace);
    					allPlaces.get(i).distances.add(Double.parseDouble(info[1]));
    					allPlaces.add(newplace);	
    				}
    				break;
    			}////////
    												
    		}
    		if(status1==0){
    			places newplace1=new places();
    			newplace1.x = Integer.parseInt(pos1[0]);
    			newplace1.y = Integer.parseInt(pos1[1]);
    			
    			for(int j=0;j<allPlaces.size();j++)
    				{
    					if(allPlaces.get(j).x<(Integer.parseInt(pos2[0])+10)&&allPlaces.get(j).x>(Integer.parseInt(pos2[0])-10)&&allPlaces.get(j).y<(Integer.parseInt(pos2[1])+10)&&allPlaces.get(j).y>(Integer.parseInt(pos2[1])-10))//if both places are already initialized
    					{
    						status2 = 1;
    						newplace1.adjacent.add(allPlaces.get(j));
    						newplace1.distances.add(Double.parseDouble(info[1]));
    						allPlaces.get(j).adjacent.add(newplace1);
    						allPlaces.get(j).distances.add(Double.parseDouble(info[1]));
    						break;
    					}		
    				}
    				
    				if(status2==0){
    					places newplace = new places();
    					newplace.x = Integer.parseInt(pos2[0]);
    					newplace.y = Integer.parseInt(pos2[1]);
    					newplace.adjacent.add(newplace1);
    					newplace.distances.add(Double.parseDouble(info[1]));
    					newplace1.adjacent.add(newplace);
    					newplace1.distances.add(Double.parseDouble(info[1]));
    					allPlaces.add(newplace);	
    				}
    			allPlaces.add(newplace1);	
    		}	
    	}											//completed graph
    
    for(int i=0;i<allPlaces.size();i++)//all pair shortest paths
    {
    	allPlaces.get(i).dummyDist=0;
    	allPlaces.get(i).marked = true;
    	allPlaces.get(i).parent=allPlaces.get(i);
    	
    	for(int j=0;j<allPlaces.size();j++)
    	{
    		if(j==i){
    			continue;
    		}
    		else{
    			allPlaces.get(j).dummyDist = 100000;
    			allPlaces.get(j).marked = false;
    		}
    			
    	}
    	
    	for(int ch=0;ch<allPlaces.size();ch++)
    	{
    	for(int m=0;m<allPlaces.size();m++)
    	{
    		if(allPlaces.get(m).dummyDist==100000)
    		{
    			continue;
    		}
    		else{
    			for(int k=0;k<allPlaces.get(m).adjacent.size();k++)
    			{
    				if( ((allPlaces.get(m).dummyDist)+(allPlaces.get(m).distances.get(k))) < allPlaces.get(m).adjacent.get(k).dummyDist )
    				{
    					allPlaces.get(m).adjacent.get(k).dummyDist = ((allPlaces.get(m).dummyDist)+(allPlaces.get(m).distances.get(k)));
    					allPlaces.get(m).adjacent.get(k).parent=allPlaces.get(m);
    				}
    			}
    		}
    	}
    	}
    	
    	for(int ch=0;ch<allPlaces.size();ch++)
    	{
    		String line;
    		places route;
    		route=allPlaces.get(ch);
    		line = allPlaces.get(i).x + "/"+allPlaces.get(i).y +"/" +allPlaces.get(ch).x+"/"+allPlaces.get(ch).y+"/"+ allPlaces.get(ch).dummyDist+"/"+allPlaces.get(ch).x + "/"+allPlaces.get(ch).y ;
    		for(;;){
    			if(route.parent==allPlaces.get(i)){
    				line=line+"/"+allPlaces.get(i).x + "/"+allPlaces.get(i).y ;
    				break;
    			}
    			
    			line=line + "/"+route.parent.x+ "/" + route.parent.y;
    			route=route.parent;
    		}
    		bw.append(line);
    		bw.newLine();
    		bw.flush();	
    	}
    	
    	
    	
    		
    }
    System.out.println(allPlaces.size());
    System.out.println(Math.random()*100000);
    }
    
}

class places{
	//String name;
	int x,y;//position
	ArrayList<places> adjacent = new ArrayList<places>();
	ArrayList<Double> distances = new ArrayList<Double>();
	double dummyDist;
	boolean marked;
	places parent;
}


