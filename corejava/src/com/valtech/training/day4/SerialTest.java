package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;

public class SerialTest {
public static void main(String[] args) throws Exception {
	Point p= new Point(2,3);
System.out.println(p);
ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("objects")));
oos.writeObject(p);
oos.flush();
oos.close();
ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File("objects")));
Point p1=(Point)ois.readObject();
System.out.println(p1);
System.out.println(p==p1);
}
}
