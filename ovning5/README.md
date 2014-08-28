Övning 5
========

Dokumentation
http://docs.spring.io/spring/docs/4.0.6.RELEASE/spring-framework-reference/htmlsingle/
Relevanta kapitel: 13. Data access with JDBC

Embedded Tomcat. Fixa koden så servleten fungerar som tänkt. Lös problemet med DI.

Du startar applikationen genom att köra se.r2m.spring.ovning4.Main. Starta sedan en webbläsare och gå till http://localhost:8080/

Övning 5-2
==========

Dokumentation
http://docs.spring.io/spring/docs/4.0.6.RELEASE/spring-framework-reference/htmlsingle/
Relevanta kapitel: 13. Data access with JDBC

1. Skapa ny metod i JdbcVetRepository och en ny servlet som infogar en ny veterinär. Denna ska lyssna på /vet/add?firstname=xxx&lastname=xxx

2. Skapa ny metod i JdbcVetRepository och en ny servlet som hämtar en veterinär med ett specifikt id. Denna ska lyssna på  /vet/id/xxx (alltså ID i URL:en). 

Läs README.md för instruktioner.

Övning 5-3
==========

Dokumentation
http://docs.spring.io/spring/docs/4.0.6.RELEASE/spring-framework-reference/htmlsingle/
Relevanta kapitel: 16. Web MVC Framework

Skapa en MVC-applikation med motsvarande funktionalitet som i 5-2. Samma URLer som tidigare, men lägg till /spring/* framför, tex /spring/vets/ etc. Skapa en Controller och låt den returnera HTML direkt.

