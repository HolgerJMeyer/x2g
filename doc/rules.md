# X2G rule language

## Rule language by example

### XML extract with match and xpath expressions

The general syntax is

`match path(<xpath-expr>) using <var-binding> { <body> }`

The body of the match statement is evaluate for each xml fragment matched by the Xpath expresion `<xpath-expr>`.  The `using` clause allows for binding a variable to each of the matches.  Within the body the current binding can be access through the bound variable`<var-binding>` or by relative Xpath expressions, alternativly.  A relative Xpath starts usually with `'.'` as in the second `match` statement in the example below.

`<body>` can be one more several other `match`- or `node` and `edge` generating statements.

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
        create edge from $s to $n label "narrator" { /* no properties */ }
    }
}
```

### The node generating statement

The node statment has the general form of

`create node <var-binding> label <string-expr> { <optional-property-list> }`

For each unique combined value of the label `<string-expr>` and `<optional-property-list>` a new node is generated.  The generated unique node id is then bound to the variable `<var-binding>`.  If already a node with the same label and set of property values exists, its node id is bound and no node is generated.

### The edge generating statement

And directed edge from a node ot another is produced by following statement:

`create edge from <node-reference> to <node-reference> label <string-expr> { <optional-property-list> }`

Both, the `from` and the `to` clause have to reference existing nodes by the given `node-reference`, i.e. nodes already generated.  A `<node-reference>` is usually a bound node variable from former node statements.

## Open questions
* How to create a node or edge condtionally?
