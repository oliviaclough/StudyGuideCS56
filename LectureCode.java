//Lecture code

//FILE IO LECTURE ----------------------------------------------------------------------------------------------------------------
//Java file encoding
System.out.println(System.getProperty("file.encoding"));

//Reading in with a Scanner object
// If the file does not exist, a FileNotFoundException is thrown
Scanner inFile = new Scanner(new File(“fileName.txt”));

//get all lines in the file and print them one by one
String line;
while (inFile.hasNextLine()){
  line = inFile.nextLine();
  System.out.println(line);
}

//get all words and print out one by one (assumes words broken up by a white space)
String word;
while (inFile.hasNext()) {
  word.inFile.next();
  System.out.println(word);
}

//Reading in file from URL
try {
Scanner inFile = new Scanner(new File("file.txt"));

    String line;
    Scanner remoteIn = null;
    try {
        URL remoteFileLocation =
        new URL("https://sites.cs.ucsb.edu/~richert/file.txt");

        URLConnection connection = remoteFileLocation.openConnection();
        remoteIn = new Scanner(connection.getInputStream());

        while (remoteIn.hasNextLine()) {
            line = remoteIn.nextLine();
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println(e.toString());
    } finally {
        if (remoteIn != null) {
            remoteIn.close();
        }
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

//using ";" as a delimiter (each inFile.next() returns a string starting from the next character)
try {
  Scanner inFile = new Scanner(new File("fileName.txt"));
  inFile.useDelimiter(";");
  String line;
  while(inFile.hasNext()) {
    line = inFile.next();
    System.out.println(line); //the ; is not printed on any line
  }
} catch (IOException e) {
    e.printStackTrace();
}

//using .split() to get pieces of the file if in a fixed format
String s;
Scanner inFile = null;
try {
    inFile = new Scanner(new File("file2.txt"));
} catch (FileNotFoundException e) {
    System.out.println(e);
}
String [] stringArray;
// Get the entire line one-at-a-time
while (inFile.hasNextLine()) {
    s = inFile.nextLine();
    stringArray = s.split(",");
    for (int i = 0; i < stringArray.length; i++) {
        System.out.println(stringArray[i]);
    }
}

//writing to a file with PrintWriter
PrintWriter out = null;
try {
    out = new PrintWriter("output.txt");
    out.println("First Line!");
} catch (FileNotFoundException e) {
    // Non existent path, write access denied, …
    System.out.println(e.toString());
} finally {
    if (out != null) {
        out.close();
    }
}

//using .printf for formatting
char grade = 'A';
double percentage = 99.8;
System.out.format("In order to get a %c, I need to score a %f%% on the final", grade, percentage);
// Output is: In order to get an A, I need to score 99.800000% on the final

//Appending to a file using FileWriter
FileWriter out = null;
try {
    out = new FileWriter("output", true);
    out.write("First Line!!!");
} catch (FileNotFoundException e) {
// Non existent path, write access denied, …
S   ystem.out.println(e.toString());
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (out != null) {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//---------------------------------------------------------------------------------------------------------------------------------     




//GENERICS LECTURE ----------------------------------------------------------------------------------------------------------------
// defining a generic method
public static <T> T getLastItem(T[] array) {
  if (array.length > 0) {
    return array[array.length - 1];
  }
  return null;
}
// in main for above method
Integer[] intArray = {1,2,3}
Double[] doubleArray = {1.1, 2.2, 3.3};
String[] stringArray = {"I", "<3", "CS56"};

System.out.println(getLastItem(intArray));
System.out.println(getLastItem(doubleArray));
System.out.println(getLastItem(stringArray));

// defining a generic class
public class Pair<T, U> {
  private T first;
  private U second;
  
  public Pair(T first, U second) {
    this.first = first;
    this.second = second;
  }
  public T getFirst() { return first; }
  public U getSecond() { return second; }
  public void print() { System.out.println(first + " " + second); }
}
//in main for above
Pair<Integer, String> pair = new Pair<Integer, String>(1, "Hello");
System.out.println(pair.getFirst() + pair.getSecond());
pair.print();

//---------------------------------------------------------------------------------------------------------------------------------     




//2D, 3D, ... ARRAY LECTURE --------------------------------------------------------------------------------------------------------
// 2D array implementation and parse through
int[][] int2d = new int[4][5];
int2d[1][3] = 8;  //initializing a value

for (int i = 0; i < int2d.length; i++) {
  for (int j = 0; j < int2d[i].length; j++) {
    System.out.println(int2d[i][j] + " ");
  }
  System.out.println();
}

//3D array implementation and parse through
int [][][] int3d = new int[2][3][2];
int3d[1][1][1] = 1;   //initializing a value

for (int i = 0; i < int3d.length; i++) {
    System.out.print("|");
    for (int j = 0; j < int3d[0].length;j++) {
        System.out.print(";");
        for (int k = 0; k < int3d[0][0].length;k++) {
            System.out.print(int3d[i][j][k]);
        }
    }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// OBSERVER LECTURE ----------------------------------------------------------------------------------------------------------------
//Subject.java
public interface Subject {
  public void registerObserver(Observer o);
  public void removeObserver(Observer o);
  public void notifyObservers();
}

//Observer.java
public interface Observer {
  public void update(String homeTeam, String awayTeam, Pair<Integer, Integer> score, 
                     Pair<Integer, Integer> assists, String time);
}

//Display.java
public interface Display {
  public void display();
}

//Pair.java - Generic
public class Pair<T,U> {
  private T first;
  private U second;
  
  public Pair(T first, U second) {
    this.first = first;
    this.second = second;
  }
  
  public T getFirst() { return first; }
  public U getSecond() { return second; }
  public void print() { System.out.println(first + ", " + second); }
}

//GameData.java
import java.util.ArrayList;
public class GameData implements Subject {
  private ArrayList<Observer> observers;
  private String homeTeam;
  private String awayTeam;
  private Pair<Integer, Integer> goals;
  private Pair<Integer, Integer> assists;
  private String time;
    
  public GameData(String homeTeam, String awayTeam) {
    observers = new ArrayList<Observer>();
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.goals = new Pair<Integer, Integer>(0,0);
    this.assists = new Pair<Integer, Integer>(0,0);
    this.time = "";
  }
  @Override
  public void registerObserver(Obeserver o) { observers.add; }
  @Override
  public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i >= 0)
      observers.remove(i);
  }
  @Override
  public void notifyOvservers() {
    for (int i = 0; i < observers.size(); i++) {
      Observer obs = observers.get(i);
      obs.update(homeTeam, awayTeam, goals, assists, time);
    }
  }
  public void updateGameState(Pair<Integer, Integer> goals, 
                              Pair<Integer, Integer> assists, String time) {
    this.goals = goals;
    this.assists = assists;
    this.time = time;
    notifyObservers();
  }
}

//GameObserver.java
public class GameObserver implements Observer, Display {
  private String homeTeam;
  private String awayTeam;
  private Pair<Integer, Integer> goals;
  private Pair<Integer, Integer> assists;
  private String time;
    
  public GameObserver(Subject gameData) {
    gameData = gameData;
    gameData.registerObserver(this);
  }
  @Override
  public void update(String homeTeam, String awayTeam,
            Pair<Integer, Integer> goals, Pair<Integer, Integer> assists,
            String time) {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.goals = goals;
    this.assists = assists;
    this.time = time;
        
    display();
  }

  @Override
  public void display() {
    System.out.format("%8s %-10s %-10s\n", "", homeTeam, awayTeam);
    System.out.format("%8s %-10d %-10d\n", "GOALS:", goals.getFirst(), goals.getSecond());
    System.out.format("%8s %-10d %-10d\n", "ASSISTS:", assists.getFirst(), assists.getSecond());
    System.out.format("%8s %-10s\n", "TIME:", time);
    System.out.println("----");
  }
}

//MainClass.java
//call various methods in order to test functionality

//---------------------------------------------------------------------------------------------------------------------------------     




// DECORATOR LECTURE ---------------------------------------------------------------------------------------------------------------
//Pizza.java
public abstract class Pizza {
  private String size = "";
  private String type = "";
  public String getSize() { return size; }
  public String getType() { return type; }
  public void setSize(String size) { this.size = size; }
  public void setType(String type) { this.type = type; }    
  public abstract double cost();
}

//ToppingDecorator.java
public abstract class ToppingDecorator extends Pizza {
  public abstract String getType();
}

//Regular.java
public class Regular extends Pizza {
  public Regular(String size) {
    setSize(size);
    setType("Regular Crust");
  }
  @Override
  public double cost() {
    switch (getSize()) {
      case "small":
        return 10;
      case "medium":
        return 15;
      case "large":
        return 20;
    }
    return 0;
  }
}

//Pan.java
public class Pan extends Pizza {
  public Pan(String size){
    setSize(size);
    setType("Pan Crust");
  }
  @Override
  public double cost() {
    switch (getSize()){
      case "small":
        return 12;
      case "medium":
        return 17;
      case "large":
        return 22;
    }
    return 0;
  }
}

//Cheese.java
public class Cheese extends ToppingDecorator {
  private Pizza pizza;
  public Cheese(Pizza pizza) {
    this.pizza = pizza;
    setSize(pizza.getSize());
    setType(pizza.getType());
  }
  @Override
  public String getType() {
    return pizza.getType() + " + Cheese";
  }
  public double cost() {
    switch (pizza.getSize()) {
      case "small":
        return 1 + pizza.cost();
      case "medium":
        return 2 + pizza.cost();
      case "large":
        return 4 + pizza.cost();
    }
    return 0;
  }
}

//Pepperoni.java
public class Pepperoni extends ToppingDecorator {
  private Pizza pizza;
  public Pepperoni(Pizza pizza) {
    this.pizza = pizza;
    setSize(pizza.getSize());
    setType(pizza.getType());
  }
  @Override
  public String getType() {
    return pizza.getType() + " + Pepperoni";
  }
  public double cost() {
    switch (pizza.getSize()) {
      case "small":
        return 1.5 + pizza.cost();
      case "medium":
        return 2.5 + pizza.cost();
      case "large":
        return 4.5 + pizza.cost();
    }
    return 0;
  }
}

//MainClass.java
public class MainClass {
  public static void printPizza(Pizza pizza) {
    System.out.format(%s %s: $%.2f\n, pizza.getSize(), pizza.getType(), pizza.cost());
    System.out.println();
  }
  public static void main (String[] args) {
    Pizza pizza = new Regular("large");
    pizza = new Cheese(pizza);
    pizza = new Pepperoni(pizza);
    printPizza(pizza);
    
    Pizza pizza2 = new Pan("small");
    pizza2 = new Cheese(pizza2);
    pizza2 = new Cheese(pizza2);
    pizza2 = new Pepperoni(pizza2);
    printPizza(pizza2);
  }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// MULTIPLE INTERFACES LECTURE -----------------------------------------------------------------------------------------------------
public interface A {
  public abstract void method1();
  public abstract void method2();
}

public interface B extends A {
  public abstract void method3();
}

public interface C {
  public abstract void method4();
}

public class ClassA implements A {
  public void method1() { System.out.println("ClassA method 1"); }
  public void method2() { System.out.println("ClassA method 2"); }
}

public class ClassB implements B {
  public void method1() { System.out.println("ClassB method 1"); }
  public void method2() { System.out.println("ClassB method 2"); }
  public void method3() { System.out.println("ClassB method 3"); }
}

public class ClassC implements B, C {
  public void method1() { System.out.println("ClassC method 1"); }
  public void method2() { System.out.println("ClassC method 2"); }
  public void method3() { System.out.println("ClassC method 3"); }
  public void method4() { System.out.println("ClassC method 4"); }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// COLLECTIONS LECTURE -------------------------------------------------------------------------------------------------------------
// HashSet implements Set Interface (no guaranteed order)
HashSet<String> s = new HashSet<String>();
System.out.println(s.add("S1")); //true - successful 
System.out.println(s.add("S2")); // true - successful
System.out.println(s.add("S2")); // false - unsuccessful
System.out.println(s.size()); // 2
System.out.println(s.contains("S1")); // true
System.out.println(s.remove("S1")); // returns true AND removes
System.out.println(s.contains("S1")); // false

// HashMap
HashMap<Integer, String> s = new HashMap<Integer,String>();
System.out.println(s.put(0, "Richert")); // null
System.out.println(s.put(1, "Wang")); // null
System.out.println(s.put(0, "RichARD")); // Richert - returns old value	

System.out.println(s.containsKey(1)); // true
System.out.println(s.containsKey(10)); // false
System.out.println(s.containsValue("Richert")); // false
System.out.println(s.containsValue("RichARD")); // true

// Get Value for specific key
System.out.println(s.get(1)); // Wang

// Traverse Keys
for (Integer i : s.keySet()) {
  System.out.println(i);
}

// Traverse values
for (String i : s.values()) {
  System.out.println(i);
}

System.out.println(s.remove(0)); // RichARD
System.out.println(s.containsValue("RichARD")); // false
System.out.println(s.remove(1, "fjskj")); // false
System.out.println(s.remove(1, "Wang")); // true
System.out.println(s.size()); // 0

//---------------------------------------------------------------------------------------------------------------------------------     




// CONCURRENCY LECTURE -------------------------------------------------------------------------------------------------------------
//creating threads
public class MyThread extends Thread {
  public void run() {
    int i = 0;
    while (true) {
      i++;
      if (i % 100000 == 0)
        System.out.println(i);
    }
  }
}
//main method
public static void main (String[] args) {
  MyTheard 1 = new MyThread();
  t.start();
}

//---------------------------------------------------------------------------------------------------------------------------------     




// RUNNABLE LECTURE ---------------------------------------------------------------------------------------------------------------
//implementing the interface
public class RunnableExample implements Runnable {
  private String id;
  public RunnableExample(String id) { this.id = id; }
  public void run() {
    int i = 0;
    Date now = null;
    try{
      while(true) {
        now = new Date();
        i++;
        if (i%100000 == 0) {
          System.out.println(i + ": " +id);
          Thread.sleep(1000);
        }
      }
    } catch (InterruptedException e) {
      System.out.println(now.toString() + "Thread " + id + " interrupted");
    }
  }
}
//main method
public static void maind(String[] args) {
  RunnableExample r1 = new RunnableExample("r1");
  RunnableExample r2 = new RunnableExample("r2");
  RunnableExample r3 = new RunnableExample("r3");
  Thread t1 = new Thread(r1);
  Thread t2 = new Thread(r2);
  Thread t3 = new Thread(r3);
  t1.start();
  t2.start();
  t3.start();
  try {
    Thread.sleep(3000);
    t1.interrupt;
    Thread.sleep(3000);
    t2.interrupt;
    Thread.sleep(3000);
    t3.interrupt;
  } catch (InterruptedException e) {
    System.out.println("Should not happen");
  }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// RACE/LOCKS LECTURE ---------------------------------------------------------------------------------------------------------------
//Bank.java
public class Bank {
  private double totalBalance;
  private Lock balanceLock;
  public Bank() { 
    totalBalance = 0;
    balanceLock = new ReentrantLock();
  }
  public void deposit(double amount) {
    balanceLock.lock();
    totalBalance += amount;
    balanceLock.unlock();
  }
  
  //can do deposit method as synchronized, but is less flexible
  //public synchronized void deposit(double amount) {
    //totalBalance += amount;
    //return;
  //}
  
  public double getBalance() { return totalBalance; }
}

//RunnableEx.java
public class RunnableEx implements Runnable {
  private String id;
  private Bank bank;
  public RunnableEx(String id, Bank bank) {
    this.id = id;
    this.bank = bank;
  }
  @Override
  public void run() {
    System.out.println("In thread " + Thread.currentThread().getId());
    for (int i = 0; i < 1000; i++) {
      bank.deposit(10);
    }
  }
}

//MainClass
public class MainClass {
  public static void main (String[] args) {
    Bank b = new Bank();
    RunnableEx r1 = new RunnableEx("r1", b);
    RunnableEx r2 = new RunnableEx("r2", b);
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) { } 
    System.out.println(b.getBalance());
  }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// ANON CLASSES LECTURE ------------------------------------------------------------------------------------------------------------
//Animal.java
@FunctionalInterface
public interface Animal {
  public void sound();
}
//MainClass.java
import java.util.ArrayList;
public class MainClass {
  public static void makeSound(Animal animal) { animal.sound(); }
  public static void main(String[] args) {
    Animal cat = new Animal() {
      public void sound() {
        System.out.println("MEOW");
      }
    };
    Animal dog = new Animal() {
      public void sound() {
        System.out.println("BARK");
      }
    };
    Animal cow = new Animal() {
      public void sound() {
        System.out.println("MOO");
      }
    };
    
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    animalList.add(cat);
    animalList.add(dog);
    animalList.add(cow);
    animalList.add(new Animal() {
      public void sound() {
        System.out.println("CAW");
      }
    });
    
    for (Animal a : animalList) {
      makeSound(a);
    }
  }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// LAMBDA EXP LECTURE -------------------------------------------------------------------------------------------------------------
//Basic implementation
Animal dog = () -> { System.out.println("BARK"); };
Animal cat = () -> { System.out.println("MEOW"); };
Animal cow = () -> { System.out.println("MOO"); };

//implementation with parameters
//Animal.java
@FunctionalInterface
public interface Animal {
  public void sound(double weight);
}
//MainClass.java
public class MainClass {
  public static void makeSound(Animal animal) {
    animal.sound(60);
  }
  
  public static void main(String[] args) {
    Animal dog = (weight) -> {
      if (weight > 50)
        System.out.println("BARK!!!!");
      else
        System.out.println("BARK");
    };
    Animal cat = (weight) -> {
      if (weight > 50)
        System.out.println("MEOW!!!!");
      else
        System.out.println("MEOW");
    };
    Animal dog = (weight) -> {
      if (weight > 50)
        System.out.println("MOO!!!!");
      else
        System.out.println("MOO");
    };
    
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    animalList.add(dog);
    animalList.add(cat);
    animalList.add(cow);
    
    for (Animal a : animalList) {
      makeSound(a);
    }
  }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// LAMBDA WITH COLLECTIONS LECTURE -------------------------------------------------------------------------------------------------
//Student.java
public class Student {
  private String name;
  private int perm;
  public Student(String name, int perm) {
    this.name = name;
    this.perm = perm;
  }
  public String getName() { return name; }
  public int getPerm() { return perm; }
}

//MainClass.java
public class MainClass {
  public static void main(String[] args) {
    ArrayList<Student> a = new ArrayList<Student>();
    a.add(new Student("RICHERT", 666));
    a.add(new Student("IDC", 1234));
    a.add(new Student("WTF", 567));
    a.add(new Student("FUCK U", 8910));
    
    //Anon Class
    Collections.sort(a, new COmparator<Object>() {
      public int compare(Object 01, Object 02) {
        Student x = (Student) o1;
        Student y = (Student) o2;
        if (x.getPerm() > y.getPerm())
          return 1;
        else if (x.getPetm() == y.getPerm())
          return 0;
        else
          return -1;
      }
    });
    
    //Lambda Expression
    Collections.sort(a, (s1,s2) -> {
      if (s1.getPerm() > s2.getPerm())
        return 1;
      else if (s1.getPerm() == s2.getPerm())
        return 0;
      else
        return -1;
    });
    
    for (Student s : a) {
      System.out.println(s.getName() + ": " + s.getPerm());
    }
  }
}

//---------------------------------------------------------------------------------------------------------------------------------     




// LAMBDA WITH RUNNABLE LECTURE ---------------------------------------------------------------------------------------------------
public static void main(String[] args) {
  Thread t1 = new Thread(() -> {
    int i = 0;
    while(true) {
      ++i;
      System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  });
  
  t1.start();
}
