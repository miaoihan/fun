package fun.ast;
import java.util.Iterator;

/**
 * 抽象语法树
 */
public abstract class ASTree implements Iterable<ASTree> {
    //得到第i个子节点
    public abstract ASTree child(int i);
    //得到子节点的数量
    public abstract int numChildren();
    //返回一个可以遍历所有子节点的 迭代器
    public abstract Iterator<ASTree> children();
    //返回语法树接点在程序内所处位置的字符串
    public abstract String location();
    //适配器，在将ASTree转换成Iterable时会用到
    public Iterator<ASTree> iterator() { return children(); }
}
