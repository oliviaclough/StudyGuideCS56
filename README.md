# StudyGuideCS56

# Java Primitive Types
Integers
-
- byte (1 byte)
- short (2 bytes)
- int (4 bytes)
- long (8 bytes)

Floating Point Numbers
-
- float (4 bytes)
- double (8 bytes)

Characters
-
- char (2 bytes)

Boolean
-
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
-
- .length() – returns number of characters in the string
- .substring(int start, int end) – returns the substring starting at position start up to and not including position end.
- .toUpperCase(), .toLowerCase() - converts String to upper / lower case
- .charAt(pos) - returns the character at index pos
- .equals(String s) - Checks if two strings have the same value, not reference.
- .equalsIgnoreCase(String s) - checks content of string ignoring case.
- s1.compareTo(String s2) - Lexicographical comparison

Concatenation
-
- Combine strings with +
- Convert a String to an Int with 
    - String s = "3"; 
    - int i = Integer.parseInt(s);
- Convert an Int to a String with 
    - String s = Integer.toString(3);

Pool
-
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
-
- Public means any instantiated object of that class can directly access a public variable / method.
- Private means only the class itself can have direct access to that variable / method.

'this' Keyword
-
- “this” refers to this class
- Used mainly to disambiguate variables within the class
- Without “this”, Java could think you’re referring to the parameter name instead of class member (due to scoping).

Accessor/Mutator Methods
-
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
-
- Static class variables belong to the class instead of a specific instance of an object.
- Static variables are shared among ALL instances of the class.
Methods that do not require an instance of an object (i.e. a constructed object) for it to be called.

# Overloading
Methods
-
- Combination between methods with the same name and parameter types is called the method signature.
- Within a class, we can have methods with the same name, but not the same signature.

Constructors
- 
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

# Exception Handling
- Allows programmers to catch and handle error conditions that occur throughout a program.

Exception Object
- 
- A java object that represents a certain error condition.
- Many types of Exceptions can occur (IOException, NullPointerException, ArithmeticException, …)
  - Java will create and “throw” an exception when it occurs for certain cases.
  - All exceptions are inherited from the Exception Java object.
  - Programmers can manually create and throw their own Exception object by extending from the Exception class.
  - Can contain information or perform certain actions.
  - All Java Exceptions carry information, such as the name of the Exception and stack trace.
  
Try/Catch Blocks
- 
- Exceptions that are thrown need to be handled somewhere in your code.
- If an exception occurs within a try block, you can catch the Exception and execute code in a corresponding catch block.
- If a catch block is executed, it resumes functionality after the try/catch block.

Multiple Exceptions
- When catching an Exception, you can execute different actions based on what Exception was caught.
- Java goes through each catch block one-by-one until a compatible Exception is matched.
- To catch any Exceptions, you can catch an Exception type (since all Exceptions are inherited from the Exception class).

Finally Block
-
- Regardless of what happens in a try/catch block, the code in “finally” will always execute.

Custom Exceptions
-
- An Exception type can be declared by defining the Class that extends the Exception class.
- You can create, throw, catch this type in your code depending on some action.
- You can also maintain additional information or provide your own methods if needed.

# Testing
- Testing every possible path in every possible situation.
- Complete tests are infeasible!
- The best we can hope for is trying to approximate a Complete Test by testing various types of cases.
- The more rigorous testing a program can “pass”, the more confidence is gained that the program “bulletproof”.

Test Suite
- 
- A program containing various tests confirming certain behavior.

Types of Test Cases
- 
- Normal Cases: Any expected or “normal” input cases that you can reasonably expect from the user.
- Error Cases: Any case where it’s not expected, but is possible
  - Passing in a null object, having a bad file name, disabling network connectivity for something that requires it…
- Boundary Cases: Testing the borders of the input.
  - Testing both max / min value for int parameters.

JUnit
- 
- JUnit allows a programmer to perform automated tests.
- Runs one or more methods on the objects you are testing and checks the results using assertions.
- Tests are run one after another and will produce a graphical report on the cases that passed, the tests that encountered an error (i.e. crashed), and the tests that didn’t crash, but failed an assertion.
- assertEquals, assertFalse, assertTrue, assertNull, assertArrayEquals

# Inheritance
- Inheritance is a way of extending functionality and properties of an existing class.
  - and allows you to add new features and overwrite existing ones.
  
public class Vehicle { ... }

public class Car extends Vehicle { ... }

- Note that Java calls our default constructor from the base class first, and then subclasses (top-down).
  - If you define constructors, call 'super()' in the sub classes constructor in order to extend base class
- Can derive more subclasses from a subclass 
  - Ex: Vehicle --> Car --> Truck
  - Truck will inherit everything from vehicle AND car
  - Uses constructor chaning to call respective super classes so it is still base to sub 
- Can use 'instanceof' operator to check if an object reference is legal 
  - Car is an instance of Vehicle, Car, and Object but NOT an instance of Truck

# Polymorphism
- All Java classes extend the Object class

Object o = new Car();

Object o1 = new int[100];

- But Object does not extend all Java classes

Car c = new Object(); //VERY ILLEGAL!!!

- Only Object methods are available if assigning a subclass to an Object class type (.toString() , .equals())
- Can declare a class/method as final to prevent others from extending and overriding it

public final class Vehicle { ... }

public final String toString() { ... }

Memory Slicing
- 
- double x = 2.2;  --> int y = (int) x;
- Can only hold '2' and drops the decimal 
- Objects on the heap aren't sliced as they use the 'new' keyword
  - Meaning they have new memory allocated for them, not changing existing memory 
  
Casting Objects
-
- Vehicle v1 = (vehicle) new Object(); //ERROR NOT VALID
- Vehicle v2 = (Vehicle) new Car(); //OKAY
- But be casting compatible objects 

# Abstract Methods
- Sometimes it doesn’t make sense for a class to provide method definitions
- For example
  - A shape’s area is dependent on the type of shape.
  - … or an Animal class may make a sound, but that sound is dependent on the Animal.
  - … or a Student may pay different tuitions (international students, out-of-state, international)… or the Unit limit may differ…
- If it doesn’t make sense for the class to provide a method definition, but know that the method should be implemented somewhere in the subclasses.
  - Abstract methods can be used!
  - A method can be declared as “abstract” if there is no sensible solution to provide an implementation in the base class.
- Subclasses either override the method and privide an implementation or declare itself abstract also and have a different subclass implement it

# Interfaces
- An interface is a mechanism for defining a “purely abstract class”
  - Similar to classes, Interfaces are considered as a type
  - Similar to abstract classes, Interface objects cannot be instantiated.
  - Interfaces may contain only public non-static methods and public static final fields (i.e. constants).
- It’s used when you want to specify a behavior that a class (and subclasses) need to support without specifying any implementation details.
- A class may implement multiple Interfaces.

public class Student extends Person implements Comparable { ... }

# Swtich Statements
- Shorthanded way to write a multi-way if statement

String x;

int y = 2;
switch (y) {

  case 1: x = "One";
    
    break;
  
  case 2: x = "Two";
    
    break;
  
  case 3: x = "Three";
    
    break;
  
  case 4: Case 5: x = "Four or Five";
    
    break;
  
  default: x = "Undefined";
    
    break;
    
} 

- Can have a default case at the end to handle any input that does not have a matching case
- Can also check for multiple values in a single case

# File IO
- 

Scanner Object 
-
- 

Delimiters
-
-

Writing to a File
-
- PrintWriter
- FileWriter

Formatting Data
-
-












v
