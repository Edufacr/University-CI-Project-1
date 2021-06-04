int b;
char b;
int c;
void foo(int p1, char p2){
    const int a = 1;
    a = 1;
    1;
    if(1){
        a = 1;
        1;
        if(1){
            if(0){
            }
            else{
                int b;
                a = 1;
                //int c; ESTE TIENE QUE DAR ERROR
            }

        }
    }
}