#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <time.h>

#define NUMHIJOS 10 //Numero de hijos que se van a crear
#define MULTIPLICAR 9 //Valor maximo por el que se va a multiplicar

int main() {
int num;

	for(int i=0; i<NUMHIJOS; i++){
		if (fork() == 0){ //Hijo
            printf("SOY HIJO %d FROM A MULTIPLICAR\n",i);
            for (int j = 0; j < MULTIPLICAR; j++)
            {
                num=i*j;
                printf("%d por %d es igual a %d\n",i,j, num);
            }
			exit(0);   
		} 		    
	} 
	for(int i=0; i<NUMHIJOS; i++){
		wait(NULL);//EL PADRE ESPERA A LOS HIJOS 
	}	
	return 0;	
}