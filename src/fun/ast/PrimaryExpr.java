package fun.ast;

import java.util.List;

/**
 * @author han
 * @date 16-5-25.
 */
public class PrimaryExpr extends ASTList {

    /**
     * 构造方法
     * @param list astree
     */
    public PrimaryExpr(List<ASTree> list) {
        super(list);
    }

    /**
     *
     * @param list 创建的
     * @return ASTree节点
     */
    public static ASTree create(List<ASTree> list){
        return list.size() == 1 ? list.get(0) : new PrimaryExpr(list);
    }
}
