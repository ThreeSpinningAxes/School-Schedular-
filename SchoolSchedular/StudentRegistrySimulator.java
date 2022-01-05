import java.util.ArrayList;
import java.util.Scanner;

// Name: Devrajsinh Chudasama
// StudentID: 500975539
public class StudentRegistrySimulator 
{
  public static void main(String[] args)
  {
	  //Creating registry object
	  Registry registry = new Registry();
	  
	  //Creating scanner
	  Scanner scanner = new Scanner(System.in);
	  
	  System.out.print(">");
	  
	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  // If input contains nothing, continue
		  if (command == null || command.equals("")) continue;
		  
		  // Print all students if input is l or list
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  registry.printAllStudents();
		  }
		  // Quit if input is q or quit
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
			  return;
		  
		  else if (command.equalsIgnoreCase("REG"))
		  {
			  // This command registers a student to the schools registry
			  // Takes two tokens: Student name, student Id
			  // Checks:
			  //  ensure name contains all alphabetic characters
			  //  ensure id contains all numeric characters
			  // If checks are met, student is added to registry
			if (commandLine.hasNext())
			{
				String name = commandLine.next();
				if (isStringOnlyAlphabet(name) == true)
				 {		  
					 if (commandLine.hasNext())
					 {
						 String ID = commandLine.next();
						  if (isNumeric(ID) == true)
						  {
							  registry.addNewStudent(name, ID);
						  }
						  else 
						  {
							  System.out.println(ID + " is not a valid student ID");
						  }
					 }
				  }
				  else
				  {
					  System.out.println("Illegal characters in name");
				  }
			}
		  
			
		  }
		  else if (command.equalsIgnoreCase("DEL"))
		  {
			  // For this command, delete a student from the registry
			  // Next token is taken as the students ID
			  // Ensure ID is numeric
			  // Removes student from registry
			if (commandLine.hasNext())
			{
				String studentId = commandLine.next();
				  if (isNumeric(studentId))
				  {
					  registry.removeStudent(studentId);
				  }
				  else
				  {
					  System.out.println(studentId + " is not a valid student ID");
				  }
			}

		  }
		  
		  else if (command.equalsIgnoreCase("ADDC"))
		  {
			 // For this command, adds a course to a students courses
			 // Takes two tokens: Student ID, course code
			 // Performs necessary checks for both tokens
			 // Adds the course to the students courses		  	  
			 if (commandLine.hasNext())
			 {
				 String studentId = commandLine.next();
				  
				  if (isNumeric(studentId))
				  {
					  if (commandLine.hasNext())
					  {
						  String courseCode = commandLine.next();
						  registry.addCourse(studentId, courseCode);
					  }				 
				  }
				  else 
				  {
					  System.out.println(studentId + " is not a valid student ID");
				  }
			 }
			  
		  }
		  else if (command.equalsIgnoreCase("DROPC"))
		  {
			// For this command, drops a course from a students courses 
			// Takes two tokens: Student ID, course code
			// Performs necessary checks for both tokens
			// Removes the course from the students courses	  
			  if (commandLine.hasNext())
			  {
				  String studentId = commandLine.next();
				  if (isNumeric(studentId))
				  {
					  if (commandLine.hasNext())
					  {
						  String courseCode = commandLine.next();
						  registry.dropCourse(studentId, courseCode);
					  }
				  }
				  else
				  {
					  System.out.println(studentId + " is not a valid student ID");
				  }
			  }
			   
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
			  // This command prints all active courses
			  registry.printActiveCourses();
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			  
			  // This command takes the next token as the course code and prints the courses class list
			  if (commandLine.hasNext())
			  {
				  String courseCode = commandLine.next();
				  registry.printClassList(courseCode);
			  }
			  
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
			  // For this command, next token is the course code
			  // prints the grades for this course
			  if (commandLine.hasNext())
			  {
				  String courseCode = commandLine.next();
				  registry.printGrades(courseCode);
			  }
			  
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			  // For this command, take the next token as the student id
			  // print the students courses
			  
			  if (commandLine.hasNext())
			  {
				  String studentId = commandLine.next();
				  if (isNumeric(studentId))
				  {
					  registry.printStudentCourses(studentId);
				  }
				  else
				  {
					  System.out.println(studentId + " is not a valid student ID");
				  }
			  }
  
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
			  // For this command, read the next token as the student ID
			  // prints the student's transcript			  
			  if (commandLine.hasNext())
			  {
				  String studentId = commandLine.next();
				  if (isNumeric(studentId))
				  {
					  registry.printStudentTranscript(studentId);
				  }
				  else
				  {
					  System.out.println(studentId + " is not a valid student ID");
				  }
			  }
			  
			  
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
			  // For this command, take the next three tokens as the following: Course code, student ID, numeric grade
			  // sets final grade for a student with a given course code and grade	  
			  if (commandLine.hasNext())
			  {
				  String courseCode = commandLine.next();
				  if (commandLine.hasNext())
				  {
					  String studentId = commandLine.next();
					  if (isNumeric(studentId))
					  {
						  if (commandLine.hasNext())
						  {
							  String numericGrade = commandLine.next();
							  if (isNumeric(numericGrade))
							  {
								  double grade = Double.parseDouble(numericGrade);
								  registry.setFinalGrade(courseCode, studentId, grade);
							  }
							  else
							  {
								  System.out.println("Not a numeric student grade");
							  }
						  }  
					  }
					  else
					  {
						  System.out.println(studentId + " is not a valid student ID");
					  }
				  }
				  
			  }
			  
			  
		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {
			// For this command, read next token as the course code and sort the registry's courses by name			  
			 if (commandLine.hasNext())
			 {
				 String courseCode = commandLine.next();
				 registry.sortCourseByName(courseCode);
			 }
	  
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
			// For this command, read next token as the course code and sort the registry's courses by ID			  
			  if (commandLine.hasNext())
			  {
				  String courseCode = commandLine.next();
				  registry.sortCourseById(courseCode);
			  }
		  
		  }
		  System.out.print("\n>");
	  }
  }
  
  // Check if a string only contains alphabetic characters
  private static boolean isStringOnlyAlphabet(String str) 
  { 
	  
	  // Loops through each character in string and checks the characters associated ASCII number to see if it is a letter	  
	  for (int i = 0; i < str.length(); i++)
	  {
		  if (str.charAt(i) >= 65 && str.charAt(i) <= 90 || str.charAt(i) >= 97 && str.charAt(i) <= 122)
		  {

		  }
		  else
		  {
			  return false;
		  }
	  }
	  return true;
	 
  } 
  
  // Checks if string only contains numeric characters
  public static boolean isNumeric(String str)
  {
    
	  // Tries to parse the string as a integer
	  // If it can be parsed, return true
	  // Else if a NumberFormatException error occurs, return false	  
	  try
	  {
		  int s = Integer.parseInt(str);
		  return true;
	  }
	  
	  catch (NumberFormatException a)
	  {
		  return false;
	  }
  }
  
  
}