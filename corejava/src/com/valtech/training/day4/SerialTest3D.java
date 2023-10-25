package com.valtech.training.day4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;
import com.valtech.training.day1.Point3D;
public class SerialTest3D {
	
	public static void main(String[] args) throws Exception {
		Point3D p =new Point3D(10,20,30);
		System.out.println(p);
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("objects")));
		oos.writeObject(p);
		oos.flush();
		oos.close();
		ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File("objects")));
		Point3D p1=(Point3D)ois.readObject();
		System.out.println(p1);
		System.out.println(p==p1);
		
	}

}
