import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        // Load existing data at startup
        FileManager.loadData(manager);

        int choice = -1;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        manager.addStudent(new Student(id, name, age, course, marks));
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        int sId = Integer.parseInt(sc.nextLine());
                        Student s = manager.searchById(sId);
                        if (s != null) s.displayDetails();
                        else System.out.println("❌ Student not found.");
                        break;

                    case 4:
                        System.out.print("Enter ID to update: ");
                        int uId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter New Name: ");
                        String uName = sc.nextLine();
                        System.out.print("Enter New Age: ");
                        int uAge = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter New Course: ");
                        String uCourse = sc.nextLine();
                        System.out.print("Enter New Marks: ");
                        double uMarks = Double.parseDouble(sc.nextLine());

                        manager.updateStudent(uId, uName, uAge, uCourse, uMarks);
                        break;

                    case 5:
                        System.out.print("Enter ID to delete: ");
                        int dId = Integer.parseInt(sc.nextLine());
                        manager.deleteStudent(dId);
                        break;

                    case 6:
                        FileManager.saveData(manager);
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
            }
        } while (choice != 6);

        sc.close();
    }
}