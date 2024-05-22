import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {

    JLabel courseLabel, codeLabel;
    JTextField courseField,codeField;
    JButton addButton;
    JTable table2;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;


    public CoursePanel(){
        init();
    }

    private void init(){

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        String [] nameColumn2 = {"Code","Name"};
        tableModel = new DefaultTableModel(nameColumn2,0 );

        add(0,0,1,1,c);
        this.add(courseLabel = new JLabel("Course Name:"),c);

        add(1,0,1,1,c);
        this.add(courseField = new JTextField(10),c);

        add(0,1,1,1,c);
        this.add(codeLabel = new JLabel("Course Code:"),c);

        add(1,1,1,1,c);
        this.add(codeField = new JTextField(10),c);

        add(1,2,1,1,c);
        this.add(addButton = new JButton("Add"),c);

        add(0,3,2,1,c);
        c.weighty = 10;
        this.add(table2 = new JTable(tableModel),c);
        scrollPane = new JScrollPane(table2);
        this.add(scrollPane,c);

//        pack();
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = courseField.getText();
                String name = codeField.getText();
                String [] container ={id, name};

                if(id.isEmpty() || name.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fill in all fields","ERROR",JOptionPane.ERROR_MESSAGE);

                }else{
                    //String[] container = {id, name};
                    // tableModel.addRow(new Object[]);
                    tableModel.addRow(container);
                    courseField.setText("");
                    codeField.setText("");


                }
            }
        });


    }
    private static void add(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c){

        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

    }
}