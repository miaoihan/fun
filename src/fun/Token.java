package fun;

/**
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
    public boolean isIdentifier(){ return false; }
    public boolean isNumber(){ return false; }
    public boolean isString(){ return false; }
    public int getNumber(){  throw new FunException("not number token");  }

    public String getText() {
        return "";
    }
}

