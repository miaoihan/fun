package main;

import fun.CodeDialog;
import fun.Lexer;
import fun.Token;

import java.text.ParseException;

/**
 * time: 16-5-10.
 * author: han
 */
public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        while (l.read() != Token.EOF){
            Token t = l.read();
            System.out.println("-> " + t);
        }
    }
}
