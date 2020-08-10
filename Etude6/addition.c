#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NUM_LEN 1000
#define RESULT_LEN 1001

void *emalloc(size_t s) {
    void *result = malloc(s);
    if (NULL == result) {
        fprintf(stderr, "Unable to allocate memory\n");
        exit(EXIT_FAILURE);
    }
    return result;
}

int main(void) {    
    int base;
    char a[NUM_LEN];
    char b[NUM_LEN];
    char sum[RESULT_LEN];
    int remainder = 0;
    int a_len;
    int b_len;

    int i;
    char c;

    int ai;
    int bi;

    if (1 == scanf("%d", &base)) {
        if (1 == scanf("%1000s", a)) {
            if (1 == scanf("%1000s", b)) {
                

            } else {
            fprintf(stderr, "Number too long. Must be under 1000 digits\n");
            }

        } else {
            fprintf(stderr, "Number too long. Must be under 1000 digits\n");
        }      

    } else {
        fprintf(stderr, "Base not given\n");
    }



    a_len = strlen(a);
    b_len = strlen(b);

    for (i = a_len - 1; i >= 0; i--) {
        ai = a[i] - '0';
        bi = b[i] - '0';

        c = ai + bi;

        sum += c;

    }
    printf("%s\n", sum);



}