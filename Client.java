import java.io.*;  
import java.net.*;
import java.time.*;
import java.util.*;
public class Client 
{  

    
    public static void main(String[] args) throws Exception
    {  
        try
        {      
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String str=""; 
            while(!str.equals("Exit"))
            {
	     
             System.out.println("enter the message:");
	     str=br.readLine();
	     if(str.equals("Time"))
             {
              System.out.println(LocalDateTime.now());
	     }               
	     dout.writeUTF(str);  
             dout.flush();
	       
            }
            System.out.println("Thank You..");
            dout.close();  
            s.close();   
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}