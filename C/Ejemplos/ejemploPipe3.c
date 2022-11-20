#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void )
{
        int fd[2];
        pid_t pid;
        char saludoPadre[]="Buenos dias hijo.\0";
        char buffer[80];

        pipe(fd); //creo pipe
        pid=fork(); // creo proceso

        switch(pid) {
                case -1 : //ERROR
                        printf("NO SE HA PODIDO CREAR HIJO ... " );
                        exit (-1);
                case 0: //HIJO RECIBE
                        close(fd[1]); //cierra el descriptor de entrada
                        read(fd[0], buffer, sizeof(buffer)); //leo el pipe
                        printf("\tEl HIJO recibe algo del pipe : %s\n",buffer);
                        break;
                default : // PADRE ENVIA
                        close(fd[0]);
                        write(fd[1],saludoPadre,strlen(saludoPadre)); //escribo en pipe
                        printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");
                        wait(NULL); //espero al proceso hijo
                        break;
        }
        return 0;
}