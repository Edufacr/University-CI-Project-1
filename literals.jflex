import java.util.ArrayList;

%%

%class literalParse 
%standalone
%line
%column


%{
    ArrayList<String> literals = new ArrayList<String>();
%}

%eof{
    System.out.println("Literals: ");
    for(String literal : literals){
        System.out.println(literal);
    };
%eof}

%%

(a|b)*b {literals.add(yytext());}
. { System.out.println("Error: "+yytext()+ " in line:" + yyline + " column: " + yycolumn); }