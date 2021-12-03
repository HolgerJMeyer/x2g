# X2G rule language

## Rule language by example

### XML extract with match and xpath expressions

The general syntax is

`match xpath(<xpath-expr>) using <var-binding> { <body> }`

The body of the `match` statement is evaluate for each xml fragment matched by the XPath expresion `<xpath-expr>`.  The `using` clause allows for binding a variable to each of the matches.  Within the body the current binding can be access through the bound variable`<var-binding>` or by relative Xpath expressions, alternativly.  A relative XPath starts usually with `'.'` as in the second `match` statement in the example below.

`<body>` can be one more several other `match`, `node` and `edge` generating or conditional statements.

```
// nested match example, the second match is evaluated within context of the first
match xpath(//story) using $s {
    create node $n label "story" {
        // property list
        content = "$s/content/text()",
        title = "$s/title/text()"
    }
    match xpath(.//person[@role="narrator"]) using $p {
        create node $p label "person" {
            name = "$p/name/text()",
            gender = "$p/appellation"
        }
        create edge $e from $s to $n label "narrator" { /* no properties */ }
    }
}
```

There is a second variant of the `match` statement not using xpath expressions but matching all nodes with a certain label:

`match node(<string-expr>) using <var-binding> { <body> }`

By this statement it is possible to go through a certain set of existing node, e.g. for generating further edges.  Further, one can combine several match expressions in one statement in this way:

`match <match-expression>, <match-expression>, ... { <body> }`

The evaluation of such `match` statement is a follows: each `<match-expression>` is computed and the body is evaluated for all possible combinations of the resulting variable bindings.

### The node generating statement

The node statement has the general form of

`create node <var-binding> label <string-expr> { <optional-property-list> }`

For each unique combined value of the label `<string-expr>` and `<optional-property-list>` a new node is generated.  The generated unique node id is then bound to the variable `<var-binding>`.  If there exists already a node with the same label and set of property values, its node id is bound and no new node is generated.

### The edge generating statement

And directed edge from a node ot another is produced by following statement:

`create edge <var-binding> from <node-reference> to <node-reference> label <string-expr> { <optional-property-list> }`

Both, the `from` and the `to` clause have to reference existing nodes by the given `<node-reference>`, i.e. nodes already generated.  A `<node-reference>` is usually a bound node variable from node statement evaluated before.

### The conditional statement

Sometimes it is necessary to only generate nodes and especially edges under certain constraints.  The following statement can be used for that:

`if <boolean-expr> { <body> }`

If the boolean expression, e.g. some comparisons of bound values, evaluates to true, statements of `<body>` are evaluated.

### Variable bindings and expressions

There are three types of variable bindings:

* Path variables bound to XML fragments by XPath expressions,
* Node variables bound to nodes by `create node` or `node(<label>)`, and
* Edge variables bound to edges by `create edge`.

A path variable can be used to further access all elements or attributes by an XPath sub-expression like:

`$<var>/<xpath-expression>`

Such an expression is `$p/name/text()` from the example above, which extracts the string of the sub-element `name` from a `person``fragment.

Node and edge variables can access the properties assigned. There a some reserved attributes/properties which are:
* `id` to access the node's id
* `label` returning the node or edge label, and
* `from` and `to` representing the source and target node ids of an edge.

To distinguish XPath from node and edge variables, the later using a dot notation for accessing the certein properties, like in `$n.id` or `$e.from`.

At the moment, we expact all expression to be evaluated ot truth (boolean) or the string values.  In a later version numerical expression evaluation may be added.

### Comment

Comment can be used as in C++ or Java:
* a comment starting with `//` to the end of the line and
* multi-line comments enclosed by `/*` and `*/`.

## Open questions
* How to create a node or edge condtionally?