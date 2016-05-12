package fun;

/**
 * Token（单词）抽象类，保存单词
 * 记录字符串、类型、行号等信息
 * time: 16-5-2.
 * author: han
 */

public abstract class Token {
    public static final Token EOF = new Token(-1){};    //end of file
    public static final String EOL = "\\n";             //end of line
    private int lineNumber;

    /**
     * 构造函数，生成带有行号的token
     * @param line 行号
     */
    protected Token(int line){
        lineNumber = line;
    }

    public int getLineNumber() {
        return lineNumber;
    }//得到行号
    public boolean isIdentifier(){ return false; }  //标识符
    public boolean isNumber(){ return false; }      //整形量
    public boolean isString(){ return false; }      //字符串
    public int getNumber(){  throw new FunException("not number token");  } //得到整型量的值

    /**
     * 给子类覆盖用
     * @return 空字符
     */
    public String getText() {
        return "";
    }
}

