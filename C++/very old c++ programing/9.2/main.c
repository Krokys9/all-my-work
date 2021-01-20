#include <stdio.h>
#include <stdlib.h>
typedef struct Stack
{
    int *a;
    int size;
} Stack;

void initStack(Stack *stack)
{
    (*stack).a =NULL;
    (*stack).size =0;
}
void printStack(Stack *stack)
{
    for (int i = 0; i < (*stack).size; i ++)
    {
        printf("%d", (*stack).a[i]);
    }
}
int getStackSize(Stack *stack)
{
    return (*stack).size;
}
void push(Stack *stack, int value)
{
    (*stack).size ++;
    int *tempo = realloc((*stack).a, ((*stack).size) * sizeof(int));
    (*stack).a = tempo;
    (*stack).a[(*stack).size-1] = value;
}
int top(Stack *stack)
{
    return ((*stack).size-1); // grazina paskutinio dinaminio masyvo reiksme
}
int pop(Stack *stack)
{
    (*stack).size --;
    (*stack).a = (int*) realloc((*stack).a, (*stack).size * sizeof(int));
    return ((*stack).size);
}
void destroyStack(Stack *stack)
{
    free((*stack).a);
    free((*stack).size);
}
int main()
{
    Stack k;
    k.a = 5;
    k.size = 5;
    initStack(&k);
    printStack(&k);
    printf ("%d" ,getStackSize(&k));
    push(&k, 8);
    printf("%d", top(&k));
    printf("%d", pop(&k));
    destroyStack(&k);
    return 0;
}
