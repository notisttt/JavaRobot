

public class VDM {

	
	public VDM() {
		super();
		
	}
	static void BeforeTest(boolean expr) throws VDMException2 {
	
		if(expr == false)
			throw new VDMException2();
	
	}	
	static void InvTest(InvariantCheck i) throws VDMException {

	
		if ( !i.Invar()) {
			throw new VDMException();
	}
    }
}
