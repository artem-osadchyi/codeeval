package org.insane.codeeval.hard;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTokenType {

    @Test
    public void testIntegerMatch() {
        assertTrue(TokenType.INTEGER.matches("1234"));
        assertFalse(TokenType.INTEGER.matches("1a"));
    }

    @Test
    public void testAddOperatorMatch() {
        assertTrue(TokenType.ADD_OPERATOR.matches("+"));
        assertFalse(TokenType.ADD_OPERATOR.matches("++"));
        assertFalse(TokenType.ADD_OPERATOR.matches("-"));
        assertFalse(TokenType.ADD_OPERATOR.matches("a"));
    }

    @Test
    public void testSubstractOperatorMatch() {
        assertTrue(TokenType.SUBSTRACT_OPERATOR.matches("-"));
        assertFalse(TokenType.SUBSTRACT_OPERATOR.matches("--"));
        assertFalse(TokenType.SUBSTRACT_OPERATOR.matches("+"));
        assertFalse(TokenType.SUBSTRACT_OPERATOR.matches("a"));
    }

    @Test
    public void testMultiplyOperatorMatch() {
        assertTrue(TokenType.MULTIPLY_OPERATOR.matches("*"));
        assertFalse(TokenType.MULTIPLY_OPERATOR.matches("**"));
        assertFalse(TokenType.MULTIPLY_OPERATOR.matches("+"));
        assertFalse(TokenType.MULTIPLY_OPERATOR.matches("a"));
    }

    @Test
    public void testDivideOperatorMatch() {
        assertTrue(TokenType.DIVIDE_OPERATOR.matches("/"));
        assertFalse(TokenType.DIVIDE_OPERATOR.matches("//"));
        assertFalse(TokenType.DIVIDE_OPERATOR.matches("+"));
        assertFalse(TokenType.DIVIDE_OPERATOR.matches("a"));
    }

    @Test
    public void testGet() {
        assertEquals(TokenType.INTEGER, TokenType.get("1"));
        assertEquals(TokenType.ADD_OPERATOR, TokenType.get("+"));
        assertEquals(TokenType.SUBSTRACT_OPERATOR, TokenType.get("-"));
        assertEquals(TokenType.MULTIPLY_OPERATOR, TokenType.get("*"));
        assertEquals(TokenType.DIVIDE_OPERATOR, TokenType.get("/"));
        assertNull(TokenType.get("as"));
    }

}
