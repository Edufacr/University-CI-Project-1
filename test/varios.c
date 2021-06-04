/// Prueba de Errores y comentarios
/// Debe reconocer errores de simbolos no reconocidos
/// Comillas sin cerrar, etc.


" un string de 
varias lineas"  // deberia dar error

int main()
{
  ///  ERRORES DE COMILLAS
  char *x = "ljhgsdkjaghsdf ;   //String sin cerrar
  char y = '\b ';  //char mal construido
  char z = '\b ;
  
  
  //  Comentarios

  
  /*
 Prueba de comentarios de Bloque
 "hola soysf "
 char y = '\b ';
 char z = '\b ;  */
 

 ///  ERRORES DE SIMBOLOS NO CONOCIDOS

      \@         //error 
  Á // error
  int árbol;  // error
  º // error
  
  /*  comentario de bloque sin cerrar
  comentario de bloque sin cerrar
  
}
