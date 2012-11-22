/* A Bison parser, made by GNU Bison 2.5.  */

/* Bison interface for Yacc-like parsers in C
   
      Copyright (C) 1984, 1989-1990, 2000-2011 Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */


/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     MINUS = 258,
     MULT = 259,
     PLUS = 260,
     EQUAL = 261,
     READ = 262,
     WRITE = 263,
     ID = 264,
     START = 265,
     END = 266,
     COMA = 267,
     SEMICOLON = 268,
     DOLLARSIGN = 269,
     CLOSEDBRACE = 270,
     OPENBRACE = 271,
     INTLIT = 272,
     COLON = 273,
     UNKNOWN = 274
   };
#endif
/* Tokens.  */
#define MINUS 258
#define MULT 259
#define PLUS 260
#define EQUAL 261
#define READ 262
#define WRITE 263
#define ID 264
#define START 265
#define END 266
#define COMA 267
#define SEMICOLON 268
#define DOLLARSIGN 269
#define CLOSEDBRACE 270
#define OPENBRACE 271
#define INTLIT 272
#define COLON 273
#define UNKNOWN 274




#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;


