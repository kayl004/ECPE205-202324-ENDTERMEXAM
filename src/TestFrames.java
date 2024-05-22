import javax.swing.*;

public class TestFrames {
    public static void main(String[] args) {

        /**
         *
         * FOR TESTING PURPOSES
         */

        //display whole frame
//        new MainFrame();

        //display only studnets frame
        JFrame studentsFrame = new JFrame();
        studentsFrame.add(new StudentsPanel());
        studentsFrame.pack();
        studentsFrame.setVisible(true);
        studentsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //display course frame
//        JFrame courseFrame = new JFrame();
//        courseFrame.add(new CoursePanel());
//        courseFrame.pack();
//        courseFrame.setVisible(true);
//        JFrame studentsFrame = new JFrame();
//        studentsFrame.add(new StudentsPanel());
//        studentsFrame.pack();
//        studentsFrame.setVisible(true);


        //display course frame
        JFrame courseFrame = new JFrame();
        courseFrame.add(new CoursePanel());
        courseFrame.pack();
        courseFrame.setVisible(true);
        courseFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
