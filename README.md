Express
=======

Simple one-liner expressions for Java.

This project includes:

1. A simple parser for one-line expressions, that may include nested function calls, simple variables, and arrays
2. A base implementation of `ExpressionContext`, to allow registering values and declaring custom functions
3. A dozen or so functions for various types of string encoding/decoding/manipulation

You could easily extend it by declaring your own functions and hooking up to your own data store.

### Background

This project is yet another spin-off from Loadster (www.loadsterperformance.com). Loadster scripts are mostly a 
chain of HTTP requests, recorded or manually entered with a graphical script editor. You can also do neat tricks like 
capturing part of an HTTP response to use in a future request: for example, Command #1 might do a POST to save some 
resource on the server, and you have to then capture and reuse the resource's ID from the HTTP response to use in 
Command #2.

Sometimes you might even have to apply some encoding to the value before sending it back: it's typical
for an HTTP GET/POST parameter to need URL encoding when submitted via a web form. In other situations you might
be submitting JSON or XML or some other format.

The easiest and most straightforward solution for this was to allow expressions such as the following...

```
// Simple variable expression
${userId}

// Array index expression, for loading from a data set
${users[3]}

// Apply URL encoding to a value from an array
${urlencode(users[0])}

// First URL decode, and then XML escape an email address
${xmlescape(urldecode(emailAddress))}

// First URL decode, and then JavaScript/JSON escape an email address
${jsescape(urldecode(emailAddress))}
```

Okay, you get the idea. These examples are all obviously of slanted towards the Loadster use case, but you could just as 
easily declare and implement your own functions in place of the ones shown here.

### Why not ANTLR?
ANTLR is great but the requirement here was really simple: single-line expressions with simple functions and 
variable/array references. That's it. I was able to build this framework in 2-3 hours total and it
does just what I needed it to do.

### Quick Start
To create a basic context and parse an expression, it's just a matter of:

```java
BasicExpressionContext context = new BasicExpressionContext();

context.setVariable("emailAddress", "andy@andyhawkes.com");

String expr = "jsescape(urlencode(emailAddress))";
Expression expression = Expression.parse(expr);
String value = expression.evaluate(context);

System.out.println("evaluated expression is " + value);
```

What's happening here? 

First, the `BasicExpressionContext` is a default implementation of `ExpressionContext` that
lets you set variables and function declarations for later use. It will work for simple projects. If your project has 
more specific needs (variable values should come from a database, functions should come from a rules engine, etc) then
you can implement your own `ExpressionContext` that acts accordingly.

Once you have an `ExpressionContext` capable of resolving variables and functions, you can parse an expression using
the static method `Expression.parse(str)`. If the expression is unparsable, it will throw a `ParseException`.

Parsed expressions can then be evaluated against the `ExpressionContext`.

### Registering Custom Functions

Most likely you'll need different functions than the dozen or so provided here. No problem, you can register your own.

```java
BasicExpressionContext context = new BasicExpressionContext();

// Set some arbitrary variable in the context
context.setVariable("anagram", "amanaplanacanalpanama");

// Declare a "reverse" function with implementation
context.setFunction("reverse", new Function() {
  public String evaluate(String arg) {
    return new StringBuffer(arg).reverse();
  }
});

// Now evaluate an expression that uses the new reverse() function
String output = Expression.parse("reverse(anagram)").evaluate(context);
```
Hopefully this gives you some idea of the ease with which you can implement custom functions.

### Gotchas
Just don't try to use this library for building a full-fledged scripting language or something. You will quickly run into
trouble. It was meant to be simple and extensible for one-line expressions and data manipulation, and that's it!

### License
Copyright (c) 2013 Andy Hawkes

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
