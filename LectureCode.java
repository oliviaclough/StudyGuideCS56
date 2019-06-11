//Lecture code

//FILE IO LECTURE ------------------------------------------------------------------------------
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

