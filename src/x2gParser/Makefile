# JAVA
SHELL = /bin/bash
JAVAC = javac
JFLAGS = -g -cp $(CLASSPATH) -d $(CLASSDIR) -Xlint:deprecation
CLASSDIR = $(TARGET)
CLASSDIR = .
CLASSPATH=".:$(COMMONS):$(AJARS):$(CLASSDIR):"
# ANTLR4 expecting version 4.9.3
ANTLR = antlr4
#AFLAGS = -o $(TARGET) -package $(TARGET)
AFLAGS = -visitor -listener
ASRCS = $(wildcard *.g4)
LIBDIR = /usr/share/java/antlr4
COMMONS = /usr/share/java/apache-commons-cli.jar
AJARS = "$(LIBDIR)/antlr4.jar:$(LIBDIR)/antlr4-runtime.jar"
# X2G
TARGET = x2g
SOURCES = $(MYSRCS) $(GENSRCS)
MYSRCS = \
	$(TARGET)Main.java \
	$(TARGET)Evaluator.java \
	Scope.java \
	SymbolTable.java \
	Variable.java \
	VarType.java
LISTENER = $(TARGET)ParserBaseListener.java $(TARGET)ParserListener.java
VISITOR = $(TARGET)ParserBaseVisitor.java $(TARGET)ParserVisitor.java
GENSRCS = $(LISTENER) $(VISITOR) $(ASRCS:.g4=.java)
GENCLASSES = $(GENSRCS:.java=.class)
MYCLASSES = $(MYSRCS:.java=.class)
CLASSES = $(GENCLASSES) $(MYCLASSES) $(CLASSDIR)/*.class
MANIFEST = Manifest.txt
TOKENS = $(TARGET)Parser.tokens $(TARGET)Lexer.tokens

all::	$(CLASSES)

$(TARGET)Parser.g4:	$(TARGET)Lexer.g4

$(GENSRCS):	$(ASRCS)

$(MYSRCS):	$(GENSRCS)

$(CLASSES):	$(GENSRCS) $(MYSRCS)

run:
	export CLASSPATH=$(CLASSPATH) ; for g in testunit/*.$(TARGET) ; do java $(TARGET)Main -h <$$g ; done

grun:
	export CLASSPATH=$(CLASSPATH) ; for g in testunit/*.$(TARGET) ; do java org.antlr.v4.gui.TestRig $(TARGET) $(TARGET) -token -tree -gui $$g ; done

clean:
	-rm -rf $(GENSRCS) $(TOKENS) $(CLASSES)

.SUFFIXES:

.SUFFIXES:	.g4 .tokens .java .class .jar

.java.class:
	$(JAVAC) $(JFLAGS) $<

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
