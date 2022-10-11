#include <stdlib.h>

#include <unistd.h>

#include <stdio.h>

#include <time.h>



int main() {

	pid_t pid;

	pid = fork ();

	

	int cont,j,i;

	

	if (pid == -1){

		printf ("No se ha podido crear el proceso hijo ... " );

		exit(-1);

	}

	if (pid == 0){ //Hijo

		for(i=100000; i<=150000; i++){

			cont=0;

			for(j=1; j<=i; j++){

			    if(i%j==0)

				cont++;

			}

			if(cont==2)

			printf("%d" ,i);

		}

	}

	else { //Padre

		for(i=150000; i<=200000; i++){

			cont=0;

			for(j=1; j<=i; j++){

			    if(i%j==0)

				cont++;

			}

			if(cont==2)

			printf("%d" ,i);

		}

	}

	return 0;

}

	

	

