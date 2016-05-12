# 一、分割单词

## Token 对象
* 单词的数据结构
* 有标识符（Identifier）、整型量(Number)、字符串量（String）

## 正则表达式定义单词
* 整型：[0-9]
* 标识符：[A-Z_a-z][A-Z_a-z0-9]*
* final: [A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||p{Punct}

## 借助java.util.regex 设计分析器
* 依赖java正则库，速度比自己手动实现**性能更好**
* Lexer类是一个词法分析器，构造函数接受一个java.io.Reader对象，根据需要逐行读取源代码
* regexPat 保存正则表达式
* read从源代码逐一获取单词，peek用于预读单词。peek(1) 等于调用两次read

## 定义抽象语法树
* 用于分析表达式
*
*
*

