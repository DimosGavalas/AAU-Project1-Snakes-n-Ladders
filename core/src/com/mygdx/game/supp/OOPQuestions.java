package com.mygdx.game.supp;

public class OOPQuestions {

    static String[] oopQues = {

            "The default value of a static integer variable of a class in Java is?",

            "What will be printed as the output of the following program?\npublic class testincr\n{\n" +
                    "public static void main(String args[])\n{\nint i = 0;\ni = i++ + i;\nSystem.out.println(“I = ” +i);\n}\n}",

            "To prevent any method from overriding, we declare the method as.",

            "Which one of the following is not true?",

            "A constructor",

            "In object-oriented programming, new classes can be defined by extending existing classes. This is an example of:",

            "Object-oriented inheritance models the",

            "A package is a collection of",

            "Which one is a valid declaration of an Array?",

            "Which one is a valid declaration of a boolean?",

            "Which is a valid declarations of a String?",

            "What is the numerical range of a char?",

            "Which provides runtime environment for java byte code to be executed?",

            "What is bytecode in Java?",

            "Which one of the following are not Java keywords?",

            "Which one of these have highest precedence?",

            "Which statement transfer execution to different parts of your code based on the value of an expression?",

            "Modulus operator (%) can be applied to which of these?",

            "What feature of OOP has a super-class sub-class concept?",

            "What is the full form of JVM?",

            "In Java code, the that begins with /* and ends with */ is known as?",

            "Which of the following are not Java modifiers?",

            "What is the range of data type short in Java?",

            "What is the range of data type byte in Java?",

            "Which of these values can a boolean variable contain?",

            "What is the output of this program?\nclass mainclass {\npublic static void main(String args[])\n{\nboolean var1 = true;\nboolean var2 = false;" +
                    "\nif (var1)\nSystem.out.println(var1);\nelse\nSystem.out.println(var2);\n}\n}",

            "What is the output of this program?\nclass mainclass {\npublic static void main(String args[])\n{\nchar a = 'A';\na++;\nSystem.out.print((int)a);\n}\n}",


            "Which of these operators is used to allocate memory to array variable in Java?",

            "What will this code print?\nint arr[] = new int [5];\nSystem.out.print(arr);",

            "Which of these is necessary to specify at time of array initialization?",

            "When does Exceptions in Java arises in code sequence?",

            "Which of these keywords is not a part of exception handling?",

            "Which of these keywords must be used to monitor for exceptions?",

            "Which of these keywords must be used to handle the exception thrown by try block in some rational manner?",

            "Which of these keywords is used to manually throw an exception?",

            "Which of these operators can be used to concatenate two or more String objects?",

            "Which of these method of class String is used to obtain length of String object?",

            "Which of these method of class String is used to extract a single character from a String object?",

            "Which of these method of class String is used to compare two String objects for their equality?",

            "Which of these access specifiers can be used for an interface?",

            "Which of the following is correct way of implementing an interface salary by class manager?",

            "Decrement operator, –, decreases value of variable by what number?",

            "What is the output of this program?\nclass increment {\npublic static void main(String args[])\n{\nint g = 3;\nSystem.out.print(++g * 8);\n}\n}",

            "Java Source Code is compiled into..",

            "Which of the following is not a keyword in Java?",

            "Which of these are selection statements in Java?",

            "Which of the following loops will execute the body of loop even when condition controlling the loop is initially false?",

            "Which of the following is used with the switch statement?",

            "Which of the following is not a valid flow control statement?",

            "Which of these keywords is used to prevent content of a variable from being modified?",

    };
    static String[][] oopAns = {

            {"0","Null", "1", "-1"},

            {"I = 0", "I = 1", "I = 2", "I = 3"},

            {"static", "abstract", "none of the above", "final"},

            {"A class containing abstract methods is called an abstract class.",
                    "An abstract class cannot have non-abstract methods.","A class must be qualified as ‘abstract’ class, if it contains one abstract method.",
                    "None of the above."},

            {"Must have the same name as the class it is declared within.","Is used to create objects.","May be declared private.","All of them above"},

            {"Encapsulation","Interface","Inheritance","Polymorphism"},

            {"“is a kind of” relationship", "“has a” relationship", "“want to be” relationship", "No relationship" },

            {"Classes","Interfaces","Editing tools","Classes and interfaces" },

            {"int [] myList = {123};","int [] myList = (5, 8, 2)","int myList [] [] = {4,9,7,0};","int myList [] = {4, 3, 7};"},


            {"boolean b1 = 0","boolean b2 = 'false';","boolean b3 = false;","boolean b4 = Boolean.false();" },

            {"String s1 = null;","String s2 = 'null';","String s3 = (String) 'abc';","String s3 = (String) 'abc';" },

            {"-128 to 127"," -(2^15) to (215) - 1","0 to 32767","0 to 65535"},

            {"JDK","JVM","JRE","JAVAC"},

            {"Code generated by a Java compiler","Code generated by a Java Virtual Machine","Name of Java source code file","Block of code written inside a class"},

            {"double","switch","then","instanceof"},

            {"()","++","*",">>"},

            {"if","switch","for-loop","while-loop"},

            {"Integers","Floating - point numbers","None of These","Both integers and floating - point numbers"},

            {"Hierarchical inheritance","Single inheritance","Multiple inheritances","Multilevel inheritance"},

            {"Java Very Large Machine","Java Verified Machine","Java Very Small Machine","Java Virtual Machine"},

            {"Multiline comment","Single line comment","Division","None of these"},

            {"public","private","friendly","transient"},

            {"-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned"},

            {"-32768 to 32767","-2147483648 to 2147483647","-128 to 127","None of the mentioned"},

            {"True & False","0 & 1","Any integer value","1 & -1"},

            {"0","1","true","false"},

            {"66","67","65","64"},

            {"malloc","alloc","new","new malloc"},

            {"0","value stored in arr[0].","Garbage value","00000"},

            {"Collumn","Row","Both Row and Column","None of the mentioned"},

            {"Never","Can Occur Any Time","Compilation Time","Run Time"},

            {"try","thrown","finally","catch"},

            {"try","throw","finally","catch"},

            {"throw","try","catch","finally"},

            {"throw","catch","try","finally"},

            {"+=","+","&","||"},

            {"get()","Sizeof()","lengthof()","length()"},

            {"CHARAT()","charat()","charAt()","ChatAt()"},

            {"equals()","Equals()","isequal()","Isequal()"},

            {"private","public","protected","default"},

            {"class manager extends salary {}","class manager implements salary {}","class manager imports salary {}","None of the mentioned."},

            {"1","2","3","4"},

            {"24","25","32","33"},

            {".Obj","Bytecode",".Exe","Source code"},

            {"finalize","abstract","assert","boolean"},

            {"if()","for()","continue","break"},

            {"while","do-while","for","none of the mentioned"},

            {"Continue","Exit","break","do"},

            {"exit()","continue","break","return"},

            {"final","last","static","constant"},


    };
    static int[] oopRightAns = {2,1,3,1,3,2,0,3,3,2,0,3,1,0,2,0,1,3,0,3,0,2,1,2,0,2,0,2,2,1,3,2,0,2,0,1,3,2,0,1,1,0,2,1,0,0,1,2,0,0};
}
