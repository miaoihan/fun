package fun;

/**
 * Token（单词）抽象类，保存单词
 * 记录字符串、类型、行号等信息
 * time: 16-5-2.
 * author: han
 */

public abstract class Token {
    public static final Token EOF = new Token(-1){};    //end of file
    public static final String ROL = "\\n";             //end of line
    private int lineNumber;
    protected Token(int line){
        lineNumber = line;
    }

    public int getLineNumber() {
        return lineNumber;
    }
    public boolean isIdentifier(){ return false; }  //标识符
    public boolean isNumber(){ return false; }      //整形量
    public boolean isString(){ return false; }      //字符串
    public int getNumber(){  throw new FunException("not number token");  }

    public String getText() {
        return "";
    }
}

