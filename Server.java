import java.io.*;  
import java.net.*;
import java.time.*;  
public class Server 
{  
    public static void main(String[] args)throws Exception
    {  
        try
        {  
            ServerSocket ss=new ServerSocket(6666);  
            Socket s=ss.accept();//establishes connection
	    //s.setSoTimeout(10*1000);
	    System.out.println("Client IP:"+InetAddress.getLocalHost().getHostAddress());
            DataInputStream dis=new DataInputStream(s.getInputStream());
	    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
            String str="";
	    while(!str.equals("Exit"))
	    {
		str=(String)dis.readUTF();  
            	System.out.println("client message:"+str);
               if(str.equals("IP"))
	       {
		System.out.println("Client IP:"+InetAddress.getLocalHost().getHostAddress());
	       }
             
            }    
            ss.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}