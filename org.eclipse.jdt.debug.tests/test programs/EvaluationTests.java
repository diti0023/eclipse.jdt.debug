import java.util.Date;
import java.util.Vector;

public class EvaluationTests {

	protected int fInt= 5;
	protected String fString= "testing";
	protected static final String CONSTANT= "constant";
	private Date fADate= new Date();

	public static void main(java.lang.String[] args) {
		EvaluationTests tests= new EvaluationTests(); //line 12
		tests.method();
	}

	public void method() {
		System.out.println(returnInt());
		System.out.println(returnDate());
		int x= 5; //line 19
		System.out.println(x);
		Vector v= new Vector();
		v.isEmpty();
	}

	public int returnInt() {
		return 7;
	}

	public Date returnDate() {
		return new Date();
	}
}

