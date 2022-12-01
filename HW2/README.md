## Execution

Start executing java codes in `Makefile` with its following targets - `merge`, `search`, `history`, and `clean` in `/Code` repository.

## Project Structure

```
./HW2
├── /Code
│   ├── History.java
│   ├── Merge.java
│   ├── Search.java
│   ├── Makefile
│   └── /data
│       ├── Kickstarter1.csv
│       ├── Kickstarter2.csv
│       └── Kickstarter3.csv
│
├── Homework_2.pdf
├── categories.txt
└── README.md

```

The workspace is structured in following:

- `/Code` : a folder to maintain source codes.
    - `Merge.java` : In this file, it catches inputs from `args` to gain  arguements from command-line, the first argument is the merged file, the second file and the files after second are the component files. After merging files in one, it also adds indexes shown at the first columns.
    - `Search.java` : A file to create `.history` in the current folder and search for the keywork input from command-line, and at the same time, it creates a timestamp and write it in `.history`. When it scans a string containing some parts of each line in the input file, it will output the *Name of Project*, *Funding Amount*, *Category*, to show its matchings.
    - `History.java` : A file to read `.history`. it reads and stores those searching data into a hashmap structure, and output the history search from command-line.
    - `Makefile` : A file to automate `merge`, `search`, `history`, and `clean` functions.
    - `/data` : a folder to maintain sources data.
        - `Kickstarter1.csv` : First example csv data file.
        - `Kickstarter2.csv` : Second example csv data file.
        - `Kickstarter3.csv` : Third example csv data file.

Meanwhile, the compiled output files will be generated in the `.class` extension by default.


## Clean up

After executing, type `make clean` to clean up `.class` and `.history` files.