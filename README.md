# 4LeafCo Readme

## Group Computers Login

- username: `4LeafCo`
- password: `4leafsql`

## MySQL Server

- username: `root`
- password: ``

## Instruction Set to Run Database:

1. To Connect to Database
2. Connect to MySQL Server
	- username: `root`
	- password: `4leafco`
3. Make sure you have an SQL Database Tool Active. Preferably MySQL Workbench.
4. Import Data Dump Zip File (If you wish to not recreate log in information)
5. Import Database Entry: Import the stated excel files to hold the database entries ("DB EX", "DB EX2", "DB EX4", "DB EX6", "DB EX8")
6. Open and Run SQL File DB to see the contents of the `blackjackdatabase`.
7. Open and Run the `Randomized 20 Cards for Database` for Possible Hand Combinations

## To Display Database Entries Using Eclipse and Java

- Open Eclipse and Configure SQL Server Jar File to the project
- Open Java File
- Run Code and Select The Number Of Databases You Would Like To Use To View Deck Content and Randomized Deck Hand Content

## To Run Frequency Table and View Statistics of Winning Based Off Of Random Hands

- Open Eclipse and Configure SQL Server Jar File to the Project
- Open Java File for Frequency Table
- Run Code and Select The Number Of Databases You Would Like To Use To View Deck Content and Randomized Deck Hand Content
- View Deck Hands & Totals for Deck
- View Frequency Table

## To Run the Probability Program and View Chances Of Winning Per Move

- Open Eclipse and Configure SQL Server Jar File to the Project
- Open Java File for Probability Program
- Run Code and Select The Number Of Databases You Would Like To Use To View Deck Content and Randomized Deck Hand Content
- View Deck Hands & Totals for Deck
- Allow Game Methods To Run and Coordinate Statistics
- View Probability Table and Return Method Value for Strategy Card

## To Run BlackJack Game Console

- Open Eclipse Or JGrasp and Open the Game Console Program
- Run the Game Console Program
- Carry Out The Functions Of The BlackJack Game (BlackJack Game Reads In Strategy Card)

## For the MySQL 5.7 Command Line Client:

- Password: 4leafco

1.	use bj;
2.	SELECT * FROM blackjackdatabase ORDER BY RAND() LIMIT 20;
3. 	Carry out previous execution to see new combination of Database
	Entried for hand combinations.
4. 	View Data for Database

`mysql> SELECT * FROM blackjackdatabase ORDER BY RAND() LIMIT 20;`

+---------------------+-----------+
| idBlackJackDatabase | CardValue |
+---------------------+-----------+
|                   8 | 8         |
|                   2 | 2         |
|                  31 | 5         |
|                  39 | King      |
|                  46 | 7         |
|                  19 | 6         |
|                  10 | 10        |
|                  17 | 4         |
|                   7 | 7         |
|                  24 | Jack      |
|                  12 | Queen     |
|                  35 | 9         |
|                  42 | 3         |
|                  22 | 9         |
|                  50 | Jack      |
|                   5 | 5         |
|                  43 | 4         |
|                  45 | 6         |
|                  32 | 6         |
|                  20 | 7         |
+---------------------+-----------+
20 rows in set (0.00 sec)