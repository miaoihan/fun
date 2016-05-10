package fun;

import fun.ast.ASTree;

/**
 * time: 16-5-4.
 * author: han
 */
public class FunException extends RuntimeException {
    public FunException(String m) {
        super(m);
    }
    public FunException (String m, ASTree t){
        super(m + " " + t.location());
    }
}
