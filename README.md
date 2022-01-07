#Object oriented programming

##First stage of "Santa Claus is coming to ACS students" project
###Author: Cherciu Andrei 322CA

---

#About code
Am adaugat 5 package-uri: actions, data, dataprocessing, entities si factory.

###Package-ul actions:
Contine clasa *Simulation* care contine metodele ce simuleaza runda zero si rundele ulterioare.
De asemenea, contine si metodele ce distribuie cadourile, ce sterge cadourile dupa fiecare an,
ce seteaza categoria de varsta si bugetul asignat fiecarui copil

###Package-ul data:
Clasa *AnnualChanges* -- contine schimbarile efectuate intr-un singur an. De asemenea,
contine si metoda ce adauga copii noi in baza de date si metodele ce actualizeaza copii si bugetul
mosului

Clasa *Database* -- contine toate informatiile extrase din fisierele JSON. Aceasta e implementata
folosind design pattern-ul singleton; contine metoda ce sterge copii ce au categoria young adults
si cea care face suma scorurilor average ale fiecarui copil

Clasa *GiftList* -- folosita pentru a impartii cadourile pe categorii

Clasa *InitialData* -- contine lista de copii si lista de cadouri a mosului

Clasa *OutputDatabase* -- contine o lista de obiecte de tip Children;; aceasta clasa e folosita
pentru output in fisiere JSON;; de asemenea, e implementata folosind Singleton

###Package-ul dataprocessing:
Clasa *DataManagement* -- reprezinta clasa de baza a implementarii;; contine metodele ce citesc
din fisierele json, ce scriu in fisierele json, si cele ce incep simularea anilor.
Restul claselor sunt strategiile de calcul a scorului average pentru fiecare categorie de varsta.

##Package-ul entities:
Clasa *Child* contine informatiile pentru un copil si metoda ce determina categoria
de varsta a copilului 

Clasa *Children* reprezinta un wrapper pentru o lista de OutputChild, necesara pentru scrierea
in fisierele json

Clasa *ChildUpdate* contine informatiile necesare pentru actualizarea informatiilor pentru un copil

Clasa *Gift* contine informatiile pentru un cadou

Clasa *OutputChild* contine doar informatiile cerute in output si este necesara pentru scrierea
in fisierele json

###Package-ul factory:
Clasa *CalculateScoreStrategyFactory* contine metoda ce creeaza o strategie in functie de categoria
de varsta a copilului