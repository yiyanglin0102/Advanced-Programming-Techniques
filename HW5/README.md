## Execution

Start executing Java codes in `main()` methods in `MongoDB.java` and `MySQL.java` files.

## Project Structure

```
./HW5
├── ./Code
│   ├── MySQL.java
│   ├── MongoDB.java
│   ├── sample.xml
│   └── ./JAR Files
│       ├── mongo-java-driver-3.12.11.jar
│       └── mysql-connector-j-8.0.31.jar
│
├── Homework_5.pdf
├── Note.txt
├── Slide.pdf
└── README.md
```

The workspace is structured in following:

- `/Code` : a folder to maintain source codes.
    - `MongoDB.java` : In this file, it will first start reading the provided `sameple.xml` file, and generate a database `DBLP` in `MongoDB` on local server. Once it connects to the server, then start creating 3 tables - `WWW`, `PHDTHESIS`, and `INPROCEEDINGS`. After that, executing `query1()` and `query2()` to querying information.
    - `MySQL.java` : In this file, it will first start reading the provided `sameple.xml` file, and generate a database `cs622` in `MySQL` on local server. Once it connects to the server, then start creating 3 tables - `WWW`, `PHDTHESIS`, and `INPROCEEDINGS`. After that, executing `query1()` and `query2()` to querying information.
    - `/JAR Files` : a folder to maintain JAR library files.
        - `mongo-java-driver-3.12.11.jar` : The official MongoDB Java Drivers providing both synchronous and asynchronous interaction with MongoDB.
        - `mysql-connector-j-8.0.31.jar` : This provides standards-based drivers for JDBC enabling developers to build database applications in their language of choice, allowing developers to embed MySQL directly into their applications.

## MongoDB Used Commands

```
brew services restart mongodb-community
brew services start mongodb-community
brew services stop mongodb-community
mongosh
-----------------------------
show databases
use DBLP
db.phdthesis.insertOne({ key: 'phd/Hoff2002', mdate: '2017-01-06', author: 'Gerd Hoff', title: 'Ein Verfahren zur thematisch spezialisierten Suche im Web und seine Realisierung im Prototypen HomePageSearch', year: '2002', school: 'University of Trier, Germany', pages: '1231-315', isbn: '123978-3-86596-263-8', ee: 'http://ubt.opus.hbz-nrw.de/volltexte/2004/146/' })
db.www.insertOne({ key: 'phd/Hoff2002', mdate: '2017-01-06', author: 'Gerd Hoff', title: 'Ein Verfahren zur thematisch spezialisierten Suche im Web und seine Realisierung im Prototypen HomePageSearch', year: '2002', school: 'University of Trier, Germany', pages: '1231-315', isbn: '123978-3-86596-263-8', ee: 'http://ubt.opus.hbz-nrw.de/volltexte/2004/146/' })
db.inproceedings.insertOne({ key: 'phd/Hoff2002', mdate: '2017-01-06', author: 'Gerd Hoff', title: 'Ein Verfahren zur thematisch spezialisierten Suche im Web und seine Realisierung im Prototypen HomePageSearch', year: '2002', school: 'University of Trier, Germany', pages: '1231-315', isbn: '123978-3-86596-263-8', ee: 'http://ubt.opus.hbz-nrw.de/volltexte/2004/146/' })
db.phdthesis.insertMany([ { key: 'phd/Hoff2002', mdate: '2017-01-06', author: 'Gerd Hoff', title: 'Ein Verfahren zur thematisch spezialisierten Suche im Web und seine Realisierung im Prototypen HomePageSearch', year: '2002', school: 'University of Trier, Germany', pages: '1231-315', isbn: '123978-3-86596-263-8', ee: 'http://ubt.opus.hbz-nrw.de/volltexte/2004/146/' }, { key: 'phd/Seltzer92', mdate: '2015-05-21', author: 'Margo I. Seltzer', title: 'File System Performance and Transaction Support.', year: '1992', school: 'University of California at Berkeley', pages: '1231-315', isbn: '123978-3-86596-263-8', url: 'http://db.cs.berkeley.edu/papers/ERL-M93-01.pdf' }])
.
.
.
db.getCollectionNames().forEach((c) => { db[c].find().forEach((d) => { print(c); printjson(d); }); })
db.phdthesis.drop()
db.www.drop()
db.inproceedings.drop()
```

## MySQL Used Commands

```
brew services restart mysql
brew services start mysql 
brew services stop mysql 
mysql
-----------------------------
show databases;
SHOW TABLES;
Describe INPROCEEDINGS;
Describe PHDTHESIS;
Describe WWW;
select * from INPROCEEDINGS;
select * from PHDTHESIS;
select * from WWW;
SELECT * FROM inproceedings WHERE title LIKE '%design%' AND year > 2000;
SELECT COUNT(*) as total FROM inproceedings WHERE title LIKE '%design%' AND year > 2000;
SELECT * FROM Inproceedings WHERE title LIKE '%of%' AND mdate between '2008-01-01' and '2010-01-31';
```