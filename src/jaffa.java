import java.io.*;
public class jaffa {
	public static void main(String args[])throws IOException
	{
		FileWriter fw=new FileWriter("oop.txt",true);
		BufferedWriter bw=new BufferedWriter(fw);
		int count=1;
		FileReader fr = new FileReader("oops.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line=br.readLine())!=null){
			
			String c1[]={line.substring(0,3),line.substring(4,7)};
			
			String c2[]={line.substring(8,11),line.substring(12)};
			int d;
			d=(int)(Math.sqrt(((Integer.parseInt(c1[0])-Integer.parseInt(c2[0]))*(Integer.parseInt(c1[0])-Integer.parseInt(c2[0])))+(Integer.parseInt(c1[1])-Integer.parseInt(c2[1]))*(Integer.parseInt(c1[1])-Integer.parseInt(c2[1]))));
			
				bw.append(line+"/"+d);
				bw.newLine();
				bw.flush();
				
			
			
		}
	}

}
