# Code Conventions

This chapter describes how developers (contributors) should write code. The reasoning of these styles and conventions is mainly for consistency, readability and maintainability reasons.

## Generic Code Style and Convention

All working files (java, xml, others) should respect the following conventions:

* **Trailing Whitespaces**, remove all trailing white-spaces
* **Indentation**, never use tabs!
* **Line wrapping**, always use a 120-column line width

## Java Code Covention

Our basic style guide for Java is to use [Sun's Java guide Code Conventions for the Java TM Programming Language](http://www.oracle.com/technetwork/java/codeconvtoc-136057.html), but we do have a few subtle differences.

* **White space**: One space after control statements and between arguments (i.e. `if ( foo )` instead of `if(foo)`), `myFunc( foo, bar, baz )` instead of `myFunc(foo,bar,baz)`). No spaces after methods names (i.e. `void myMethod()`, `myMethod( "foo" )`)
* **Indentation**: Always use 4 spaces indents for java file, 2 spaces for xml file and **never** use tabs!
* **Blocks**: Always enclose with a new line brace.
* **Line wrapping**: Always use a 120-column line width for Java code and Javadoc.
* **Design idioms**: Avoid creating internal objects as much as possible. Favor dependency injection whenever possible.
* **Organization**: Avoid using a lot of public inner classes. Prefer interfaces instead of default implementation.
* **Modifier**:Avoid using final modifier on all member variables and arguments. Prefer using private or protected member instead of public member.
* **Standard Annotations**: Use `@Override` where required, use `@Deprecated` when something is deprecated, but still functions, and use `@SuppressWarnings` only when it's impossible to eliminate the warning.
* **Exceptions**: Throw meaningful exceptions to makes debugging and testing more easy. If you're not doing anything meaningful with an exception, throw it to the caller. Wrapping with a RuntimeException is fine if it's an exception that is only going to occur in the event of a programming error rather than a logical error (i.e. the same reason why unchecked exceptions exist in the first place).
* **Scope**: Limit scope as much as possible. If you have a member that is a private part of your interface, but that you need to get access to for testing (such as an internal constant), make it package private (default).
* **Documentation**: Document public interfaces well, i.e. all non-trivial public and protected functions should include Javadoc that indicates what it does, expected inputs, return values, exceptions thrown, and any implementation notes.
  * Do not include authorship information.
  * Don't waste time with redundant and obvious comments. This means getters and setters probably don't need comments at all.
  * Use the notation `TODO`: comment when leaving a comment about future work that needs to be done. This is automatically picked up by Eclipse the auto generated [Taglist report](http://www.mojohaus.org/taglist-maven-plugin/) and other editors, and it makes finding them useful. Don't put user ids or specific dates.
* **Testing**: All non-trivial public classes should include a corresponding unit test. We use `JUnit`, `PowerMock`, `Mockito` and `EasyMock` (preferred) to make testing easier. Patches will be refused without corresponding test cases. Classes should have all feasible branches covered, any branch that isn't covered must be explained in comments.

**Naming**

* Treat acronyms as words. This means "HtmlParser" and not "HTMLParser". Java's standard libraries are inconsistent about this, but we shouldn't be.
* Constants (static final members) should always use an ALL_CAPS form.
* Enum values should always capitalized and camel case.
* Use short, descriptive names for your classes and functions.

## Versioning Naming Convention

The version name is normalized according to [Semantic Versioning][semver].

[semver]: http://semver.org/
