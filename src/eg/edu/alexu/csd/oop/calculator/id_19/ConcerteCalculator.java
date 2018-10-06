package eg.edu.alexu.csd.oop.calculator.id_19;

import eg.edu.alexu.csd.oop.calculator.Calculator;

public class ConcerteCalculator implements Calculator  {

	
	private String inputString = null;

	public ConcerteCalculator() {
		System.out.println("init");
	}
	
	@Override
	public void input(String s) {
		// TODO Auto-generated method stub
		this.inputString  = s ;
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		String[] parsedInput = RegexHelper.parse(inputString); 
		Double num1 = Double.parseDouble(parsedInput[0]);
		String operator = parsedInput[1];
		Double num2 = Double.parseDouble(parsedInput[2]);
		
		Double result = 0.0;
		switch (operator) {
		case "+" : result =  num1 + num2;break;
		case "/" : result =  num1 / num2;break;
		case "-" : result =  num1 - num2;break;
		default :  result =  num1 + num2;break;
		}

		return result+"";
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub
		return inputString;
	}

	@Override
	public String prev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
