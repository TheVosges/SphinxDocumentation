Dostępne dla każdego:
=============================================
GET …/api/product - zwraca produkt o odpowiednim id,
GET …/api/product/all - zwraca listę wszystkich produktów,
GET …/api/order - zwraca zamówienie o podanym id,
GET ../api/order/all - zwraza listę wszystkich zamówień,
POST …/api/order - umieszcza nowe zamówienie w bazie,


Dla zalogowanych użytkowników posiadających uprawnienia klienta (ROLE_CUSTOMER), zapytania:
===============================================================================================================
GET …/api/customer - zwraca klienta o podanym id,
GET …/api/customer/all - zwraza listę wszystkich klientów,


Dla zalogowanych użytkowników posiadających uprawnienia administratora (ROLE_ADMIN):
============================================================================================================
POST …/api/admin/product - umieszcza nowy produkt w bazie,
PUT …/api/admin/product - modufikuje istniejący produkt o zadanym id,
PATCH …/api/admin/product - częściowo modyfikuje istniejący produkt o zadanym id,
POST …/api/admin/customer - umieszcza nowego klienta w bazie,
PUT …/api/admin/customer - modufikuje istniejącego klienta o zadanym id,
PATCH …/api/admin/customer - częściowo modyfikuje istniejącego klienta o podanym id,
PUT …/api/admin/order - modufikuje istniejące zamówienie o zadanym id,
PATCH …/api/admin/order - częściowo modyfikuje istniejące zamówienie o podanym id.
