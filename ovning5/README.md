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

Övning 5-3
==========

Dokumentation
http://docs.spring.io/spring/docs/4.0.6.RELEASE/spring-framework-reference/htmlsingle/
Relevanta kapitel: 16. Web MVC Framework

1. Använd JavaConfig
2. Lägg till beroende till spring-webmvc i pom.xml.
3. Skapa en MVC-applikation med motsvarande funktionalitet som i 5-2. Samma URLer som tidigare, men lägg till /spring/* framför, tex /spring/vets/ etc.
4. Skapa en Controller och låt den returnera HTML direkt, skapa ingen vy.

Övning 5-4
==========

Dokumentation
http://freemarker.org/docs/
Relevanta kapitel: 3. The Template

http://docs.spring.io/spring/docs/4.0.6.RELEASE/spring-framework-reference/htmlsingle/
Relevanta kapitel: 16.5 Resolving views

1. Använd JavaConfig
2. Lägg till beroende till freemarker spring-context-support i pom.xml.
3. Skapa en FreeMarkerConfig och en FreeMarkerViewResolver böna
4. Skapa templates för varje vy med freemarker och använd dem för att rendera vyn med modellobjekten

Övning 5-5
==========

Dokumentation
http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/

1. Använd JavaConfig och @Secure annoteringen
2. Lägg till beroende till spring-security-web och spring-security-config i pom.xml.
3. Skapa en ny SpringSecurityConfig klass och konfigurera två in-memory användare, en med roll USER och en med roll ADMIN
4. Enabla den bortkommenterade koden i Main för Spring Security
5. Konfigurera så alla URL:er kräver roll USER, utom /vet/add vet som skall kräva roll ADMIN

Övning 5-6
==========

Dokumentation
http://docs.spring.io/spring/docs/4.0.6.RELEASE/spring-framework-reference/htmlsingle/
Relevanta kapitel: 16. Web MVC Framework

1. Knyt ihop säcken
2. Skapa en sida som listar alla veterinärer med ett inmatningsformulär längst ner för att mata in nya användare
3. Använd @ModelAttribute istället för @RequestParam
4. När man matat in en ny ny användare skall den dyka upp på listan
5. Alla användare ska vara klickbara och skall leda till sidan med en Vet representerad i Json eller XML
6. Man måste ha roll USER för att se information och roll ADMIN för att kunna mata in information
