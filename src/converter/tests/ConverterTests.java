package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {
    //TestFlow
    //ToArabicFunctioning
        //eachLowercase
        // triplelowercaseinmiddle
        //doubleLowercase
        //doubleLowercase at end   MMvV
        //spaces before and after
        //max number //in Order all letters //eachLetter //triple
        //0
    //ToArabicFails
        //spaces in the middle
        //letters out of order
        // Dd
        // dV
        // DDDD
        // dDD
        // MXM


    //ToArabic Tests all functioning
    @Test
    public void eachLowerCase() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("dDlLvV");
        assertEquals(converter.toArabic(),444);
    }
    @Test
    public void tripleLowerCaseInMiddle() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DdDLlLVvV");
        assertEquals(converter.toArabic(),999);
    }
    @Test
    public void doubleLowerCase() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMdD");
        assertEquals(converter.toArabic(),2400);
    }
    @Test
    public void spacesBeforeAndAfter() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(" MD  ");
        assertEquals(converter.toArabic(),1500);
    }
    @Test
    public void MaxNumber() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMDDDCCCLLLXXXVVVIII");
        assertEquals(converter.toArabic(),4998);
    }
    @Test
    public void Zero() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MD");
        assertEquals(converter.toArabic(),1500);
    }

    //ToArabic Tests all failing
    //spaces in the middle
    // Dd
    // dV
    // DDDD
    // dDD
    // MXM //letters out of order
    @Test(expected = MalformedNumberException.class)
    public void ToArabicFail_SpacesIntheMiddle() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MdD  lLvV");
    }

    @Test(expected = MalformedNumberException.class)
    public void Lowercase_Out_of_Order_End() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MDd");
    }

    @Test(expected = MalformedNumberException.class)
    public void Lowercase_Out_of_Order_Middle() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MDdV");
    }

    @Test(expected = MalformedNumberException.class)
    public void fourInARow() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCC");
    }

    @Test(expected = MalformedNumberException.class)
    public void threeInARow_lowercaseFirst() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("vVV");
    }

    @Test(expected = MalformedNumberException.class)
    public void lettersOutOfOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IM");
    }

    @Test(expected = MalformedNumberException.class)

    public void lettersOutOfOrder2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XL");
    }

    @Test(expected = MalformedNumberException.class)
    public void lettersOutOfOrder3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LMMM");
    }







//    @Test
//    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
//        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
//        assertEquals(converter.toArabic(), 1);
//    }
//
//    @Test(expected = MalformedNumberException.class)
//    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
//        throw new MalformedNumberException("TEST");
//    }
//
//    @Test(expected = ValueOutOfBoundsException.class)
//    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
//        ElbonianArabicConverter converter = new ElbonianArabicConverter("5000");
//    }

    // TODO Add more test cases

}
