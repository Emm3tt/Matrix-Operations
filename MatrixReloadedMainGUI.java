import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
public class MatrixReloadedMainGUI extends JFrame 
{

	private MatrixGUI matrixA, matrixB, matrixC;
	private JButton saveMatrixData;
	
	private JTextField rowJTextField, colJTextField;
	
	private JLabel label, labelA, labelB, labelC, instructionsLabel;
	
	private JButton buttonA, buttonB, addButton, subtractButton,
	multiplyButton, clearAButton,clearBButton;
	
	private Container contentPane ;
	
	private JTable tableA  = new JTable();
	private JTable tableB = new JTable();
	private JTable tableC = new JTable();
	private TheMatrix calculator = new TheMatrix();
	
	
	MatrixReloadedMainGUI()
	{
		createMainInterface();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	void createMainInterface()
	{
		 contentPane = getContentPane();
		 contentPane.setLayout(null);
		
		//set up instructions
		 instructionsLabel = new JLabel("<html>NOTE: Press the tab key after"
		 		+ "<br>entering the matrix values</html>");
		 instructionsLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		 instructionsLabel.setBounds(15, 58, 530, 40);
		 instructionsLabel.setForeground(Color.RED);
		 contentPane.add(instructionsLabel);
		 
		//set up rowJTextField
		rowJTextField = new JTextField(); 
		rowJTextField.setFont(new Font("Arial Black", Font.BOLD, 25));
		rowJTextField.setBounds(10, 30, 100, 30);
		rowJTextField.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(rowJTextField);
		rowJTextField.addKeyListener(
				
				new KeyAdapter()
				{
					public void keyPressed(KeyEvent e)
					{
						
						contentPane.remove(tableC);
						repaint();
						
					}
					
				}
				
				);
		
		//set up colJTextField
		colJTextField  = new JTextField();
		colJTextField.setFont(new Font("Arial Black", Font.BOLD, 25));
		colJTextField.setBounds(110, 30, 100, 30);
		colJTextField.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(colJTextField);
		colJTextField.addKeyListener(
				
				new KeyAdapter()
				{
					public void keyPressed(KeyEvent e)
					{
						contentPane.remove(tableC);
						repaint();
						
					}
					
				}
				
				);
		
		
		//set up label
		label = new JLabel("         Row             Col");
		label.setFont(new Font("Arial Black", Font.BOLD, 14));
		label.setBounds(0, 0, 200, 30);
		contentPane.add(label);
		
		//set up label A
		 labelA = new JLabel("MATRIX A ");
		 labelA.setFont(new Font("Arial Black", Font.BOLD, 20));
		 labelA.setBounds(10, 100, 200, 30);
		 contentPane.add(labelA);
		 
		//set up label B
		labelB = new JLabel("MATRIX B ");
		labelB.setFont(new Font("Arial Black", Font.BOLD, 20));
		labelB.setBounds(10, 400, 200, 30);
		contentPane.add(labelB);
		
		
		//set up label C
		labelC = new JLabel("SOLUTION: MATRIX C ");
		labelC.setFont(new Font("Arial Black", Font.BOLD, 20));
		labelC.setBounds(700, 100, 300, 30);
		contentPane.add(labelC);
		
		clearAButton = new JButton("Clear A");
		clearAButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		clearAButton.setBounds(220, 5, 150, 30);
		contentPane.add(clearAButton);
		clearAButton.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						tableA.setVisible(false);
						tableC.setVisible(false);

					}
					
				}
					
		);
		
		clearBButton = new JButton("Clear B");
		clearBButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		clearBButton.setBounds(360, 5, 150, 30);
		contentPane.add(clearBButton);
		clearBButton.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						
						tableB.setVisible(false);
						tableC.setVisible(false);
						
					}
					
				}
					
		);
		
		//set up button
		buttonA = new JButton("Create Matrix A");
		buttonA.setFont(new Font("Arial Black", Font.BOLD, 14));
		buttonA.setBounds(220, 30, 150, 30);
		contentPane.add(buttonA);
		buttonA.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						contentPane.remove(tableA);
						contentPane.remove(tableC);
					     addButton.setEnabled(false);
						 subtractButton.setEnabled(false);
						 multiplyButton.setEnabled(false);
						 labelC.setText("SOLUTION: MATRIX C ");
						try
						{
							 
							
							int row = Integer.parseInt(rowJTextField.getText());
							int col = Integer.parseInt(colJTextField.getText());
							
							if( row <= 9 && col <= 9)
							{
								if(row == 1 && col == 1)
								{
									JOptionPane.showMessageDialog(null,
											"1X1 matrices not allowed!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									matrixA = new MatrixGUI(row, col);
									tableA = matrixA.getMatrixAsTable();
									tableA.setBounds(10, 130, tableA.getColumnCount()*75, 
									row*tableA.getRowHeight());
									contentPane.add(tableA);
									repaint();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,
										"Rows and Columns must be integers greater than 1 and"
										+ " less than 10", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							}
							 
						}
						catch(Exception error)
						{
							JOptionPane.showMessageDialog(null,
									"Please enter a row and a col as integers from 1 to 9", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					
					}
				}
				
				);
		
		
		//set up button
				buttonB = new JButton("Create Matrix B");
				buttonB.setFont(new Font("Arial Black", Font.BOLD, 14));
				buttonB.setBounds(360, 30, 150, 30);
				contentPane.add(buttonB);
				buttonB.addActionListener(
						
						new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								
								contentPane.remove(tableB);
								contentPane.remove(tableC);
								 addButton.setEnabled(false);
								 subtractButton.setEnabled(false);
								 multiplyButton.setEnabled(false);
								 labelC.setText("SOLUTION: MATRIX C ");
								try
								{
									 
									
									int row = Integer.parseInt(rowJTextField.getText());
									int col = Integer.parseInt(colJTextField.getText());
									if( row <= 9 &&  col <= 9)
									{
										if(row == 1 && col == 1)
										{
											JOptionPane.showMessageDialog(null,
													"1X1 matrices not allowed!", "ERROR",
													JOptionPane.ERROR_MESSAGE);
										}
										else
										{
											matrixB = new MatrixGUI(row, col);
											tableB = matrixB.getMatrixAsTable();
											tableB.setBounds(10, 430, tableB.getColumnCount()*75, 
													row*tableB.getRowHeight());
											contentPane.add(tableB);
										     repaint();
										}
									
									}
									else
									{
										JOptionPane.showMessageDialog(null,
												"Rows and Columns must be integers greater than 1 and "
												+ " less than 10", "ERROR",
												JOptionPane.ERROR_MESSAGE);
										
									}
				
									 
								}
								catch(Exception error)
								{
									JOptionPane.showMessageDialog(null,
											"Please enter a row and a col as integers from 1 to 9", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								}
							
							}
						}
						
						);

			//Save data
				saveMatrixData = new JButton("SAVE DATA");
				saveMatrixData.setFont(new Font("Arial Black", Font.BOLD, 16));
				saveMatrixData.setForeground(Color.RED);
				saveMatrixData.setBounds(305, 60, 120, 40);
				contentPane.add(saveMatrixData);
				saveMatrixData.addActionListener(
						
						new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								if(matrixA != null && matrixB != null && matrixA.saveData(tableA, tableB))
								{
									JOptionPane.showMessageDialog(null, 
											"DATA SAVED");
									addButton.setEnabled(true);
									 subtractButton.setEnabled(true);
									 multiplyButton.setEnabled(true);
								}
								else
								{
									//do nothing
								}
								
							
							}
						}
						
						);
				
				//set up addButton, subtractButton, multiplyButton;
				addButton = new JButton("ADD");
				addButton.setEnabled(false);
				addButton.setBounds(600, 30, 120, 30);
				addButton.setFont(new Font("Arial Black", Font.BOLD, 15));
				contentPane.add(addButton);
				addButton.addActionListener(
						
						new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								
								    contentPane.remove(tableC);
								    int A[][] = getMatrixAData();
								    int B[][] = getMatrixBData();
								    int C[][] = calculator.add(A, B);
								    
								    if(C.length == 1 && C[0].length == 1)//NO SOLUTION
								    {
								     	labelC.setText("A+B = NO SOLUTION");
								     	JOptionPane.showMessageDialog(null,
												"NO SOLUTION", "ERROR",
												JOptionPane.ERROR_MESSAGE);
								   
								    }
								    else
								    {
								    
								    		matrixC = 
								    		new MatrixGUI(matrixA.convertFromIntToInteger(C));
								    		tableC = matrixC.getMatrixAsTable();
								    		tableC.setBounds(700, 130, tableB.getColumnCount()*75, 
											C.length*tableB.getRowHeight());
								    		centerSolution(C);
								    		contentPane.add(tableC);
								    		labelC.setText("SOLUTION: A + B = C");
								    		repaint();
								    }
								
	
							}
						}
						);
				
				subtractButton = new JButton("SUBTRACT");
				subtractButton.setEnabled(false);
				subtractButton.setBounds(750, 30, 120, 30);
				subtractButton.setFont(new Font("Arial Black", Font.BOLD, 15));
				contentPane.add(subtractButton);
				subtractButton.addActionListener(
						
						new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								
							
								 contentPane.remove(tableC);
								    int A[][] = getMatrixAData();
								    int B[][] = getMatrixBData();
								    int C[][] = calculator.subtract(A, B);
								    
								    if(C.length == 1 && C[0].length == 1)//NO SOLUTION
								    {
								     	labelC.setText("A+B = NO SOLUTION");
								     	JOptionPane.showMessageDialog(null,
												"NO SOLUTION", "ERROR",
												JOptionPane.ERROR_MESSAGE);
								   
								    }
								    else
								    {
								    
								    		matrixC = 
								    		new MatrixGUI(matrixA.convertFromIntToInteger(C));
								    		tableC = matrixC.getMatrixAsTable();
								    		tableC.setBounds(700, 130, tableB.getColumnCount()*75, 
											C.length*tableB.getRowHeight());
								    		centerSolution(C);
								    		contentPane.add(tableC);
								    		labelC.setText("SOLUTION: A - B = C");
								    		repaint();
								    }
							
							}
						}
						);
				
				multiplyButton = new JButton("MULTYPLY");
				multiplyButton.setEnabled(false);
				multiplyButton.setBounds(900, 30, 120, 30);
				multiplyButton.setFont(new Font("Arial Black", Font.BOLD, 15));
				contentPane.add(multiplyButton);
				multiplyButton.addActionListener(
						
						new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								
								contentPane.remove(tableC);
							    int A[][] = getMatrixAData();
							    int B[][] = getMatrixBData();
							    int C[][] = calculator.multiply(A, B);
							    
							    if(C.length == 1 && C[0].length == 1)//NO SOLUTION
							    {
							     	labelC.setText("A*		B = NO SOLUTION");
							     	JOptionPane.showMessageDialog(null,
											"NO SOLUTION", "ERROR",
											JOptionPane.ERROR_MESSAGE);
							   
							    }
							    else
							    {
							    
							    		matrixC = 
							    		new MatrixGUI(matrixA.convertFromIntToInteger(C));
							    		tableC = matrixC.getMatrixAsTable();
							    		tableC.setBounds(700, 130, tableB.getColumnCount()*75, 
										C.length*tableB.getRowHeight());
							    		centerSolution(C);
							    		contentPane.add(tableC);
							    		labelC.setText("SOLUTION: A * B = C");
							    		repaint();
							    }
								
							}
						}
						
						);
				
		setSize(1200, 1200);
		setTitle("Matrix Reloaded");
		setVisible(true);
		
	}
	
	public int[][] getMatrixAData () 
	{
		return matrixA.getTableData();
	}
	
	public int[][] getMatrixBData () 
	{
		return matrixB.getTableData();
	}
	
	private void centerSolution(int C[][])
	{
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		for(int i=0; i<C[0].length; i++)
		{
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			tableC.getColumnModel().getColumn(i).setCellRenderer
			( centerRenderer );
			
	     }
	}
	

}
