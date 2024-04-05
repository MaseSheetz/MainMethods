package com.mycompany.groupproject;

import java.util.*;
/*
Checked ----- Your system must allow for the creation and editing of Students, Faculty, Courses,
and Semesters.

Checked ----- Your system must allow for the assignment of a Faculty to a Course in a particular
Semester.

Your system must allow for the enrollment of a Student in a Course in a particular
Semester.

Checked ----- Your system must be capable of the following, separate reports. Reports should be
printed in neat, column aligned, formatted output, business-appropriate style. For
all of these reports, you should prompt the user to make the appropriate selection
of desired Faculty member, Student, Course, or Semester:
       
    Your system must allow for the printing of a report of all Courses taught in a Semester.
    Your system must allow for the printing of all the Courses taught by a single Faculty member in a semester.
    Your system must show all Courses a Student is enrolled in for a single Semester.
    Your system must show all students enrolled in a single Course in a certain Semester.
    You are free to use standard Java arrays or the ArrayList<E> Class (Chapter 7) for this assignment.
    Your code must be suƯiciently documented with code comments throughout. You might even have team members label parts of the code they worked on in particular.
    It must have a code header at the top listing names of team members, date, and description of the system.
*/



/**
 * 
 * @author Mason Sheetz, Nick Vinh, John LaSalle
 * @date 04/04/2024
 * 
 * The main method was created by Mason and John. The methods outside of the main method were created by Mason.
 */
public class GroupProject {

    private static Student[] students = new Student[1000];
    private static Faculty[] facultyMember = new Faculty[500];
    private static Course[] course = new Course[1000];
    private static Semester[] semester = new Semester[400];
    private static int studentNumber = 1;
    private static int facultyNumber = 1;
    private static int courseNumbers = 1;
    private static int semesterNumber = 1;
    
    private static ArrayList<Student> student = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Semester> semesters = new ArrayList<>();
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Scanner scanIn;
        boolean runner = true;
        
        mainMethod();
        
        while(runner) {  
        // Main menu choice
        scanIn = new Scanner(System.in);
        int choice = scanIn.nextInt();
        switch(choice) {
          
            case 1: studentMenu();
                    int studentChoice = scanIn.nextInt();
                    switch(studentChoice)
                    {
                        // create student record
                        case 1: 
                            createStudent(scanIn);
                            studentNumber++;
                            mainMethod();
                            break;
                        // edit student record
                        case 2: 
                            printStudents(scanIn);
                            mainMethod();
                            break;
                        // enroll in class
                        case 3: break;
                        // main menu
                        case 4: 
                            mainMethod();
                            break;
                                
                    }
                    // End of student menu choice
                    break;
            // End of main menu choice    
            case 2: facultyMenu();
                    int facultyChoice = scanIn.nextInt();
                    switch(facultyChoice)
                    {
                        // create faculty record
                        case 1: 
                            createFaculty(scanIn);
                            facultyNumber++;
                            mainMethod();
                            break;
                        // edit faculty record
                        case 2: 
                            printFaculty(scanIn);
                            mainMethod();
                            break;
                        // create course record    
                        case 3: 
                            createCourse(scanIn);
                            courseNumbers++;
                            mainMethod();
                            break;
                        // edit course record
                        case 4: 
                            printCourse(scanIn);
                            mainMethod();
                            break;
                        // create semester
                        case 5: 
                            createSemester(scanIn);
                            semesterNumber++;
                            mainMethod();
                            break;
                        // edit semester
                        case 6: 
                            printSemester(scanIn);
                            mainMethod();
                            break;
                        // add faculty to couse or course to semester
                        case 7:
                            addSelected(scanIn);
                            mainMethod();
                            break;
                        case 8:
                            break;
                        // main menu
                        case 9: 
                            mainMethod();
                            break;                              
                    }
                    // End of faculty menu choice
                    break;
            // End of main menu choice
            case 3: runner = false;
                    break;
        }
        }
    }
    
    public static void mainMethod() {
        System.out.println("===========================");
        System.out.println("  Select your role:        ");
        System.out.println("  1) Student               ");
        System.out.println("  2) Faculty/Admin         ");
        System.out.println("  3) Quit                  ");
        System.out.println("===========================");
    }
    public static void facultyMenu() {
        System.out.println("===========================");
        System.out.println("  Please Select an Option  ");
        System.out.println("  1) Create Faculty Record ");
        System.out.println("  2) Edit Faculty Record   ");
        System.out.println("  3) Create Course         ");
        System.out.println("  4) Edit Course           ");
        System.out.println("  5) Create Semester       ");
        System.out.println("  6) Edit Semester         ");
        System.out.println("  7) Add Faculty to Course or Course to Semester");
        System.out.println("  8)                       ");
        System.out.println("  9) Exit to Main Menu     ");

        System.out.println("===========================");
    }
    public static void studentMenu() {
        System.out.println("===========================");
        System.out.println("  Please Select an Option  ");
        System.out.println("  1) Create Student Record ");
        System.out.println("  2) Edit Student Record   ");
        System.out.println("  3) Enroll in Class       ");
        System.out.println("  4) Exit to Main Menu     ");
        System.out.println("===========================");
    }
    
    public static void createStudent(Scanner scanIn) {
        System.out.println("===========================");
        String holder = scanIn.nextLine();
        System.out.print("Enter Name: ");
        String name = scanIn.nextLine();
        System.out.print("Enter StudentID: ");
        String id = scanIn.nextLine();
        System.out.print("Enter Social Security Number: ");
        String ssn = scanIn.nextLine();
        System.out.print("Enter Address: ");
        String address = scanIn.nextLine();
        System.out.print("Enter current GPA: ");
        double currentGPA = scanIn.nextDouble();
        System.out.println("===========================");

        students[studentNumber] = new Student(name, id, ssn, address, currentGPA);
    }  
    public static void printStudents(Scanner scanIn) {
        System.out.println("===========================");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(i + ") " + students[i].getName()
                    + ", " + students[i].getStudentID()
                    + ", " + students[i].getSocialSecurityNumber()
                    + ", " + students[i].getHomeAddress()
                    + ", " + students[i].getGPA());
            }
        }
        System.out.println("===========================");
        System.out.print("Please Select The Student Number: ");
        int chosen = scanIn.nextInt();
        System.out.println("Type What You Want to Edit: Name, StudentID, SSN, Address, GPA");
        String holder = scanIn.nextLine();
        String attribute = scanIn.nextLine();
        
        String name = "name";
        String studentID = "studentid";
        String ssn = "ssn";
        String address = "address";
        String gpa = "gpa";
        
        if (attribute.equalsIgnoreCase(name)){
            System.out.print("What Would You Like to Change the Name to?: ");
            String newName = scanIn.nextLine();
            students[chosen].setName(newName);
        }
        if (attribute.equalsIgnoreCase(studentID)){
            System.out.print("What Would You Like to Change the StudentID to?: ");
            String newID = scanIn.nextLine();
            students[chosen].setStudentID(newID);
        }
        if (attribute.equalsIgnoreCase(ssn)){
            System.out.print("What Would You Like to Change the SSN to?: ");
            String newSSN = scanIn.nextLine();
            students[chosen].setSocialSecurityNumber(newSSN);
        }
        if (attribute.equalsIgnoreCase(address)){
            System.out.print("What Would You Like to Change the Address to?: ");
            String newAddress = scanIn.nextLine();
            students[chosen].setHomeAddress(newAddress);
        }
        if (attribute.equalsIgnoreCase(gpa)){
            System.out.print("What Would You like to Change the GPA to?: ");
            double newGPA = scanIn.nextDouble();
            students[chosen].setGPA(newGPA);
        }
        
        System.out.println("===========================");
    }
    public static void enrollStudent(Scanner scanIn) {
        System.out.println("Enrolling a Student in a Course for a Specific Semester");

        // Select Student
        System.out.println("Select Student:");
        for (int i = 0; i < student.size(); i++) {
            System.out.println(i + ": " + student.get(i).getName());
        }
        int studentIndex = scanIn.nextInt();
        if (studentIndex < 0 || studentIndex >= student.size()) {
            System.out.println("Invalid Student selection.");
            return;
        }
        Student selectedStudent = student.get(studentIndex);

        // Select Course
        System.out.println("Select Course:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ": " + courses.get(i).getCourseName());
        }
        int courseIndex = scanIn.nextInt();
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid Course selection.");
            return;
        }
        Course selectedCourse = courses.get(courseIndex);

        // Select Semester
        System.out.println("Select Semester:");
        for (int i = 0; i < semesters.size(); i++) {
            System.out.println(i + ": " + semesters.get(i).getPeriod() + " " + semesters.get(i).getYear());
        }
        int semesterIndex = scanIn.nextInt();
        if (semesterIndex < 0 || semesterIndex >= semesters.size()) {
            System.out.println("Invalid Semester selection.");
            return;
        }
        Semester selectedSemester = semesters.get(semesterIndex);
// Create and add the enrollment
        Enrollment newEnrollment = new Enrollment(selectedStudent, selectedCourse, selectedSemester);
        enrollments.add(newEnrollment);
        System.out.println("Enrollment Successful!");
    }
    
    public static void createFaculty(Scanner scanIn) {
        System.out.println("===========================");
        String holder = scanIn.nextLine();
        System.out.print("Enter FacultyID: ");
        String id = scanIn.nextLine();
        System.out.print("Enter Name: ");
        String name = scanIn.nextLine();
        System.out.print("Enter Email Address: ");
        String email = scanIn.nextLine();
        System.out.print("Enter Building Name: ");
        String building = scanIn.nextLine();
        System.out.print("Enter Office Number: ");
        int officeNum = scanIn.nextInt();
        System.out.print("Enter Phone Number: ");
        int phoneNum = scanIn.nextInt();
        holder = scanIn.nextLine();
        System.out.print("Enter Department Name: ");
        String department = scanIn.nextLine();
        System.out.print("Enter Position: ");
        String position = scanIn.nextLine();
        System.out.println("===========================");

        facultyMember[facultyNumber] = new Faculty(id, name, email, building, officeNum, phoneNum, department, position);
    }
    public static void printFaculty(Scanner scanIn) {
        System.out.println("===========================");
        for (int i = 0; i < facultyMember.length; i++) {
            if (facultyMember[i] != null) {
                System.out.println(i + ") " + facultyMember[i].getName()
                    + ", " + facultyMember[i].getFacultyID()
                    + ", " + facultyMember[i].getEmailAddress()
                    + ", " + facultyMember[i].getBuildingName()
                    + ", " + facultyMember[i].getOfficeNumber()
                    + ", " + facultyMember[i].getPhoneNumber()
                    + ", " + facultyMember[i].getDepartmentName()
                    + ", " + facultyMember[i].getPosition());
            }
        }
        
        System.out.println("===========================");
        System.out.print("Please Select The Student Number: ");
        int chosen = scanIn.nextInt();
        System.out.println("Type What You Want to Edit: Name, FacultyID, Email, "
                + "Building Name, Office Number, Phone Number, Department Name, Position");
        String holder = scanIn.nextLine();
        String attribute = scanIn.nextLine();
        
        String name = "name";
        String id = "facultyid";
        String email = "email";
        String buildingName = "building name";
        String officeNum = "office number";
        String phoneNum = "phone number";
        String departmentName = "department name";
        String position = "position";
        
        
        if (attribute.equalsIgnoreCase(name)){
            System.out.print("What Would You Like to Change the Name to?: ");
            String newName = scanIn.nextLine();
            facultyMember[chosen].setName(newName);
        }
        if (attribute.equalsIgnoreCase(id)){
            System.out.print("What Would You Like to Change the FacultyID to?: ");
            String newID = scanIn.nextLine();
            facultyMember[chosen].setFacultyID(newID);
        }
        if (attribute.equalsIgnoreCase(email)){
            System.out.print("What Would You Like to Change the Email to?: ");
            String newEmail = scanIn.nextLine();
            facultyMember[chosen].setEmailAddress(newEmail);
        }
        if (attribute.equalsIgnoreCase(buildingName)){
            System.out.print("What Would You Like to Change the Building Name to?: ");
            String newBuilding = scanIn.nextLine();
            facultyMember[chosen].setBuildingName(newBuilding);
        }
        if (attribute.equalsIgnoreCase(officeNum)){
            System.out.print("What Would You like to Change the Office Number to?: ");
            int newOffice = scanIn.nextInt();
            facultyMember[chosen].setOfficeNumber(newOffice);
        }
        if (attribute.equalsIgnoreCase(phoneNum)){
            System.out.print("What Would You like to Change the Phone Number to?: ");
            int newPhoneNumber = scanIn.nextInt();
            facultyMember[chosen].setPhoneNumber(newPhoneNumber);
        }
        if (attribute.equalsIgnoreCase(departmentName)){
            System.out.print("What Would You Like to Change the Deparment Name to?: ");
            String newDepartment = scanIn.nextLine();
            facultyMember[chosen].setDepartmentName(newDepartment);
        }
        if (attribute.equalsIgnoreCase(position)){
            System.out.print("What Would You Like to Change the Position to?: ");
            String newPosition = scanIn.nextLine();
            facultyMember[chosen].setDepartmentName(newPosition);
        }
        
        System.out.println("===========================");
    }
    
    public static void createCourse(Scanner scanIn) {
        System.out.println("===========================");
        String holder = scanIn.nextLine();
        System.out.print("Enter CourseID: ");
        String courseID = scanIn.nextLine();
        System.out.print("Enter Course Prefix: ");
        String prefix = scanIn.nextLine();
        System.out.print("Enter Course Number: ");
        int num = scanIn.nextInt();
        System.out.print("Enter Course Name: ");
        String name = scanIn.nextLine();
        System.out.print("Enter How Many Days A Week: ");
        int days = scanIn.nextInt();
        System.out.print("Enter Start Time, Followed by AM or PM: ");
        String start = scanIn.nextLine();
        System.out.print("Enter End Time, Followed by AM or PM: ");
        String end = scanIn.nextLine();
        System.out.print("Enter Credit Hours: ");
        int hours = scanIn.nextInt();
        System.out.println("===========================");

        course[courseNumbers] = new Course(courseID, prefix, num, name, days, start, end, hours);
        
    }
    public static void printCourse(Scanner scanIn) {
            
        System.out.println("===========================");
        for (int i = 0; i < course.length; i++) {
            if (course[i] != null) {
                System.out.println(i + ") " + course[i].getCourseID()
                    + ", " + course[i].getCoursePrefix()
                    + ", " + course[i].getCourseNumber()
                    + ", " + course[i].getCourseName()
                    + ", " + course[i].getDaysOfWeek()
                    + ", " + course[i].getStartTime()
                    + ", " + course[i].getEndTime()
                    + ", " + course[i].getCreditHours());
            }
        }
        
        System.out.println("===========================");
        System.out.print("Please Select The Course Number: ");
        int chosen = scanIn.nextInt();
        System.out.println("Type What You Want to Edit: CourseID, Course Prefix, Course Number, Course Name"
                + "Days Of Week, Start Time, End Time, Credit Hours");
        String holder = scanIn.nextLine();
        String attribute = scanIn.nextLine();
        
        String id = "courseid";
        String prefix = "course prefix";
        String courseNum = "course number";
        String courseName = "course name";
        String days = "days of week";
        String start = "start time";
        String end = "end time";
        String credit = "credit hours";
        
        if (attribute.equalsIgnoreCase(id)){
            System.out.print("What Would You Like to Change the CourseID to?: ");
            String newID = scanIn.nextLine();
            course[chosen].setCourseID(newID);
        }
        
        if (attribute.equalsIgnoreCase(prefix)) {
            System.out.print("What Would You Like to Change the Course Prefix to?: ");
            String newprefix = scanIn.nextLine();
            course[chosen].setCoursePrefix(newprefix);
        }
        
        if (attribute.equalsIgnoreCase(courseNum)) {
            System.out.print("What Would You Like to Change the Course Number to?: ");
            int newCourseNumber = scanIn.nextInt();
            course[chosen].setCourseNumber(newCourseNumber);
        }
        
        if (attribute.equalsIgnoreCase(courseName)) {
            System.out.print("What Would You Like to Change the Course Name to?: ");
            String newName = scanIn.nextLine();
            course[chosen].setCourseName(newName);
        }
        
        if (attribute.equalsIgnoreCase(days)) {
            System.out.print("What Would You Like to Change the Number of Days to?: ");
            int newDays = scanIn.nextInt();
            course[chosen].setDaysOfWeek(newDays);
        }
        
        if (attribute.equalsIgnoreCase(start)) {
            System.out.print("What Would You Like to Change the Start Time to?: ");
            String newStart = scanIn.nextLine();
            course[chosen].setStartTime(newStart);
        }
        
        if (attribute.equalsIgnoreCase(end)) {
            System.out.print("What Would You Like to Change the End Time to?: ");
            String newEnd = scanIn.nextLine();
            course[chosen].setEndTime(newEnd);
        }
        
        if (attribute.equalsIgnoreCase(days)) {
            System.out.print("What Would You Like to Change the Credit Hours to?: ");
            int newHours = scanIn.nextInt();
            course[chosen].setCreditHours(newHours);
        }
        
        System.out.println("===========================");
    }
    
    public static void createSemester(Scanner scanIn) {
        System.out.println("===========================");
        String holder = scanIn.nextLine();
        System.out.print("Enter SemesterID: ");
        String id = scanIn.nextLine();
        System.out.print("Enter period: ");
        String period = scanIn.nextLine();
        System.out.print("Enter Year: ");
        int year = scanIn.nextInt();
        
        semester[semesterNumber] = new Semester(id, period, year);
    }
    public static void printSemester(Scanner scanIn) {
        System.out.println("===========================");
        for (int i = 0; i < semester.length; i++) {
            if (semester[i] != null) {
                System.out.println(i + ") " + semester[i].getSemesterID()
                    + ", " + semester[i].getPeriod()
                    + ", " + semester[i].getYear());
            }
        }
        
        System.out.println("===========================");
        System.out.print("Please Select The Semester Number: ");
        int chosen = scanIn.nextInt();
        System.out.println("Type What You Want to Edit: SemesterID, Period, Year");
        String holder = scanIn.nextLine();
        String attribute = scanIn.nextLine();
        
        String id = "semesterid";
        String period = "period";
        String year = "year";
        
        if (attribute.equalsIgnoreCase(id)){
            System.out.print("What Would You Like to Change the SemesterID to?: ");
            String newID = scanIn.nextLine();
            semester[chosen].setSemesterID(newID);
        }
        
        if (attribute.equalsIgnoreCase(period)){
            System.out.print("What Would You Like to Change the Period to?: ");
            String newperiod = scanIn.nextLine();
            semester[chosen].setPeriod(newperiod);
        }
        
        if (attribute.equalsIgnoreCase(year)){
            System.out.print("What Would You Like to Change the Year to?: ");
            int newYear = scanIn.nextInt();
            semester[chosen].setYear(newYear);
        }
        System.out.println("===========================");
        
    }   
    
    public static void facultySchedule(Scanner scanIn) {
    
    }
    public static void addSelected(Scanner scanIn) {
        // faculty assigned to course, course assigned to semester
        System.out.println("===========================");
        System.out.print("Do You Want To Add a Faculty Member to a Course? (y or n): ");
        String choice = scanIn.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            
            System.out.println("===========================");
            System.out.println("Select a Faculty Member: ");
            for (int i = 0; i < facultyMember.length; i++) {
                if (facultyMember[i] != null) {
                    System.out.println(i + ") " + facultyMember[i].getName()
                        + ", " + facultyMember[i].getPosition());
                }
            }
            int facultyPick = scanIn.nextInt();
                
            System.out.println("===========================");
            System.out.println("Select a Course to Add Faculty to: ");
            for (int j = 0; j < course.length; j++) {
                if (course[j] != null) {
                    System.out.println(j + ") " + course[j].getCourseID()
                        + ", " + course[j].getCoursePrefix()
                        + ", " + course[j].getCourseNumber()
                        + ", " + course[j].getCourseName()
                        + ", " + course[j].getDaysOfWeek()
                        + ", " + course[j].getStartTime()
                        + ", " + course[j].getEndTime()
                        + ", " + course[j].getCreditHours());
                }
            }
            int coursePick = scanIn.nextInt();
            
            course[coursePick].setFacultyID(facultyMember[facultyPick].getFacultyID());
            course[coursePick].setName(facultyMember[facultyPick].getName());
            course[coursePick].setPosition(facultyMember[facultyPick].getPosition());
        }
        System.out.print("Do You Want To Add a Course to a Semester? (y or n): ");
        String choice2 = scanIn.nextLine();
        if (choice2.equalsIgnoreCase("y")) {
            System.out.println("===========================");
            System.out.println("Select a Course: ");
            for (int k = 0; k < course.length; k++) {
                if (course[k] != null) {
                    System.out.println(k + ") " + course[k].getCourseID()
                        + ", " + course[k].getCoursePrefix()
                        + ", " + course[k].getCourseNumber()
                        + ", " + course[k].getCourseName()
                        + ", " + course[k].getDaysOfWeek()
                        + ", " + course[k].getStartTime()
                        + ", " + course[k].getEndTime()
                        + ", " + course[k].getCreditHours());
                }
            }
            int coursePick2 = scanIn.nextInt();
              
            System.out.println("===========================");
            System.out.println("Select a Semester to Add Course to: ");
            for (int o = 0; o < semester.length; o++) {
                if (semester[o] != null) {
                    System.out.println(o + ") " + semester[o].getSemesterID()
                        + ", " + semester[o].getPeriod()
                        + ", " + semester[o].getYear());
                }
            }
            int semesterPick = scanIn.nextInt();
            
            semester[semesterPick].setCourseID(course[coursePick2].getCourseID());
            semester[semesterPick].setCoursePrefix(course[coursePick2].getCoursePrefix());
            semester[semesterPick].setCourseNumber(course[coursePick2].getCourseNumber());
            semester[semesterPick].setCourseName(course[coursePick2].getCourseName());
            semester[semesterPick].setStartTime(course[coursePick2].getStartTime());
            semester[semesterPick].setEndTime(course[coursePick2].getEndTime());
            semester[semesterPick].setCreditHours(course[coursePick2].getCreditHours());
        }
        
        
    }
}
