#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define LECTURA 0
#define ESCRITURA 1
#define NUMENVIO 3
#define TAMAÑOPIPE 2

int main(void )

{
	int padrehijo[TAMAÑOPIPE];
	int hijopadre[TAMAÑOPIPE];

	pipe(padrehijo);
	pipe(hijopadre);

    int entero;
    int numtemp=0;
    int numtemp2=0;
    int numtemp3=0;

    int ordenados[NUMENVIO];

    srand(time(NULL));

	switch(fork()) {
		case -1 : //ERROR
		    printf("NO SE HA PODIDO CREAR HIJO ... " );
		    exit (-1);
		case 0: 
            for (int i=0;i<NUMENVIO;i++){
                close(padrehijo[ESCRITURA]);
                read(padrehijo[LECTURA], &entero, sizeof(entero)); //leo el pipe
                printf("\t El HIJO RECIBE : %d\n",entero);
                numtemp = entero;
                close(hijopadre[LECTURA]);
                write(hijopadre[ESCRITURA],&numtemp, sizeof(numtemp)); //escribo en pipe
            }
            
            break;

    default : 

        for (int i=0;i<NUMENVIO;i++){
            entero=rand() % 10;
            close(padrehijo[LECTURA]);
            write(padrehijo[ESCRITURA],&entero, sizeof(entero)); //escribo en pipe
            printf("El PADRE ENVIA %d AL HIJO ...\n",entero);
        }

        wait(NULL); //espero al proceso hijo

        for (int i=0;i<NUMENVIO;i++){
            close(hijopadre[ESCRITURA]);
            read(hijopadre[LECTURA], &numtemp, sizeof(entero)); //leo el pipe
            printf("El PADRE RECIBE : %d\n",numtemp);
        }
		    break;
	}
	return 0;
}