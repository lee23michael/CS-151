package edu.sjsu.cs151.tetris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import edu.sjsu.cs151.tetris.model.Block;

public class TestGamePanel extends JPanel {

    public TestGamePanel() {
    	
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 10; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                CellPane cellPane = new CellPane();
                Border border = null;
                border = new MatteBorder(1, 1, 0, 0, Color.DARK_GRAY);
                
                
                
                if(row==0&&col==4)
                {
                cellPane.setBackground(Color.BLUE);
                }
                
                
                cellPane.setBorder(border);
                add(cellPane, gbc);
            }
        }
        
        
  
    }
    
    
    
    
    	public TestGamePanel(Block[][] g) {
    	
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        for (int row = 2; row < 22; row++) {
            for (int col = 0; col < 10; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                CellPane cellPane = new CellPane();
                Border border = null;
                border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                
                
                
                if(g[row][col] != null)
                {
                cellPane.setBackground(ColorHelper.getColor(g[row][col].getColor()));
                
            }
                
                
                cellPane.setBorder(border);
                add(cellPane, gbc);
            }
        }
        
        
  
    }
    
    


	public class CellPane extends JPanel {

    private Color defaultBackground;

    public CellPane() {
//        addMouseListener(new MouseAdapter() {

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(25, 25);
    	}
	}
	}
