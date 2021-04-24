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
    
    private void addOp(List<ArrayList<String>> pList, String pOp, int pLine, int pCol) {
        ArrayList<String> op = new ArrayList();
        op.add(pOp);
        op.add(String.valueOf(pLine));
        op.add(String.valueOf(pCol));
        pList.add(op);
    }

    private void printArrays(List<ArrayList<String>> pArray) {
        for (int i = 0; i < pArray.size(); i++) {
            System.out.print("[ "+(pArray.get(i)).get(0) + " ] \t ( l:"+(pArray.get(i)).get(1) + ", c:"+(pArray.get(i)).get(2)+" ) \n");
        }
    }
%}

%eof{
    System.out.print("Operators: \n");
    printArrays(this.operators);
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

// Identifiers
[a-zA-Z_][a-zA-Z0-9_]*        { addOp(this.identifiers, yytext(), yyline, yycolumn); }

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
\n {/*Nothing*/}
. { System.out.println("Error: "+yytext()+ " in line:" + yyline + " column: " + yycolumn); }