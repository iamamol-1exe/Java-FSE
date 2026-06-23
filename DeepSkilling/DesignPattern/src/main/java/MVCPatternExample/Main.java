package MVCPatternExample;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("Amol", 101, "A");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        System.out.println("Initial Student Information:");
        controller.updateView();

        controller.setStudentName("Salmanka");
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Student Information:");
        controller.updateView();
    }
}