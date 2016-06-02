/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;

/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class GUISimulator extends JFrame implements Runnable,ActionListener {
	
	static GUISimulator GUI;
	
	//Simulation Heading
	private JLabel simHeader;
	
	private JLabel rngText;
	private JLabel dmeanText;
	private JLabel qsizeText;
	private JLabel cancelText;
	
	private JTextField rngField;
	private JTextField dmeanField;
	private JTextField qsizeField;
	private JTextField cancelField;
	
	//Fare Classes Heading
	private JLabel fareHeader;
	
	private JLabel firstText;
	private JLabel businessText;
	private JLabel premiumText;
	private JLabel economyText;
	
	private JTextField firstField;
	private JTextField businessField;
	private JTextField premiumField;
	private JTextField economyField;
	
	//Operation Heading
	private JLabel operationHeader;
	
	private JButton runSimButton;
	private JButton nextChartButton;
	
	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		
		//JFree Chart Panel (Unused, no implementation)
	    ChartPanel chartPanel = new ChartPanel(null);
	    chartPanel.setBackground(Color.WHITE);
	    
	    TextArea logTextArea = new TextArea();
	    logTextArea.setEditable(false);
	    
	    //JPanels
	    JPanel simPanel = new JPanel();
	    JPanel farePanel = new JPanel();
	    JPanel operationPanel = new JPanel();
	    
	    //Main Group Layout
	    GroupLayout mainLayout = new GroupLayout(this.getContentPane());
	    this.getContentPane().setLayout(mainLayout);
		
		mainLayout.setAutoCreateGaps(true);
		mainLayout.setAutoCreateContainerGaps(true);
		
		// Layout Horizontal components 
	    mainLayout.setHorizontalGroup(
	        mainLayout.createSequentialGroup()
	        .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent( logTextArea )
	            .addGroup(mainLayout.createSequentialGroup()
	            		.addGroup(
                                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent( simPanel ))
                        .addGroup(
                                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent( farePanel ))
                        .addGroup(
                                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent( operationPanel )
                               )
                        	)
	            		)
	    		);

	    // Layout vertical components 
	    mainLayout.setVerticalGroup(
	        mainLayout.createSequentialGroup()
	        .addGroup( 
	             mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	             .addComponent( logTextArea )
	         ).addGroup(
	        	 mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainLayout.createSequentialGroup()
                .addGroup(
                     mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent( simPanel )
	                 .addComponent( farePanel )
	                 .addComponent( operationPanel ))
                )
            )
	    );
	    
	    
	    //Simulation Panel Layout
	    simPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//SIMULATION TITLE
		simHeader = new JLabel("SIMULATION");
		simHeader.setForeground(Color.darkGray);
		simHeader.setFont(new Font("Helvetica", Font.BOLD, 26));
				
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
				
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 20;
				
		simPanel.add(simHeader, c);
		
		//FIRST LINE
		rngText = new JLabel("RNG Speed:");
	    rngText.setFont(new Font("Ariel", Font.PLAIN, 20));
	    rngField = new JTextField();
	    rngField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    rngField.setText(Integer.toString(Constants.DEFAULT_SEED));
		
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 1;
		
		simPanel.add(rngText, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 1;
		
		simPanel.add(rngField, c);
		
		//SECOND LINE
		dmeanText = new JLabel("Daily Mean:");
	    dmeanText.setFont(new Font("Ariel", Font.PLAIN, 20));
	    dmeanField = new JTextField();
	    dmeanField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    dmeanField.setText(Double.toString(Constants.DEFAULT_DAILY_BOOKING_MEAN));
		
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 1;
				
		simPanel.add(dmeanText, c);
				
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 2;
				
		simPanel.add(dmeanField, c);
		
		//THIRD LINE
		qsizeText = new JLabel("Queue Size:");
	    qsizeText.setFont(new Font("Ariel", Font.PLAIN, 20));
	    qsizeField = new JTextField();
	    qsizeField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    qsizeField.setText(Integer.toString(Constants.DEFAULT_MAX_QUEUE_SIZE));
				
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 1;
				
		simPanel.add(qsizeText, c);
				
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 3;
				
		simPanel.add(qsizeField, c);
		
		//FOURTH LINE
		cancelText = new JLabel("Cancellation:");
	    cancelText.setFont(new Font("Ariel", Font.PLAIN, 20));
	    cancelField = new JTextField();
	    cancelField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    cancelField.setText(Double.toString(Constants.DEFAULT_CANCELLATION_PROB));
				
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0;
		c.weighty = 1;
				
		simPanel.add(cancelText, c);
				
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 4;
				
		simPanel.add(cancelField, c);
	    
		//Fare Classes Layout
		farePanel.setLayout(new GridBagLayout());
		
		//FARE CLASS TITLE
		fareHeader = new JLabel("FARE CLASSES");
		fareHeader.setForeground(Color.darkGray);
		fareHeader.setFont(new Font("Helvetica", Font.BOLD, 26));
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 20;
		
		farePanel.add(fareHeader, c);
		
		//FIRST LINE
		firstText = new JLabel("First:");
		firstText.setFont(new Font("Ariel", Font.PLAIN, 20));
		firstField = new JTextField();
		firstField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    firstField.setText(Double.toString(Constants.DEFAULT_FIRST_PROB));
		
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 1;
		c.ipadx = 0;
		c.ipady = 0;
		
		farePanel.add(firstText, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 1;
		
		farePanel.add(firstField, c);
		
		//SECOND LINE
		businessText = new JLabel("Business:");
		businessText.setFont(new Font("Ariel", Font.PLAIN, 20));
		businessField = new JTextField();
		businessField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    businessField.setText(Double.toString(Constants.DEFAULT_BUSINESS_PROB));
		
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 1;
				
		farePanel.add(businessText, c);
				
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 2;
				
		farePanel.add(businessField, c);
		
		//THIRD LINE
		premiumText = new JLabel("Premium:");
		premiumText.setFont(new Font("Ariel", Font.PLAIN, 20));
		premiumField = new JTextField();
		premiumField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    premiumField.setText(Double.toString(Constants.DEFAULT_PREMIUM_PROB));
	    
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 3;
		c.weighty = 1;
						
		farePanel.add(premiumText, c);
						
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 3;
						
		farePanel.add(premiumField, c);
		
		//FOURTH LINE
		economyText = new JLabel("Economy:");
		economyText.setFont(new Font("Ariel", Font.PLAIN, 20));
		economyField = new JTextField();
		economyField.setFont(new Font("Ariel", Font.PLAIN, 20));
	    economyField.setText(Double.toString(Constants.DEFAULT_ECONOMY_PROB));
	    
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
								
		farePanel.add(economyText, c);
								
		c.anchor = GridBagConstraints.CENTER;
		c.ipadx = 200;
		c.ipady = 12;
		c.gridx = 1;
		c.gridy = 4;
								
		farePanel.add(economyField, c);
				
		//Operation Panel Layout
		operationHeader = new JLabel("OPERATION");
		operationHeader.setForeground(Color.darkGray);
		operationHeader.setFont(new Font("Helvetica", Font.BOLD, 26));
		
		runSimButton = new JButton("Run Simulation");
		runSimButton.addActionListener(this); 
		runSimButton.setFont(new Font("Ariel", Font.BOLD, 15));
		runSimButton.setBackground(Color.darkGray);
		runSimButton.setForeground(Color.white);
		
		nextChartButton = new JButton("Show Charts");
		nextChartButton.setFont(new Font("Ariel", Font.BOLD, 15));
		nextChartButton.setBackground(Color.darkGray);
		nextChartButton.setForeground(Color.white);
		
		operationPanel.setLayout(new GridBagLayout());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 20;
		
		operationPanel.add(operationHeader, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		
		c.ipadx = 20;
		c.ipady = 20;
		c.gridx = 0;
		c.gridy = 1;
		
		operationPanel.add(runSimButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0;
		c.ipadx = 20;
		c.ipady = 20;
		c.gridx = 0;
		c.gridy = 2;
		
		operationPanel.add(nextChartButton, c);
		
	    repaint();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
	    this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		GUI = new GUISimulator("Aircraft Simulator");
		GUI.setSize(1300,700);
		GUI.setMinimumSize(new Dimension(1300,700));
	    GUI.setBackground(Color.darkGray);
	    GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.run();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Double mean = Double.parseDouble(dmeanField.getText());
		String stdDev = Double.toString(mean * 0.33);
		
		String[] args = {rngField.getText(), qsizeField.getText(), dmeanField.getText(), stdDev, firstField.getText(), businessField.getText(), premiumField.getText(), economyField.getText(), cancelField.getText()};
		SimulationRunner.main(args);
	}
	
}
