package converter;

import com.sun.deploy.util.StringUtils;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.concurrent.Callable;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;


    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        FormedElbonian(number);
        this.number = number;
        System.out.println(toArabic());
        //this.number = ToArabic();
    }

    //helper functions for ElobianArabicConverter
//    private boolean AcceptedArabic(String S){ //4998
//        try:
//            Integer.parseInt(S);
//        catch
//    }
    public int toArabic(){
        int toReturn = 0;
        for(int i = 0; i < this.number.length(); i++){
            char c = this.number.charAt(i);
            switch(c){
                case 'M':
                    toReturn+=1000;
                    break;
                case 'C':
                    toReturn+=100;
                    break;
                case 'X':
                    toReturn+=10;
                    break;
                case 'I':
                    toReturn+=1;
                    break;
                case 'L':
                    toReturn+=50;
                    break;
                case 'l':
                    i++;
                    toReturn += 40;
                    break;
                case 'D':
                    toReturn+=500;
                    break;
                case 'd':
                    toReturn +=400;
                    i++;
                    break;
                case 'V':
                    toReturn+=5;
                    break;
                case 'v':
                    toReturn +=4;
                    i++;
                    break;
            }
        }
        return toReturn;
    }


    private void FormedElbonian(String S) throws MalformedNumberException{
        S = S.trim();
        String UpS = S.toUpperCase();
        for(Character C : UpS.toCharArray()) {
            if (!(C == 'M' || C == 'C' || C == 'X' || C == 'I' || C == 'L' || C == 'D' || C == 'V')) {
                throw new MalformedNumberException("Input: " + S + " contains illegal character/s");
            }
        }
        ElbonianRule1(S);
        ElbonianRule2(S);
        ElbonianRule3(S);
    }

    private void ElbonianRule1(String S) throws MalformedNumberException{
        int M = S.length() - S.replace("M", "").length();
        int C = S.length() - S.replace("C", "").length();
        int X = S.length() - S.replace("X", "").length();
        int I = S.length() - S.replace("I", "").length();
        if( M>3 || C>3 || X>3 || I>3){ throw new MalformedNumberException("Input: "+S+" breaks rule 1");}
    }
    private void ElbonianRule2(String S) throws MalformedNumberException{
        S = S.toUpperCase();
        int i = 0;

        while(((i <= S.length() - 1) ? (S.charAt(i) == 'M') : false)){ i++;}
        while(((i <= S.length() - 1) ? (S.charAt(i) == 'D') : false)){ i++;}
        while(((i <= S.length() - 1) ? (S.charAt(i) == 'C') : false)){ i++;}
        while(((i <= S.length() - 1) ? (S.charAt(i) == 'L') : false)){ i++;}
        while(((i <= S.length() - 1) ? (S.charAt(i) == 'X') : false)){ i++;}
        while(((i <= S.length() - 1) ? (S.charAt(i) == 'V') : false)){ i++;}
        while(((i <= S.length() - 1) ? (S.charAt(i) == 'I') : false)){ i++;}
        if(i != S.length()) {
            throw new MalformedNumberException("Input: " + S + " breaks rule 2");
        }
    }
    private void ElbonianRule3(String S) throws MalformedNumberException{
        int i;
        for(i =0; i<S.length();i++){
            if(Character.isLowerCase(S.charAt(i))){
                if( (i==S.length()-1) ||
                   ((i+1<S.length()) ?
                                (!(Character.toUpperCase(S.charAt(i)) == S.charAt(i+1))) :
                                 false) ||
                   ((i+2<S.length()) ?
                                (Character.toUpperCase(S.charAt(i)) == S.charAt(i+2)) :
                                 false)) {
                    throw new MalformedNumberException("Input: "+S+" breaks rule 3");
                }
            }
        }
    }


    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

}
