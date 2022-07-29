#!/bin/sh

export CLASSPATH=".:/usr/share/java/apache-commons-cli.jar:/usr/share/java/apache-commons-csv.jar:./jdom2/jdom-2.0.6.1.jar:./jdom2/lib/jaxen-1.2.0.jar:"/usr/share/java/antlr4/antlr4.jar:/usr/share/java/antlr4/antlr4-runtime.jar":.:" ; java Main $*
