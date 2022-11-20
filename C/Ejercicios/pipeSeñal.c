#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>


int main(void ){
    int fd[2];
    int entero = -1;
    int suma=0;
    char buffer[sizeof(entero)];

	srand(time(NULL));

    pipe(fd); //creo pipe

    switch(fork()) {

        case -1 : //ERROR

            printf("NO SE HA PODIDO CREAR HIJO ... " );
            exit (-1);
        case 0: //HIJO RECIBE
            while(entero){
                close(fd[0]); //cierra el descriptor de salida
                entero=rand() % 20;
                write(fd[1], &entero, sizeof(entero)); //escribo el pipe
                printf("\tEl HIJO escribe el pipe : %d\n",entero);
            }

            break;

        default : // PADRE ENVIA

            do{
                close(fd[1]);

                printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");

                write(fd[1],&entero, sizeof(entero)); //escribo en pipe

            }while(entero!=17);

                wait(NULL); //espero al proceso hijo

                break;

    }

    return 0;

}
