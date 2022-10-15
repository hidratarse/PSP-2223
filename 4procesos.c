#include <stdlib.h>

#include <unistd.h>

#include <stdio.h>

#include <time.h>

int main() {
	int contador=0; 
	int n=4; 
	int inicio=100000, fin=200000; 

	for(int i=0; i<4; i++){
		if (fork() == 0){ //Hijo
			primos(inicio+i, fin, n); 
			printf("[son] pid %d from [parent] pid %d\n",getpid(),getppid());
			exit(0);   
		} 		    
	} 
	for(int i=0; i<4; i++){
		wait(NULL); 
	}	
	return 0;	
}

int primos(inicio, fin, hijos){
	int cont,j,i;
	for(i=inicio; i<=fin; i=i+hijos){
		cont=0;
		for(j=1; j<=i; j++){
	    		if(i%j==0)
				cont++;
		}
		if(cont==2)
			printf("%d" ,i);
	}
	return 0; 
}	