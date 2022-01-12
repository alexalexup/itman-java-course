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
}