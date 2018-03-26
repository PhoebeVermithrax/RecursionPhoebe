/*
 * Created by: Phoebe Vermithrax
 * Created on: 26-March-2018
 * Created for: ICS4U
 * Daily Assignment – Day #24
 * This program allows the user to input a string and, using recursion, reverses the string and outputs it to the user.
*/ 

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
//import javax.swing.jOptionPane.
import javax.swing.JOptionPane;

public class Recursion {

	protected Shell shell;
	private Text txtString;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Recursion window = new Recursion();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//Create a function that will flip the string.
	//code is from: https://www.youtube.com/watch?v=Emv1zODKYgc
	public static String Reverse(String str)
	{
		//If the length of the string is less than or equal to one, return it.
		if (str.length() <= 1)
		{
			return str;
		}
		//If the string is greater than 1,
		else 
		{
			//Call the function within itself, creating a substring of the string, starting at one and going through the length, and then putting it at 0.
			return Reverse(str.substring(1, str.length())) + str.charAt(0);
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(407, 300);
		shell.setText("Recursion");
		
		txtString = new Text(shell, SWT.BORDER);
		txtString.setBounds(10, 24, 371, 21);
		
		Button btnReverse = new Button(shell, SWT.NONE);
		btnReverse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Create variable to collect data.
				String user;
				
				//Collect info from text box.
				user = txtString.getText();
				
				//Pass the user to the function, Reverse, and output it into s message box.
				JOptionPane.showMessageDialog(null, Reverse(user));
			}
		});
		btnReverse.setBounds(10, 51, 371, 25);
		btnReverse.setText("Reverse");

	}
}
