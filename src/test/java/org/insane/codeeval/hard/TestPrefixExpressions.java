package org.insane.codeeval.hard;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class TestPrefixExpressions {
    private PrefixExpressions application;

    @Before
    public void setUp() {
        application = new PrefixExpressions();
    }

    @Test
    public void testTokenize() {
        String expression = "+ - * / 2";
        Stack<Token> expected = toStack(new Token[]{
                new Token("+"),
                new Token("-"),
                new Token("*"),
                new Token("/"),
                new Token("2")
        });
        Stack<Token> actual = application.tokenize(expression);

        assertEquals(expected, actual);
    }

    @Test
    public void testTokenizeWithRandomSpaces() {
        String expression = "   +  -    *  /     2     ";
        Stack<Token> expected = toStack(new Token[]{
                new Token("+"),
                new Token("-"),
                new Token("*"),
                new Token("/"),
                new Token("2")
        });
        Stack<Token> actual = application.tokenize(expression);

        assertEquals(expected, actual);
    }

    @Test
    public void testEvaluateIntegerExpression() {
        assertEquals(3, application.evaluate("3"));
    }

    @Test
    public void testAddition() {
        assertEquals(7, application.evaluate("+ 3 4"));
    }

    @Test
    public void testSubstraction() {
        assertEquals(-1, application.evaluate("- 3 4"));
    }

    @Test
    public void testMultiplication() {
        assertEquals(12, application.evaluate("* 3 4"));
    }

    @Test
    public void testDivision() {
        assertEquals(0, application.evaluate("/ 3 4"));
    }

    @Test
    public void testEvaluateCompoundExpression() {
        assertEquals(8, application.evaluate("* + 2 2 2"));
    }

    protected <T> Stack<T> toStack(T[] array) {
        Stack<T> result = new Stack<>();

        for (int i = array.length - 1; i >= 0; i--)
            result.add(array[i]);

        return result;
    }

}
