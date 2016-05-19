package fun.ast;

import java.util.Iterator;
import java.util.List;

/**
 * @author han
 * @date 16-5-19.
 */
public class ASList extends ASTree{
    protected List<ASTree> children;

    /**
     *
     * @param i 节点
     * @return
     */
    @Override
    public ASTree child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public Iterator<ASTree> children() {
        return null;
    }

    @Override
    public String location() {
        return null;
    }
}
