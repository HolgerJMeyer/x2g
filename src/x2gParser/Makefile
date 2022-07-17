# JAVA
SHELL = /bin/bash
JAVAC = javac
JFLAGS = -g -cp $(CLASSPATH) -d $(CLASSDIR) -Xlint:deprecation -Xlint:unchecked
CLASSDIR = $(TARGET)
CLASSDIR = .
CLASSPATH=".:$(COMMONS):$(JDOM):$(JAXEN):$(AJARS):$(CLASSDIR):"
# ANTLR4 expecting version 4.9.3
ANTLR = antlr4
#AFLAGS = -o $(TARGET) -package $(TARGET)
AFLAGS = -visitor -no-listener
ASRCS = $(wildcard *.g4)
LIBDIR = /usr/share/java/antlr4
COMMONS = /usr/share/java/apache-commons-cli.jar
#JDOM = /usr/share/java/jdom2/jdom2.jar
JDOM = ./jdom2/jdom-2.0.6.1.jar
JAXEN = ./jdom2/lib/jaxen-1.2.0.jar
AJARS = "$(LIBDIR)/antlr4.jar:$(LIBDIR)/antlr4-runtime.jar"
# X2G
TARGET = x2g
SOURCES = $(MYSRCS) $(GENSRCS)
GRAPHSRCS = \
	gElement.java \
	gEdge.java \
	gGraph.java \
	gNode.java \
	gProperties.java \
	gTest.java \
	csvExport.java 
XMLSRCS = \
	xTractor.java
MYSRCS = \
	Evaluator.java \
	Scope.java \
	SymbolTable.java \
	Variable.java \
	VarType.java \
	$(GRAPHSRCS) \
	$(XMLSRCS)
#LISTENER = x2gParserBaseListener.java x2gParserListener.java
VISITOR = x2gParserBaseVisitor.java x2gParserVisitor.java
GENSRCS = $(LISTENER) $(VISITOR) $(ASRCS:.g4=.java)
GENCLASSES = $(GENSRCS:.java=.class)
MYCLASSES = $(MYSRCS:.java=.class)
CLASSES = $(GENCLASSES) $(MYCLASSES)
MANIFEST = Manifest.txt
TOKENS = x2gParser.tokens x2gLexer.tokens

all::	Main.class

all::	$(CLASSES)

#$(CLASSES)::	$(SOURCES)

Main.class:	Main.java
Main.java:	$(SOURCES)

x2gParserListener.java:	x2gParser.java
x2gParserVisitor.java:	x2gParser.java
x2gParserBaseListener.java:	x2gParserListener.java
x2gParserBaseVisitor.java:	x2gParserVisitor.java
Evaluator.java:	x2gParserBaseVisitor.java
x2gParser.java:	x2gLexer.java

run:	runhelp runparse werewolf graphtest

runhelp:
	@export CLASSPATH=$(CLASSPATH) ; java Main -h

runparse:
	@export CLASSPATH=$(CLASSPATH) ; java Main -vp <testunit/simple-ruleset-with-errors.x2g
	@export CLASSPATH=$(CLASSPATH) ; java Main -vp <testunit/simple-ruleset.x2g

werewolf:
	export CLASSPATH=$(CLASSPATH) ; java Main -n -d isebel/werewolf <testunit/isebel-stories.x2g

werewolf1:
	export CLASSPATH=$(CLASSPATH) ; java Main -vn -d isebel/werewolf001 <testunit/isebel-stories.x2g

graphtest:
	@export CLASSPATH=$(CLASSPATH) ; for g in testunit/*.x2g ; do java -ea gTest <$$g ; done

xpathtest:
	@export CLASSPATH=$(CLASSPATH) ; java -ea xTractor testunit/catalog.xml "//cd"

cdcatalog:
	@export CLASSPATH=$(CLASSPATH) ; java Main -v testunit/catalog.xml <testunit/catalog.x2g

grun:
	@export CLASSPATH=$(CLASSPATH) ; for g in testunit/*.x2g ; do java org.antlr.v4.gui.TestRig x2g x2g -token -tree -gui <$$g ; done

clean:
	-rm -rf $(GENSRCS) $(TOKENS) $(CLASSES) *.class

.SUFFIXES:

.SUFFIXES:	.g4 .tokens .interp .java .class .jar

.java.class:
	$(JAVAC) $(JFLAGS) $<

.g4.interp:
	$(ANTLR) $(AFLAGS) $<

.g4.tokens:
	$(ANTLR) $(AFLAGS) $<

.g4.java:
	$(ANTLR) $(AFLAGS) $<

jar:    
	@echo "Manifest-Version: 1.0" > $(MANIFEST)
	@echo "Class-Path: ." >> $(MANIFEST)
	@echo "Main-Class: $(TARGET)" >> $(MANIFEST)
	@echo "" >> $(MANIFEST)
	jar -cmf $(MANIFEST) $(TARGET).jar $(CLASSES)

# vim: ts=3 sw=3 sts=3 noet
