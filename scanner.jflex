import java.util.*;

%%
%class Scanner
%standalone
%line
%column

%{
    ArrayList<String> literals = new ArrayList<String>();

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

//Numbers
Sign = ("-"|"+")
Integer = ([1-9] [0-9]* | 0)
Octal = 0 [1-7] [0-7]*
Hexadecimal = (0x| 0X) ([1-9]|[A-F]) ([1-9]|[A-F])*
UnsignedLong = (LU? | UL?)?
Real = {Sign}? {Integer}? "." O* {Integer} {SciNotation}?

//Real Numbers
SciNotation = (e|E) {Sign}? {Integer}

//Strings
StringBegin = \"

%%
// Comments
{Comment}                      {}

// Identifiers
^[a-zA-Z_][a-zA-Z0-9_]* {
    System.out.printf(
        "Found match: %s at line %d column %d\n",
        yytext(), yyline, yycolumn
    );
}

// Literals
{Sign}? {Integer} {UnsignedLong} {
                            literals.add(yytext()); 
                            System.out.println(yytext()+" Dec");}

{Sign}? {Octal} {UnsignedLong} {
                            literals.add(yytext()); 
                            System.out.println(yytext()+" Octa");}

{Sign}? {Hexadecimal} {UnsignedLong}  {
                                literals.add(yytext()); 
                                System.out.println(yytext()+" Hex");}
{Real} {literals.add(yytext()); 
                                System.out.println(yytext()+" Real");}

// Operators
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


\n {/*Nothing*/}
. { System.out.println("Error: "+yytext()+ " in line:" + yyline + " column: " + yycolumn); }