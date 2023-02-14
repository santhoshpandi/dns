

import java.io.*;
import java.net.*;
import java.util.*;
public class rs
{
	public static void main(String args[]) throws Exception
	{
		Scanner in=new Scanner(System.in);
		String x="";
		int b,c=0;
		try
		{
			ServerSocket skt1=new ServerSocket(1111);
			Socket sk1=skt1.accept();
			System.out.println("Connected");
			DataInputStream odis1=new DataInputStream(sk1.getInputStream());
			DataOutputStream odos1=new DataOutputStream(sk1.getOutputStream());

			
			FileReader fr1=new FileReader("root.txt");  
		BufferedReader br1=new BufferedReader(fr1); 
String line1;
			int flag1=0,flag2=0;
				String user=odis1.readUTF();
				
			
				System.out.println(user);
				
				String temp="";
				
				while((line1=br1.readLine())!=null)  
				{
					String[] arr=line1.split(",",2);
					if(arr[0].equals(user))
					{
						odos1.writeUTF(arr[1]);
						temp=temp+line1;
					}
				}
				Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream("local.txt", true), "UTF-8"));
		writer.append("\n");
		writer.append(temp);
		writer.close();
				

fr1.close();  
sk1.close();
  

  
	
			
		}catch(EOFException exp){}
		catch(Exception ep){}
	}
}


