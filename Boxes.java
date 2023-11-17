

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.*;


public class Boxes extends JPanel{
    
Border BlackLine, RaisedEtched, LoweredEtched, RaisedBevel, LoweredBevel, Empty;	 
	
JPanel[][] Boxes = new JPanel[6][6];	
JLabel[][] Box_Labels = new JLabel[6][6];
	
    
	
	
	
        
        
        Boxes() {
	
		 
		
   		
   		 
		this.setSize(500,500);  
		this.setLayout(new GridLayout(6,6)); 
   		Border BlackLine = BorderFactory.createLineBorder(Color.black);
   
   		
   		BlackLine = BorderFactory.createLineBorder(Color.black);
   		RaisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
   		LoweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
   		RaisedBevel = BorderFactory.createRaisedBevelBorder();
   		LoweredBevel = BorderFactory.createLoweredBevelBorder();
   		Empty = BorderFactory.createEmptyBorder();
   		for(int i= 0; i < 6 ;i++ ) {
   		 
   		 for (int j=0; j < 6; j++) {
   				 
 		 Boxes[i][j]= new JPanel();
   		 Box_Labels[i][j]= new JLabel();
   		 Boxes[i][j].setBorder(RaisedEtched);
  		 Boxes[i][j].setBackground(Color.gray);   
                 Box_Labels[i][j].setText("");
   		 Box_Labels[i][j].setBounds(0, 0, 200, 50);
   		 Boxes[i][j].add(Box_Labels[i][j]);
   		 this.add(Boxes[i][j]);
                                 
   	            }
   	       }
                
   		Boxes[5][5].setBackground(Color.blue);
   		Box_Labels[5][5].setText("Door");
   		Box_Labels[0][0].setText("Robot");
  			
	}
	
	public void init_pos() {
	
	  for(int i= 0; i < 6 ;i++ ) {
  		 
	   for (int j=0; j < 6; j++) {
  				 
  					
            Boxes[i][j].setBackground(Color.gray);
  					
  	      }
          }	
	    Boxes[5][5].setBackground(Color.blue);
            Box_Labels[5][5].setText("Exit");
	}
	

	public void show_newpos2(int old_x, int old_y, int new_x, int new_y, String ON_OFF) {
	

		if(old_x==6 && old_y == 6) {
		
		Boxes[old_x-1][old_y-1].setBackground(Color.blue);
		Box_Labels[old_x-1][old_y-1].setText("Exit");
                
		}
                else {
		
		Boxes[old_x-1][old_y-1].setBackground(Color.green);
		Box_Labels[old_x-1][old_y-1].setText("");
                
		}

		Boxes[new_x-1][new_y-1].setBackground(Color.red);	
		Box_Labels[new_x-1][new_y-1].setText("Robot");
		
	}
}
