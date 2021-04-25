int main(){
    
    //COMENTARIOS
    
    //Comentario simple
    
    /* Comentario
       de 
       bloque
    */
    
    /** 
        Comentario especial
    */

    //IDENTIFICADORES
    int var = 0;                //identificador lowercase
    int VAR = 0;                //identificador uppercase
    int _var = 0;               //identificador con underscore
    int var1 = 0;               //identificador con numero
    printf("Hello World");      //identificador de función
    
    //LITERALES
    int _firstInt = 5;          //int
    int negative = -8;          //int negativo
    int b=0xFAFA;               //hex
    int x = 012;                //octal
    float y = 1.21;             //float
    float z = -12.15;           //float negativo
    float zz = 12E10;           //Notacion Cientifica
    float zz = 12.12E10;        //Notacion Cientifica

    //ERRORES LITERALES



    
    //PALABRAS RESERVADAS
    int entero = 0;             //int
    float flotante = 0.0;       //float
    double doble = 0.0;         //double
    long largo = 10;            //long
    short int c = 1;            //short
    signed int result = 12;     //signed
    unsigned int noSigno = 12;  //unsigned
    char simpleChar = 'a'       //char
    char string[] = "c string"; //string
    const int a = 0;            //const
    register int i = 10;        //register
    auto int aa = 32;           //auto
    extern int xtern = 32;      //extern
    static int count=0;         //static
    volatile uint16_t x;        //volatile
    enum reply{yes, no};        //enum
    typedef unsigned char BYTE; //typedef
    printf("%d",sizeof(corto)); //sizeof
    
    if(var == 0){               //if
        printf("Yes");
    } else {                    //else
        printf("No");
    }
    
    
    switch(_firstInt){          //switch
        case 4:                 //case
            printf("Caso 4");
            break;              //break
        case 5:                 
            printf("Caso 5");
            break;              
        default:                //default
            printf("Default");
            break;
    }
    
    do{                         //do
        entero++
    } while(var==0);            //while
    
    for(int gg=0; gg<=3; gg++){ //for
        if(gg<2){
            continue;           //continue
        }
    }
    
    goto label;                 //goto
    label: int statement = 0;
    
    struct Books {              //struct
       char  title[50];
       char  author[50];
       char  subject[100];
       int   book_id;
    } book;
    
    union Data {                //union
       int i;
       float f;
       char str[20];
    } data;  
    
    
    
    //OPERADORES
    int puntoComa;              //operador ;
    a = a+1;                    //operador +
    b = b-1;                    //operador -
    c = c*1;                    //operador *
    a = a/1;                    //operador /
    c = a%b;                    //operador %
    var++;                      //operador ++ 
    VAR--;                      //operador -- 
    int uno, dos = 5, a;        //operador ,
    result = (a==b) && (c>b);   //operadores ==, && y >
    result = (a!=b) || (c<b);   //operadores !=, || y <
    result = !(a == b);         //operador !
    result = (a>=b) && (c<=b);  //operadores >= y <=
    large= a>b ? c : b;         //operadores ? y :
    
    result = a&b;               //operador &
    result = a|b;               //operador |
    result = a^b;               //operador ^
    result = ~35;               //operador ~
    result = a>>1;              //operador >>
    result = a<<1;              //operador <<
    
    int* a = &i;                //operadores * y &
    
    printf("Hello World");      //operadores ()
    char title[50];             //operadores []
    enum saludo{hola, adios};   //operadores {} 
    
    int large = 0;              //operador =
    c += a;                     //operador +=
    c -= a;                     //operador -=
    c *= a;                     //operador *=
    c /= a;                     //operador /=
    c %= a;                     //operador %=
    
    unsigned int mask = 1 << 11;
    a |=  mask;                 //operador |=
    a &= ~mask;                 //operador &=
    a %=  mask;                 //operador %=
    a ^=  mask;                 //operador ^=
    mask <<= 1;                 //operador <<=
    mask >>= 1;                 //operador >>=
    
    struct Book* book;
    book->book_id = 5           //operador ->
    
    struct Point p1 = { 0, 1 };
    p1.x = 20;                  //operador .
    
    return 0; //return
}

void doit( int x ) {        //void
    x = 5; 
}
