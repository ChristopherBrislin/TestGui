import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Christopher Brislin 
 * 2 Jun 2020 
 * ProjectSix
 */

public class Front {

	JFrame frame = new JFrame(); // Instantiate the frame.

	JLabel firstName = new JLabel("First name:"); // Instantiate the labels.
	JLabel lastName = new JLabel("Last name:");
	JLabel data = new JLabel();
	
	
	JTextField firstNameText = new JTextField(25); // Instantiate the text fields.
	JTextField lastNameText = new JTextField(25);
	
	JPanel firstNamePanel = new JPanel(); // Instantiate some JPanels to help the component layout.
	JPanel lastNamePanel = new JPanel();
	JPanel namePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	/**
	 * Instantiate 2 Radio Buttons for the user to select their age group
	 * and a submit button. The Radio Buttons are added to a Button Group
	 * so the age group selection is exclusive.
	 */

	JRadioButton childCheck = new JRadioButton("Under 18.", false); 
	JRadioButton adultCheck = new JRadioButton("18 and older.", false);
	JButton submit = new JButton("Submit");
	ButtonGroup bgroup = new ButtonGroup();
	



	public static void main(String[] args) {
		
		/**
		 * Instantiate and start the program. 
		 */
		Front frontGUI = new Front();
		frontGUI.start();
	}

	public void start() {

	
		
		/**
		 * Setting the layouts for the panels.
		 */

		firstNamePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
		lastNamePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bgroup.add(childCheck); //Adding the Radio buttons to the group.
		bgroup.add(adultCheck);

		firstNamePanel.add(firstName); //Adding the text fields to their respective panels.
		firstNamePanel.add(firstNameText);
		lastNamePanel.add(lastName);
		lastNamePanel.add(lastNameText);

		namePanel.add(firstNamePanel); //Adding the panels to another panel to maintain a stacked layout.
		namePanel.add(lastNamePanel);

		submit.addActionListener(new submitListener()); //Action Listener on the submit button.

		buttonPanel.add(childCheck); //Add the buttons to the button panel.
		buttonPanel.add(adultCheck);
		buttonPanel.add(submit);

		firstNameText.requestFocus(); //Set the cursor in the first text field.

		frame.getContentPane().add(BorderLayout.NORTH, namePanel); // Add the panels to the frame.
		frame.getContentPane().add(BorderLayout.WEST, buttonPanel);

		frame.setSize(500, 300); //Set the size of the frame and display the content.
		frame.setVisible(true);

	}
	
	/**
	 * Inner class for the submit button in the event that more action listeners are added.
	 *
	 */

	public class submitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			/**
			 * Get the content of text fields and add them to some 
			 * Strings. Check that the text fields are not empty - 
			 * if they are then generate a JOptionPane prompt. Then 
			 * check if an age group has been selected and return a 
			 * prompt if not. 
			 */
			
			String fName = new String (firstNameText.getText());
			String lName = new String (lastNameText.getText());
			//String dataStr = new String();

			if (fName.length() != 0 && lName.length() != 0) {
				if (!childCheck.isSelected() && !adultCheck.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Please select age group.");
				} else if (childCheck.isSelected()) {
					
					/**
					 * Add results to the data Label, which is then added to
					 * the button panel. The frame is then re-drawn with the 
					 * added content.
					 */
					
					data.setText(fName + " " + lName + " is a child.");
					buttonPanel.add(data);
					frame.setVisible(true);

				}

				else if (adultCheck.isSelected()) {

					data.setText(fName + " " + lName + " is an adult.");
					buttonPanel.add(data);
					frame.setVisible(true);
				}

			} else {
				JOptionPane.showMessageDialog(frame, "Please enter a name.");
			}

		}
	}

}
