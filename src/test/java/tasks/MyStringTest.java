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

}