# Spring Boot Samples

# Clean Code Tips
- Don’t Repeat Yourself – DRY
    - any code in your program should only be written once, and never duplicated.
- Separation of Concerns
    - Make use of layered approach.
    - Create layers wth wll defined responsibilities...
- Composition over Inheriitance
- Seperate the moving part and inject them using well defined interfaces
- Keep it Simple

- Avoid IF/ELSE, use ternary operator 
    e.g. (a < b) ? true : false;
- Builder pattern for building complex objects
- Chain of Responsibilities when mutiple conditions are called one after another 
    - e.g. Person validator different attributes (name, email, etc.)
    - any validation failure should break the chain and throw appropriate exception...
- Keep method size short
- Method should do only one thing
- Avoid complex statements, move it to a method and give it a meaningful name
- Use meaningful name for conditions 
    e.g. if (isPersonExists()) in place of if (person != null) as 
- Use diamond operator for collections
- Use Arrays.asList() to make list from Array
- Use meaningful names for classes and methods
- Avoid overloaded constructors, construct with static factory methods with meaningful names
- Encapsulate Classes with a Factory
- Switch case in place for multiple IF/ELSE statements
- Never return NULL or a collection as null;
    e.g. List<String> elements = null;    - never return...
        instead...
    e.g. List<String> elements = new ArrayList<>;    - initialize list and return
    elements.addAll(other elements);
- Hibernate N + 1 Select problem
    - use JOIN FETCH in our queries whenever we need to fetch an entity with all of its children at the same time

# SQL Performance Tips
- Indexes on all fields used in the WHERE and JOIN portions of the SQL statement
- Define SELECT Fields instead of SELECT *
- Select More Fields to Avoid SELECT DISTINCT
- Create Joins with INNER JOIN Rather than WHERE
- Remove OUTER JOINS
- Remove Unnecessary Tables
- Use WHERE instead of HAVING to Define Filters
- Use Wildcards at the End of a Phrase Only
- Use LIMIT to Sample Query Results
- Run Analytical Queries During Off-Peak Times

