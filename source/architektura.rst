Architektura:
==============

.. uml::

	database    Database    as Foo5

	Product <-> Order : n:n
	Order <-> Customer : n:1

	Product -> ProductManager: Product Repository 
	ProductManager -> ProductApi: Model

	Order -> OrderManager: Order Repository 
	OrderManager -> OrderApi: Model
	
	Customer -> CustomerManager: Customer Repository 
	CustomerManager -> CustomerApi: Model
	
	Klient -> ProductApi : Query
	Klient -> OrderApi : Query
	Klient -> CustomerApi : Query
	ProductApi -> Klient : Response
	OrderApi -> Klient : Response
	CustomerApi -> Klient : Response
	
	Foo5 -> Product : Database
	Foo5 -> Order : Database
	Foo5 -> Customer : Database


