package org.movsim.viewer.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.movsim.simulator.Simulator;

public class EditorCanvas extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4899177473580009694L;
	private final AppFrame frame;
	
	public EditorCanvas(AppFrame appFrame, Simulator simulator, Properties properties) {
		// TODO Auto-generated constructor stub
		frame=appFrame;
		this.setVisible(false);
		
		this.createContent();
		
		
	}

	private void createContent() {
		
		JLabel mainLabel = new JLabel("Scenario Editor");
		//this.add(mainLabel);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.hideEditorCanvas();
			}
		});
		
		JButton saveButton = new JButton("Save");
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveModifications();
			}
		});
		
		//this.add(closeButton);
		
		
		this.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

	    // Create the layout
	    GroupLayout layout = new GroupLayout( this );
	    this.setLayout( layout );
	    layout.setAutoCreateGaps( true );

	    // Create the components we will put in the form
	    /*JLabel ipAddressLabel = new JLabel( "IP Address:" );
	    JTextField ipAddressTextField = new JTextField( 20 );
	    JLabel subnetLabel = new JLabel( "Subnet:" );
	    JTextField subnetTextField = new JTextField( 20 );
	    JLabel gatewayLabel = new JLabel( "Gateway:" );
	    JTextField gatewayTextField = new JTextField( 20 );*/

	    // Horizontally, we want to align the labels and the text fields
	    // along the left (LEADING) edge
	    layout.setHorizontalGroup( layout.createSequentialGroup()
	                                       .addGroup( layout.createParallelGroup( GroupLayout.Alignment.LEADING )
	                                                          //.addComponent( ipAddressLabel )
	                                                          //.addComponent( subnetLabel )
	                                                          //.addComponent( gatewayLabel ) )
	                                    		   				.addComponent(mainLabel)
	                                    		   				.addComponent(saveButton)
	                                    		   				.addComponent(closeButton)
	                                    		   			)
	                                       /*.addGroup( layout.createParallelGroup( GroupLayout.Alignment.LEADING )
	                                                          .addComponent( ipAddressTextField )
	                                                          .addComponent( subnetTextField )
	                                                          .addComponent( gatewayTextField ) )*/
	    );

	    // Vertically, we want to align each label with his textfield
	    // on the baseline of the components
	    layout.setVerticalGroup( layout.createSequentialGroup()
	                                    /* .addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
	                                                        .addComponent( ipAddressLabel )
	                                                        .addComponent( ipAddressTextField ) )
	                                     .addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
	                                                        .addComponent( subnetLabel )
	                                                        .addComponent( subnetTextField ) )
	                                     .addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
	                                                        .addComponent( gatewayLabel )
	                                                        .addComponent( gatewayTextField ) )*/
	    								.addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
	    													.addComponent(mainLabel)
	    													)
	    								.addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
															.addComponent(saveButton)
															)	
										.addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
															.addComponent(closeButton)
															)	
	    );
		
		
	}

	/**
	 * if changed occurs in the scenario, ask the user for saving the modifications
	 */
	private void saveModifications() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Button run action: runs the current scenario
	 */
	public void run(){
		//first, ask the user for saving
		saveModifications();
	}
	
	public void close(){
		this.reset();
	}

	/**
	 * Clear all the fields 
	 */
	public void reset() {
		this.saveModifications();
		// TODO Auto-generated method stub
	}

	/**
	 * Fill fields with current scenario infos
	 */
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
