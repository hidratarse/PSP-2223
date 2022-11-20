#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>

void interrumpir(int);

int main(){
	signal(SIGINT, interrumpir);
	signal(SIGKILL,interrumpir);
	
	while(1){
		printf("INTERRUMPEME SI PUEDES SOY EL PID:\n");
		sleep(1);
	}
	return 0;
}

void interrumpir(int sig){
	printf("recibida señal, creo fork");
	int pid;
	pid=fork();
}