%{
    #include <stdio.h>
    #include "y.tab.h"
%}
%%

"begin"     return START;
"end"       return END;
"read"      return READ;
"write"     return WRITE;
"INTLIT"    return INTLIT;
"Id"        return ID;
","         return COMA; 
":"         return COLON;
";"         return SEMICOLON;
-           return MINUS;
\+          return PLUS;
\$          return DOLLARSIGN;
\)          return CLOSEDBRACE;
\(          return OPENBRACE;
\=          return EQUAL;
[ \t]       /* ignore whitespace */;
.           return UNKNOWN;

%%

