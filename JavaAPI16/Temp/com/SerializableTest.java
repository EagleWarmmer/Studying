package com;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Employee e1 = new  Employee( " zhangsan " , 25 , 3000.50 );
        Employee e2 = new  Employee( " lisi " , 24 , 3200.40 );
        Employee e3 = new  Employee( " wangwu " , 27 , 3800.55 );
        
        FileOutputStream fos = new  FileOutputStream( " employee.txt " );
        ObjectOutputStream oos = new  ObjectOutputStream(fos);
        oos.writeObject(e1);
        oos.writeObject(e2);
        oos.writeObject(e3);
        oos.close();
        
        FileInputStream fis = new  FileInputStream( " employee.txt " );
        ObjectInputStream ois = new  ObjectInputStream(fis);
        Employee e;
         for ( int  i = 0 ;i < 3 ;i ++ )
         {
            e = (Employee)ois.readObject();
            System.out.println(e.name + " : " + e.age + " : " + e.salary);
        } 
        ois.close();
        
	}
}
