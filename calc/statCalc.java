package calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class statCalc extends JPanel implements PropertyChangeListener{

    private static JButton resetButt;

    private int str = 0;
    private int dex = 0;
    private int luk = 0;
    private int tot = 0;

    //labels for stats
    private JLabel strlabel;
    private JLabel dexlabel;
    private JLabel luklabel;
    private JLabel totlabel;

    private static String strstring = "STR";
    private static String dexstring = "DEX";
    private static String lukstring = "LUK";
    private static String totstring = "Total";

    //fields for data entry
    private JFormattedTextField strField;
    private JFormattedTextField dexField;
    private JFormattedTextField lukField;
    private JFormattedTextField totField;

    private NumberFormat strFormat;
    private NumberFormat dexFormat;
    private NumberFormat lukFormat;
    private NumberFormat totFormat;

    public statCalc(){
        super(new BorderLayout());
        setUpFormats();

        resetButt = new JButton("reset");
        resetButt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){
                strField.setValue(0);
                dexField.setValue(0);
                lukField.setValue(0);
            }

        });

        //create labels
        strlabel = new JLabel(strstring);
        dexlabel = new JLabel(dexstring);
        luklabel = new JLabel(lukstring);
        totlabel = new JLabel(totstring);

        //create text fields
        strField = new JFormattedTextField(strFormat);
        strField.setValue(str);
        strField.setColumns(10);
        strField.addPropertyChangeListener("value", this);
        
        dexField = new JFormattedTextField(dexFormat);
        dexField.setValue(dex);
        dexField.setColumns(10);
        dexField.addPropertyChangeListener("value", this);

        lukField = new JFormattedTextField(lukFormat);
        lukField.setValue(luk);
        lukField.setColumns(10);
        lukField.addPropertyChangeListener("value", this);
        
        totField = new JFormattedTextField(totFormat);
        totField.setValue(tot);
        totField.setColumns(5);
        totField.setEditable(false);
        totField.addPropertyChangeListener("value", this);

        //lay in panels
        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        labelPane.add(strlabel);
        labelPane.add(dexlabel);
        labelPane.add(luklabel);
        labelPane.add(totlabel);

        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(strField);
        fieldPane.add(dexField);
        fieldPane.add(lukField);
        fieldPane.add(totField);

        JPanel buttonPane = new JPanel(new GridLayout(0,1));
        buttonPane.add(resetButt);

        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        add(labelPane,BorderLayout.CENTER);
        add(fieldPane,BorderLayout.LINE_END);
        add(buttonPane,BorderLayout.NORTH);
    }

    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if ( source == strField){
            str = ((Number)strField.getValue()).intValue();
        } else if  (source == dexField){
            dex = ((Number)dexField.getValue()).intValue();
        } else if (source == lukField){
            luk = ((Number)lukField.getValue()).intValue();
        }

        int total = (int)((str + dex + luk) * .60); 
        totField.setValue(total);
    }

    public static void displayGUI(){
        //create the frame
        JFrame frame = new JFrame("Silly Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new statCalc());

        
        frame.pack();
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                displayGUI();
            }
        });
    }

    private  void setUpFormats(){
        strFormat = NumberFormat.getNumberInstance();
        dexFormat = NumberFormat.getNumberInstance();
        lukFormat = NumberFormat.getNumberInstance();
        totFormat = NumberFormat.getNumberInstance();

    }


}
