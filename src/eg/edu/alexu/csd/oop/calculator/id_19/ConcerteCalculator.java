package eg.edu.alexu.csd.oop.calculator.id_19;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.calculator.Calculator;

public class ConcerteCalculator implements Calculator  {

	
	private static final int MAXIMUM_SIZE = 5;
	private List<String> history = null ;
	private List<String> historySnapshot = null ;
	private Integer historyIndex = null ;
	private Integer historyIndexSnapshot = null ;
	
	public ConcerteCalculator() {
		history = new ArrayList<String>();
		historyIndex = 0;
	}
	
	@Override
	public void input(String s) {		
		history.add(0, s);
		
		if (history.size() == MAXIMUM_SIZE + 1 ) {
			history.remove(MAXIMUM_SIZE);
		}  
	}

	@Override
	public String getResult() {
		String currentFormula = current();
		if (currentFormula == null)
			return null ;
		
		String[] parsedInput = RegexHelper.parse(currentFormula); 
		Double num1 = Double.parseDouble(parsedInput[0]);
		String operator = parsedInput[1];
		Double num2 = Double.parseDouble(parsedInput[2]);
		
		Double result = 0.0;
		switch (operator) {
		case "+" : result =  num1 + num2;break;
		case "/" : result =  num1 / num2;break;
		case "-" : result =  num1 - num2;break;
		default :  result =  num1 * num2;break;
		}

		return result+"";
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub
		return history.size()==0 ? null : history.get(historyIndex);
	}

	@Override
	public String prev() {
		if (historyIndex == history.size()-1||history.size()==0) {
			return null;
		}
		
		return history.get(++historyIndex);
		
		
	}

	@Override
	public String next() {
		if (historyIndex == 0) {
			return null;
		}
		
		return history.get(--historyIndex);
		
	}

	@Override
	public void save() {
		historyIndexSnapshot = historyIndex;
		historySnapshot = (List<String>) ((ArrayList<String>) history).clone();
		
	}

	@Override
	public void load() {
		history = (List<String>) ((ArrayList<String>) historySnapshot).clone();
		historyIndex = historyIndexSnapshot ;
		
	}

}
