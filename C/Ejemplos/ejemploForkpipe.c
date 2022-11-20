#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

//ABUELO-HIJO-NIETO

void main(){
	pid_t pid, Hijo_pid , pid2,Hijo2_pid;
	
	int fd1[2];
	int fd2[2];
	
	char saludoAbuelo[]="Saludos del Abuelo.\0";
	char saludoPadre[]="Saludos del Padre .. \0";
	char saludoHijo[]="Saludos del Hijo ... \0";
	char saludoNieto[]="Saludos del Nieto .. \0";
	
	char buffer[80]="";
	
	pipe (fd1);
	pipe(fd2);
	pid = fork(); //Soy el Abuelo, creo a Hijo
	
	if (pid == -1) //Ha ocurrido un error
	{
	printf("No se ha podido crear el proceso hijo ... ");
	exit (-1);
	}
	
	if (pid == 0 ) //Nos -encontramos en Proceso . hijo
	{
		pid2 = fork() ;//Soy el Hijo, creo a Nieto
	  switch(pid2)
	  {
		case -1: // error
			printf("No se ha podido crear el proceso hijo en el HIJO.");
			exit(-1);
			break;
		case 0: //proceso hijo (nieto)
			//NIETO RECIBE
			close(fd2[1]);//cierra el descriptor de entrada
			read(fd2[0], buffer, sizeof(buffer)); //leo el pipe
			printf("\t\tNIETO RECIBE mensaje de su padre:%s\n" ,buffer);
			//NIETO ENVIA
			printf("\t\tNIETO ENVIA MENSAJE a su padre ...\n");
			close(fd1[0]);
			write(fd1[1], saludoNieto,strlen(saludoNieto));
			break;
		default: //proceso padre (hijo)
			//HIJO RECIBE
			close(fd1[1]);//cierra el descriptor de entrada
			read(fd1[0], buffer, sizeof(buffer)); //leo el pipe
			printf("\tHIJO recibe mensaje de ABUELO: %s\n",buffer);
			
			//HIJO ENVIA a su hijo
			close (fd2[0]);
			write(fd2[1] , saludoPadre, strlen(saludoPadre));
			Hijo2_pid=wait(NULL); //espero al hijo
			
			//RECIBE de su hijo
			close(fd1[1]) ;//cierra el descriptor de entrada
			read(fd1[0], buffer, sizeof(buffer)); //leo el pipe
			printf("\tHIJO RECIBE mensaje de su hijo: %s\n",buffer);
			
			//HIJO ENVIA a su PADRE
			printf("\tHIJO ENVIA MENSAJE a su padre ...\n");
			close (fd2[0]);
			write(fd2[1], saludoHijo, strlen(saludoHijo));
  	  }
	}
	else	//Nos encontramos en Proceso padre (abuelo)
	{
		//PADRE ENVIA
		printf ("ABUELO ENVIA MENSAJE AL HIJO ...\n");
		close(fd1[0]);
		write(fd1[1], saludoAbuelo, strlen(saludoAbuelo)); //escribo
		Hijo_pid = wait(NULL); //espera la finalización del hijo
		
		//PADRE RECIBE
		close(fd2[1]) ;//cierra el descripto~ de entrada
		read(fd2[0], buffer, sizeof(buffer)); //leo el pipe
		printf("El ABUELO RECIBE MENSAJE del HIJO: %s \n", buffer);
	}
	exit(0);
}