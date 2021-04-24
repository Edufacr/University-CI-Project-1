import java.util.*;

%%
%class Scanner
%standalone
%line
%column

%{
    List<ArrayList<String>> literals = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> operators = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> identifiers = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> keywords = new ArrayList<ArrayList<String>>();
    
    private void addOp(List<ArrayList<String>> pList, String pOp, int pLine, int pCol) {
        ArrayList<String> op = new ArrayList();
        op.add(pOp);
        op.add(String.valueOf(pLine));
        op.add(String.valueOf(pCol));
        pList.add(op);
    }

    private void printArrays(List<ArrayList<String>> pArray) {
        for (int i = 0; i < pArray.size(); i++) {
            System.out.print("[ "+(pArray.get(i)).get(0) + " ] \t ( "+(pArray.get(i)).get(1) + ":"+(pArray.get(i)).get(2)+" ) \n");
        }
    }
%}

%eof{
    System.out.print("Operators: \n");
    printArrays(this.operators);
    System.out.print("Keywords: \n");
    printArrays(this.keywords);
    System.out.print("Identifiers: \n");
    printArrays(this.identifiers);
    System.out.print("Literals: \n");
    printArrays(this.literals);
    
%eof}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

//Numbers
Sign = ("-"|"+")
Integer = ([1-9] [0-9]* | 0)
Octal = 0 [1-7] [0-7]*
Hexadecimal = (0x| 0X) ([1-9]|[A-F]) ([1-9]|[A-F])*
UnsignedLong = (LU? | UL?)?
Real = {Integer}? "." O* {Integer} {SciNotation}?

//Real Numbers
SciNotation = (e|E) {Sign}? {Integer}

//Strings
StringBegin = \"

%%
// Comments
{Comment}                      {}

//Keywords
"auto"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"break"                        { addOp(this.keywords, yytext(), yyline, yycolumn);}
"case"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"char"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"const"                        { addOp(this.keywords, yytext(), yyline, yycolumn);}
"continue"                     { addOp(this.keywords, yytext(), yyline, yycolumn);}
"default"                      { addOp(this.keywords, yytext(), yyline, yycolumn);}
"do"                           { addOp(this.keywords, yytext(), yyline, yycolumn);}
"double"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"else"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"enum"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"extern"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"float"                        { addOp(this.keywords, yytext(), yyline, yycolumn);}
"for"                          { addOp(this.keywords, yytext(), yyline, yycolumn);}
"goto"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"if"                           { addOp(this.keywords, yytext(), yyline, yycolumn);}
"int"                          { addOp(this.keywords, yytext(), yyline, yycolumn);}
"long"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"register"                     { addOp(this.keywords, yytext(), yyline, yycolumn);}
"return"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"short"                        { addOp(this.keywords, yytext(), yyline, yycolumn);}
"signed"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"sizeof"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"static"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"struct"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"switch"                       { addOp(this.keywords, yytext(), yyline, yycolumn);}
"typedef"                      { addOp(this.keywords, yytext(), yyline, yycolumn);}
"union"                        { addOp(this.keywords, yytext(), yyline, yycolumn);}
"unsigned"                     { addOp(this.keywords, yytext(), yyline, yycolumn);}
"void"                         { addOp(this.keywords, yytext(), yyline, yycolumn);}
"volatile"                     { addOp(this.keywords, yytext(), yyline, yycolumn);}
"while"                        { addOp(this.keywords, yytext(), yyline, yycolumn);}

// Identifiers
[a-zA-Z_][a-zA-Z0-9_]*         { addOp(this.identifiers, yytext(), yyline, yycolumn); }

// Literals
{Integer} {UnsignedLong}       { addOp(this.literals, yytext(), yyline, yycolumn); }

{Octal} {UnsignedLong}         { addOp(this.literals, yytext(), yyline, yycolumn); }

{Hexadecimal} {UnsignedLong}   { addOp(this.literals, yytext(), yyline, yycolumn); }

{Real}                         { addOp(this.literals, yytext(), yyline, yycolumn); }

// Operators
"=="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"<<="                          { addOp(this.operators, yytext(), yyline, yycolumn); }
">>="                          { addOp(this.operators, yytext(), yyline, yycolumn); }
"<="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
">="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"!="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"+="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"-="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"*="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"/="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"%="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"&="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"^="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"|="                           { addOp(this.operators, yytext(), yyline, yycolumn); }
">>"                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"<<"                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"->"                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"||"                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"&&"                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"++"                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"--"                           { addOp(this.operators, yytext(), yyline, yycolumn); }
"="                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"+"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
","                            { addOp(this.operators, yytext(), yyline, yycolumn); }
";"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
">"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"?"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"<"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"!"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"-"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"*"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"/"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"%"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"("                            { addOp(this.operators, yytext(), yyline, yycolumn); }
")"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"["                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"]"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"{"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"}"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
":"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"."                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"&"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"^"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"|"                            { addOp(this.operators, yytext(), yyline, yycolumn); }
"~"                            { addOp(this.operators, yytext(), yyline, yycolumn); }

{WhiteSpace} {}

. { System.out.println("Error: "+yytext()+ " in line:" + yyline + " column: " + yycolumn); }