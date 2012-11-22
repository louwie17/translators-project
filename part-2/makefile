compile:	grammer.lex grammer.y
	yacc -d grammer.y
	lex grammer.lex
	cc lex.yy.c y.tab.c -o grammer
test:	grammer
	@echo '-----------valid------------'
	echo 'begin read ( Id , Id ) ; end $$' | grammer
	@echo ''
	echo 'begin Id : = Id ; read ( Id , Id ) ; end $$' | grammer
	@echo ''
	echo 'begin Id : = INTLIT ( Id + INTLIT ( Id ) ) ; write ( Id - INTLIT , Id ( INTLIT + INTLIT ) ) ; read ( Id , Id , Id ) ; end $$' | grammer
	@echo ''
	echo 'begin read ( Id , Id ) ; read ( Id , Id , Id ) ; write ( Id ( INTLIT - INTLIT - INTLIT + Id ) , Id + Id  ) ; Id : = Id ; end $$' | grammer
	@echo ''
	@echo '----------invalid-----------'
	echo 'begin read ( Id , Id ) ; read ( Id , Id , Id ) ; write ( Id ( INTLT - INTLIT - INTLIT + Id ) , Id + Id  ) ; Id : = Id ; end $$' | grammer
	@echo ''
	echo 'begin read ( Id , Id ) ; end $$ as' | grammer
	@echo '' 
	echo 'begin read ( Id , Id ) end $$' | grammer
	@echo ''
	echo 'begin read ( Id ) ; end' | grammer
	@echo ''
	echo 'begin Id : INTLIT ( Id + INTLIT ( Id ) ) ; write ( Id - INTLIT , Id ( INTLIT + INTLIT ) ) ; read ( Id , Id , Id ) ; end $$' | grammer
