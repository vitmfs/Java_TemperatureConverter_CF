import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class TemperatureConverter extends JFrame {
    
    // DECLARE AND CREATE COMPONENTS
    JLabel myJLabelTypeConversion = new JLabel("Type of conversion");
    
    JRadioButton myJRadioButton_CF = new JRadioButton("ºC-ºF");
    
    JRadioButton myJRadioButton_FC = new JRadioButton("ºF-ºC");
    
    ButtonGroup myButtonGroup = new ButtonGroup();
    
    JPanel myJPanel = new JPanel();
    
    JLabel myJLabelValueToConvert = new JLabel("Value to convert");
    
    JTextField myJTextFieldValue = new JTextField(5);
    
    JButton myJButtonConverter = new JButton("Converter");
    
    // CONSTRUCTOR
    private TemperatureConverter() {
        
        setTitle("Temperature Converter");
        setSize(280, 130);
        setLocation(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 1, 5));
        setVisible(true);
        
        add(myJLabelTypeConversion);
        myJPanel.setLayout(new GridLayout(1, 2));
        myJPanel.add(myJRadioButton_CF);
        myJPanel.add(myJRadioButton_FC);
        add(myJPanel);
        add(myJLabelValueToConvert);
        add(myJTextFieldValue);
        add(myJButtonConverter);
        
        
        myButtonGroup.add(myJRadioButton_CF);
        myButtonGroup.add(myJRadioButton_FC);
        
        myJButtonConverter.addActionListener(new EventJButton());
        
        
    }
    
    public static void main(String[] args) {
        
        new TemperatureConverter();
        
    }
    
    private class EventJButton implements ActionListener {
        
        public void actionPerformed(ActionEvent ev) {
            
            double result = 0;
            String message = "";
            
            if (myJRadioButton_CF.isSelected()) {

                //JOptionPane.showMessageDialog(null, "Something Happened");
                
                result = Double.parseDouble(myJTextFieldValue.getText()) * 9/5 + 32;
                
                result = Math.round(result);
                
                message = myJTextFieldValue.getText() + "ºC is approximately" + Double.toString(result) + " ºF";
                

                
            } else if (myJRadioButton_FC.isSelected()) {
                
                //JOptionPane.showMessageDialog(null, "Something Happened");

                result = (Double.parseDouble(myJTextFieldValue.getText()) - 32) * 5/9;
                
                result = Math.round(result);
                
                message = myJTextFieldValue.getText() + "ºF is approximately" + Double.toString(result) + " ºC";
                

                
            } else {
                
                message = "Please check an option and enter a value";
                
                
            }
            
            myJTextFieldValue.setText("0.0");
            
            JOptionPane.showMessageDialog(null, message);
        }
    }
    
    
}
