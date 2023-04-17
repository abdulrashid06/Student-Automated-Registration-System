package com.masai.main;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.Service.AdminBatch;
import com.masai.Service.AdminBatchService;
import com.masai.Service.AdminCourse;
import com.masai.Service.AdminCourseServices;
import com.masai.Service.StudentSE;
import com.masai.Service.StudentServices;
import com.masai.entities.Batch;
import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.utlities.Admin;
import com.masai.utlities.FileExits;
import com.masai.utlities.RollNoGeneration;


public class Main {
	
	//**************************************************************************************************************//
	//                            *~*~*  A D M I M     D A S H B O A R D   *~*~*                                    //
	//**************************************************************************************************************//
	
	private static void admindashboard(Scanner sc, Map<String, Course> courses, Map<String, Student> students, Map<String, Batch> batches) throws InvalidDetailsException  {
		adminLogin(sc);
		
		StudentSE studen = new StudentServices();
		AdminCourse courseService = new AdminCourseServices();
		AdminBatch batchService = new AdminBatchService();
		
		
		int choice = 0;
		try {
			do {
				System.out.println("Press 1 to add New Course");
				System.out.println("Press 2 to Search Courses");
				System.out.println("Press 3 to Update Course Details");
				System.out.println("Press 4 to add New Batch");
				System.out.println("Press 5 to Search Batch");
				System.out.println("Press 6 to Update Batch Details");
				System.out.println("Press 7 to View List of Students");
				System.out.println("Press 8 to Search Courses");
				System.out.println("Press 9 to logout");
				
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = addCourse(sc, courses, courseService);
					System.out.println(added);
					break;
				case 2:

					searchCourse(sc, courses, courseService);
					break;
				case 3:

					updateCourse(sc, courses, courseService);
					break;
				case 4:

//					String upt = addBatch(sc, batches, courses, batchService);
//					System.out.println(upt);
					addBatch(sc, batches, courses, batchService);
					break;
				case 5:
					searchBatch(sc, batches, batchService);

					break;
				case 6:
					updateBatch(sc, batches, courses , batchService);
					break;
				case 7:
					viewAllStudents(students, studen);
					break;
				case 8:
					deleteProduct(sc, courses, courseService);
					break;
				case 9:
					System.out.println("admin has successfully logout");
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	



	//           *****    A D M I N    L O G I N    *****
	public static void adminLogin(Scanner sc) throws InvalidDetailsException {
		
		System.out.println("Enter Username");
		String userName = sc.next();
		System.out.println("Enter Password");
		String passWord = sc.next();
		
		if(userName.equals(Admin.username) && passWord.equals(Admin.password)) {
			System.out.println("Login Successfully");
		}
		else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}

	
	
	
	//           ***    A D D    C O U R S E    ***
	private static String addCourse(Scanner sc, Map<String, Course> courses, AdminCourse courseService) {
		// TODO Auto-generated method stub
		String str = null;
		System.out.println("Enter the course details");
		System.out.println("Enter Course Name");
		String courseName = sc.next();
		System.out.println("Enter Course Duration");
		int courseDuration = sc.nextInt();
		System.out.println("Enter Course Fee");
		double courseFee = sc.nextDouble();
		
		Course cou = new Course(courseName, courseDuration, courseFee);
		str = courseService.addCourse(cou, courses);
		
		return str;
	}

	
	
	//           ***    S E A R C H    C O U R S E    ***
	private static void searchCourse(Scanner sc, Map<String, Course> courses, AdminCourse courseService) throws CourseException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter course name");
		String searchName = sc.next();
		
//		System.out.println("Enter minimum course duration");
//		int minDuration = sc.nextInt();
//		
//		System.out.println("Enter maximum course duration");
//		int maxDuration = sc.nextInt();
//		
//		System.out.println("Enter minimum fee range");
//		int minFee = sc.nextInt();
//		
//		System.out.println("Enter maximum fee range");
//		int maxFee = sc.nextInt();
		
//		courseService.searchCourse(courses);
//		
//		List<Course> list = new ArrayList<>();
//		
//		for(Course c : list) {
//			if(c.getName().equals(searchName) && c.getDuration() >= minDuration && c.getDuration() <= maxDuration
//					&& c.getFee() >= minFee && c.getFee() <= maxFee) {
//				System.out.println("Course found :- " + c.getName() + " Duration : " + c.getDuration() + " Fee : " + c.getFee());
//			}
//		}
		
//		for(Map.Entry<String, Course> ce : courses.entrySet()) {
//			if(courses.containsKey(searchName)) {
//				if(courses.get(searchName).getName().equals(searchName)){
//					System.out.println("Course found :- " + courses.get(searchName).getName() + " Duration : " + courses.get(searchName).getDuration()
//							+ " Fee : " + courses.get(searchName).getFee());
//						}
//			}
//		}
		
		
		if(courses.containsKey(searchName)) {
			System.out.println(courses.get(searchName));
		}
		
	}
	
	
	
	
	//             ***    U P D A T E    C O U R S E    ***
	private static String updateCourse(Scanner sc, Map<String, Course> courses, AdminCourse courseService) throws CourseException {
		
		// TODO Auto-generated method stub
		
		String str = null;
		
		System.out.println("Enter course name to be updated");
		String cName = sc.next();
		
		System.out.println("Enter course duration");
		int cDuration = sc.nextInt();
		
		System.out.println("Enter course fee");
		double cFee = sc.nextDouble();
		
		
		Course cou = new Course(cName, cDuration, cFee);
		
		str = (String) courseService.updateCourse(cName, cou, courses);
		
		
		return str;
		
		
	}

		

	
	//             ***     A D D     B A T C H     ***
	private static void addBatch(Scanner sc, Map<String, Batch> batches, Map<String, Course> courses, AdminBatch batchService) {
		// TODO Auto-generated method stub
		
		String str = null;
		
		System.out.println("Enter course name");
		String cName = sc.next();
		
		if(courses.containsKey(cName)) {
			
			System.out.println("Enter batch name");
			String batchName = sc.next();
			
			System.out.println("Enter start date of course");
			String sDate = sc.next();
			
			System.out.println("Enetr end date of course");
			String eDate = sc.next();
			
			Batch bat = new Batch(batchName, sDate, eDate);
			
			courses.get(cName).addBatch(bat);
			batchService.addBatch(bat, batches);
			

			
		}
//		return str;
		
		
		
	}



	
	//             ***     S E A R C H     B A T C H     ***
	private static void searchBatch(Scanner sc, Map<String, Batch> batches, AdminBatch batchService) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter batch name");
		String bName = sc.next();
		
		
		if(batches.containsKey(bName)) {
			System.out.println(batches.get(bName));
		}
		
	}
	
	
	
	
	//             ***    U P D A T E     B A T C H    ***
	private static String updateBatch(Scanner sc, Map<String, Batch> batches, Map<String, Course> courses, AdminBatch batchService) throws CourseException {
		// TODO Auto-generated method stub
		
		String str = null;
		
		System.out.println("Enter course name");
		String cName = sc.next();
		
		System.out.println("You can only update batch details not batch name");
		System.out.println("Enter batch name");
		String bName = sc.next();
		
		System.out.println("Enter batch start date");
		String sDate = sc.next();
		
		System.out.println("Enter batch end date");
		String eDate = sc.next();
		
		Batch bat = new Batch(bName, sDate, eDate);
		
//		batches.get(bName).ge
		
		if(courses.containsKey(cName)) {
			courses.get(cName).removeBatch(bat);
		}
		
		str = (String) batchService.updateBatch(bName, bat, batches);
		
		return str;
		
	}


	

	
	//             ***    V I E W    A L L    S T U D E N T S    ***
	private static void viewAllStudents(Map<String, Student> students, StudentSE studen) throws StubNotFoundException  {
		// TODO Auto-generated method stub
		
		List<Student> list = studen.viewAllStudents(students);
		
		for(Student s : list) {
			System.out.println(s);
		}
		
	}



	
	
	
	private static void deleteProduct(Scanner sc, Map<String, Course> courses, AdminCourse courseService) throws CourseException {
		// TODO Auto-generated method stub
		
		System.out.println("please enter the name of course to be deleted");
		String cName = sc.next();
		courseService.deleteProduct(cName, courses);
		
		
	}
	
	


//	private static String addBatch(Scanner sc, Map<String, Course> courses, AdminCourse courseService) throws CourseException {
//		// TODO Auto-generated method stub
//		
//		String str = null;
//		
//		System.out.println("Enter course name");
//		String cName = sc.next();
//		
//		
//		if(courses.containsKey(cName)) {
//			
//			System.out.println("Enter batch name");
//			String bName = sc.next();
//			
//			System.out.println("Enter duration of course");
//			int duration = sc.nextInt();
//			
//			System.out.println("Enter fee of course");
//			double fee = sc.nextInt();
//			
//			System.out.println("Enter start date of course");
//			String startDate = sc.next();
//			
//			System.out.println("Enter end date of course");
//			String endDate = sc.next();
//			
//			Batch obj = new Batch(bName, duration, fee, startDate, endDate);
//			List<Batch> list = new ArrayList<>();
//			
//			courses.get(cName).setBatches(list);
//			
//			System.out.println("Batch Added successfully");
//			
//		}
//		else {
//			throw new CourseException("Failed to add batch");
//		}
//		
////		Batch bat = new Batch(bName, duration, fee, startDate, endDate);
//		
////		return str = courseService.addBatch(null, bat)
//		return str;
//		
////		return bat;
//	}










	
	
	//**************************************************************************************************************//
	//                          *~*~*     S T U D E N T     D A S H B O A R D      *~*~*                            //
	//**************************************************************************************************************//
	
	public static void studentdashboard(Scanner sc, Map<String, Student> students, Map<String, Course> courses, Map<String, Batch> batches) throws InvalidDetailsException {
		
		Student std = new Student();
		StudentSE studen = new StudentServices();
		AdminCourse courseService = new AdminCourseServices();
		AdminBatch batchService = new AdminBatchService();
		
		System.out.println("please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		studentLogin(email,pass, students, studen);
		
		try {
			int choice=0;
			
			do {
				
				System.out.println("Select the option of your choice");
				System.out.println("Select 1 to update your personal details");
				System.out.println("Select 2 for change your password");
				System.out.println("Select 3 to view courses list");
				System.out.println("Select 4 to view batches list");
				System.out.println("Select 5 to enroll in course");
				System.out.println("Select 6 to logout");
				
				choice = sc.nextInt();
				
				switch(choice) {
				    
				case 1 : updatePersonalDetails(sc, students, studen);
				break;
				
				case 2 : changePassword(sc, students, std);
				break;
				
				case 3 : ViewCoursesList(courses, courseService);
				break;
				
				case 4 : viewBatchList(batches, courseService);
				break;
				
				case 5 : registerInCourse(sc, students, studen);
				break;
				
				case 6 : System.out.println("You have been successfully logged out");
				break;
				default : System.out.println("Invalid selection");
				break;
				
				}
				
			} while (choice <= 4);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	//             ***    S T U D E N T    L O G I N    ***
	public static void studentLogin(String email,String pass, Map<String, Student> students, StudentSE studen)
			throws InvalidDetailsException {
		studen.login(email, pass,students);
		System.out.println("Student has successfully login");

	}
	
	
	
	//                ***      S T U D E N T    S I G N U P    ***
	public static void studentSignup(Scanner sc, Map<String, Student> students) throws DuplicateDataException {
		
		String str = null;
		
		System.out.println("please enter the following details to Signup");
		System.out.println("please enter the user name");
		String name = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		System.out.println("enter the address");
		String address = sc.next();
		System.out.println("Enter the email id");
		String email = sc.next();
		
		Student cus = new Student(name, pass, address, email);

		StudentSE studen = new StudentServices();
		
		studen.signUp(cus, students);
		System.out.println("Student has Succefully sign up");

		
	}
	
	
	
	//                 ****     S T U D E N T     P E R S O N A L     D E T A I L S    U P D A T E    ***
	private static String updatePersonalDetails(Scanner sc, Map<String, Student> students, StudentSE studen) throws  StubNotFoundException {
		// TODO Auto-generated method stub
		
		String updResult = null;
		System.out.println("Your cannot update registered email");
		System.out.println("Enter the old email");
		String email = sc.next();
		
		System.out.println("Enter new name");
		String updName = sc.next();
		
		System.out.println("Enter new password");
		String updPassword = sc.next();
		
		System.out.println("Enter new address");
		String updAddress = sc.next();
		
		System.out.println("Enter alternate email");
		String updEmail = sc.next();
		
		Student updatedValue = new Student(updName, updPassword, updAddress, updEmail);
	
		updResult = (String) studen.updatePersonalDetails( email,updatedValue, students);
		
		return updResult;
		
	}
	
	
	
	//               ***      C H A N G E    P A S S W O R D    ***
	private static void changePassword(Scanner sc, Map<String, Student> students, Student std) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter your email");
		String email = sc.next();
		
		if(students.containsKey(email)) {
			System.out.println("Enter you old password");
			String oldpass = sc.next();
			if(students.get(email).getPassword().equals(oldpass)) {
				System.out.println("Enter new password");
				String newpass = sc.next();
				students.get(email).setPassword(newpass);
//				std.setPassword(newpass);
//				students.put(email, std);
				System.out.println("Password has been changed successfully");
			}
		}
		
	}

	
	
	//                 ****     V I E W   C O U R S E    L I S T     ***
	private static void ViewCoursesList(Map<String, Course> courses, AdminCourse courseService) throws CourseException {
		// TODO Auto-generated method stub
		
		courseService.viewAllCourses(courses);
		
	}

	
	
	//      ****      V I E W    B A T C H    L I S T    ***
	private static void viewBatchList(Map<String, Batch> batches, AdminCourse courseService) throws CourseException {
		// TODO Auto-generated method stub
		
		courseService.viewAllBatches(batches);
		
	}



	//      ****      R E G  I S T E R    I N    C O U R S E    ***
	private static void registerInCourse(Scanner sc, Map<String, Student> students, StudentSE studen) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter you email");
		String email = sc.next();
		
		if(students.containsKey(email)) {
			
			System.out.println("Enter course name");
			String cName = sc.next();
			System.out.println("Enter the batch name");
			String bName = sc.next();
			students.get(email).setCourseName(cName);
			students.get(email).setBatchName(bName);
			
			System.out.println("Congraluation! you have been successfully enrolled");
		}
		
		
		
	}








	
	
	
	//**************************************************************************************************************//
	//         *~*~*  T H E   M A I N  /  D A T A B A S E   O F   I N S T I T U T E   I S   H E R E   *~*~*         //
	//**************************************************************************************************************//
	
	public static void main(String[] args) {
		
		Map<String, Course> courses = FileExits.courseFile();
		Map<String, Student> students = FileExits.studentFile();
		Map<String, Batch> batches = FileExits.batchFile();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welecome to Bharat Institute of Technology");
		
		int input=0;
		
		try {
			int userPreference=0;
			
			do {
				System.out.println("Please Enter you Prefernce ");
			    System.out.println("'1' --> Adminstrator Login");
			    System.out.println("'2' --> Student Login");
			    System.out.println("'3' --> Student SignUp");
			    System.out.println("'0' --> Exits");
			    
				
				userPreference = sc.nextInt();
				
				switch (userPreference) {
				case 1 : admindashboard(sc, courses, students, batches);
				     break;
				     
				case 2 : studentdashboard(sc, students, courses, batches);
			     break;
			     
				case 3 : studentSignup(sc, students);
			     break;
			     
				case 0 : System.out.println("successfully existed from the system");
			     break;
					
				default:
					throw new IllegalArgumentException("Unexpected / Invalid Selection");
				}
				
			} while (userPreference!=0);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			// serialization (finally always executed)
			try {
				ObjectOutputStream cour = new ObjectOutputStream(new FileOutputStream("Course.ser"));
				cour.writeObject(courses);
				
//				ObjectInputStream cour1 = new ObjectInputStream(new FileInputStream("Course.ser"));
//				cour1.readObject();
				
				ObjectOutputStream stus = new ObjectOutputStream(new FileOutputStream("Student.ser"));
				stus.writeObject(students);
				
				
				ObjectOutputStream btc = new ObjectOutputStream(new FileOutputStream("Batch.ser"));
				btc.writeObject(batches);
				

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
	}

}
