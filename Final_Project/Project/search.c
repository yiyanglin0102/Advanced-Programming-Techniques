#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {

    char* argument_list[] = {"sh", "./run.sh", argv[1], NULL};

    int status_code = execvp("sh", argument_list);

    


    return 0;
}