import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EnrolPanel extends JPanel {

    JTable table3;

    JScrollPane scrollPane3;

    DefaultTableModel tableModel2;


    public EnrolPanel (){
        init();
    }
    private void init(){

        String [] ColumnNames2  = { "Code", "Name", "Enrollees","No. of Students"};

        tableModel2 = new DefaultTableModel(ColumnNames2,0);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        adds(0,0,1,1,c);
        this.add(table3 = new JTable(tableModel2),c);
        c.weighty = 10;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        scrollPane3 = new JScrollPane(table3);

        this.add(scrollPane3,c);
        this.setVisible(true);



    }
    private void adds(int gridX, int gridY, int gridWidth, int gridHeight, GridBagConstraints c){

        c.gridx = gridX;
        c.gridy = gridY;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.fill = GridBagConstraints.BOTH;


    }

}
