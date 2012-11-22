%{
    #include <stdio.h>
    #include <string.h>
    int valid = 0;
    void yyerror(const char *str)
    {
        fprintf (stderr, "error: %s\n",str);
    }

    int yywrap()
    {
        if (valid == 1)
        {
            printf("valid\n");
        }
        return 1;
    }

    main()
    {
        yyparse();
    }
%}

%token MINUS MULT PLUS EQUAL READ WRITE ID START END COMA SEMICOLON DOLLARSIGN
%token CLOSEDBRACE OPENBRACE INTLIT COLON UNKNOWN

%start system_goal

%%

program:    START statement_list END
        ;
statement_list: statement statement_tail
        ;
statement_tail: statement statement_tail
        | /* empty */
        ;
statement:  ID COLON EQUAL expression SEMICOLON
        | READ OPENBRACE id_list CLOSEDBRACE SEMICOLON
        | WRITE OPENBRACE expr_list CLOSEDBRACE SEMICOLON
        ;
id_list:    ID id_tail
        ;
id_tail:    COMA ID id_tail
        | /* empty */
        ;
expr_list:  expression expr_tail
        ;
expr_tail:  COMA expression expr_tail
        |   /* empty */
        ;
expression: primary primary_tail
        ;
primary_tail:   add_op primary primary_tail
        |   /* empty */
        |   OPENBRACE expression CLOSEDBRACE
        ;
primary:    ID
        |   INTLIT
        ;
add_op:     PLUS
        |   MINUS
        ;
system_goal:    program DOLLARSIGN { valid = 1; }
        ;

%%

