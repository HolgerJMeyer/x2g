# X2G rule language

## Rule language by example

### XML extract with match and xpath expressions

The general syntax is

`match path(<xpath-expr>) using <var-binding> { <body> }`

The body of the match statement is evaluate for each xml fragment matched by the Xpath expresion `<xpath-expr>`.  The `using` clause allows for bind a variable to each of the matches.  Within the body the current binding can be access through the bound variable`<var-binding>` or by relative Xpath expressions, alternativly.  A relative Xpath starts with `.`.

`<body>` can be one more several other `match`- or `node` and `edge` generating statements.

```
// nested match example, the second match is evaluated within context of the first
match path(//story) using $s {
    create node $n label "story" {
        // property list
        content = "$s/content/text()",
        title = "$s/title/text()"
    }
    match path(.//person[@role="narrator"]) using $p {
        create node $p label "person" {
            name = "$p/name/text()",
            gender = "$p/appellation"
        }
        create edge from $s to $n label "narrator" { /* no properties */ }
    }
}
```


## Open questions
* How to create a node or edge condtionally?
