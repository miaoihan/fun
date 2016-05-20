package fun.ast;

import java.util.List;

/**
 * 这个类是获取父类list的域
 * 含有左值、右值和运算符
 * @author han
 * @date 16-5-20.
 */
public class BinaryExpr extends ASList {
    public BinaryExpr(List<ASTree> a) { super(a);
    }
    public ASTree left(){ return child(0); }
    public String operator(){
        return ((ASTLeaf)child(1)).getToken().getText();
    }
    public ASTree right(){ return child(2); }
}
