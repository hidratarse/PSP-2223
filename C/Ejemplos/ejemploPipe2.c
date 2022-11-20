#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h> 
int main(void){
	//creacion de variables
	int fd[2];
	int fd2[2];
	pid_t pid,hijo_pid;
	char saludoHijo[] = "Saludos del hijo...\n";
	char saludoPadre[] = "Saludos del padre...\n";
	char buffer[50]="";
	
	//creacion de los pipes
	pipe(fd); 
	pipe(fd2);

	//creacion del proceso hijo
	pid=fork(); 

	switch(pid) {
		case -1:
			printf ("HA HABIDO UN ERROR...\n");
			exit(-1);
		case 0:
			//Cerramos el descriptor que no vamos a usar con close()
			close(fd[1]);
			read(fd[0], buffer, sizeof(buffer)); 
			printf("\tHIJO RECIBE MENSAJE DE PADRE: %s",buffer);
			close(fd2[0]);
			write(fd2[1] ,saludoHijo,strlen(saludoHijo));
			printf("\tHIJO ENVIA MENSAJE A SU PADRE.\n");
			break;
		default:
			//Cerramos el descriptor que no vamos a usar con close()
			close(fd[0]);
			printf("\tPADRE ENVIA MENSAJE.\n") ;
			write(fd[1] ,saludoPadre,strlen(saludoPadre));
			hijo_pid=wait(NULL);
			close(fd2[1]);
			read(fd2[0], buffer, sizeof(buffer)); 
			printf("\tPADRE RECIBE MENSAJE DEL HIJO: %s",buffer);
			break;
	}
	return 0;
}