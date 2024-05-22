import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    StudentsPanel studentsPanel = new StudentsPanel();
    CoursePanel coursePanel = new CoursePanel();
    EnrolPanel enrolPanel = new EnrolPanel();

    EnrolledTableModel enrolledTableModel = new EnrolledTableModel();

    JTable table2 = new JTable(enrolledTableModel);

    JButton enrollButton;

    public MainFrame() {
        init();
    }

    private void init() {



        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());


        adds(0,0,1,1,c);
        c.weighty = 5;
        this.add(studentsPanel,c);

        adds(1,0,1,1,c);
        c.weighty = 5;
        this.add(coursePanel,c);

        adds(0,1,1,1,c);
        this.add(enrollButton = new JButton("Enroll"), c);


        adds(0,2,2,1,c);
        c.weighty = 10;
        this.add(enrolPanel,c);


        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedStudentRow = studentsPanel.table.getSelectedRow();
                int selectedCourseRow = coursePanel.table2.getSelectedRow();

                if (selectedStudentRow != -1 && selectedCourseRow != -1) {
                    String studentId = (String) studentsPanel.table.getValueAt(selectedStudentRow, 0);
                    String studentName = (String) studentsPanel.table.getValueAt(selectedStudentRow, 1);
                    Student student = new Student(studentId, studentName);

                    String courseCode = (String) coursePanel.table2.getValueAt(selectedCourseRow, 0);
                    String courseName = (String) coursePanel.table2.getValueAt(selectedCourseRow, 1);
                    Course course = new Course(courseCode, courseName);

                    boolean courseFound = false;
                    for (EnrolledCourse enrolledCourse : enrolledTableModel.enrolledCourses) {
                        if (enrolledCourse.getCourse().getCourseCode().equals(courseCode)) {
                            enrolledCourse.addStudent(student);
                            courseFound = true;
                            break;
                        }
                    }

                    if (!courseFound) {
                        EnrolledCourse newEnrolledCourse = new EnrolledCourse(course);
                        newEnrolledCourse.addStudent(student);
                        enrolledTableModel.enrolledCourses.add(newEnrolledCourse);
                    }

                    enrolledTableModel.fireTableDataChanged();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a student and a course", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setTitle("Course Enrollment System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 900);
        
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);

    }
    private void adds(int gridX, int gridY, int gridWidth, int gridHeight, GridBagConstraints c){

        c.gridx = gridX;
        c.gridy = gridY;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weighty = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;

    }

}






