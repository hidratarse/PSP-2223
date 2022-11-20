#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>

void gestion_hijo( int segnal )
{
    printf("Hijo recibe señal..%d\n", segnal);
    exit(0);
}

int main(void ){
    int fd[2];
    int entero = -1;
    int suma=0;
    char buffer[sizeof(entero)];

	srand(time(NULL));

    pipe(fd); //creo pipe

    int pid_hijo =fork();

    switch(pid_hijo) {

        case -1 : //ERROR

            printf("NO SE HA PODIDO CREAR HIJO ... " );
            exit (-1);
        case 0: //HIJO RECIBE
            signal( SIGUSR1, gestion_hijo );
            while(1){
                close(fd[0]); //cierra el descriptor de salida
                entero=rand() % 10;
                printf("\tEl HIJO escribe el pipe : %d\n",entero);
                write(fd[1], &entero, sizeof(entero)); //escribo el pipe
            }
            break;

        default : // PADRE ENVIA

            do{
                close(fd[1]);
                read(fd[0],&entero, sizeof(entero));
                printf("El PADRE RECIBE ENTEROS ...: %d\n", entero);
                suma+=entero;     
            }while(entero!=0);

                kill(pid_hijo, SIGUSR1);

                wait(NULL); //espero al proceso hijo

                printf("SUMA TOTAL : %d", suma);
                break;
    }

    return 0;
}
