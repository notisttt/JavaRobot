
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;



public class GUITester extends JFrame implements ActionListener{
	
	 
  Boxes boxes;	//o pinakas me ta koutakia pou perpataei to robot
  JPanel buttons; //o pinakas me ta koumpia
  JPanel messages; //o pinakas ton mynimatwn
  JButton up;
  JButton down;
  JButton left;                   //Ta koumpia
  JButton right;
  JButton exit;
  JLabel msgs;
  JLabel exceptions;
  Craft craft; 
  int old_x;
  int old_y;

       public GUITester() {
	this.setLayout(new BorderLayout()); 	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	craft= new Craft();
        buttons = new JPanel(); //o pinakas me ta koumpia
        messages = new JPanel(); //pinakas mynimatwn
	messages.setLayout (new BorderLayout()); 
        boxes = new Boxes(); //ta koutakia pou perpataei to robot

        
        this.add(boxes,BorderLayout.CENTER);
  		
		
	up = new JButton("UP");
	buttons.add(up);
	down = new JButton("DOWN");
	buttons.add(down);
	left = new JButton("LEFT");
	buttons.add(left);             //ta koumpia
	right = new JButton("RIGHT");
	buttons.add(right);
	exit = new JButton("EXIT");
	buttons.add(exit);
	this.add(buttons,BorderLayout.SOUTH);	
	down.addActionListener(this);
	up.addActionListener(this);		
	right.addActionListener(this);		
	left.addActionListener(this);
	exit.addActionListener(this);
        
	msgs = new JLabel("ROW 1 and COL 1");
	messages.add(msgs,BorderLayout.NORTH);
	exceptions = new JLabel("No exceptions");
	messages.add(exceptions,BorderLayout.SOUTH);
	this.add(messages,BorderLayout.NORTH);


	this.setSize(400,400);  
	this.setVisible(true); 	
		
		

		
	
	this.boxes.Boxes[0][0].setBackground(Color.red);
			

	}
	@Override
	public void actionPerformed(ActionEvent e) {
	try {
                                    
        if (e.getSource()==this.up) {
					
	old_x = craft.Show_Row();
	old_y = craft.Show_Col();
        craft.Record_Position( old_x-1,craft.Show_Col());
	this.boxes.show_newpos2(old_x,old_y,craft.Show_Row(),craft.Show_Col(),craft.Show_Status());
	this.msgs.setText("ROW "+craft.Show_Row() + " COL "+craft.Show_Col() + " "+ craft.Show_Door(craft.Show_Row(),craft.Show_Col()));
					
      }
                                        
         else if (e.getSource()==this.down ) {
             old_x = craft.Show_Row();
             old_y = craft.Show_Col();
	     craft.Record_Position( old_x+1,craft.Show_Col());
	     this.boxes.show_newpos2(old_x,old_y,craft.Show_Row(),craft.Show_Col(),craft.Show_Status());				this.msgs.setText("ROW "+craft.Show_Row() + " COL "+craft.Show_Col() + " "+ craft.Show_Door(craft.Show_Row(),craft.Show_Col()));
							
	}
				
        else if (e.getSource()==this.left ) {
					
	      old_x = craft.Show_Row();
	      old_y = craft.Show_Col();
	      craft.Record_Position( craft.Show_Row(),old_y-1);
	      this.boxes.show_newpos2(old_x,old_y,craft.Show_Row(),craft.Show_Col(),craft.Show_Status());
	      this.msgs.setText("ROW "+craft.Show_Row() + " COL "+craft.Show_Col() + " "+ craft.Show_Door(craft.Show_Row(),craft.Show_Col()));
	}
	else if (e.getSource()==this.right ) {
					
	      old_x = craft.Show_Row();
	      old_y = craft.Show_Col();
	      craft.Record_Position(craft.Show_Row(),old_y+1);
	      this.boxes.show_newpos2(old_x,old_y,craft.Show_Row(),craft.Show_Col(),craft.Show_Status());
	      this.msgs.setText("ROW "+craft.Show_Row() + " and COL "+craft.Show_Col() + " "+ craft.Show_Door(craft.Show_Row(),craft.Show_Col()));
					
        }
					
					
	else if (e.getSource()==this.exit) {
					
	       craft.Record_Exit();
               this.boxes.init_pos();	
	       this.boxes.show_newpos2(6,6,craft.Show_Row(),craft.Show_Col(),craft.Show_Status());	
	       this.msgs.setText("ROW "+ craft.Show_Row() + " COL "+ craft.Show_Col() + " "+ craft.Show_Door(craft.Show_Row(),craft.Show_Col()));
							
	}
	       this.exceptions.setText("No exception");
	
				
	}
               catch (VDMException exc) {
				
        	this.exceptions.setText(exc.toString());
					
	}
	       catch (VDMException2 exc) {
				
		this.exceptions.setText(exc.toString());
				
	}
				
				
    }
			
		

}
