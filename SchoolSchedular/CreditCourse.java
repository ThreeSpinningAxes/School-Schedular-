public class CreditCourse extends Course
{
	
	// Name: Devrajsinh Chudasama
	// StudentID: 500975539
	
	// Private String for semester
	// Public double variable that stores grade
	// Public boolean variable to see if course if active
	private String semester;
	public double grade;
	public boolean active;
	
	// A constructor method to initialize instance variables
	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		super(name,code,descr,fmt);
		this.semester = semester;
		this.grade = grade;
	}
	
	// Returns active state credit course
	public boolean getActive()
	{
		return active;
	}
	
	// sets course to being active
	public void setActive()
	{
		active = true;
	}
	
	// sets course to being inactive
	public void setInactive()
	{
		active = false;
	}
	
	// Returns string representation of the creditcourses semester
	public String getSemester()
	{
		return semester;
	}
	
	// Displays grade for a course
	public String displayGrade()
	{
		
		// Create variable that is equal to the letter grade of the courses number grade
		// Return a string of the courses info + semester and grade
		String letterGrade = convertNumericGrade(grade);
		return getInfo() + " Semester: " + getSemester() + " Grade: " + letterGrade;
	}
	
}