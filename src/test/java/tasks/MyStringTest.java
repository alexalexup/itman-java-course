package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStringTest {

    @Test
    public void toStringShouldReturnEmptyStringWhenFieldSmbHaveNotSymbols() {
        MyString a = new MyString(new char[]{});
        String expectedResult = "";
        String actualResult = a.toString();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void toStringShouldReturnResultWhenFieldSmbHaveOneSymbol() {
        MyString a = new MyString(new char[]{'h'});
        String expectedResult = "h";
        String actualResult = a.toString();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void toStringShouldReturnNullWhenFieldSmbIsNull() {
        MyString a = new MyString(null);
        String expectedResult = null;
        String actualResult = a.toString();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void toStringShouldReturnResultWhenFieldSmbHaveCharAndDecInOneArray() {
        MyString a = new MyString(new char[] {'H', 101, 108, 108, 111, '!'});
        String expectedResult = "Hello!";
        String actualResult = a.toString();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void lengthShouldReturnZeroWhenFieldSmbHaveNotSymbols() {
        MyString a = new MyString(new char[]{});
        int expectedResult = 0;
        int actualResult = a.length();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void lengthShouldReturnNullWhenFieldSmbIsNull() {
        MyString a = new MyString(null);
        int expectedResult = 0;
        int actualResult = a.length();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void charArtShouldReturnResultWhenIndexIsFirst() {
        MyString a = new MyString(new char[]{'f', '2', '!', 'g'});
        int index = 0;
        char expectedResult ='f';
        char actualResult = a.charAt(index);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void charArtShouldReturnResultWhenIndexIsLast() {
        MyString a = new MyString(new char[]{'f', '2', '!', 'g', 't', 'H'});
        int index = 5;
        char expectedResult ='H';
        char actualResult = a.charAt(index);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareToShouldReturnNegativeNumberWhenFirstStringLessThanSecondAndLengthBothArraysAreSame(){
        MyString firstString = new MyString(new char[]{'c','o','m','p','a'});
        MyString secondString = new MyString(new char[]{'c','o','m','p','o'});
        int actualResult = firstString.compareTo(secondString);
        int expectedResult = -1;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareToShouldReturnPositiveNumberWhenFirstStringBiggerThanSecondAndFirstArrayLengthIsBigger() {
        MyString firstString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'z', 'a'});
        MyString secondString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a'});
        int actualResult = firstString.compareTo(secondString);
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareToShouldReturnZeroWhenBothStringsHaveSameSymbolsAndLength() {
        MyString firstString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't'});
        MyString secondString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't'});
        int actualResult = firstString.compareTo(secondString);
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void compareToShouldReturnNegativeNumberWhenFirstStringLessThanSecond() {
        MyString firstString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't'});
        MyString secondString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't','f','f'});
        int actualResult = firstString.compareTo(secondString);
        int expectedResult = -1;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void equalsShouldReturnTrueWhenStringAreSame() {
        MyString firstString = new MyString(new char[]{'f', 'i', 's', 'h'});
        MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h'});
        boolean actualResult = firstString.equals(secondString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenStringHaveDifferentLength() {
        MyString firstString = new MyString(new char[]{'f', 'i', 's', 'h'});
        MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h', 'h', 'h'});
        boolean actualResult = firstString.equals(secondString);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenStringHaveSameLengthAndDifferentSymbols() {
        MyString firstString = new MyString(new char[]{'f', 'i', 't', 'h'});
        MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h'});
        boolean actualResult = firstString.equals(secondString);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenSecondStringIsNull() {
        MyString firstString = new MyString(new char[]{'f', 'i', 't', 'h'});
        MyString secondString = null;
        boolean actualResult = firstString.equals(secondString);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void plusShouldReturnConcatenationBothStringWhenFirstStringIsLessThanSecond() {
        MyString firstString = new MyString(new char[]{'I', ' ', 'l', 'i', 'k', 'e'});
        MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h', 'i', 'n', 'g'});
        MyString actualString = MyString.plus(firstString, secondString);
        MyString actualString2 = firstString.plus(secondString);
        MyString expectedString = new MyString(new char[]{'I', ' ', 'l', 'i', 'k', 'e',
                'f', 'i', 's', 'h', 'i', 'n', 'g'});
        boolean actualResult = actualString.equals(expectedString);
        boolean actualResult2 =actualString2.equals(expectedString);
        Assertions.assertTrue(actualResult);
        Assertions.assertTrue(actualResult2);
    }

    @Test
    public void plusShouldReturnSecondStringWhenFirstStringIsEmpty() {
        MyString firstString = new MyString(new char[]{});
        MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h', 'i', 'n', 'g'});
        MyString actualString = MyString.plus(firstString, secondString);
        MyString actualString2 = firstString.plus(secondString);
        MyString expectedString = new MyString(new char[]{'f', 'i', 's', 'h', 'i', 'n', 'g'});
        boolean actualResult = actualString.equals(expectedString);
        boolean actualResult2 = actualString2.equals(expectedString);
        Assertions.assertTrue(actualResult);
        Assertions.assertTrue(actualResult2);
    }

    @Test
    public void plusShouldReturnFirstStringWhenSecondStringIsEmpty() {
        MyString firstString = new MyString(new char[]{'h', 'e', 'l', 'l', 'l', 'o'});
        MyString secondString = new MyString(new char[]{});
        MyString actualString = MyString.plus(firstString, secondString);
        MyString actualString2 = firstString.plus(secondString);
        MyString expectedString = new MyString(new char[]{'h', 'e', 'l', 'l', 'l', 'o'});
        boolean actualResult = actualString.equals(expectedString);
        boolean actualResult2 = actualString2.equals(expectedString);
        Assertions.assertTrue(actualResult);
        Assertions.assertTrue(actualResult2);
    }

    @Test
    public void plusShouldReturnEmptyStringWhenBothStringAreEmpty() {
        MyString firstString = new MyString(new char[]{});
        MyString secondString = new MyString(new char[]{});
        MyString actualString = MyString.plus(firstString, secondString);
        MyString actualString2 = firstString.plus(secondString);
        MyString expectedString = new MyString(new char[]{});
        boolean actualResult = actualString.equals(expectedString);
        boolean actualResult2 = actualString2.equals(expectedString);
        Assertions.assertTrue(actualResult);
        Assertions.assertTrue(actualResult2);
    }

    @Test
    public void plusShouldReturnStringWhenEachStringHaveOneSymbol() {
        MyString firstString = new MyString(new char[]{'r'});
        MyString secondString = new MyString(new char[]{'t'});
        MyString actualString = MyString.plus(firstString, secondString);
        MyString actualString2 = firstString.plus(secondString);
        MyString expectedString = new MyString(new char[]{'r','t'});
        boolean actualResult = actualString.equals(expectedString);
        boolean actualResult2 = actualString2.equals(expectedString);
        Assertions.assertTrue(actualResult);
        Assertions.assertTrue(actualResult2);
    }

    @Test
    public void replaceShouldReturnResultWhenReplaceOneSymbol() {
        MyString firsString = new MyString(new char[]{'g', 'o', 'o', 'd', 'l', 'u', 'c', 'k'});
        MyString actualString = firsString.replace('k', 'i');
        MyString expectedString = new MyString(new char[]{'g', 'o', 'o', 'd', 'l', 'u', 'c', 'i'});
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void replaceShouldReturnResultWhenReplaceAllSymbols() {
        MyString firsString = new MyString(new char[]{'g', 'g', 'g', 'g'});
        MyString actualString = firsString.replace('g', 'T');
        MyString expectedString = new MyString(new char[]{'T', 'T', 'T', 'T'});
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void replaceShouldNotReplaceSymbolsWhenObjectHaveNotSymbolForReplace() {
        MyString firsString = new MyString(new char[]{'u', 'h', 'g', 'd'});
        MyString actualString = firsString.replace('j', 'u');
        MyString expectedString = new MyString(new char[]{'u', 'h', 'g', 'd'});
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void replaceShouldReturnResultWhenFieldSmbIsNull() {
        MyString firsString = new MyString(null);
        String actualString = firsString.replace('j', 'u').toString();
        Assertions.assertEquals(null, actualString);
    }

    @Test
    public void replaceShouldReturnResultWhenFieldSmbIsEmpty() {
        MyString firsString = new MyString(new char[]{});
        MyString actualString = firsString.replace('j', 'u');
        MyString expectedString = new MyString(new char[]{});
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }







}