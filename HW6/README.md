## Execution

Start executing Jar zip file by typing `java -jar ` with `.jar PATH`  in IDE IntelliJ IDEA.

## Project Structure

```
./HW6
├── ./Code
│   ├── HW6-Maven.zip
│   └── HW6-Gradle.zip
│
├── ./Previous_HW
│   ├── BFMain.java
│   ├── LuceneMain.java
│   ├── sample.xml
│   └── ./JAR Files
│       ├── mongo-java-driver-3.12.11.jar
│       └── mysql-connector-j-8.0.31.jar
│
├── Homework_6.pdf
├── Slide.pdf
└── README.md
```

The workspace is structured in following:

- `/Code` : a folder to maintain source codes.
    - `HW6-Maven.zip` : This zip file was generated from `IntelliJ IDEA` -> `File` -> `Export` -> `Project to Zip File...`. In Maven software project management tool, it saves all dependencies information to `pom.xml`. The imported JAR Library files will be mentioned in `pom.xml` , so that the wrapped `.jar` can simply be executed.
    - `HW6-Gradle.zip` : This zip file was generated from `IntelliJ IDEA` -> `File` -> `Export` -> `Project to Zip File...`. In Gradle software project management tool, it saves all dependencies information to `gradle.build`. The imported JAR Library files will be mentioned in `gradle.build` , so that the wrapped `.jar` can simply be executed.
    - `Previous_HW` : 
        - `LuceneMain.java` : In this file, it will create index cache mapping to each line of strings. At the next time, when a token is searched, it will be significantly save time because of tracing the string index from space.
        - `BFMain.java` : It searches token each line by line and makes a linear search.

