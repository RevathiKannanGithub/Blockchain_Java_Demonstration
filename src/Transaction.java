import java.io.Serializable;

// Simple transaction for demonstration with a String input/output, integer amount
public class Transaction implements Serializable {
	
	private String input;
	private String output;
	private int sum;
	
	public Transaction(String input, String output, int sum) {
		this.input = input;
		this.output = output;
		this.sum = sum;
	}
	
	@Override
	public String toString() {
		return "From : " + this.input + "; To : " + this.output + "; Amount = " + this.sum;
	}
}
