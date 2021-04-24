import java.util.*;

%%
%class Scanner
%standalone
%line
%column

%{
    StringBuffer stringBuffer = new StringBuffer();
    Output out = new Output();
%}

%eof{
    this.out.printResult();    
%eof}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifiers = [a-zA-Z_][a-zA-Z0-9_]*

//Numbers
Sign = ("-"|"+")
Integer = ([1-9] [0-9]* | 0)
Octal = 0 [1-7] [0-7]*
Hexadecimal = (0x| 0X) ([1-9]|[A-F]) ([1-9]|[A-F])*
UnsignedLong = (LU? | UL?)?
Real = {Integer}? "." O* {Integer} {SciNotation}?

//Real Numbers
SciNotation = (e|E) {Sign}? {Integer}

//Char
%state CHAR
//Strings
%state STRING
StringBoundary = \"            

%%

//Keywords
"auto"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"break"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"case"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"char"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"const"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"continue"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"default"                      { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"do"                           { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"double"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"else"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"enum"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"extern"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"float"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"for"                          { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"goto"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"if"                           { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"int"                          { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"long"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"register"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"return"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"short"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"signed"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"sizeof"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"static"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"struct"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"switch"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"typedef"                      { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"union"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"unsigned"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"void"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"volatile"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"while"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }

<YYINITIAL> {
    // Comments
    {Comment}                      {}
// Identifiers
 {Identifiers}         { this.out.addToken(yytext(), "Identificadores", yyline); }

// Literals
{Integer} {UnsignedLong}       { this.out.addToken(yytext(), "Literales", yyline); }

{Octal} {UnsignedLong}         { this.out.addToken(yytext(), "Literales", yyline); }

{Hexadecimal} {UnsignedLong}   { this.out.addToken(yytext(), "Literales", yyline); }

{Real}                         { this.out.addToken(yytext(), "Literales", yyline); }

// Operators
"=="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"<<="                          { this.out.addToken(yytext(), "Operadores", yyline); }
">>="                          { this.out.addToken(yytext(), "Operadores", yyline); }
"<="                           { this.out.addToken(yytext(), "Operadores", yyline); }
">="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"!="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"+="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"-="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"*="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"/="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"%="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"&="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"^="                           { this.out.addToken(yytext(), "Operadores", yyline); }
"|="                           { this.out.addToken(yytext(), "Operadores", yyline); }
">>"                           { this.out.addToken(yytext(), "Operadores", yyline); }
"<<"                           { this.out.addToken(yytext(), "Operadores", yyline); }
"->"                           { this.out.addToken(yytext(), "Operadores", yyline); }
"||"                           { this.out.addToken(yytext(), "Operadores", yyline); }
"&&"                           { this.out.addToken(yytext(), "Operadores", yyline); }
"++"                           { this.out.addToken(yytext(), "Operadores", yyline); }
"--"                           { this.out.addToken(yytext(), "Operadores", yyline); }
"="                            { this.out.addToken(yytext(), "Operadores", yyline); }
"+"                            { this.out.addToken(yytext(), "Operadores", yyline); }
","                            { this.out.addToken(yytext(), "Operadores", yyline); }
";"                            { this.out.addToken(yytext(), "Operadores", yyline); }
">"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"?"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"<"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"!"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"-"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"*"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"/"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"%"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"("                            { this.out.addToken(yytext(), "Operadores", yyline); }
")"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"["                            { this.out.addToken(yytext(), "Operadores", yyline); }
"]"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"{"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"}"                            { this.out.addToken(yytext(), "Operadores", yyline); }
":"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"."                            { this.out.addToken(yytext(), "Operadores", yyline); }
"&"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"^"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"|"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"~"                            { this.out.addToken(yytext(), "Operadores", yyline); }

    {WhiteSpace}                   {}

}

<CHAR> {

    \"                         { yybegin(YYINITIAL); addOp(this.literals, stringBuffer.toString(), yyline, yycolumn); } //Se guarda la columan y fila donde termina
    \\\\                       { stringBuffer.append('\\'); }
    \\\"                       { stringBuffer.append('"'); }
    \\'                        { stringBuffer.append("'"); }
    \\\?                       { stringBuffer.append('?'); }
    \\n                        { stringBuffer.append('\n'); }
    \\r                        { stringBuffer.append('\r'); }
    \\t                        { stringBuffer.append('\t'); }
    [^\n\r\"\\]+               { stringBuffer.append( yytext() ); }
}

//String

<YYINITIAL> {StringBoundary}       { yybegin(STRING); stringBuffer.setLength(0); }  

//Falta tomar en cuena varios caracteres especiales
<STRING> {

    \"                         { yybegin(YYINITIAL); addOp(this.literals, stringBuffer.toString(), yyline, yycolumn); } //Se guarda la columan y fila donde termina
    \\\\                       { stringBuffer.append('\\'); }
    \\\"                       { stringBuffer.append('"'); }
    \\'                        { stringBuffer.append("'"); }
    \\\?                       { stringBuffer.append('?'); }
    \\n                        { stringBuffer.append('\n'); }
    \\r                        { stringBuffer.append('\r'); }
    \\t                        { stringBuffer.append('\t'); }
    [^\n\r\"\\]+               { stringBuffer.append( yytext() ); }
}

. { System.out.println("Error: "+yytext()+ " in line:" + yyline + " column: " + yycolumn); }