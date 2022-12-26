package com.example.skilltest;

public class QuestionsAnswers {

    public static String[] getQuizData() {
        return new String[] {
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5"
        };
    }

    public static String[] phpQuestions = {
            "Full form of PHP is",
            "The default file extension in PHP are",
            "Which of the following is the correct way\n to declare the constant in PHP?",
            "How does the name of the variable in PHP starts?",
            "Which of the following is the syntax of comment in PHP?"
    };

    public static String[][] phpAnswers = {
            {"Hypertext Preprocessor",
                    "Pretext Hypertext Preprocessor",
                    "Processor Hypertext Preprocessor",
                    "None of the above"},
            {".php", ".css", ".js", ".html"},
            {"const", "define", "var", "let"},
            {"!", "$", "&", "#"},
            {"/**/", "#", "//", "All of the above"}
    };

    public static String[] phpCorrectAnswers = {
            "Hypertext Preprocessor", ".php", "define", "$", "All of the above"
    };

    public static String[] javaQuestions = {
            "What is a correct syntax to output \"Hello World\" in Java?",
            "How do you insert COMMENTS in Java code?",
            "Which data type is used to create\n a variable that should store text?",
            "How do you create a variable with the numeric value 5?",
            "Which method can be used to find the length of a string?"
    };

    public static String[][] javaAnswers = {
            {"Console.Writline(\"Hello World\");",
                    "echo(\"Hello World\");",
                    "print(\"Hello World\");",
                    "System.out.println(\"Hello World\");"},
            {"//", "/*", "#", "/\\"},
            {"myString", "Txt", "string", "String"},
            {"num x = 5;", "int x = 5;", "float x = 5;", "x = 5;"},
            {"length()", "len()", "getLength()", "getSize()"}
    };

    public static String[] javaCorrectAnswers = {
            "System.out.println(\"Hello World\");", "//", "String", "int x = 5;", "length()"
    };

    public static String[] pythonQuestions = {
            "What is a correct syntax\n to output \"Hello World\" in Python?",
            "Which one is NOT a legal variable name?",
            "What is the correct file extension for Python files?",
            "What is the correct syntax to output\n the type of a variable or object in Python?",
            "What is the correct way to create a function in Python?"
    };

    public static String[][] pythonAnswers = {
            {"echo \"Hello World\"",
                    "print(\"Hello World\")",
                    "p(\"Hello World\")",
                    "echo(\"Hello World\")"},
            {"myvar", "Myvar", "_myvar", "my-var"},
            {".pyt", ".pyth", ".py", ".pt"},
            {"print(typeof x)", "print(typeOf(x))", "print(type(x))", "print(typeof(x))"},
            {"function myFunc():", "def myFunc():", "create myFunc():", "fun myFunc():"},
    };

    public static String[] pythonCorrectAnswers = {
            "print(\"Hello World\")", "my-var", ".py", "print(type(x))", "def myFunction():"
    };

    public static String[] javascriptQuestions = {
            "Inside which HTML element do we put the JavaScript?",
            "What is the correct syntax for referring\n to an external script called \"xxx.js\"?",
            "How do you write \"Hello World\" in an alert box?",
            "How to write an IF statement in JavaScript?",
            "What is the correct way to write a JavaScript array?"
    };

    public static String[][] javascriptAnswers = {
            {"<js>", "<script>", "<scripting>", "<javascript>"},
            {"<script name=\"xxx.js\">",
                    "<script src=\"xxx.js\">",
                    "<script href=\"xxx.js\">",
                    "<script link=\"xxx.js\">"},
            {"msg(\"Hello World\");",
                    "alert(\"Hello World\");",
                    "msgBox(\"Hello World\");",
                    "alertBox(\"Hello World\");"},
            {"if i == 5 then", "if (i == 5)", "if i = 5 then", "if i = 5"},
            {"var colors = [\"red\", \"green\", \"blue\"]",
                    "var colors = \"red\", \"green\", \"blue\"",
                    "var colors = 1 = (\"red\"), 2 = (\"green\"), 3 = (\"blue\")",
                    "var colors = (1:\"red\", 2:\"green\", 3:\"blue\")"}
    };

    public static String[] javascriptCorrectAnswers = {
            "<script>",
            "<script src=\"xxx.js\">",
            "alert(\"Hello World\");",
            "if (i == 5)", "var colors = [\"red\", \"green\", \"blue\"]"
    };

}