package fun.ast;
import java.util.Iterator;

/**
 *
 */
public abstract class ASTree implements Iterable<ASTree> {
    //子节点
    public abstract ASTree child(int i);
    //子节点的数量
    public abstract int numChildren();
    //
    public abstract Iterator<ASTree> children();
    public abstract String location();
    public Iterator<ASTree> iterator() { return children(); }
}
