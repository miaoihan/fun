package fun;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 词法分析器
 * time: 16-5-4.
 * author: han
 */
public class Lexer {
    //正则表达式，java里就是这么乱...
    //匹配每一个单词
    public static String regexPat = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
            + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
    //java 正则表达
    private Pattern pattern = Pattern.compile(regexPat);
    //存放单词的列表
    private ArrayList<Token> queue = new ArrayList<>();
    //行是否读取完
    private boolean hasMore;
    private LineNumberReader reader;
    //构造器
    public Lexer(Reader r){
        hasMore = true;
        reader=  new LineNumberReader(r);
    }

    public Token read() throws ParseException{
        if (fillQueue(0)) return queue.remove(0);
        else return Token.EOF;
    }

    /**
     *
     * @param i
     * @return
     * @throws ParseException
     */
    private boolean fillQueue(int i) throws ParseException{
        while (i >= queue.size()){
            if (hasMore) readLine();
            else return false;
        }
        return true;
    }

    /**
     *
     * @throws ParseException
     */
    protected void readLine() throws ParseException{
        //每一行的内容
        String line = null;
        try {
            //读取行
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
//            throw new ParseException(e);
        }
        //如果读取完毕，返回
        if (line == null){
            hasMore = false;
            return;
        }
        //行号
        int lineNo = reader.getLineNumber();
        Matcher matcher = pattern.matcher(line);
        matcher.useTransparentBounds(true).useTransparentBounds(false);
        int pos = 0;
        int endPos = line.length();
        while (pos < endPos){
            matcher.region(pos, endPos);
            if (matcher.lookingAt()){
                addToken(lineNo, matcher);
                pos = matcher.end();
            }
            else throw new ParseException("bad token at line " + lineNo, 0);
        }
        queue.add(new IdToken(lineNo, Token.EOF));
    }

    /**
     *
     * @param lineNo
     * @param matcher
     */
    protected void addToken(int lineNo, Matcher matcher){
        String m = matcher.group(1);
        //若不是空格
        if (m != null) {
            //若不是a comment
            if (matcher.group(2) == null) {
                Token token;
                if (matcher.group(3) != null)
                    token = new NumToken(lineNo, Integer.parseInt(m));
                else if (matcher.group(4) != null)
                    token = new StrToken(lineNom toStringLiteral(m));
                else
                    token = new IdToken(lineNo, m);
                queue.add(token);
            }
        }
    }

    /**
     *
     * @param s 字符串
     * @return
     */
    protected String toStringLiteral(String s){
        StringBuilder sb = new StringBuilder();
        int len = s.length() - 1;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < len){
                int c2 = s.charAt(i);
                if (c2 == '"' || c2 == '\\')
                    c = s.charAt(++i);
                else if (c2 == 'n'){
                    ++i;
                    c = '\n';
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 整型类Token
     */
    protected static class NumToken extends Token{
        private int value;

        protected NumToken(int line, int v) {
            super(line);
            value = v;
        }

        @Override
        //重写父类方法，设置isNumber为true
        public boolean isNumber() {
            return true;
        }
        //得到整型量的字符串形式
        public String getText(){
            return Integer.toString(value);
        }
        public int getNumber(){
            return value;
        }
    }

    protected static class IdToken extends Token{
        private String text;
        protected IdToken(int line, String id){
            super(line);
            text = id;
        }
        public boolean isIdentifier(){ return true; }
        public String getText(){ return text; }
    }




}
