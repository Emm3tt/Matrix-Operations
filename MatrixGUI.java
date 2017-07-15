import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.awt.*;


public class MatrixGUI 
{
	
	private JTable matrixTable;
	private int row, col;
	private boolean isDataSaved = false;
	
	
	public MatrixGUI(int r, int c)
	{
		row = r;
		col = c;
		
		 //set up matrixTable
		matrixTable = new JTable(row, col);
		matrixTable.setFont(new Font("Arial Black", Font.BOLD, 20));
		matrixTable.setRowHeight(30);
		matrixTable.setGridColor(Color.black);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		for(int i=0; i<col; i++)
		{
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			matrixTable.getColumnModel().getColumn(i).setCellRenderer
			( centerRenderer );
			
	     }
	
	}
	
	public MatrixGUI(Integer array[][])
	{
		 //set up matrixTable
		String a[] = new String[array[0].length];
		for(int i = 0; i < a.length; i++)
		{
			a[i] = "data";
		}
		matrixTable = new JTable(array, a);
		matrixTable.setFont(new Font("Arial Black", Font.BOLD, 20));
		matrixTable.setRowHeight(30);
		matrixTable.setGridColor(Color.black);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		for(int i=0; i<col; i++)
		{
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			matrixTable.getColumnModel().getColumn(i).setCellRenderer
			( centerRenderer );
			
	     }
		
	}
	
		 
        
	public boolean saveData(JTable A, JTable B)
	{
		isDataSaved = true;
		for(int i = 0; i< row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(A.getModel().getValueAt(i, j) == null 
						|| B.getModel().getValueAt(i, j) == null)
				{
					JOptionPane.showMessageDialog(null, 
							"Enter and center your values by selecting a row.",
							"ERROR",
							JOptionPane.ERROR_MESSAGE);
					   isDataSaved = false;
					   return isDataSaved;
				}
			}
		}
	
		return isDataSaved;
		
	}
         
   
	
	
	
	public int[][] getTableData () 
	{
	   
	    DefaultTableModel dtm = (DefaultTableModel) matrixTable.getModel();
	 
	    int[][] tableData = new int[row][col];
	    for (int i = 0 ; i < row ; i++)
	    {
	        for (int j = 0 ; j < col ; j++)
	        {
	        	   
	        	    String s = (String)dtm.getValueAt(i, j);
	        	    if(s == null)
	        	    {
	        	    	   JOptionPane.showMessageDialog(null, "Please make sure"
	        	    	   		+ "all of your matrix values are centered before performing"
	        	    	   		+ "any operation.",
	        	    			   "ERROR", JOptionPane.ERROR_MESSAGE);
	        	    }
	        	    int value = Integer.parseInt(s);
	        	    tableData[i][j] = value;
	           
	        }
	    }
	    return tableData;
	}
	
	
	public JTable getMatrixAsTable()
	{		
		return matrixTable;
	}
	
	
	public Integer[][] convertFromIntToInteger(int array[][])
	{
		Integer a[][] = new Integer[array.length][array[0].length];
		
			for(int row = 0; row < array.length; row++)
			{
				for(int col = 0; col < array[0].length; col++)
				{
					Integer x = new Integer(array[row][col]);
					a[row][col] = x;
				}
			}
		return a;
	}
	
	
}
