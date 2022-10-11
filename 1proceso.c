#include <stdlib.h>

#include <unistd.h>
#include <stdio.h>
#include <time.h>

int main() {

	int cont,j,i;

	

	for(i=100000; i<=200000; i++){

		cont=0;

		for(j=1; j<=i; j++){

		    if(i%j==0)

			cont++;

		}

		if(cont==2)

		printf("%d",i);

	}

	return 0;

}