## Getting Started

Start executing java codes in `Main.java` - `main()` file.

## Folder Structure

The workspace is structured in the following:

- `src`: the folder to maintain sources
    - `Main.java`: the app starts from this file, creating the characters that players would like to create and passing numbers to indicate each specific gorilla.
    - `GameStart.java`: After passing number of indication of specific gorilla, the constructor build the object class and assign it to global `Character role` variable to `GameStart` class.
    - `Character.java`: A parent class of 3 different sub-gorilla classes, creating polymorphism and being inherited. In the `Character` class, it defined the general gorilla bomb called "Default-Bomb", and afterall, the parent method `setSpecialty()` will always be overriden by subclasses.
        - `Mountain_Gorilla.java`
        - `North_Gorilla.java`
        - `Long_Arm_Gorilla.java`

Meanwhile, the compiled output files will be generated in the `bin` folder by default.
