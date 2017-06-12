/*By: Tyrone Bacchus
 *Course: ICS 4U1
 *Teacher: Mr. Ryan
 *Due: Thursday, December 22, 2011*/

 import javax.swing.*;	//for the frame
 import java.awt.*;	//for the graphics
 import java.awt.event.*;	//for the interacting events
 import java.io.*;		//for input/output exceptions

public class PrimeCheckerGUI extends JFrame
{
	private JLabel lblPrompt = new JLabel("Enter a positive integer:");
	private JLabel lblResults = new JLabel("Results");
	private JLabel lblTime = new JLabel("");

	private JCheckBox chkInfo = new JCheckBox("View prime numbers next time");

	private JButton btnClick = new JButton("Check Method-->");
	private JButton btnQuit = new JButton("Quit");

	private JTextField txtPrompt = new JTextField("10000");
	private JTextArea txtResults = new JTextArea("");

	private JRadioButton radMethodOne = new JRadioButton("First Method");
	private JRadioButton radMethodTwo = new JRadioButton("Second Method");
	private ButtonGroup grpOrganize = new ButtonGroup();

	private JMenuItem mnuClick = new JMenuItem("Check Method");
	private JMenuItem mnuClear = new JMenuItem("Clear");
	private JMenuItem mnuHelp = new JMenuItem("Help");
	private JMenuItem mnuAbout = new JMenuItem("About");
	private JMenuItem mnuQuit = new JMenuItem("Quit");

	public static void main(String[] Tyrone)
	{
		JOptionPane.showMessageDialog(null, "Project: PrimeCheckerGUI\n"
											+ "By: Tyrone Bacchus\n" + "Teacher: Mr. Ryan\n"
											+ "Course: ICS 4U1\n" + "Due: Thursday, December 22, 2011\n\n"
											+ "This program tests the efficiency of 2 prime checker methods.\n");

		PrimeCheckerGUI window = new PrimeCheckerGUI();
		window.setTitle("(Mr. Ryans's)Prime Checker GUI: By Tyrone Bacchus");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
	}

    public PrimeCheckerGUI()
    {
    	JMenu fileMenu = new JMenu("File");
		fileMenu.add(mnuClick);
		fileMenu.add(mnuClear);
		fileMenu.add(mnuHelp);
		fileMenu.add(mnuAbout);
		fileMenu.add(mnuQuit);

		JMenuBar bar= new JMenuBar();
		bar.add(fileMenu);
		setJMenuBar(bar);

		lblTime.setVisible(false);

		txtPrompt.setHorizontalAlignment(JTextField.CENTER);
		txtPrompt.setColumns(8);

		txtResults.setEnabled(false);
		txtResults.setLineWrap(true);
		txtResults.setWrapStyleWord(true);
		txtResults.setDisabledTextColor(Color.black);

		grpOrganize.add(radMethodOne);
		grpOrganize.add(radMethodTwo);
		radMethodOne.setSelected(true);

		btnClick.setMnemonic(KeyEvent.VK_SPACE);		mnuClick.setMnemonic(KeyEvent.VK_SPACE);
		btnQuit.setMnemonic(KeyEvent.VK_Q);				mnuQuit.setMnemonic(KeyEvent.VK_Q);

		JScrollPane scroll = new JScrollPane(txtResults);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(256, 128));

		JPanel promptPanel = new JPanel();
		promptPanel.add(lblPrompt);
		promptPanel.add(txtPrompt);

		JPanel resultPanel = new JPanel(new GridLayout(3, 1));
		resultPanel.add(lblResults);
		resultPanel.add(scroll);
		resultPanel.add(lblTime);

		JPanel choicePanel = new JPanel(new GridLayout(2, 2));
		choicePanel.add(radMethodOne);
		choicePanel.add(radMethodTwo);
		choicePanel.add(chkInfo);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnQuit);
		buttonPanel.add(btnClick);

		JPanel topPanel = new JPanel();
		topPanel.add(promptPanel);
		topPanel.add(choicePanel);

		Container pane = this.getContentPane();
		pane.add(topPanel, BorderLayout.NORTH);
		pane.add(resultPanel, BorderLayout.CENTER);
		pane.add(buttonPanel, BorderLayout.SOUTH);

		btnClick.addActionListener(new ClickListener());
		mnuClick.addActionListener(new ClickListener());
		btnQuit.addActionListener(new QuitListener());
		mnuQuit.addActionListener(new QuitListener());
		mnuAbout.addActionListener(new AboutListener());
		mnuHelp.addActionListener(new HelpListener());
		mnuClear.addActionListener(new ClearListener());
    }

    private class ClickListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
		{
			txtResults.setText("");
			lblTime.setVisible(false);

			if(radMethodOne.isSelected() && chkInfo.isSelected())
	    	{
	    		long startTime = System.nanoTime();
	    		txtResults.setText(methodOne(true));
	    		long elapsedTime = System.nanoTime() - startTime;
	    		double eT = (double)elapsedTime;
	    		lblTime.setText(String.format("The amount of nanoseconds the first method took is %.2e.", eT));
	    		if(!(txtResults.getText().equals("")))
	    			lblTime.setVisible(true);
	    	}
	    	else if(radMethodOne.isSelected())
	    	{
	    		long startTime = System.nanoTime();
	    		txtResults.setText(methodOne(false));
	    		long elapsedTime = System.nanoTime() - startTime;
	    		double eT = (double)elapsedTime;
	    		lblTime.setText(String.format("The amount of nanoseconds the first method took is %.2e.", eT));
	    		if(!(txtResults.getText().equals("")))
	    			lblTime.setVisible(true);
	    	}
	    	else if(radMethodTwo.isSelected() && chkInfo.isSelected())
	    	{
	    		long startTime = System.nanoTime();
	    		txtResults.setText(methodTwo(true));
	    		long elapsedTime = System.nanoTime() - startTime;
	    		double eT = (double)elapsedTime;
	    		lblTime.setText(String.format("The amount of nanoseconds the second method took is %.2e.", eT));
	    		if(!(txtResults.getText().equals("")))
	    			lblTime.setVisible(true);
	    	}
	    	else
	    	{
	    		long startTime = System.nanoTime();
	    		txtResults.setText(methodTwo(false));
	    		long elapsedTime = System.nanoTime() - startTime;
	    		double eT = (double)elapsedTime;
	    		lblTime.setText(String.format("The amount of nanoseconds the second method took is %.2e.", eT));
	    		if(!(txtResults.getText().equals("")))
	    			lblTime.setVisible(true);
	    	}
		}

    }

    private class QuitListener implements ActionListener	//to exit
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	private class AboutListener implements ActionListener	//basic info
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "Project: PrimeCheckerGUI\n"
											+ "By: Tyrone Bacchus\n" + "Teacher: Mr. Ryan\n"
											+ "Course: ICS 4U1\n" + "Due: Thursday, December 22, 2011\n\n"
											+ "This program tests the efficiency of 2 prime checker methods.\n");
		}
	}

	private class HelpListener implements ActionListener	//for the mentally....
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "Enter a positive integer to proceed");
		}
	}

	private class ClearListener implements ActionListener	//clears the fields....
	{
		public void actionPerformed(ActionEvent e)
		{
			txtPrompt.setText("");
			txtResults.setText("");
			lblTime.setVisible(false);
		}
	}

	public String methodOne(boolean info)
	{
		int numberOfPrimes = 0;
		int upperLimit;

		String primeString = new String("");

		boolean prime = true;

		try
		{
			upperLimit = Integer.parseInt((txtPrompt.getText()).trim());

			if(upperLimit < 1)
			{
				int destroy = 1 / 0;
			}

			for(int out = 2; out <= upperLimit; out++)
			{
				prime = true;

				for(int in = 2; in <= (int)(Math.sqrt(out)); in++)
				{
					if(out % in == 0)
					{
						prime = false;
						break;
					}
				}

				if(prime)
				{
					if(info)
						primeString += out + "\t";

					numberOfPrimes++;
				}
			}

			primeString += "\nThere are " + numberOfPrimes + " prime numbers between 1 and "
							+ upperLimit + ", inclusive.";

			return primeString;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Enter a positive integer to proceed");
		}
		return "";
	}

	public String methodTwo(boolean info)
	{
		int numberOfPrimes = 0;
		int upperLimit;

		String primeString = new String("");

		boolean prime = true;
		boolean allNumbers[];

		try
		{
			upperLimit = Integer.parseInt((txtPrompt.getText()).trim());
			allNumbers = new boolean[upperLimit];

			if(upperLimit < 1)
			{
				int destroy = 1 / 0;
			}

			for(int out = 2; out <= upperLimit; out++)
			{
				if(allNumbers[out - 1] == false)
				{
					if(info)
						primeString += out + "\t";

					numberOfPrimes++;

					for(int in = out; in <= (int)(upperLimit / out); in++)
					{
						allNumbers[out * in - 1] = true;
					}
				}
			}

			primeString += "\nThere are " + numberOfPrimes + " prime numbers between 1 and "
							+ upperLimit + ", inclusive.";

			return primeString;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Enter a positive integer to proceed");
		}
		return "";
	}
}