import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.sun.xml.internal.bind.v2.runtime.Name;

// Name: Devrajsinh Chudasama
// StudentID: 500975539
public class Registry
{
   
   // Private ArrayList that contains Student objects
   // Private ArrayList that contains ActiveCourse objects
   private ArrayList<Student>      students = new ArrayList<Student>();
   private ArrayList<ActiveCourse> courses  = new ArrayList<ActiveCourse>();
   
   public Registry()
   {
	// Add some students
	   // in A2 we will read from a file
	   Student s1 = new Student("JohnOliver", "34562");
	   Student s2 = new Student("HarryWindsor", "38467");
	   Student s3 = new Student("SophieBrown", "98345");
	   Student s4 = new Student("FaisalQuereshi", "57643");
	   Student s5 = new Student("GenghisKhan", "25347");
	   Student s6 = new Student("SherryTu", "46532");
	   students.add(s1);
	   students.add(s2);
	   students.add(s3);
	   students.add(s4);
	   students.add(s5);
	   students.add(s6);

	   
	   // Array List containing students in registry
	   ArrayList<Student> list = new ArrayList<Student>();
	   
	   //Sorting the student list alphabetically
	   Collections.sort(list);
	   
	   // Add some active courses with students
	   String courseName = "Computer Science II";
	   String courseCode = "CPS209";
	   String descr = "Learn how to write complex programs!";
	   String format = "3Lec 2Lab";
	   list.add(s2); list.add(s3); list.add(s4);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   // Add course to student list of courses
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s3.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	  
	   // CPS511
	   list.clear();
	   courseName = "Computer Graphics";
	   courseCode = "CPS511";
	   descr = "Learn how to write cool graphics programs";
	   format = "3Lec";
	   list.add(s1); list.add(s5); list.add(s6);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"F2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	   
	   // CPS643
	   list.clear();
	   courseName = "Virtual Reality";
	   courseCode = "CPS643";
	   descr = "Learn how to write extremely cool virtual reality programs";
	   format = "3Lec 2Lab";
	   list.add(s1); list.add(s2); list.add(s4); list.add(s6);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   
   }
   
   // Adds new student to the registry 
   public boolean addNewStudent(String name, String id) 
   {
	   // Created a new student object
	   // check to ensure student is not already in registry using equals method
	   // if not, add them and return true, otherwise return false
	   Student s = new Student(name,id);
	   for (Student element : students)
	   {
		   if (element.equals(s))
		   {
			   System.out.println(s.getName() + " is already registered");
			   return false;
		   }
	   }
	   
	   students.add(s);
	   return true;
   
   }
   
   // Returns ArrayList courses
   public ArrayList<ActiveCourse> getRegCourses()
   {
	   return courses;
   }
   
   // Returns ArrayList students
   public ArrayList<Student> getRegStudents()
   {
	   return students;
   }
   
   // Removes student from registry 
   public boolean removeStudent(String studentId)
   {
	   // Find student in students ArrayList by comparing students ID with the one given
	   // If found, remove this student and return true, else return false
	   
	   for (Student element : students)
	   {
		   if (element.getId().equals(studentId))
		   {
			   students.remove(element);
			   return true;
		   }
	   }
	   
	   return false;
   }
   
   // Prints all registered students
   public void printAllStudents()
   {
	   for (int i = 0; i < students.size(); i++)
	   {
		   System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName() );   
	   }
	   
   }
   
   // Given a studentId and a course code, add student to a active course
   public void addCourse(String studentId, String courseCode)
   {
	   // Find student object in registry by searching through students ArrayList
	   // Check if student has already taken this course by searching the students
	   // 	courses and seeing if any of the courses code equals the given code   
	   for (Student s : students)
	   {
		   if (s.getId().equals(studentId))
		   {
			   for (CreditCourse c : s.courses)
			   {
				   if (c.getCode().equalsIgnoreCase((courseCode)))
				   {
					   System.out.println(s.getName() + " has already took this course before.");
					   return;
				   }
			   }
			   
			// If not, then find the active course in courses ArrayList using course code
			   // If active course found then check the courses students and see if the student is in the class
			   for (ActiveCourse a : courses)
			   {
				   if (a.getCode().equalsIgnoreCase(courseCode))
				   {
					   for (Student s_AC : a.getStudents())
					   {
						   if (s_AC.equals(s))
						   {
							   System.out.println(s_AC.getName() + " has already enrolled in this course.");
							   return;
						   }  
					   }
					   // If not in the class
					   //   add student to the active course
					   //   add course to student list of credit courses with initial grade of 0
					   a.getStudents().add(s);
					   s.addCourse(a.getName(), courseCode, a.getDescription(), a.getFormat(), a.getSemester(), 0);
					   return;
				   }
			   }
			   
			   
		   }
	   }
	   
	   
	  
	   
	   
   }
   
   // Given a studentId and a course code, drop student from a active course
   public void dropCourse(String studentId, String courseCode)
   {
	   // Search active courses until the one specified is found
	   // Once found, loop through the students of that course until you find the specified student
	   // remove the active course from the student and remove the student from the active course
	   
	   for (ActiveCourse c : courses)
	   {
		   if (c.getCode().equalsIgnoreCase(courseCode))
		   {
			   for (Student s : c.getStudents())
			   {
				   if (s.getId().equals(studentId))
				   {
					   s.removeActiveCourse(courseCode);
					   c.getStudents().remove(s);
					   return;
				   }
			   }
		   }
	   }
	   System.out.println("Student not enrolled in course");
   }
   
   // Prints all active courses
   public void printActiveCourses()
   {
	   for (int i = 0; i < courses.size(); i++)
	   {
		   ActiveCourse ac = courses.get(i);
		   System.out.println(ac.getDescription());
		   System.out.println();
	   }
   }
   
   // Prints the list of students in a active course
   public void printClassList(String courseCode)
   {
	  for (ActiveCourse c : courses)
	  {
		  if (c.getCode().equalsIgnoreCase(courseCode))
		  {
			  c.printClassList();
		  }
	  }
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseByName(String courseCode)
   {
	   for (ActiveCourse c : courses)
	   {
		   if (c.getCode().equalsIgnoreCase(courseCode))
		   {
			   c.sortByName();
		   }
		  
	   }
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseById(String courseCode)
   {
	   for (ActiveCourse c : courses)
	   {
		   if (c.getCode().equalsIgnoreCase(courseCode))
		   {
			   c.sortById();
		   }
		  
	   }
   }
   
   // Given a course code, find course and print student names and grades
   public void printGrades(String courseCode)
   {
	   for (ActiveCourse c : courses)
	   {
		   if (c.getCode().equalsIgnoreCase(courseCode))
		   {
			   c.printGrades();
		   }
		  
	   }
   }
   
   // Given a studentId, print all active courses of student
   public void printStudentCourses(String studentId)
   {
	   for (Student s : students)
	   {
		   if (s.getId().equals(studentId))
		   {
			   s.printActiveCourses();
		   }
	   }
   }
   
   // Given a studentId, print all completed courses and grades of student
   public void printStudentTranscript(String studentId)
   {
	   for (Student s : students)
	   {
		   if (s.getId().equals(studentId))
		   {
			   s.printTranscript();
		   }
	   }
   }
   
   // Given a course code, student id and numeric grade, set the final grade
   public void setFinalGrade(String courseCode, String studentId, double grade)
   {
	  
	  // Search active courses until the specified course is found
	  // Once found, search through the courses students until the specified student is found
	  // Once found, search through the students courses until the specified course is found
	  // Finally once found, set grade to the one given and set the course as inactive
	   for (ActiveCourse c : courses)
	   {
		   if (c.getCode().equalsIgnoreCase(courseCode))
		   {
			   for (Student s : c.getStudents())
			   {
				   if (s.getId().equals(studentId))
				   {
					   for (CreditCourse x : s.courses)
					   {
						   if (x.getCode().equalsIgnoreCase(courseCode))
						   {
							   x.grade = grade;
							   x.setInactive();
						   }
					   }
				   }
			   }
		   }
	   }
	   
   }
  
}
