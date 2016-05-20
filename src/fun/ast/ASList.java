package fun.ast;

import fun.Token;

import java.util.Iterator;
import java.util.List;

/**
 * 是非叶子节点的类
 * @author han
 * @date  16-5-19.
 */
public class ASList extends ASTree{
    /**  保存子节点   */
    protected List<ASTree> children;

    /**
     * 构造器
     * @param list astree
     */
    public ASList(List<ASTree> list) {
        children = list;
    }


    /**
     *
     * @param i 节点
     * @return 第i个子节点
     */
    @Override
    public ASTree child(int i) {
        return children.get(i);
    }

    /**
     * 孩子节点的数量
     * @return 列表长度
     */
    @Override
    public int numChildren() {
        return children.size();
    }

    /**
     * 迭代器
     * @return 返回一个迭代器
     */
    @Override
    public Iterator<ASTree> children() {
        return children.iterator();
    }

    /**
     * 子节点的位置
     * @return 不为空返回位置字符串
     *         空返回null
     */
    @Override
    public String location() {
        /**   遍历  */
        for (ASTree child : children) {
            //定位
            String s = child.location();
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    /**
     * 输出打印
     * @return （所有的自节点）
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
//        String sep = "";
        /**   遍历所有孩子节点  */
        for (ASTree child : children) {
//            builder.append(sep);
//            sep = " ";
            //空格后输出
            builder.append(child.toString()).append(" ");
        }
        /**   返回拼接好的字符串  */
        return builder.append(')').toString();
    }

}
