#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main() {
pid_t pid, hijo_pid;

int numero= 6;

printf("Variable inicial = %d", numero);
pid = fork ();
if (pid == -1 )
{
printf("No se ha podido crear el proceso hijo...");
exit(-1);
}
if (pid == 0 )
{
printf("Variable en proceso hijo: %d \n", numero-5);
}
else
{
hijo_pid = wait(NULL);
printf("Variable en proceso padre: %d", numero+5);
}
exit(0);
}