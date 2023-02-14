

import java.io.*;
import java.net.*;
import java.util.*;
public class ls
{
	public static void main(String args[]) throws Exception
	{
		Scanner in=new Scanner(System.in);
		String x="";
		int b,c=0;
		try
		{
			ServerSocket skt=new ServerSocket(2598);
			Socket sk=skt.accept();
			System.out.println("Connected");
			DataInputStream odis=new DataInputStream(sk.getInputStream());
			DataOutputStream odos=new DataOutputStream(sk.getOutputStream());
			
			String ipv="";
			FileReader fr=new FileReader("local.txt");  
		BufferedReader br1=new BufferedReader(fr); 
		StringBuffer sb=new StringBuffer(); 

String line1;
			int flag1=0,flag2=0,flag=0;
				String user=odis.readUTF();
						
				System.out.println(user);

				
				while((line1=br1.readLine())!=null)  
				{
					String[] arr=line1.split(",",2);
					if(arr[0].equals(user))
					{
						flag=1;
						ipv = arr[1];
					}
				}
				if(flag==0)
				{
					odos.writeUTF("Not found in local server..");
				}
				else
				{
					odos.writeUTF(ipv);
				}



fr.close();  
sk.close();
  

  
	
			
		}catch(EOFException exp){}
		catch(Exception ep){}
	}
}


