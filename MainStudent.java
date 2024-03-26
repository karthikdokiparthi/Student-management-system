import java.util.*;

class MainStudent{
    StudentInfo stu=new StudentInfo();
    static boolean ordering=true;
    public static void menu(){
        System.out.println("1.Add Student Info");  
        System.out.println("2.View Info");
        System.out.println("3.Update Info");
        System.out.println("4.Delete Student Info"); 
        System.out.println("5.View All Info");
        System.out.println("6.Exit");
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        StudentInfo stu=new StudentInfo();
        do{
            menu();
            System.out.print("Enter your choise:");
            int Num=sc.nextInt();
            switch(Num){
                case 1:
                System.out.println("Add Student Info");
                stu.addStudent();
                break;
                case 2:
                System.out.println("View Info");
                stu.viewStudents();
                break;
                case 3:
                System.out.println("Update Info");
                stu.updateStudent();
                break;
                case 4:
                System.out.println("Delete Info");
                stu.deleteStudent();
                break;
                case 5:
                System.out.println("View All Info");
                stu.viewallStudents();
                break;
                case 6:
                System.out.println("Thank you for Using");
                System.exit(0);
                break;
                default:
                System.out.println("Please enter valid choice");
            }
        }while(ordering);
    }
}
class StudentInfo{
    boolean found=false;
    int id;
    String Name;
    int Age;
    String Branch;
    int Fee;
    Scanner sc=new Scanner(System.in);
    HashSet<Student> stuset=new HashSet<Student>();

    Student stuset1=new Student(101,"Rama Lakshimi","CSE",50000);
    Student stuset2=new Student(102,"Karthik","CSE",50000);
    Student stuset3=new Student(103,"Lavanya","CSE",50000);
    Student stuset4=new Student(104,"Lakshmi","CSE",50000);
    
    public StudentInfo(){ 
        stuset.add(stuset1);
        stuset.add(stuset1);
        stuset.add(stuset2);
        stuset.add(stuset3);
        stuset.add(stuset4);
    }
    public void viewallStudents(){
        for(Student stu:stuset){
            System.out.println(stu);
        }
    }
    public void viewStudents(){
        System.out.print("Enter Id: ");
        id=sc.nextInt();
        for(Student stu:stuset){
            if(stu.getId()==id){
                System.out.println(stu);
                found=true;
            }
        }
        if(!found){
            System.out.println("Student with this id is not Present");
        }
    }
    public void updateStudent(){
        System.out.print("Enter Id: ");
        id=sc.nextInt();
        for(Student stu:stuset){
            if(stu.getId()==id){
                System.out.print("Enter name: ");
                Name=sc.next();
                System.out.print("Enter Branch: ");
                Branch=sc.next();
                System.out.print("Enter Fee: ");
                Fee=sc.nextInt();
                stu.setName(Name);
                stu.setBranch(Branch);
                stu.setFee(Fee);
                System.out.println("Updated Details of Student are: ");
                System.out.println(stu);
                found=true;
            }
        }
            if(!found){
            System.out.println("Student is not Present");
            }
            else
                System.out.println("Update Successfully");
        }
        public void deleteStudent(){
        System.out.println("Enter id");
        id=sc.nextInt();
        boolean found=false;
        Student studelete=null;
        for(Student stu:stuset){
            if(stu.getId()==id){
                studelete=stu;
                found=true;
            }
        }
        if(!found){
            System.out.println("Student is not Present");
        }
        else{
            stuset.remove(studelete);
            System.out.println("Student Delete Successfully");
        }
        }
        public void addStudent(){
            System.out.println("Enter id: ");
            id=sc.nextInt();
            System.out.println("Enter Name: ");
            Name=sc.next();
            System.out.println("Enter Branch: ");
            Branch=sc.next();
            System.out.println("Enter Fee: ");
            Fee=sc.nextInt();

            Student stu=new Student(id,Name,Branch,Fee);
            stuset.add(stu);
            System.out.println(stu);
            System.out.println("Student Added Successfully");
        }
    }
    class Student{
    int Id;
    String Name;
    String Branch;
    int Fee;
    public Student(int Id,String Name,String Branch,int Fee){
        this.Id=Id;
        this.Name=Name;
        this.Branch=Branch;
        this.Fee=Fee;
    }
    public int getId(){
        return Id;
    }
    public void setId(int Id){
        this.Id=Id;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getNBranch(){
        return Branch;
    }
    public void setBranch(String Branch){
        this.Branch=Branch;
    }
    public int getFee(){
        return Id;
    }
    public void setFee(int Fee){
        this.Fee=Fee;
    }
    public String toString(){
        return "Id: "+Id+" "+"Name: "+Name+" "+"Branch: "+Branch+" "+"Fee: "+Fee;
        
    }
}
class StudentManagementSystem {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void viewStudents() {
        students.forEach(System.out::println);
    }


    public void updateStudent(int id, String newName, String newBranch,int newFee) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setBranch(newBranch);
                s.setFee(newFee);
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public Student searchStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}
    