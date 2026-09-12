import java.util.ArrayList;
import java.util.List;
public class StudentManager {
    private List<Student> list = new ArrayList<>();
    public void addStudent(Student s) {
        if (searchById(s.getId()) != null) {
            System.out.println("❌ Student ID already exists!");
            return;
        }
        list.add(s);
        System.out.println("✅ Student added!");
    }
    public void viewStudents() {
        if (list.isEmpty()) {
            System.out.println("⚠️ No students found.");
            return;
        }
        for (Student s : list) {
            s.displayDetails();
        }
    }
    public Student searchById(int id) {
        for (Student s : list) {
            if (s.getId() == id) return s;
        }
        return null; }
    public void updateStudent(int id, String newName, int newAge, String newCourse, double newMarks) {
        Student s = searchById(id);
        if (s != null) {
            s.setName(newName);
            s.setAge(newAge);
            s.setCourse(newCourse);
            s.setMarks(newMarks);
            System.out.println("✅ Student updated!");
        } else {
            System.out.println("❌ Student not found!");
        }  }
    public void deleteStudent(int id) {
        Student s = searchById(id);
        if (s != null) {
            list.remove(s);
            System.out.println("✅ Student deleted!");
        } else {
            System.out.println("❌ Student not found!");
        }
    }
    public List<Student> getList() { return list; }
}