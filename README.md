# TechnicalTesterAssignment

## Beskrivning
Detta testprojekt är utformat för att utföra tester på en webbapplikation med hjälp av Java, Selenium och TestNG. Projektet är strukturerat enligt följande:

### Paketstruktur
- `Minso`: Huvudapplikationen.
    - `settings`: Innehåller klasser för testinställningar.
        - `RetryTest`: Hanterar testretrylogik.
        - `TestData`: Innehåller testdata.
        - `TestSetup`: Sätter upp WebDriver och andra testerinställningar.
        - `TestUtility`: Kommande logic för tester.
    - `form`: En separat paket som representerar formuläret som ska testas.
        - `errorMessages`: Klass för att testa felmeddelanden i formuläret.
        - `sendForm`: Klass för att skicka formuläret och verifiera resultatet.

### Testfiler
- `errorMessages.java`: Innehåller tester för felmeddelanden i formuläret.
- `sendForm.java`: Innehåller tester för att skicka formuläret.

## Kör tester
Testerna kan köras från en XML-fil som definierar testsviten och dess konfiguration. XML-filen innehåller alla tester och deras grupper och prioritet.
