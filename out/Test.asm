datos segment

c db 4 dup (?) 
b db 4 dup (?) 
a db 4 dup (?) 
tempVar0 db 4 dup (?) 


datos ends

pila segment stack 'stack'

    dw 256 dup (?)

pila ends

codigo segment

    assume  cs:codigo, ds:datos, ss:pila

 inicio:
        mov ax, datos   ; protocolo de inicialización del programa.
        mov ds, ax
        mov ax, pila
        mov ss, ax

        ; carnita del programa


        lea di, b
mov bx, word ptr [di]
mov ax, bx
inc axlea di, tempVar0
mov word ptr[di], ax


        mov ax, word ptr [a]
        call printAX
        jmp finale

        printAX proc near
            ; imprime a la salida estandar un numero que supone estar en el AX
            ; supone que es un numero positivo y natural en 16 bits.
            ; lo imprime en decimal.

            push AX
            push BX
            push CX
            push DX

            xor dx, dx
            xor cx, cx
            mov bx, 10

            ciclo1PAX: xor dx, dx
                div bx
                push dx
                inc cx
                cmp ax, 0
                jne ciclo1PAX
                mov ah, 02h
            ciclo2PAX:
                pop dx
                add dl, 30h
                int 21h
                loop ciclo2PAX

            pop DX
            pop CX
            pop BX
            pop AX
            ret
        printAX endp




        finale:
            ;Program close
            mov ax, 4C00h
            int 21h
     
codigo ends

end inicio