%{
    #include <stdio.h>
    #include <iostream>
    using namespace std;

    extern "C" int yylex();
    extern "C" int yyparse();
    extern "C" FILE *yyin;

    void yyerror(const char *s);
%}

%union {
    int ival;
    float fval;
    char *sval;
}

%token <ival> INT
%token <fval> FLOAT
%token <sval> STRING

%%

program:    "begin" statement_list "end"
        ;
statement_list: statement statement_tail
        ;
statement_tail: statement statement_tail
        | /* empty */
        ;
statement:  "Id" ":" "=" expression ";"
        | "read" "(" id_list ")" ";"
        | "write" "(" expr_list ")" ";"
        ;
id_list:    "Id" id_tail
        ;
id_tail:    "," "Id" id_tail
        | /* empty */
        ;
expr_list:  expression expr_tail
        ;
expr_tail:  "," expression expr_tail
        |   /* empty */
        ;
expression: primary primary_tail
        ;
primary_tail:   add_op primary primary_tail
        |   /* empty */
        |   "(" expression ")"
        ;
primary:    "Id"
        |   "INTLIT"
        ;
add_op:     "+"
        |   "-"
        ;
system_goal:    program "$"
        ;

%%

void yyerror(char *s)
{
    fprintf(stderr, "%s\n", s);
}

int main(void) {
    yyparse();
    return 0;
}
