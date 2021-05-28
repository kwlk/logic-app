# logic-app

Java application created using Maven.
Given a string argument, application identifies the words containing LOGIC characters and prints the frequency of those characters based on the combination of LOGIC characters and length of the words.
App excludes special characters, saved in "specialCharacters.txt"
Default LOGIC characters are "LOGIC", but can be different, applied as a second argument.
Special characters may also be submitted in a file, with path to the file added as third argument.

The ``` mvn exec:java ``` command starts the program with arguments ```I love to work in global logic!``` and ```LOGIC```