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
Example:

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
private variables

      private String color;
      private double amount;

getter

      public String getColor() { return color; }
      public double getAmount() { return amount; }

setter

      public void setColor(String color) { this.color = color; }
      public void setAmount(double amount) { this.amount = amount; }

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
Example:

    import java.util.Scanner;

    Scanner s. = new Scanner(System.in);

    String t = s.nextLine();

# Random Number Generation
Java’s API gives us the Random object (java.util.Random).

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
Example:  

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
All Java classes extend the Object class

    Object o = new Car();

    Object o1 = new int[100];

But Object does not extend all Java classes

    Car c = new Object(); //VERY ILLEGAL!!!

- Only Object methods are available if assigning a subclass to an Object class type (.toString() , .equals())
Can declare a class/method as final to prevent others from extending and overriding it

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
Shorthanded way to write a multi-way if statement


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
- Data from input source or output destination is represented in a “stream”
  - A stream is a sequence of binary data (0’s and 1’s).
- Since bytes are usually the smallest piece of data, Java has Stream objects that read / write data in 8-bit (1 byte) pieces.

- American Standard Code for Information Interchange (ASCII)
  - Each character is represented as 1 byte
  - This standard was only keeping English in mind…
- Unicode
  - Can represent characters from a larger set
  - We need more than 8 bits to represent characters from different languages.
- UTF-8
  - can store anywhere between 1 – 4 bytes per character
  - Most common standard for the web
  - UTF-16 – can store characters with 2 or 4 bytes

Scanner Object 
-
- In Java, reading from Files and user input from the command line can be done in several different ways.
- Scanner is a Java Object we’ve used to collect user input and this can be used for File I/O
- We can also use Scanners to read data from a file into the application.
Example:

    Scanner inFile = new Scanner(new File("fileName.txt"));
    
 - Tokens are the next “piece” of data you can expect when scanning through the stream.
  - .hasNext(), .hasNextInt(), .hasNextLong(), .hasNextByte(), .hasNextDouble()

Delimiters
-
- Scanners use delimiters to distinguish what is “next” to read on the input stream.
- By default, Scanners have a delimiter set to any number of whitespace characters.
- If our first line was written as “This is line 1”, the tokens will be the same.
- Scanner breaks the pieces into non-whitespace tokens.
  - We can set Scanner to use a specific delimiter.
  - When inFile.next() is called, it will read the token and put it into a String up to the delimiter or \n character.
  
Example of Delimiter

      inFile.useDelimiter(“l”);
      
 Example of using .split() after
 
    s = inFile.nextLine();
    stringArray = s.split(",");

Writing to a File
-
- PrintWriter
  - A simple object called PrintWriter exists, which allows you to write content to a file.
  - PrintWriter is very simple and doesn’t allow you to append to an existing file using the object directly
- FileWriter
  - Another object, FileWriter, provides more functionality than PrintWriter, including the ability to append to an existing file.

Formatting Data
-
- System.out.printf() is used to display formatted text.
- System.out.format() behaves the same as System.out.printf().
- %s is known as a format specifier
- s is known as a conversion character
- %d  decimal integer (or just integer)
- %f  floating point
- %e  floating point in exponential notation
- %c  Characters
- %s  Strings
- %b  boolean
- %%  ‘%’ sign
- Positive values indicate a left justified String //%10s
- Negative values indicate a right justified String //%-10s

# Generics
- A programmer can create their own Generic representations.
- In Java, generic types cannot be primitive (though we have use object wrappers for primitive types).

Methods
-
- Assume we want to write a method that takes an array, gets the last item of an array, and returns that item.
  - We could write the same method for all different parameter types
Example:

    public static <T> T getLastItem(T[] array) { ... }

Classes
-
- We can also create entire classes that are generic.
- Assume we want to write a simple class storing a pair of values of different types
Example:
    
    public class Pair<T> {
      private T first;
      private U second;
      
      public Pair(T first, U second) {
        this.first = first;
        this.second = second;
      }
      
      public void print() {
        System.out.println(first + " , " + second);
      }
    }

# 2D Arrays
- We can actually organize data into multiple dimensions with multi-dimensional arrays.
  - Good way to think of it is an array of arrays
  
Example:

      int[][] int2D = new int[4][5];
      for (int i=0; i<int2D.length; i++){
        for (int j=0; j<int2D[i].length; j++){
          System.out.println(int2D[i][j] + " ");
        }
        System.out.println();
      }
      
- Can also be 3D Arrays and so on ... 

# UML (Unified Modeling Language)
- Pictorial “language” used to visualize software architecture and design.
- Can be used in many forms (ex, process management), but is commonly used for Object Oriented (OO) Design.
  - Identifies OO components (such as classes / interfaces)
  - Identifies the relationships between these components
- Breaking out the varying functionality is known as the Strategy (Behavior) Design Pattern.
- In case we want to make a change for a behavior, we only need to change the Behavior class (not all subclasses implementing the behavior).
- Can be useful to solve certain maintenance issues as described above.  

# Observer Pattern
- A way of creating real-time updates
- The Observer pattern is a publication/subscription (pub/sub) design that updates information whenever necessary without having to worry about periodic probing.
  - Object state can be updated whenever something changes.
- In general, there needs to be a:
  - Subject (Publisher): Object(s) that maintains data and sends updated information whenever a change occurs
  - Observer (Subscribers): Object(s) that subscribe to certain Subjects and obtain updated information whenever it occurs.
- Usually shown with a .update() method that is declared in the Observer interface and then overridden in the class that implements the interface
- This is an example of a “push” design (i.e. the updates occur whenever they happen without asking for the updates.).
- We can also modify update to react to “pull” relevant info.

# Decorator Pattern
- A situation where you must keep track of various attributes for objects, where all attributes can be used in combination with each other.
- “attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality”

Open-Close Principle
-
- Classes should be open for extension, but closed for modification.
  - Basically, once a class is written and tested, we don’t want to modify this.
  - But we want to extend functionality and we can do this by creating additional classes and test those.
  - If specifications change, then we can modify a single class instead of modifying the change in multiple places.
- Separate Components that contain multiple Behaviors or Attributes (Decorators).
- Components and Behaviors will extend from a common type.
  - This is important for wrapping components with the necessary decorators.

# Extending Interfaces
- You can have interfaces extending other existing Interfaces
  - Usually done when you want to make an Interface with more specific functionality.
  - Polymorphism allows the correct method to be called on a specific object.
  
Example: 
  
    public interface InterfaceA { ... }
    public interface InterfaceB extends InterfaceA { ... }
    public interface InterfaceC { ... }
    
    public class ClassA implements InterfaceA { ... }
    public class ClassB implements InterfaceB { //which extends InterfaceA }
    public class ClassC implements InterfaceB, InterfaceC { //Interface A, B, C }
    
# Collections
- Collections provide mechanisms for inserting and retrieving various types of data.

Collection Interface
-
- An unordered group of objects allowing duplicate entries
- Common methods:
  - int .size()
  - boolean .add(item)
  - boolean .remove(item)
  - boolean .isEmpty()

List Interface
-
- An unordered group of objects allowing duplicate entries that are indexed.
- Common methods:
  - Object .get(index)
  - int .indexOf(item)
- Examples: LinkedList, ArrayList

Set
-
- A collection containing no duplicate elements
- Ensures that no pair of objects are equal to each other
- For every object in the set, .equals(item) should return false

Map
-
- Technically doesn’t extend the Collection interface, but it can be considered a Collection of values.
- A collection of items stored as (key, value) pairs.
- Keys are unique and can only map to one Object (but the Object can contain multiple values)
- Keys are represented as any object (normally strings or ints)
- Values can be represented as any Object
- Common methods:
  - boolean .containsKey(key)
  - boolean containsValue(value)
  - Object .get(key)
  - Object .put(key, value) // returns previous value for key or null
  - boolean .remove(key, value) // returns true if the key mapped to the value and was removed
  - Object .remove(key) // returns previous value for key or null
- Examples: HashMao, TreeMap

# Concurrency
- Working on “parts of a problem” concurrently if the parts can be done independently.
  - Many applications use concurrency for performance reasons.
  - Web servers process requests concurrently.
  - Web browsers fetch / render images concurrently.
  - Embarrassingly Parallel problems are usually a good fit for concurrent computing.
- Concurrency also allows efficient use of hardware.
  - For multi-core processors, you can design your program such that several parts of it work concurrently.
  - Each processor (core) in this case runs instructions in parallel.
  - For single-core architectures, it provides the illusion that something is working concurrently, but the processor is shared among all programs.
  - The processor does context switching between the various programs, but it cannot process instructions concurrently.
  
# Threads
- A thread is a program unit that is executed independently of other parts of your program.
  - Every Java application has a single process called the main process or main thread.
  - Every thread that the main process creates is called a subprocess or subthread.
  - A sub-process shares the memory space of the main process.

Runnable Interface
-
- We can define and manage threads by implementing the Runnable Interface (rather than creating a class that extends Thread).
- Will need to create thread objects that pass in the Runnable classes.

Example:

    public class ThreadingEx implements Runnable {
      private String id;
      public ThreadingEx(String i) { this.id = i; }
      public void run() {
        int x=0;
        while(true) {
          x++;
          if (x % 2 = 0) {
            System.out.println(x + " : " + id);
          }
        }
      }
    }
    
- You can put threads to sleep if you want it to periodically continue its task.
  - Thread.sleep(long milliseconds) allows the programmer to tell a thread to sleep for a certain period of time.
  - While the thread is sleeping, no CPU resources are dedicated to executing its statements.
  - .sleep() throws the InterruptedException since a thread may be interrupted while sleeping.
  
Race Conditions
-
- If threads share some memory (for example, an object), read / write order conflicts can happen.

Locks
-
- A solution to a race condition is to block thread access to a shared object.
- We can surround code manipulating a shared resource with Lock objects (specifically ReentrantLock).
- There are several other ways to do this (including the keyword synchronized).
- Synchronized can be used on a method level to prevent multiple threads from executing this concurrently.
- A little less flexible than the lock mechanism, but works in a similar way.

# Lambda Expressions
- Can be used with existing interfaces or custom created ones

Example Using Collections.sort:

    Collections.sort(a, (s1, s2) -> {
      if (s1.getX() > s2.getX())
        return 1;
      else
        return -1;
    });
    
Example Using Runnable:

    Thread t1 = new Thread(() -> {
      int i = 0;
      while (true) {
         ++i;
         System.out.println(i);
      }
    });

Anonymous Classes
- 
- Anonymous classes can be used to define classes extending abstract classes or implementing interfaces.
- Could be useful for code organization
  - If we only want to use the class once and define specific behavior, we …
    - Could implement a class file
    - Or just define the behavior and move on.
  - If a class is used in multiple parts in your code, then providing its own implementation may be better for readability / reusability reasons.
  
Example (Assunimg Animal Interface exists):

    Animal dog = new Animal() {
      public void sound() {
        System.out.println("BARK!");
      }
    };

Lamba
-
- Allows pieces of functionality to exist without it being defined in a class.
- Functions are defined inline whenever we need it.
- Lambda functions are used with Functional Interfaces

Example (Assunimg Animal Interface exists):
    
    Animal dog = () --> {System.out.println("BARK"); };
    
    
# In Class Final Review
- Cummulative, but the emphasis will be post-midterm material 
- Know the methods that are in lecture notes, those in code examples are the most likely to be tested on

Post Midterm Topics Below
-

File IO (Review Lab04)
-
- Scanner objects for outside data
- Absolute vs Relative file paths
- Reading files from file system vs URL
- Dilimiters
  - Breaking into tokens: .useDilimiter, .hasNext, .next, ...
- Writing / appending data to a file
  - PrintWriter, FileWriter
  - open, write to, close
- String formatting
  - printf, format
  - positive vs negative space values for justification
  - padding Strings
  - format specifiers (%s, %d, etc)
  - floating point precision

Generics
-
- Similar to C++ templates
- Generic methods and classes

MultiDimensional Arrays
-
- 2D / 3D
  - Could be really any dimension 
- Memory Org
- Syntax

UML
-
- Look at tutorials
- Look at CS48 notes honestly that's more beneficial
- Basic structure !
- Fields of classes (attributes)
- Methods (operations)
- Relationships (inheritance, ...)

Strategy Design Pattern
-
- Also known as Behavior
- Easier to expand the interface and subsequent classes
- Using interfaces to be the appropriate type of behavior to be implemented in classes which can be used in other classes
- Supports the Open-Close Principle

Observer Design Pattern (Review Lab05)
-
- Publication / Subscription mechanism
- Subjects (publishers) update Observers (subscribers) whenever relavent info is updated
- Notification comes when the thing happens, not over or under pulling
- Beneficial to push notifications to the Observer in most ways
- Understand the design and organization 

Decorator Pattern
-
- Components containing multiple behaviors / attributes (Decorators)
- Components and Decorators extend from a common type
- Component is the base form, Decorators are added onto it 
- Understand the overall relationships between Components and Decorators

Interfaces extending Interfaces
-
- How classes implement multiple Interfaces
- Understanding the hierarchy and type structure

Collections
-
- Understand Java API hierarchy with Collection Interface
- How other collections (set, list, ...) extends Collection
- HashSet, HashMap, TreeMap
- Understanding commonly used methods
  - HashSet: .add, .size, .contains, .remove,
  - HashMap: .put, .containsKey, .containsValue, .get, .keySet, .values, .remove, .size
  
Multithreads
-
- How concurrency is acheived with multi-core architectures
- OS Schedule behavior (context switching) between processes and threads
- Creating threads
  - Thread class
  - Runnable Interface
  - .run methods
- Thread.join()
- .interupt method
- Thread.sleep(in milliseconds)
  - InterruptedException handling

Race Conditions
-
- Example of multiple threads updating
- Using locks to support atomic operations
  - Lock (ReentrantLock) and synchronized

Anonymous Classes
-
- Implementing an interface "on the fly"

Functional Interface
-
- Special type of interface that has only one abstract method

Lambda Expressions
-
- Allows functionality to be defined outside of a class
- Implements functional interfaces
- Know syntax of providing definition of functional interface's abstract method
- Defining lambda expression for Comparator interface and Runnable


# Homework Questions

Homework 00
-
- 2 classes needed for testing an individual class: One class is for the objects you want to use, the second class is the "tester class" that contains objecrs of the first class and accesses its instance variables and methods as the sole purpose
- The heap contains all objects created with the 'new' keyword, and the JVM manages the memory space and will remove objects when they are no longer necessary to free up memory space
- Source code: the actual code in a specified language
- Compiler: used to run the code and check for errors that would prevent it from running
- Java Bytecode: Compiler takes the source code and turns it into Java bytecode
- JVM: what the Java bytecode is run on (software)
- ridgid code much more inefficient than a flexible OO approach to writing code due to the fact that if the specs for one part changes, all of the code has to be redone and retested

Homework 01
-
- Primitive types home fundamental values
  - the actual value is stored in the variable
- Reference types hold references to objects
  - bits representing the path to the object is stored in the variable
- double x = 3.4;   vs    float y = 3.4f;
- Array in Java is an object
- All references for a given JVM are the same size
  - but the amount of memory taken up by an object can differ
- References of the same type can be different sizes on different JVMs
- == is used to compare two primitive types
- .equals() is used to compare two objects

Homework 02
-
String to Int

    String s = "3";
    int p = Integer.parseInt(s);
   
Random Numbers [0, n-1]

    int x = (int)(Math.random()*(n));
    
- Writing tests before writing the actual code can make it easier and faster to write the code. It is easier to clarify what the method needs to do
- Continuous integration: constantly update the code and running tests for each task completed
- Pair programming: working together helps check over code to limit human error
- Encapsulation forces code to go through setter methods to change any variable (can check parameters) so the code can be edited in one place without breaking others

Array Declaration:

    Student[] students = new Student[5];
    
ArrayList Declaration:

    ArrayList<Student> students = new ArrayList<Student>();
    
 Homework 03
 -
 - Valid inheritance examples
  - guitar extends instrument
  - friedEgg extends food
  - beagle extends pet
  - gratefulDead extends band
- Polymorphic arguments and return types..
  - If you have a Boss object with a .fire() function that takes an Employee object as the parameter, you can call this function and pass in any object that extends the Employee class such as a softwareEngineer or a Janitor 
- An abstract class has one or more abstract functions that must be overridden and the others may be defined in the class and interfaces are 100% pure abstract so all functions must be overridden
- Overloading is when two methods have the same name but different argument lists
- Overriding is when subclasses rewerite the superclass method with the same argument list and compatible return type

Homework 04
-
- Java will create a default no-arg constuctor for you if you do not initialize any constructor of your own. 
- The only exceptions that do not have to be caught or declared to be through are extensions of the RuntimeExceptions class
- RuntimeExceptions are for flaws in the code that should not have happened, you want these to happen at development
- Other exceptions are incase a condition falls at runtime in ways that you cannot predict/prevent. Use try/catch blocks for these to handle exceptional situatuons out of your control (Ex: user input)

# Lab Basic Ideas

Lab01
-
- 2 classes -> Book and Author
- Book class has private attributes including an Author object
- Author class has private attributes of its own
- Both classes need setter/getter methods due to encapsulation
- Must make a deep copy of the Author object into the Book object

Shallow Copy Constructor in Author class

    
    //copy constructor
    public Author(Author a) {
	    this.firstName = a.getFirstName();
	    this.lastName = a.getLastName();
	    this.birthYear = a.getBirthYear();
	    this.pubs = a.getPubs();
    }
    
Deep Copy Constructor in Book Class

    
    //deep copy constructor
    public Book (Book b){
	    this.pages = b.getPages();
	    this.year = b.getYear();
	    this.price = b.getPrice();
	    this.title = b.getTitle();

	    this.author = new Author(b.getAuthor());
    }
    
Lab02
-
- Random Number Generation
- User input with Scanner object
  - Including checks for validity
- Multiple class design
- Monitoring variables that are updated in individual methods in a separate class

Lab03
-
- Array functionality
  - add
  - remove
  - ordering
- JUnit testing
- Case insensitivity in Strings for comparison

Lab04
-
- File IO
- Reading a file into the program

From the Web using a URL

    //read from web
		String line;
		Scanner remoteIn = null;
		try {
		    URL remoteFileLocation =new URL("https://sites.cs.ucsb.edu/~richert/cs56/misc/lab04/MusicList.txt");

		    URLConnection connection = remoteFileLocation.openConnection();
		    remoteIn = new Scanner(connection.getInputStream());

		    while (remoteIn.hasNextLine()) {
			    //parse through file line by line
			    line = remoteIn.nextLine();
          .... }
        } catch (IOException e) {
		        System.out.println(e.toString());
		    } finally {
		        if (remoteIn != null) {
			        remoteIn.close();
		        }
		    }
    
From the disk (root directory)

    //read from disk
	   Scanner inFile = null;
	   String line;
	   try {
	       inFile = new Scanner(new File("MusicList.txt"));
	       while (inFile.hasNextLine()) {
			      //parse through file line by line
			      line = inFile.nextLine();
            .... }
        } catch (IOException e) {
		        System.out.println(e.toString());
		    }
        
-ArrayLists
  - .add()
  - .remove()
  - .get()
  - .size()
- Implementing interfaces

Writing to a File in the correct format

    import java.io.*;
    import java.util.Locale;

    public class OutputFile implements OutputFileInterface{
      private PrintWriter out;
    
      //implement output file interface
      public void open(String outputFileName){
	      String t = "TITLE";
	      String art = "ARTIST";
	      String alb = "ALBUM";
	      String len = "LENGTH";
	      String yr = "YEAR";
	      String addit = "ADDITIONAL_INFORMATION";
	
	      try {
	        out = new PrintWriter(outputFileName);	    	
        } catch (Exception e) {
	        System.out.println(e.toString());
	      }
	
	      out.format("%-40s%-40s%-40s%-7s%-5s%-40s\n", "TITLE","ARTIST","ALBUM","LENGTH","YEAR","ADDITIONAL_INFORMATION");
      }

    
      public void writeItem(MusicTrack trackToWrite){
	      String format = trackToWrite.getFormat();
	      String title = trackToWrite.getTitle();
	      String artist = trackToWrite.getArtist();
	      String album = trackToWrite.getAlbum();
	      String length = trackToWrite.getLength();
	      String add = trackToWrite.getAdditionalInfo();
	      int year = trackToWrite.getYear();
	 
	      out.format("%-40s%-40s%-40s%-7s%-5d%-40s\n",title, artist, album, length, year, add);
	
      }

      public void close(){
	      out.close();
      } 
    }
    
Lab05
-
- Observer Design Pattern
- Subject and Observer interfaces implemented
- .update() method 
- LinkedHashMap
- HashSet
- ArrayList
- pushing notifications to the Observer
