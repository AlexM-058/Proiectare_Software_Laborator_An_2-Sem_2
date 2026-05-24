# Structura Laboratoarelor

Acest fisier explica unde se afla codul dupa restructurare si ce rol are fiecare pachet.

## Pachete principale

- `student.model`
  - Entitati comune folosite in mai multe laboratoare.
  - Include `Student`, `StudentBursier`, `CatalogStudenti`.

- `student.app`
  - Aplicatii demo pentru functionalitatile din proiectul Students.
  - Include `AplicatieCuBursa`, `AplicatieCuStrategy`, `MainStudent`.

- `student.examples`
  - Exemple istorice care arata cum au fost folosite clasele Students in laboratoare.
  - Include `MainStudentLab4`, `MainStudentLab5`, `MainStudentLab9`.

- `student.io.excel`
  - Logica dedicata pentru procesare Excel cu Apache POI.
  - Include `StudentExcelProcessor`.

- `student.strategy`
  - Contractele si contextul pentru Strategy Pattern.
  - Include `IStudentiExport`, `IStudentiImport`, `Exporter`.

- `student.strategy.export`
  - Strategii concrete de export.
  - Include `StudentiInConsola`, `StudentiInFisierText`, `StudentiInFisierXlsx`.

- `student.strategy.imports`
  - Strategii concrete de import.
  - Include `StudentiDinFisierText`, `StudentiDinFisierXlsx`.

- `student.decorator`
  - Decorator Pattern pentru masurarea timpului de executie.
  - Include `ExportTimerDecorator`.

- `labs`
  - Pachet primar pentru toate laboratoarele generale `lab_x`.
  - Pastreaza functionalitatea existenta, dar muta namespace-ul din `lab_x` in `labs.lab_x`.

## Harta pe laboratoare

- Lab 2: `labs.lab_2`
  - Colectii de baza: `List`, `Set`, operatii de manipulare colectii.

- Lab 3: `labs.lab_3`
  - Procesare fisiere text si studenti prin Java NIO.
  - `StudentFileProcessor` lucreaza acum cu `student.model.Student`.

- Lab 4: `labs.lab_4` si `student.model`
  - Identitate logica, mapari si concepte de hashing.
  - `CatalogStudenti` este in `student.model`, deoarece este folosit ca structura comuna.

- Lab 5: `labs.lab_5` si `student.model`
  - Mostenire, calculatoare si exemple cu studenti bursieri.
  - `StudentBursier` este in `student.model`.

- Lab 7: `labs.lab_7`
  - Imutabilitate, impartirea studentilor in formatii si Singleton prin `PasswordMaker`.

- Lab 8: `labs.lab_8` si `student.io.excel`
  - Integrare Apache POI.
  - `StudentExcelProcessor` este in `student.io.excel`.

- Lab 9: `labs.lab_9` si `student.examples`
  - Exemple de lucru cu liste, stream-uri si studenti.

- Lab 10: `student.strategy`
  - Strategy Pattern pentru decuplarea exportului studentilor.

- Lab 11: `student.decorator` si `labs.lab_11`
  - Decorator Pattern pentru masurarea timpului de export.
  - Observer Pattern in `labs.lab_11`, cu `YouTubeChannel`, `Subject`, `Observer`, `MediaInterested`.

## Entry points utile

- Strategy + Decorator:
  - `student.app.AplicatieCuStrategy`

- Bursa si sortare:
  - `student.app.AplicatieCuBursa`

- Excel Students:
  - `student.app.MainStudent`

- Observer:
  - `labs.lab_11.ObserverPatternDemo`
