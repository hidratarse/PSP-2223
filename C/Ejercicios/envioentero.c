#include <stdio.h>

#include <unistd.h>

#include <stdlib.h>

#include <string.h>



int main(void )

{

        int fd[2];

	int suma=0; 

        int entero = -1;

        char buffer[sizeof(entero)];

	srand(time(NULL));

        pipe(fd); //creo pipe



        switch(fork()) {

                case -1 : //ERROR

                        printf("NO SE HA PODIDO CREAR HIJO ... " );

                        exit (-1);

                case 0: //HIJO RECIBE

                	do{

                		close(fd[1]); //cierra el descriptor de entrada

              			suma=suma+entero; 

                        	read(fd[0], &entero, sizeof(entero)); //leo el pipe

                        	printf("\tEl HIJO recibe algo del pipe : %d\n",entero);

                	}while(entero!=17);

                        printf("La suma es %d", suma); 

                        break;

                default : // PADRE ENVIA

                	do{

		        	close(fd[0]);

		                entero=rand() % 20;

		                printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");

		                write(fd[1],&entero, sizeof(entero)); //escribo en pipe

                	}while(entero!=17);

                        wait(NULL); //espero al proceso hijo

                        break;

        }

        return 0;

}

