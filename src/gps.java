import java.io.*;
import java.awt.*;
import javax.swing.*;


public class gps {
	
}

class gps1 
{
	void go()
	{
		try{
			FileReader fr = new FileReader("gps.txt");
			BufferedReader br = new BufferedReader(fr);
			String line ="";
			while((line=br.readLine())!=null){
				String divide[] = line.split("/");
				//0 to 9
			}
		}catch(Exception ex){}
	}
}