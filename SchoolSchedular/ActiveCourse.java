import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Name: Devrajsinh Chudasama
// StudentID: 500975539
// Active University Course
 
public class ActiveCourse extends Course
{
	// Private ArrayList containing object Students 
	// Private String for the semester
	private ArrayList<Student> students; 
	private String             semester;
	
	   
   // Add a constructor method with appropriate parameters
  
   public ActiveCourse(String name, String code, String descr, String fmt,String semester,ArrayList<Student> students)
   {
	   super(name,code,descr,fmt); 
	   this.semester = semester;
	   this.students = new ArrayList<Student>(students); // creating copy of students ArrayList
   }

   // Return string of semester
   public String getSemester() 
   {
	   return semester;
   }
   
   // Return the ArrayList of students
   public ArrayList<Student> getStudents()
   {
	   return students;
   }
   
 
   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
	  for (int i = 0; i < students.size(); i++) 
	  {
		  System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName());
	  }
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   // 
   public void printGrades()
   {
	   for (int i = 0; i < students.size(); i++) 
		  {
			  System.out.println("Name: " + students.get(i).getName() + " ID: " + students.get(i).getId() + " Grade: " + getGrade(students.get(i).getId()));
		  }
   }
   
   // Returns the numeric grade in this course for this student
   // If student not found in course, return 0 
   public double getGrade(String studentId)
   {
	   
	   // Loops through students arraylist, checks each student's ID and compares it with studentId
	   // If a student's id mathches with the one given, loop through the students credit courses
	   // If course code matches with this active courses course code, return grade
	   for (int i = 0; i < students.size(); i++)
	   {
		  if (students.get(i).getId().equals(studentId))
		  {
			  for (CreditCourse course : students.get(i).courses)
			  {
				  if (course.getCode().equalsIgnoreCase(getCode()))
				  {
					  return course.grade;
				  }
			  }
		  
		  }
	   }
	   return 0; 
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // Overrides method in the superclass Course and uses super class method getDescription()
   public String getDescription()
   {
	   return super.getDescription() + " Semester: " + getSemester() + " " + students.size();
   }
    
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Uses private Comparator class nameComparator
   public void sortByName()
   {
 	  //students.sort(c);
	   Collections.sort(students, new NameComparator());
   }
   

   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator<Student>
   {
	   public int compare(Student a, Student b) 
	    { 
	        return a.getName().compareTo(b.getName());
	    } 
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Uses a private comparator class IdComparator
   public void sortById()
   {
 	  Collections.sort(students, new IdComparator());
   }
   
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator<Student>
   {
   		public int compare(Student a, Student b)
   		{
   			return a.getId().compareTo(b.getId());
   		}
   }
}
