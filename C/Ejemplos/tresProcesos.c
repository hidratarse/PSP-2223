#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
int main() {
        int pid_padre, pid_hijo, pid_hijo1, pid_hijo2;

        pid_padre = getpid();
        pid_hijo = fork();

        switch (pid_hijo){
                case -1:
                        exit(-1);

                case 0:
                        printf("Soy el hijo = 1, Mi padre es = %d, Mi PID = %d\n", pid_padre, getpid());
                        printf("Proceso PADRE = %d\n",pid_padre);
                        break;
                default:
                        pid_hijo1 = fork();
                        switch (pid_hijo1){
                                case -1:
                                        exit(-1);
                                case 0:
                                        printf("Soy el hijo = 2, Mi padre es = %d, Mi PID = %d\n", pid_padre, getpid());
                                        break;
                                default:
                                        pid_hijo2 = fork();
                                        switch (pid_hijo2){
                                                case -1:
                                                        exit(-1);
                                                case 0:
                                                        printf("\nSoy el hijo = 3, Mi padre es = %d, Mi PID = %d\n", pid_padre, getpid());
                                                        break;
                                        }
                        }
        }
}          