## Execution

Start executing Java codes in the `main()` methods in `Single.java` and `Multithread.java` files.
In total, there are going to be 10000 lines of 10 characters DNA sequences printed out in each Java file.

## Project Structure

```
./HW7
├── ./Code
│   ├── Single.java
│   └── Multithread.java
│
├── Homework_7.pdf
├── Slide.pdf
└── README.md
```

The workspace is structured in following:

- `/Code` : a folder to maintain source codes.
    - `Single.java` : This is a single thread process that serially compile for loops without concurrency. At first, it creates a map data structure that let the random generator outputs 0, 1, 2, 3 and `get` the corresponding A, T, C, G. Later on, it adds on an accumulated string with 10 random characters to list all DNA sequences.
    - `Multithread.java` : In this file, it starts created an object, and in a for loop it starts creating 100 threads in 100 `new` objects. When it comes to each object created, it calls a `run()` method. This method creates a map data structure that let the random generator outputs 0, 1, 2, 3 and get the corresponding A, T, C, G. In the next part of the `run()`, it out prints 100 DNA sequences by adding on an accumulated string with 10 random characters to list all DNA sequences.
