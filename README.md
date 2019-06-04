# StudyGuideCS56

# Java Primitive Types
Integers
- byte (1 byte)
- short (2 bytes)
- int (4 bytes)
- long (8 bytes)

Floating Point Numbers
- float (4 bytes)
- double (8 bytes)

Characters
- char (2 bytes)

Boolean
- boolean (1 byte)

Note that primitive types in Java are stored on the stack.

# Objects
- The 'new' keyword is used to allocate memory for a new object.
- All objects in Java are dynamically allocated on the heap.
- The only values on the stack are Java primitive types and object references.
  - You can think of Java similar to C++ where all objects are dynamically allocated on the heap and all object variables are pointers.
  - However, Java doesn’t use pointers in the same sense that C++ does. For example, you cannot do pointer arithmetic on a reference.

# Overflow
Java does not check for overflow

# Increment/Decrement
- x++; // post-increment – increments x by 1 after the expression is evaluated.
- ++x; // pre-increment – increments x by 1 before expression is evaluated.
- x--; // post-decrement – decrements x by 1 after the expression is evaluated.
- --x; // pre-decrement – decrements x by 1 before expression is evaluated.

# Strings
- Strings are objects of class String (not a primitive type like “int”)
- Strings are characters stored as an array
- Note: we do not have to use the keyword new when creating strings (but we can).

Methods
- .length() – returns number of characters in the string
- .substring(int start, int end) – returns the substring starting at position start up to and not including position end.
- .toUpperCase(), .toLowerCase() - converts String to upper / lower case
- .charAt(pos) - returns the character at index pos
- .equals(String s) - Checks if two strings have the same value, not reference.
- .equalsIgnoreCase(String s) - checks content of string ignoring case.
- s1.compareTo(String s2) - Lexicographical comparison

Concatenation
- Combine strings with +
- Convert a String to an Int with 
    - String s = "3"; 
    - int i = Integer.parseInt(s);
- Convert an Int to a String with 
    - String s = Integer.toString(3);

Pool
- Java does some optimization by storing identical Strings that are declared in code to reference the same location in memory.
- If the String changes, then Java will allocate another section in memory for the updated string. Java Strings are immutable (i.e. they can’t be changed in memory once created).
- The 'new' keyword bypasses the String pool and creates a separate memory location for the initialized String.

# Control Flow
- Allows the execution of code if some boolean value is true.

  if (boolean) 
  {
    statement;
  }
  
  else if (boolean) 
  {
    statement;
  }
  
  else 
  {
    statement;
  }

# Relational vs Logical Operators
- Relational: ==, !=, <, <=, >, >=
    - left to right precedence
- Logical: !, && , ||
    - right expression only evaluated based on the left most expression

# Loops
  while(boolean) {
    statement;
  }
  
  do {
    statement;
  } while (boolean);
  
  for (initial, boolean, update) {
    statement;
  }
  
# Class Definitions
Public vs Private
- Public means any instantiated object of that class can directly access a public variable / method.
- Private means only the class itself can have direct access to that variable / method.

'this' Keyword
- “this” refers to this class
- Used mainly to disambiguate variables within the class
- Without “this”, Java could think you’re referring to the parameter name instead of class member (due to scoping).

Accessor/Mutator Methods
- private variables
    - private String color;
    - private double amount;

- getter
    - public String getColor() { return color; }
    - public double getAmount() { return amount; }

- setter
    - public void setColor(String color) { this.color = color; }
    - public void setAmount(double amount) { this.amount = amount; }

Static
- Static class variables belong to the class instead of a specific instance of an object.
- Static variables are shared among ALL instances of the class.
Methods that do not require an instance of an object (i.e. a constructed object) for it to be called.

# Overloading
Methods
- Combination between methods with the same name and parameter types is called the method signature.
- Within a class, we can have methods with the same name, but not the same signature.

Constructors
- Constructors can be overloaded as well.
- A default constructor is a constructor without any parameters.
- If no constructor is provided, Java makes one that sets the class variables to default values.
- If any constructor is defined, Java does not supply a default constructor and you must write one.

# Passing Variables
- Pass by value is when a copy of a value is used, not the original variable itself.
  - Any changes to this variable will not remain changed when out of scope.
- Pass by reference is when the original variable is passed into a method. Any changes to this variable will remain changed when out of scope.
  - Java passes everything by value

# Command Line Arguments
- Similar to C++, we can pass in content into our program when executing it using command line arguments.
- This is what the String[] args portion in the main method is.
- All of the command line arguments are of String types and we need to convert them to numbers if needed.

# Console Input
- A way for users to interact with their programs is by using the console for input.
  - Your program can prompt users for information and users can enter information into the program by typing it in the console.
  - There are several ways to do this, but we will use the Scanner object for this purpose.
  - The Scanner object can be used for several types of I/O interaction including files (more on this later).

import java.util.Scanner;

Scanner s. = new Scanner(System.in);

String t = s.nextLine();

# Random Number Generation
- Java’s API gives us the Random object (java.util.Random).

import java.util.Random;

Random gen = new Random();

int randomInt = gen.nextInt(4);    //[0,3]

# Arrays
- You can allocate memory to store items of the same type with arrays.
- Recall, arrays are indexed from 0 to n – 1.
- The items in a Java array must be of the same type.
- Arrays are objects in Java (i.e. they’re not primitive types like in C++).
- .length is not a method here, it's a value
- .clone() copies the contents of the array

# ArrayLists
- Arrays need to be defined with a predetermined size.
- If you try and access / add to a position past the size, an error occurs.
- Sometimes we don’t know what the size limit is and we want to expand our array automatically.
- We don’t know what an ArrayList can hold and we want to make it general enough where it can hold any type the programmer wants.
- .set() changes existing item of an ArrayList
- .remove() removes the idem by index or the Object
- .add() adds an object to the end

# Stack Overflow
- When a program crashes due to running out of memory in the call stack.
- The java.lang.StackOverflowError Exception is thrown.
- ex: Infinite recursion, increased stack size




