package eg.edu.alexu.csd.oop.calculator.id_19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexHelper {
  
 public static String[] parse(String inputString) {
   
  
  
   
  String regexDecimal = "-?\\d*\\.\\d+";
  String regexInteger = "-?\\d+";
  String regexOperator = "[+\\-*\\/]";
  String regexDouble = "("+regexDecimal + "|" + regexInteger+")("+regexOperator+")("+regexDecimal + "|" + regexInteger+")";
 
  Pattern pattern = Pattern.compile(regexDouble);
  
  
  Matcher matcher = pattern.matcher(inputString);
  
  matcher.find();
  
  
  return new String[]{matcher.group(1),matcher.group(2),matcher.group(3)};
 }
}