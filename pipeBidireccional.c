#include <stdio.h>

#include <unistd.h>

#include <stdlib.h>

#include <string.h>



int main(void )

{

	int padrehijo[2];

	int hijopadre[2];

	



	char saludoPadre[]="Hola hijo soy tu padre.\0";

	char saludoHijo[]="Hola padre soy tu hijo.\0";

	char buffer[80];

	char buffer2[80];



	pipe(padrehijo);

	pipe(hijopadre);



	switch(fork()) {

		case -1 : //ERROR

		        printf("NO SE HA PODIDO CREAR HIJO ... " );

		        exit (-1);

		case 0: 

		       	for (int i=0;i<3;i++){

			       	close(padrehijo[1]);

				read(padrehijo[0], buffer, sizeof(saludoPadre)); //leo el pipe

				printf("\t El HIJO %d recibe algo del pipe : %s\n",i,buffer);

		       	} 

		       	for (int i=0;i<3;i++){

		       		close(hijopadre[0]);

				write(hijopadre[1],saludoHijo,strlen(saludoHijo)); //escribo en pipe

				printf("El HIJO ENVIA MENSAJE AL PADRE ...\n");

			}

		        break;

		default : 

		       	for (int i=0;i<3;i++){

		       		close(padrehijo[0]);

				write(padrehijo[1],saludoPadre,strlen(saludoPadre)); //escribo en pipe

				printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");

			}

			wait(NULL); //espero al proceso hijo

			for (int i=0;i<3;i++){

			       	close(hijopadre[1]);

				read(hijopadre[0], buffer2, sizeof(saludoHijo)); //leo el pipe

				printf("\t El PADRE %d recibe algo del pipe : %s\n",i,buffer);

		       	} 

		        

		        break;

	}

	return 0;

}
