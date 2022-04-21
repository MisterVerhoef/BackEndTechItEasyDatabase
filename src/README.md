## Inleiding
Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt. Tijdens de cursus Spring Boot ga jij een backend applicatie programmeren voor het bedrijf. De winkel heeft een inventaris van televisies die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen door middel van de huiswerkopdrachten. Zo krijg je stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde van de cursus zullen we een werkende Tech It Easy backend applicatie hebben!

## Opdrachtbeschrijving
Je gaat via de Spring Boot Initialzr een project aanmaken, waarbij je gebruikmaakt van de volgende dependency:
- Spring Web

Gedurende de cursus Spring Boot zal het langzamerhand duidelijk worden waarom je deze dependency nodig hebt. Voor nu mag je dit gewoon van ons aannemen! 

## Randvoorwaarden
De opdracht moet voldoen aan de volgende voorwaarden:

- Het project bevat, op de juiste plaats in de map-structuur, een map genaamd `Controllers`;
- Het project bevat, op de juiste plaats in de map-structuur, een map genaamd `Exceptions`;
- Het project bevat een `TelevisionsController`;
- Het project bevat een `ExceptionController`;
- Het project bevat een `RecordNotFoundException`;
- De **TelevisionsController** bevat: 
  - een GET-request voor alle televisies
  - een GET-request voor 1 televisie
  - een POST-request voor 1 televisie
  - een PUT-request voor 1 televisie
  - een DELETE-request voor 1 televisie
- De **ExceptionController** bevat:
  - een exceptionhandler
- De **RecordNotFoundException** bevat:
  - een default exception 
  - een exception met message

### Belangrijk
Bij het inleveren van deze opdracht is de applicatie nog niet functioneel, omdat we hier meer kennis over andere technieken voor nodig hebben die later in de cursus aan bod komt.

Je mag de volgende return fragmenten gebruiken:
  - `ResponseEntiteit.ok()`
  - `ResponseEntiteit.created()`
  - `ResponseEntiteit.noContent()`

Door het gebruik van deze return fragmenten zul je de volgende foutmeldingen tegenkomen:
- `incompatible types found`
- `created .... cannot be applied to ()`
Deze mag je negeren tijdens het maken van deze opdracht.

## Stappenplan
_Let op_: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet beginnen, kun je onderstaand stappenplan volgen:

1. Zet een nieuw project op via Spring Boot Initialzr genaamd TechItEasy.
2. Maak een nieuwe map aan in je project genaamd Controllers.
3. Maak een nieuwe map aan in je project genaamd Exceptions.
4. Maak een nieuwe klasse aan in de map Controllers voor de TelevisionController.
5. Voorzie de klasse van de juiste annotatie.
6. Maak in de klasse de gevraagde requests aan met de juiste response entities.
7. Maak een nieuwe klasse aan in de map Controllers voor de ExceptionController.
8. Voorzie de klasse van de juiste annotatie.
9. Maak in de klasse een exceptionHandler met de juiste notatie en response entitiy.
10. Maak een nieuwe klasse aan in de map Exceptions.
11. Extent de klasse met de RunTimeException.
12. Vul de klasse aan aan de hand van het voorbeeld in hoofdstuk 5.11 van de cursus Spring Boot.


Opdrachtbeschrijving Model/Repository
Inleiding
Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt. Tijdens de cursus Spring Boot ga jij een backend applicatie voor hen programmeren. De winkel heeft een inventaris van televisies die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen in de vorm van huiswerk. Zo krijgen we stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde van de cursus zullen we een werkende Tech It Easy backend hebben!

Recap van vorige opdracht
Je hebt de vorige les een begin gemaakt voor de applicatie voor je werkgever TechItEasy. Je hebt een controller aangemaakt met verschillende endpoints. Deze kunnen aangeroepen worden via een frontend. Jij maakt hiervoor gebruik van Postman. Omdat we niet weten of alles bestaat wat de gebruiker opvraagt heb je ook een exception controller gemaakt en een RecordNotFound exception. Na een nieuwe les Spring boot ben je klaar voor de volgende stap van het bouwen van je applicatie.

Randvoorwaarden
Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Models;
Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Repositories;
Het project bevat een Television in de map Models;
Het project bevat een TelevisionRepository;
Het project bevat de volgende dependencies:
Spring Web
Spring Data Jpa
PostgreSQL Driver
De Application.properties bevat de properties uit hoofdstuk 9.2 van de cursus Spring Boot(met aangepaste namen)
De TelevisionRepository extends JpaRepository met de juiste parameters
De Television bevat: -de attributen:
Long id (incl. annotaties id en generatedValue)
String type
String brand
String name
Double price
Double availableSize
Double refreshRate
String screenType
String screenQuality
Boolean smartTv
Boolean wifi
Boolean voiceControl
Boolean hdr
Boolean bluetooth
Boolean ambiLight
Integer originalStock
Integer sold
default constructor
constructor
alle getters en setters
Belangrijk
Bij het inleveren van deze opdracht is deze applicatie nog niet functioneel, hier hebben we meer kennis over andere technieken voor nodig.
Laat de application.properties overeenkomen met de gegevens van PgAdmin
Je mag de volgende return fragmenten gebruiken:
ResponseEntiteit.ok()
ResponseEntiteit.created()
ResponseEntiteit.noContent()
Door het gebruik van deze return fragmenten zul je de volgende foutmeldingen tegenkomen:

incompatible types found
created .... cannot be applied to () Deze mag je negeren tijdens het maken van deze opdracht.
Stappenplan
Let op: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet beginnen, kun je onderstaand stappenplan volgen:

Voeg de benodigde dependencies toe aan je POM.xml en laat Maven deze instaleren
Voeg aan de application.properties de benodigde properties toe
Maak een nieuwe database aan in PgAdmin (zorg dat de naam overeenkomt met de properties in je _application.properties)
Maak een nieuwe map aan in je project voor Models
Maak een nieuwe klasse genaamd Television
Voeg de annotatie @Entity toe aan de klasse
Voeg de juiste attributen toe aan de klasse
Voeg de beide constructors toe aan de klasse
Voeg alle getters & setters toe aan de klasse
Maak een nieuwe map aan in je project voor Repositories
Voeg aan deze map een nieuwe klasse toe genaamd TelevisionRepository
Extend de repository met de JpaRepository en geef de juiste attributen mee


