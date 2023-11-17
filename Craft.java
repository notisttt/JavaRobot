public class Craft implements InvariantCheck{

	
		public static final int lowlimit = 1;
		public static final int maxlimit = 6;
		private int row;
		private int col;
		private Status status;
	
		
		
		public Craft() {
		
			this.row= lowlimit;
			this.col= lowlimit;
		        
		}
		
	
		
		public boolean Invar () {
		
			return (InRange(this.row) && InRange(this.col) && (OffInRow(this.row,this.status)));
		}
		
		
	
		private boolean InRange(int val) {
		
			return (lowlimit <= val && val <= maxlimit);
		}
		
		private boolean OffInRow(int r, Status s) {
		
			if (r==1 && s==Status.ON) {
				return false;
                        }
                        else {
				return true;
                        }
		}
		
		
		
		private boolean IsAtDoor(int x, int y) {
		
			if (x!=6 || y!=6) {
				return false;
                        }
                        else {
				return true;
                        }
		}
		
		

		public void Record_Position(int in_row,int in_col) {
		
                    VDM.BeforeTest(InRange(in_row) && InRange(in_col) && OffInRow(in_row,this.status));
		    this.row = in_row;
		    this.col=in_col;
		    VDM.InvTest(this);
		}

		

		public void record_status(Status in_status) {
		
			VDM.BeforeTest(OffInRow(this.row,in_status));
  		 	VDM.InvTest(this);
		}
		
		
		

		public void Record_Exit() {
		
			VDM.BeforeTest(IsAtDoor(this.row,this.col));
		        this.row = 1;
		        this.col=1; 
		        VDM.InvTest(this);
		}
		

			public String Show_Status() {
			
				if (this.status == Status.OFF){
					return "OFF";
                                }
                                else {
					return "ON";
                                }
			}
			
			public int Show_Row() {
			
			    return this.row;

                        }
			
			

			public int Show_Col() {
		
			    return this.col;
                            
			}


			public String Show_Door(int x, int y) {
			
				if (IsAtDoor(x,y)) {
					return "AT DOOR";
                                }
                                else {
					return "";
                                }
			}
			

			

}

