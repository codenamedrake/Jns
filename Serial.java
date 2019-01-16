
import java.io.*;
import java.util.*;


public class Serial 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        Student st1=new Student();
        st1.age=23;
        st1.name="sita";
        
        FileOutputStream fob=new FileOutputStream("obj1.txt");
        ObjectOutputStream ob=new ObjectOutputStream(fob);
        ob.writeObject(st1);
        ob.flush();
        fob.close();
        ob.close();
        
        
        Student st2=new Student();
        st2.age=24;
        st2.name="gita";
        
        FileOutputStream fob1=new FileOutputStream("obj2.txt");
        ObjectOutputStream ob1=new ObjectOutputStream(fob1);
        ob1.writeObject(st2);
        ob1.flush();
        fob1.close();
        ob1.close();

        FileInputStream in=new FileInputStream("obj1.txt");
        ObjectInputStream obb=new ObjectInputStream(in);
        Student ot=(Student)obb.readObject();
        in.close();
        obb.close();
        System.out.println(ot.age+" "+ot.name);
        
        FileInputStream in1=new FileInputStream("obj2.txt");
        ObjectInputStream obb1=new ObjectInputStream(in1);
        Student ot1=(Student)obb1.readObject();
        in1.close();
        obb1.close();
        System.out.println(ot1.age+" "+ot1.name);
        
        
        // TODO code application logic here
    }
    
}
class Student implements Serializable
{
    int age;
    String name;
}