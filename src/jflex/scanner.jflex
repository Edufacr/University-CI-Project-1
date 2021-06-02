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
    //return new Symbol(sym.EOF, yyline, yycolumn, "Lexic Error");
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

    //Functions
    "read"                         { return new Symbol(sym.READ, yyline, yycolumn, "read"); }
    "write"                        { return new Symbol(sym.WRITE, yyline, yycolumn, "write"); }

    //Keywords
    "auto"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "break"                        { return new Symbol(sym.BREAK, yyline, yycolumn, "break"); }
    "case"                         { return new Symbol(sym.CASE, yyline, yycolumn, "case"); }
    "char"                         { return new Symbol(sym.CHAR, yyline, yycolumn, "char"); }
    "const"                        { return new Symbol(sym.CONST, yyline, yycolumn, "const"); }
    "continue"                     { return new Symbol(sym.CONTINUE, yyline, yycolumn, "continue"); }
    "default"                      { return new Symbol(sym.DEFAULT, yyline, yycolumn, "default"); }
    "do"                           { return new Symbol(sym.DO, yyline, yycolumn, "do"); }
    "double"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "else"                         { return new Symbol(sym.ELSE, yyline, yycolumn, "else"); }
    "enum"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "extern"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "float"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "for"                          { return new Symbol(sym.FOR, yyline, yycolumn, "for"); }
    "goto"                         { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "if"                           { return new Symbol(sym.IF, yyline, yycolumn, "if"); }
    "int"                          { return new Symbol(sym.INT, yyline, yycolumn, "int"); }
    "long"                         { return new Symbol(sym.LONG, yyline, yycolumn, "long"); }
    "register"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "return"                       { return new Symbol(sym.RETURN, yyline, yycolumn, "return"); }
    "short"                        { return new Symbol(sym.SHORT, yyline, yycolumn, "short"); }
    "signed"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "sizeof"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "static"                       { return new Symbol(sym.STATIC, yyline, yycolumn, "static"); }
    "struct"                       { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "switch"                       { return new Symbol(sym.SWITCH, yyline, yycolumn, "switch"); }
    "typedef"                      { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "union"                        { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "unsigned"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "void"                         { return new Symbol(sym.VOID, yyline, yycolumn, "void"); }
    "volatile"                     { this.out.addToken(yytext(), "Palabras Reservadas", yyline); }
    "while"                        { return new Symbol(sym.WHILE, yyline, yycolumn, "while"); }

    // Comments
    {Comment}                      {}
    // Identifiers
    {Identifiers}                  { return new Symbol(sym.IDENTIFIER, yyline, yycolumn, yytext()); }

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
    ";"                            { return new Symbol(sym.SEMICOLON, yyline, yycolumn, ";"); }
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

}
<YYINITIAL> {StringBoundary}   { yybegin(STRING); stringBuffer.setLength(0); bufferColumn = yycolumn+1; }  

<STRING> {
    {StringBoundary}           { yybegin(YYINITIAL); this.out.addToken("\""+stringBuffer.toString()+"\"", "Literales", yyline); } //Se guarda la columan y fila donde termina
    {LineTerminator}           { yybegin(YYINITIAL); this.out.addError("\"" + stringBuffer.toString(), yyline+1, bufferColumn); }
    [^\n\r\"\\]+               { stringBuffer.append( yytext() ); }
    \\\"                       { stringBuffer.append( yytext() ); }
    \\{LineTerminator}         {}
    \\                         { stringBuffer.append( yytext() ); }
}

//. { throw new Error("Illegal character <"+ yytext() +">"); }
. { this.out.addError(yytext(),yyline + 1, yycolumn + 1); }