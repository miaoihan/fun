package fun.ast;

import fun.Token;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 叶子节点类。继承自ASTree
 * time: 16-5-12.
 * author: han
 */
public class ASTLeaf extends ASTree {

    private static ArrayList<ASTree> empty = new ArrayList<>();
    protected Token token;
    public ASTLeaf(Token t) {token = t;}

    /**
     *
     * @param i
     * @return
     */
    @Override
    public ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    /**
     * 叶子节点没有子节点 返回0
     * @return 0
     */
    @Override
    public int numChildren() {
        return 0;
    }

    /**
     * 子节点，没有子节点
     * @return
     */
    @Override
    public Iterator<ASTree> children() {
        return empty.iterator();
    }

    @Override
    public String location() {
        return "at line " + token.getLineNumber();
    }

    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return token.getText();
    }
}
