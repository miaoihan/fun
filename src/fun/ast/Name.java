package fun.ast;

import fun.Token;

/**
 * @author han
 * @date 16-5-20.
 */
public class Name extends ASTLeaf {
    public Name(Token t){ super(t); }
    public String name(){ return getToken().getText(); }
}
