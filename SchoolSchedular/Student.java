import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Name: Devrajsinh Chudasama
// StudentID: 500975539
// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student implements Comparable<Student>
{
  
	// Private variables for student name and ID
	// Public ArrayList for student that contains CreditCourse objects
  private String name;
  private String id;
  public  ArrayList<CreditCourse> courses;
  
  
  //Constuctor method to initialize instance variables
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  // Returns string of students ID
  public String getId()
  {
	  return id;
  }
  
  // Returns string of students name
  public String getName()
  {
	  return name;
  }
  
  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
	  // creates a CreditCourse object
	  // sets course active
	  // adds new course to courses array list
	  
	  CreditCourse newCourse = new CreditCourse(courseName,courseCode,descr,format,sem,grade);
	  newCourse.setActive();
	  courses.add(newCourse);

  }
  
  
  
  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade 
  public void printTranscript()
  {
	  
	  // Loops through all the students courses
	  // If course is inactive, print the students grade for that course
	  // Using method from class CreditCourse
	  for (CreditCourse course : courses)
	  {
		  if (course.getActive() == false)
		  {
			  System.out.println(course.displayGrade());
		  }
	  }
  }
  
  // Prints all active courses this student is enrolled in 
  public void printActiveCourses()
  {
	// Loops through all the students courses
	// If course is inactive, print the students info for that course
	// Using method from class Course
	  for (CreditCourse course : courses)
	  {
		  if (course.getActive() == true)
		  {
			  System.out.println(course.getInfo());
		  }
	  }
  }
  
  //Method used to compare two students names for alphabetical order
  public int compareTo(Student b)
  	{
  		return this.getName().compareTo(b.getName());
  	}

  // Drop a course (given by courseCode)
  // Find the credit course in courses arraylist above and remove it
  // only removes it if it is an active course
  public void removeActiveCourse(String courseCode)
  {
	  for (CreditCourse course : courses)
	  {
		  if (course.getCode().equalsIgnoreCase(courseCode) && course.getActive() == true)
		  {
			  courses.remove(course);
		  }
	  }
  }
  
  // ToString method that returns a String of the student ID + name
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  
  // override equals method inherited from superclass Object
  // if student names are equal and student ids are equal then return true

  public boolean equals(Object other)
  {
	  // Check if objects are instances of eachother
	  // Create student object of object parameter
	  // Check if both objects names and id are equal to each other
	  if (this.getClass() == other.getClass())
	  {
		  Student temp = (Student) other;
		  
		  if (this.getName().contentEquals(temp.getName()) && this.getId().contentEquals(temp.getId()))
		  {
			  return true;
		  }
	  }
	  return false;
  }
  
}
