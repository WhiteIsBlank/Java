import java.util.Scanner;

class Student{
    private int number;
    private String name;
    private String Gender;
    private int age;
    public Student(int number,String name,String Gender,int age){
        this.number = number;
        this.name = name;
        this.Gender = Gender;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "学号："+number+" 姓名："+name + " 性别："+Gender+" 年龄："+age;
    }
}
class Add{
    public void add(int number,String name,String Gender,int age,Student[] stu,int i){
        Student student = new Student(number,name,Gender,age);
        stu[i] = student;
    }
}
class Del{
    public void del(int number,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && stu[i].getNumber() == number){
                for(int j = i;j < stu.length - 1;j++){
                    stu[j] = stu[j + 1];
                }
                stu[stu.length - 1] = null;
                break;
            }
        }
    }
    public void del(String name,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && stu[i].getName().equals(name)){
                for(int j = i;j < stu.length - 1;j++){
                    stu[j] = stu[j + 1];
                }
                i--;
                stu[stu.length - 1] = null;
            }
        }
    }
    public void del(String name,String Gender,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && stu[i].getName().equals(name) && stu[i].getGender().equals(Gender)){
                for(int j = i;j < stu.length - 1;j++){
                    stu[j] = stu[j + 1];
                }
                i--;
            }
            stu[stu.length - 1] = null;
        }
    }
}
class Modify{
    public void modify(int number,String string,int k,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && number == stu[i].getNumber()){
                if(k == 1){
                    stu[i].setName(string);//当k为1的时候为重新设置姓名
                }else{
                    stu[i].setGender(string);//当k为2的时候为重新设置性别
                }
                break;
            }
        }
    }
    public void modify(int number,int age,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && number == stu[i].getNumber()){
                stu[i].setAge(age);
                break;
            }
        }
    }
}
class Search{
    public void search(int number,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && number == stu[i].getNumber()){
                System.out.println(stu[i].toString());
                break;
            }
        }
    }
    public void search(String name,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && stu[i].getName().equals(name)){
                System.out.println(stu[i].toString());
            }
        }
    }
    public void search(String name,String Gender,Student[] stu){
        for(int i = 0;i < stu.length;i++){
            if(stu[i] != null && stu[i].getName().equals(name) && stu[i].getGender().equals(Gender)){
                System.out.println(stu[i].toString());
            }
        }
    }
}
public class StudentManagementSystem {
    public static void main(String[] args) {
        System.out.println("------------------学生管理系统---------------------");
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];//设置学生人数
        int studentCount = 0;
        int flag = 1;
        while (flag != 0) {
            System.out.println("1.添加学生信息\n2.删除学生信息\n3.修改学生信息\n4.查找学生信息\n5.打印全体学生信息\n0.退出该系统" +
                    "注：输入对应编号即可进行操作\n" +
                    "添加学生信息必须有学号、姓名、性别、年龄；\n" +
                    "删除、查找学生信息提供学号、姓名或者姓名和性别\n" +
                    "修改学生信息输入学号和修改内容，姓名/性别（1,2）或者年龄");
            flag = scanner.nextInt();
            switch (flag) {
                case 1:
                    System.out.println("请输入学生信息（学号 姓名 性别 年龄）：");
                    int number = scanner.nextInt();
                    String name = scanner.next();
                    String gender = scanner.next();
                    int age = scanner.nextInt();
                    Add add = new Add();
                    add.add(number, name, gender, age,students,studentCount);
                    studentCount++;
                    break;
                case 2:
                    System.out.println("请选择删除方式：\n1.按学号\n2.按姓名\n3.按姓名和性别");
                    int deleteOption = scanner.nextInt();
                    switch (deleteOption) {
                        case 1:
                            System.out.println("请输入要删除学生的学号：");
                            int deleteNumber = scanner.nextInt();
                            Del del = new Del();
                            del.del(deleteNumber,students);
                            break;
                        case 2:
                            System.out.println("请输入要删除学生的姓名：");
                            String deleteName = scanner.next();
                            Del del1 = new Del();
                            del1.del(deleteName, students);
                            break;
                        case 3:
                            System.out.println("请输入要删除学生的姓名和性别：");
                            String deleteNameGender = scanner.next();
                            String deleteGender = scanner.next();
                            Del del2 = new Del();
                            del2.del(deleteNameGender, deleteGender, students);
                            break;
                        default:
                            System.out.println("无效的选择，请重新输入。");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("请选择修改内容：\n1.姓名\n2.性别\n3.年龄");
                    int modifyOption = scanner.nextInt();
                    switch (modifyOption){
                        case 1:
                            System.out.println("请输入学号及修改姓名：");
                            int modifyNumber = scanner.nextInt();
                            String modifyName = scanner.next();
                            Modify modify = new Modify();
                            modify.modify(modifyNumber,modifyName,modifyOption,students);
                            break;
                        case 2:
                            System.out.println("请输入学号及修改性别：");
                            int modifyNumber1 = scanner.nextInt();
                            String modifyGender = scanner.next();
                            Modify modify1 = new Modify();
                            modify1.modify(modifyNumber1,modifyGender,modifyOption,students);
                            break;
                        case 3:
                            System.out.println("请输入学号及修改年龄：");
                            int modifyNumber2 = scanner.nextInt();
                            int modifyAge = scanner.nextInt();
                            Modify modify2 = new Modify();
                            modify2.modify(modifyNumber2,modifyAge,students);
                            break;
                    }
                    break;
                case 4:
                    System.out.println("请选择查找方式：\n1.按学号\n2.按姓名\n3.按姓名和性别");
                    int searchOption = scanner.nextInt();
                    switch (searchOption) {
                        case 1:
                            System.out.println("请输入要查找学生的学号：");
                            int searchNumber = scanner.nextInt();
                            Search search = new Search();
                            search.search(searchNumber, students);
                            break;
                        case 2:
                            System.out.println("请输入要查找学生的姓名：");
                            String searchName = scanner.next();
                            Search search1 = new Search();
                            search1.search(searchName, students);
                            break;
                        case 3:
                            System.out.println("请输入要查找学生的姓名和性别：");
                            String searchNameGender = scanner.next();
                            String searchGender = scanner.next();
                            Search search2 = new Search();
                            search2.search(searchNameGender, searchGender, students);
                            break;
                        default:
                            System.out.println("无效的选择，请重新输入。");
                            break;
                    }
                    break;
                case 5:
                    for(int i = 0; i < studentCount; i++){
                        if(students[i] != null){
                            System.out.println(students[i].toString());
                        }
                    }
                    break;

                case 0:
                    break;
                default:
                    System.out.println("无效的选择，请重新输入。");
                    break;
            }
            System.out.println("------------------------------------------------");
        }
        System.out.println("------------------学生管理系统---------------------");
    }
}
