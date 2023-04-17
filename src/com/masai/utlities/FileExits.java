package com.masai.utlities;




import com.masai.entities.Batch;
import com.masai.entities.Course;
import com.masai.entities.Student;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileExits {
	
	public static Map<String, Course> courseFile() {

		Map<String, Course> pFile = null;

		File f = new File("Course.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {

				pFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(pFile);
//				System.out.println("ADDED");
				return pFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				pFile = (Map<String, Course>) ois.readObject();
//				System.out.println(pFile);
				return pFile;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return pFile;
	}
	
	
	
	
	public static Map<String, Student> studentFile() {

		Map<String, Student> cFile = null;

		File f = new File("Student.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {
				
				cFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(cFile);
//				System.out.println("ADDED");
				return cFile;

			} else {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				cFile = (Map<String, Student>) ois.readObject();
//				System.out.println("studentttttt");
//                System.out.println(cFile);
				return cFile;

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
		return cFile;

	}
	
	
	
	
	public static Map<String, Batch> batchFile() {

		Map<String, Batch> bFile = null;

		File b = new File("Batch.ser");
		boolean flag = false;
		try {
			if (!b.exists()) {
				b.createNewFile();
				flag = true;
			}

			if (flag) {
				
				bFile = new LinkedHashMap<>();
				ObjectOutputStream bo = new ObjectOutputStream(new FileOutputStream(b));
				bo.writeObject(bFile);
//				System.out.println("ADDED");
				return bFile;

			} else {
				
				ObjectInputStream bi = new ObjectInputStream(new FileInputStream(b));
				bFile = (Map<String, Batch>) bi.readObject();
//				System.out.println("studentttttt");
//                System.out.println(bFile);
				return bFile;

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
		return bFile;

	}

}
