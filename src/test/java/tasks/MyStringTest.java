package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStringTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnEmptyStringWhenFieldSmbHaveNotSymbols() {
            MyString a = new MyString(new char[]{});
            String expectedResult = "";
            String actualResult = a.toString();
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnResultWhenFieldSmbHaveOneSymbol() {
            MyString a = new MyString(new char[]{'h'});
            String expectedResult = "h";
            String actualResult = a.toString();
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnResultWhenFieldSmbHaveCharAndDecInOneArray() {
            MyString a = new MyString(new char[] {'H', 101, 108, 108, 111, '!'});
            String expectedResult = "Hello!";
            String actualResult = a.toString();
            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class Length {
        @Test
        public void shouldReturnZeroWhenFieldSmbHaveNotSymbols() {
            MyString a = new MyString(new char[]{});
            int expectedResult = 0;
            int actualResult = a.length();
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnResultWhenFieldSmbHaveSomeSymbols() {
            MyString a = new MyString(new char[]{'d', 's', 's', 'f', 'd'});
            int expectedResult = 5;
            int actualResult = a.length();
            Assertions.assertEquals(expectedResult, actualResult);

        }
    }

    @Nested
    public class CharArt {
        @Test
        public void shouldReturnResultWhenIndexIsFirst() {
            MyString a = new MyString(new char[]{'f', '2', '!', 'g'});
            int index = 0;
            char expectedResult ='f';
            char actualResult = a.charAt(index);
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnResultWhenIndexIsLast() {
            MyString a = new MyString(new char[]{'f', '2', '!', 'g', 't', 'H'});
            int index = 5;
            char expectedResult ='H';
            char actualResult = a.charAt(index);
            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class CompareTo {
        @Test
        public void shouldReturnNegativeNumberWhenFirstStringLessThanSecondAndLengthBothArraysAreSame(){
            MyString firstString = new MyString(new char[]{'c','o','m','p','a'});
            MyString secondString = new MyString(new char[]{'c','o','m','p','o'});
            int actualResult = firstString.compareTo(secondString);
            boolean expectedResult = actualResult < 0;
            Assertions.assertTrue(expectedResult);
        }

        @Test
        public void shouldReturnPositiveNumberWhenFirstStringBiggerThanSecondAndFirstArrayLengthIsBigger() {
            MyString firstString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'z', 'a'});
            MyString secondString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a'});
            int actualResult = firstString.compareTo(secondString);
            boolean expectedResult = actualResult > 0;
            Assertions.assertTrue(expectedResult);
        }

        @Test
        public void shouldReturnZeroWhenBothStringsHaveSameSymbolsAndLength() {
            MyString firstString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't'});
            MyString secondString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't'});
            int actualResult = firstString.compareTo(secondString);
            int expectedResult = 0;
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnNegativeNumberWhenFirstStringLessThanSecond() {
            MyString firstString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't'});
            MyString secondString = new MyString(new char[]{'c', 'o', 'm', 'p', 'p', 'a', 't','f','f'});
            int actualResult = firstString.compareTo(secondString);
            boolean expectedResult = actualResult < 0;
            Assertions.assertTrue(expectedResult);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldBeEqualWhenStringAreSame() {
            MyString firstString = new MyString(new char[]{'f', 'i', 's', 'h'});
            MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h'});
            Assertions.assertEquals(firstString, secondString);
        }

        @Test
        public void shouldNotBeEqualWhenStringHaveDifferentLength() {
            MyString firstString = new MyString(new char[]{'f', 'i', 's', 'h'});
            MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h', 'h', 'h'});
            Assertions.assertNotEquals(firstString, secondString);
        }

        @Test
        public void shouldNotBeEqualWhenStringHaveSameLengthAndDifferentSymbols() {
            MyString firstString = new MyString(new char[]{'f', 'i', 't', 'h'});
            MyString secondString = new MyString(new char[]{'f', 'i', 's', 'h'});
            Assertions.assertNotEquals(firstString, secondString);
        }

        @Test
        public void shouldNotBeEqualWhenSecondStringIsNull() {
            MyString firstString = new MyString(new char[]{'f', 'i', 't', 'h'});
            MyString secondString = null;
            Assertions.assertNotEquals(firstString, secondString);
        }
    }

    @Nested
    public class Plus {
        @Test
        public void shouldReturnSecondStringWhenFirstStringIsEmpty() {
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
        public void shouldReturnFirstStringWhenSecondStringIsEmpty() {
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
        public void shouldReturnEmptyStringWhenBothStringAreEmpty() {
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
        public void shouldReturnStringWhenEachStringHaveOneSymbol() {
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
        public void shouldReturnConcatenationBothStringWhenFirstStringIsLessThanSecond() {
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
    }

    @Nested
    public class Replace {
        @Test
        public void shouldReturnResultWhenReplaceOneSymbol() {
            MyString firsString = new MyString(new char[]{'g', 'o', 'o', 'd', 'l', 'u', 'c', 'k'});
            MyString actualString = firsString.replace('k', 'i');
            MyString expectedString = new MyString(new char[]{'g', 'o', 'o', 'd', 'l', 'u', 'c', 'i'});
            boolean actualResult = actualString.equals(expectedString);
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldReturnResultWhenReplaceAllSymbols() {
            MyString firsString = new MyString(new char[]{'g', 'g', 'g', 'g'});
            MyString actualString = firsString.replace('g', 'T');
            MyString expectedString = new MyString(new char[]{'T', 'T', 'T', 'T'});
            boolean actualResult = actualString.equals(expectedString);
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldNotReplaceSymbolsWhenObjectHaveNotSymbolForReplace() {
            MyString firsString = new MyString(new char[]{'u', 'h', 'g', 'd'});
            MyString actualString = firsString.replace('j', 'u');
            MyString expectedString = new MyString(new char[]{'u', 'h', 'g', 'd'});
            boolean actualResult = actualString.equals(expectedString);
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldReturnResultWhenFieldSmbIsEmpty() {
            MyString firsString = new MyString(new char[]{});
            MyString actualString = firsString.replace('j', 'u');
            MyString expectedString = new MyString(new char[]{});
            boolean actualResult = actualString.equals(expectedString);
            Assertions.assertTrue(actualResult);
        }
    }
}