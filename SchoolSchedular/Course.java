// Name: Devrajsinh Chudasama
// StudentID: 500975539

public class Course 
{
	// Instance variables for class course
	private String code;
	private String name;
	private String description;
	private String format;
	   
	// Defaults constructor method
	public Course()
	{
	  this.code        = "";
	  this.name        = "";
	  this.description = "";
	  this.format      = "";
	}
	   
	// Constructor method for initializing instance variables to specific values
	public Course(String name, String code, String descr, String fmt)
	{
	  this.code        = code;
	  this.name        = name;
	  this.description = descr;
	  this.format      = fmt;
	}
	   
	// Returns course code
	public String getCode()
	{
	   return code;
	}
	   
	// Returns course name
	public String getName()
	{
	  return name;
	}
	   
	// Returns format
	public String getFormat()
	{
	  return format;
	}
	
	// Returns course code + name + description formated
	public String getDescription()
	{
	  return code +" - " + name + "\n" + description + "\n" + format;
	}
	
	// Returns course code + name
	public String getInfo()
	 {
	   return code +" - " + name;
	 }
	 
	 // static method to convert numeric score to letter grade string 
	 // e.g. 91 --> "A+"
	 public static String convertNumericGrade(double score)
	 {
		 // fill in code
		 if (score >= 90)
		 {
			 return "A+";
		 }
		 if (score >= 85 && score <=89)
		 {
			 return "A";
		 }
		 else if (score >= 80 && score <= 84)
		 {
			 return "A-";
		 }
		 else if (score >= 77 && score <= 79)
		 {
			 return "B+";
		 }
		 else if (score >= 73 && score <= 76)
		 {
			 return "B";
		 }
		 else if (score >= 70 && score <= 72)
		 {
			 return "B-";
		 }
		 else if (score >= 67 && score <= 69)
		 {
			 return "C+";
		 }
		 else if (score >= 63 && score <= 66)
		 {
			 return "C";
		 }
		 else if (score >= 60 && score <= 62)
		 {
			 return "C-";
		 }
		 else if (score >= 57 && score <= 59)
		 {
			 return "D+";
		 }
		 else if (score >= 53 && score <= 56)
		 {
			 return "D";
		 }
		 else if (score >= 50 && score <= 52)
		 {
			 return "D-";
		 }
		 else
		 {
			 return "F";
		 }
		 
	 }
	 
}
