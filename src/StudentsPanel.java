import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {

    JLabel studLabel, NameL;
    JTextField studField,nameField;
    JButton addButton, enrollButton;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;

    public StudentsPanel () {
        init();
    }

    private void init(){

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        String [] nameColumn = {"I.D","Name"};
        tableModel = new DefaultTableModel(nameColumn,0 );

        add(0,0,1,1,c);
        this.add(studLabel = new JLabel("Student I.D:"),c);

        add(1,0,1,1,c);
        this.add(studField = new JTextField(15),c);

        add(0,1,1,1,c);
        this.add(NameL = new JLabel("Name:"),c);

        add(1,1,1,1,c);
        this.add(nameField = new JTextField(15),c);

        add(1,2,1,1,c);
        this.add(addButton = new JButton("Add"),c);

        add(0,3,2,1,c);
        c.weighty = 10;
        this.add(table = new JTable(tableModel),c);

        scrollPane = new JScrollPane(table);
        this.add(scrollPane,c);
//        this.pack();
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studField.getText();
                String name = nameField.getText();
                String [] container ={id, name};

                if(id.isEmpty() || name.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fill in all fields","ERROR",JOptionPane.ERROR_MESSAGE);

                }else{
                    //String[] container = {id, name};
                    // tableModel.addRow(new Object[]);
                    tableModel.addRow(container);
                    studField.setText("");
                    nameField.setText("");

                }
            }
        });





    }
    private static void add(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c){
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

    }
}
