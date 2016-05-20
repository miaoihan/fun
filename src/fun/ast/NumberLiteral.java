package fun.ast;

import fun.Token;

/**
 * @author han
 * @date 16-5-19.
 */
public class NumberLiteral extends ASTLeaf{

    public NumberLiteral(Token t) {
        super(t);
    }
//    public int value(){ return token.getNumber(); }
    public int value(){ return getToken().getNumber(); }
}
