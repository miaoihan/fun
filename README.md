

# fun

基于java的一个脚本语言.

* 语言设计.
* 正在实现当中...


类型目前定义了三种:

* 标识符
* 整型量
* 字符串

class Token:
    
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
        public boolean isNumber(){ return false; }      //整型量
        public boolean isString(){ return false; }      //字符串
        public int getNumber(){  throw new FunException("not number token");  }
    
        public String getText() {
            return "";
        }
    }
    
    
Enjoy it!
ok


