import java.util.*;
import java_cup.runtime.*;

%%
%class Scanner
%cup
%line
%column

%{
    StringBuffer stringBuffer = new StringBuffer();
    StringBuffer charBuffer = new StringBuffer();
    int bufferColumn = 0;
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
Hexadecimal = (0x| 0X) ([1-9]|[a-fA-F])+
UnsignedLong = (LU? | UL?)?
Real = {Integer}? "." O* {Integer} {SciNotation}?

//Real Numbers
SciNotation = (e|E) {Sign}? {Integer}

//Strings
%state STRING
StringBoundary = \"    

%%

<YYINITIAL> {

//Keywords
"auto"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"break"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"case"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"char"                         { return new Symbol(sym.CHAR, yyline, yycolumn, "char"); }
"const"                        { return new Symbol(sym.CONST, yyline, yycolumn, "consty"); }
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
"long"                         { return new Symbol(sym.LONG, yyline, yycolumn, "long"); }
"register"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"return"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"short"                        { return new Symbol(sym.SHORT, yyline, yycolumn, "short"); } }
"signed"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"sizeof"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"static"                       { return new Symbol(sym.STATIC, yyline, yycolumn, "static"); }
"struct"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"switch"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"typedef"                      { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"union"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"unsigned"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"void"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"volatile"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
"while"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }

// Comments
{Comment}                      {}
// Identifiers
{Identifiers}                  { return new Symbol(sym.ID, yyline, yycolumn, "id"); }

// Literals
{Integer} {UnsignedLong}       { return new Symbol(sym.NUMCONST, yyline, yycolumn, "numconst"); }

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
"="                            { return new Symbol(sym.ASSIGN, yyline, yycolumn, "assign"); }
"+"                            { this.out.addToken(yytext(), "Operadores", yyline); }
","                            { return new Symbol(sym.COMMA, yyline, yycolumn, "comma"); }
";"                            { return new Symbol(sym.SEMICOLON, yyline, yycolumn, "hola"); }
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
"["                            { return new Symbol(sym.RBRACK, yyline, yycolumn, "["); }
"]"                            { return new Symbol(sym.LBRACK, yyline, yycolumn, "]"); }
"{"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"}"                            { this.out.addToken(yytext(), "Operadores", yyline); }
":"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"."                            { this.out.addToken(yytext(), "Operadores", yyline); }
"&"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"^"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"|"                            { this.out.addToken(yytext(), "Operadores", yyline); }
"~"                            { this.out.addToken(yytext(), "Operadores", yyline); }

{WhiteSpace}                   {}

'[a-zA-Z0-9]'                  {this.out.addToken(yytext(), "Literales", yyline);}
'\\x([0-9A-Fa-f])'             {this.out.addToken(yytext(), "Literales", yyline);}
'\\[0-7]{1,3}'                 {this.out.addToken(yytext(), "Literales", yyline);}
'\\[\'\"\?\\]'                 {this.out.addToken(yytext(), "Literales", yyline);}
'\\[abfnrtv]'                  {this.out.addToken(yytext(), "Literales", yyline);}

//Error ' sin cerrar
'[^\n\r']*                      {yybegin(YYINITIAL); this.out.addError(yytext(), yyline+1, yycolumn+1);}


<YYINITIAL> {StringBoundary}   { yybegin(STRING); stringBuffer.setLength(0); bufferColumn = yycolumn+1; }  

<STRING> {
    {StringBoundary}           { yybegin(YYINITIAL); this.out.addToken("\""+stringBuffer.toString()+"\"", "Literales", yyline); } //Se guarda la columan y fila donde termina
    {LineTerminator}           { yybegin(YYINITIAL); this.out.addError("\"" + stringBuffer.toString(), yyline+1, bufferColumn); }
    [^\n\r\"\\]+               { stringBuffer.append( yytext() ); }
    \\\"                       { stringBuffer.append( yytext() ); }
    \\{LineTerminator}         {}
    \\                         { stringBuffer.append( yytext() ); }
}

. { this.out.addError(yytext(),yyline+1,yycolumn+1); }