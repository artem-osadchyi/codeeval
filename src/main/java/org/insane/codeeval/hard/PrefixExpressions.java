package org.insane.codeeval.hard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Prefix Expressions https://www.codeeval.com/open_challenges/7/
 */
public class PrefixExpressions {

    public static void main(String[] args) throws FileNotFoundException {
        PrefixExpressions application = new PrefixExpressions();

        for (String line : readLines(args[0]))
            System.out.println(application.evaluate(line));

    }

    public static List<String> readLines(File file) throws FileNotFoundException {
        List<String> result = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine())
                result.add(input.nextLine());
        }

        return result;
    }

    public static List<String> readLines(String path) throws FileNotFoundException {
        return readLines(new File(path));
    }

    public int evaluate(String expression) {
        return (int) parse(tokenize(expression)).evaluate();
    }

    public Stack<Token> tokenize(String expression) {
        String[] words = expression.trim().split(" +");
        Stack<Token> tokens = new Stack<>();

        for (int i = words.length - 1; i >= 0; i--)
            tokens.add(new Token(words[i]));

        return tokens;
    }

    public Expression parse(Stack<Token> tokens) {
        Expression root = null;

        Token token = tokens.pop();
        switch (token.getType()) {
            case INTEGER:
                root = new IntegerExpression(token);
                break;

            case ADD_OPERATOR:
                AbstractBinaryOperatorExpression addition = new Addition();
                addition.setLeft(parse(tokens));
                addition.setRight(parse(tokens));
                root = addition;
                break;

            case SUBSTRACT_OPERATOR:
                AbstractBinaryOperatorExpression subtraction = new Subtraction();
                subtraction.setLeft(parse(tokens));
                subtraction.setRight(parse(tokens));
                root = subtraction;
                break;

            case MULTIPLY_OPERATOR:
                AbstractBinaryOperatorExpression multiplication = new Multiplication();
                multiplication.setLeft(parse(tokens));
                multiplication.setRight(parse(tokens));
                root = multiplication;
                break;

            case DIVIDE_OPERATOR:
                AbstractBinaryOperatorExpression division = new Division();
                division.setLeft(parse(tokens));
                division.setRight(parse(tokens));
                root = division;
                break;
        }

        return root;
    }

}

enum TokenType {
    INTEGER("\\d+"),
    ADD_OPERATOR("\\+"),
    SUBSTRACT_OPERATOR("\\-"),
    MULTIPLY_OPERATOR("\\*"),
    DIVIDE_OPERATOR("/");

    private final Pattern pattern;

    TokenType(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean matches(String word) {
        return pattern.matcher(word).matches();
    }

    public static TokenType get(String word) {
        for (TokenType type : values())
            if (type.matches(word))
                return type;

        return null;
    }

}

class Token {
    private final TokenType type;
    private final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Token(String value) {
        this(TokenType.get(value), value);
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        return getType() == token.getType() && getValue().equals(token.getValue());
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

}


interface Expression {

    double evaluate();

}

class IntegerExpression implements Expression {
    private final Token token;

    public IntegerExpression(Token token) {
        this.token = token;
    }

    @Override
    public double evaluate() {
        return Integer.valueOf(token.getValue());
    }
}

interface BinaryOperatorExpression extends Expression {

    Expression getLeft();

    Expression getRight();

}

abstract class AbstractBinaryOperatorExpression implements BinaryOperatorExpression {
    private Expression left;
    private Expression right;

    @Override
    public Expression getLeft() {
        return left;
    }

    @Override
    public Expression getRight() {
        return right;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    @Override
    public double evaluate() {
        double left = getLeft().evaluate();
        double right = getRight().evaluate();

        return evaluate(left, right);
    }

    protected abstract double evaluate(double left, double right);

}

class Addition extends AbstractBinaryOperatorExpression {

    @Override
    public double evaluate(double left, double right) {
        return left + right;
    }

}

class Subtraction extends AbstractBinaryOperatorExpression {

    @Override
    public double evaluate(double left, double right) {
        return left - right;
    }

}

class Multiplication extends AbstractBinaryOperatorExpression {

    @Override
    public double evaluate(double left, double right) {
        return left * right;
    }

}

class Division extends AbstractBinaryOperatorExpression {

    @Override
    public double evaluate(double left, double right) {
        return left / right;
    }

}
