# Mobile store architecture design 
sql is used to store table and query from java code from the backend is used to provide implementation.


# Packages
dao - (Data access object) contains the code which has all the functionality. the DAO provides some specific data operations without 		  exposing details of the database.

exception - to handle custom messages which can be understood by the user

main - has the main method

model - JavaBean class in Java. JavaBeans are classes that encapsulate many objects into a single object (the bean). All properties in java bean must be private with public getters and setter methods.

services - to match and validate user input
