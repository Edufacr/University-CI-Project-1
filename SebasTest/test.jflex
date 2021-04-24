%%
%class search 
%standalone
%line
%column
%%
^[a-zA-Z_][a-zA-Z0-9_]* {
    System.out.printf(
        "Found match: %s at line %d column %d\n",
        yytext(), yyline, yycolumn
    );
}
\n {/*Nothing*/}
. {/*Nothing*/}