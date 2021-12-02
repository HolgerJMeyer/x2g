# X2G rule language

## Rule language by example

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

// conditional node creation
