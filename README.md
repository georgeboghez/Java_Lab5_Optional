# Java_Lab5_Optional

## Document Management System

Write an application that can manage a catalog of documents. An entry in this catalog might be an article, a book, etc.
A document may be located using a path in the local file system or a link to an external URL. Each document has a unique ID, a name and may have additional tags, which are pairs name-value. Example of tags may be title, author, year, publishingDate, etc.
The main specifications of the application are:

# Compulsory
- Create an object-oriented model of the problem. You should have at least the following classes: Catalog, Document. Consider creating a class responsible with external operations regarding a catalog.
- Implement the following methods:
1. save: saves the catalog to an external file, using object serialization;
2. load: loads the catalog from an external file.
3. view: opens a document using the native operating system application (see the Desktop class);

## Optional
- Implement the save and load methods using a plain text representation of the catalog (instead of binary serialization).
- Create a shell that allows reading commands from the keyboard, together with their arguments and implement the commands load, list, view.
- Represent the commands using classes instead of methods (create the classes LoadCommand, ListCommand, etc.). Use an interface or an abstract class in order to desribe a generic command.
- Implement the command report html: create an HTML report representing the content of the catalog.
- The application will signal invalid data (duplicate names, invalid paths or URLs, etc.) or invalid commands using custom exceptions.
- The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.
