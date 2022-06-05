# Inżynieria oprogramowania - Spring Data
###### tags: `inżynieria_oprogramowania_l`

Repo link: https://github.com/TheVosges/SpringData

## Ćwiczenie I - połączenie bazy danych

1. Zrzut ekranu z konsoli H2 przedstawiający wypełnioną tabelę (podpunkt 3. ćwiczenia pierwszego)

<center>

![](https://i.imgur.com/Hgv2DQU.png)

</center>

2. Zrzut ekranu z pgAdmina przedstawiający wypełnioną tabelę (podpunkt 5. ćwiczenia pierwszego)

<center>

![](https://i.imgur.com/wIOg1aI.png)

</center>

## Ćwiczenie II - relacje

1. Zrzuty ekranu z konsoli H2 lub z pgAdmia przedstawiające wypełnione cztery tabele (podpunkt 3. ćwiczenia pierwszego)

<center>

![](https://i.imgur.com/aQxY5B9.png)
Tabela 1. Customers

![](https://i.imgur.com/M0yteXB.png)
Tabela 2. Orders
    
![](https://i.imgur.com/OQ3QAkY.png)
Tabela 3. Product

![](https://i.imgur.com/N4RdPTq.png)
Tabela 4. products_orders
    
</center>

## Teoria

1. Jak oceniasz w skali 0-10 trudność zadań ze Spring Data.

Odpowiedź: 4

2. Co sprawiło najwięcej problemów.

Odpowiedź: Myślę że najtrudniejszym było zrozumienie działania relacji @ManyToMany, mnóstwo przykładów na internecie zawiera obiekty Set<> w obu klasach. Na szczęście przypomniałem sobie o adnotacji @Transient pozwalającej pominąć to pole.

3. Opisz, krótko, własnymi słowami (maks 5 zdań):

    1. czym jest relacyjna baza danych - jest to baza składająca się z encji (lub potocznie mówiąc tabel) posiadających różne atrybuty (kolumny) między którymi mogą występować trzy rodzaje relacji - jeden do wielu, jeden do jednego i wiele do wielu. 

    2. czym jest ORM - Object-Relational Mapping to technika mapowania relecyjnych baz danych do obiektów języka programowania oraz odwrotnie.  

    3. czym jest tabela łącznikowa - tabela łącznikowa powstaje w przypadku relacji wiele do wielu. Jest to pośrednik tej relacji posiadający informacje o tej relacji (np. zamówienie 1 zawiera produkt 1, zamówienie 1 zawiera produkt 2, zamówienie 2 zawiera produkt 1).# SphinxDocumentation
