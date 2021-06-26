datos segment

    c db 4 dup (?) 
b db 4 dup (?) 
a db 4 dup (?) 

    
datos ends

pila segment stack 'stack'

    dw 256 dup (?)

pila ends

codigo segment

    assume  cs:codigo, ds:datos, ss:pila
                                                                             
 inicio: mov ax, datos   ; protocolo de inicialización del programa.
         mov ds, ax
         mov ax, pila
         mov ss, ax

         ; carnita del programa

         {-code-segment}

         mov ax, 4C00h    ; protocolo de finalización del programa.
         int 21h
     
codigo ends

end inicio