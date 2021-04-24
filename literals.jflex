import java.util.ArrayList;

%%

%class literalParse 
%standalone
%line
%column

//Numbers
Sign = ("-"|"+")
Integer = ([1-9] [0-9]* | 0)
Octal = 0 [0-7] [0-7]*
Hexadecimal = (0x| 0X) ([1-9]|[A-F]) ([1-9]|[A-F])*
UnsignedLong = (LU? | UL?)?
//Real Numbers
SciNotation = (e|E) {Sign}? {Integer}
Real = {Sign}? {Integer}? "." O* {Integer} {SciNotation}?

//Falta el f de float pero se ignorara
//Char

//Strings
    StringBegin = \"

%{
    ArrayList<String> literals = new ArrayList<String>();
%}

%eof{
    System.out.println("Literals: ");
    for(String literal : literals){
        System.out.println(literal);
    };
%eof}

%state STRING

%%

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


. { System.out.println("Error: "+yytext()+ " in line:" + yyline + " column: " + yycolumn); }