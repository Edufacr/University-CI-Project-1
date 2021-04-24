import java.util.*;

%%
%class Scanner
%standalone
%line
%column

%{
    List<ArrayList<String>> operators = new ArrayList<ArrayList<String>>();
    
    private void addOp(String pOp, int pLine, int pCol) {
        ArrayList<String> op = new ArrayList();
        op.add(pOp);
        op.add(String.valueOf(pLine));
        op.add(String.valueOf(pCol));
        this.operators.add(op);
    }
%}

%eof{
    System.out.print("Operators: \n");
    for (int i = 0; i < operators.size(); i++) {
        System.out.print("op: "+(operators.get(i)).get(0) + " l:"+(operators.get(i)).get(1) + " c:"+(operators.get(i)).get(2)+"\n");
    }
%eof}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]


Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

%%
{Comment}                      {}

"=="                           { addOp(yytext(), yyline, yycolumn); }
"<<="                          { addOp(yytext(), yyline, yycolumn); }
">>="                          { addOp(yytext(), yyline, yycolumn); }
"<="                           { addOp(yytext(), yyline, yycolumn); }
">="                           { addOp(yytext(), yyline, yycolumn); }
"!="                           { addOp(yytext(), yyline, yycolumn); }
"+="                           { addOp(yytext(), yyline, yycolumn); }
"-="                           { addOp(yytext(), yyline, yycolumn); }
"*="                           { addOp(yytext(), yyline, yycolumn); }
"/="                           { addOp(yytext(), yyline, yycolumn); }
"%="                           { addOp(yytext(), yyline, yycolumn); }
"&="                           { addOp(yytext(), yyline, yycolumn); }
"^="                           { addOp(yytext(), yyline, yycolumn); }
"|="                           { addOp(yytext(), yyline, yycolumn); }
">>"                           { addOp(yytext(), yyline, yycolumn); }
"<<"                           { addOp(yytext(), yyline, yycolumn); }
"->"                           { addOp(yytext(), yyline, yycolumn); }
"||"                           { addOp(yytext(), yyline, yycolumn); }
"&&"                           { addOp(yytext(), yyline, yycolumn); }
"++"                           { addOp(yytext(), yyline, yycolumn); }
"--"                           { addOp(yytext(), yyline, yycolumn); }
"="                            { addOp(yytext(), yyline, yycolumn); }
"+"                            { addOp(yytext(), yyline, yycolumn); }
","                            { addOp(yytext(), yyline, yycolumn); }
";"                            { addOp(yytext(), yyline, yycolumn); }
">"                            { addOp(yytext(), yyline, yycolumn); }
"?"                            { addOp(yytext(), yyline, yycolumn); }
"<"                            { addOp(yytext(), yyline, yycolumn); }
"!"                            { addOp(yytext(), yyline, yycolumn); }
"-"                            { addOp(yytext(), yyline, yycolumn); }
"*"                            { addOp(yytext(), yyline, yycolumn); }
"/"                            { addOp(yytext(), yyline, yycolumn); }
"%"                            { addOp(yytext(), yyline, yycolumn); }
"("                            { addOp(yytext(), yyline, yycolumn); }
")"                            { addOp(yytext(), yyline, yycolumn); }
"["                            { addOp(yytext(), yyline, yycolumn); }
"]"                            { addOp(yytext(), yyline, yycolumn); }
"{"                            { addOp(yytext(), yyline, yycolumn); }
"}"                            { addOp(yytext(), yyline, yycolumn); }
":"                            { addOp(yytext(), yyline, yycolumn); }
"."                            { addOp(yytext(), yyline, yycolumn); }
"&"                            { addOp(yytext(), yyline, yycolumn); }
"^"                            { addOp(yytext(), yyline, yycolumn); }
"|"                            { addOp(yytext(), yyline, yycolumn); }
"~"                            { addOp(yytext(), yyline, yycolumn); }