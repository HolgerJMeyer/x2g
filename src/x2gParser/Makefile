# JAVA
SHELL = /bin/bash
JAVAC = javac
JFLAGS = -g -cp $(CLASSPATH) -d $(CLASSDIR) -Xlint:deprecation
CLASSDIR = x2g
CLASSPATH=".:antlr-4.7/antlr-4.7-complete.jar:antlr-4.7/antlr-runtime-4.7.jar:$(CLASSDIR):"
# ANTLR4
#ANTLR = antlr4
ANTLR = java -jar ./antlr-4.7/antlr-4.7-complete.jar
#AFLAGS = -package $(TARGET)
ASRCS = $(wildcard *.g4)
# GRAFL
TARGET = x2g
SOURCES = $(MYSRCS) $(GENSRCS)
MYSRCS = $(TARGET)Main.java
GENSRCS = $(TARGET)ParserBaseListener.java $(TARGET)ParserListener.java $(ASRCS:.g4=.java)
GENCLASSES = $(GENSRCS:.java=.class)
MYCLASSES = $(MYSRCS:.java=.class)
CLASSES = $(GENCLASSES) $(MYCLASSES)
MANIFEST = Manifest.txt
TOKENS = $(TARGET)Parser.tokens $(TARGET)Lexer.tokens

all::	$(CLASSES)

$(TARGET)Parser.g4:	$(TARGET)Lexer.tokens

$(MYSRCS):	$(GENSRCS)

$(GENSRCS):	$(ASRCS)

$(TARGET)ParserBaseListener.class $(TARGET)ParserListener.class:	$(TARGET)Parser.java

run:
	export CLASSPATH=$(CLASSPATH) ; for g in testunit/*.$(TARGET) ; do java $(TARGET)Main <$$g ; done

grun:
	export CLASSPATH=$(CLASSPATH) ; for g in testunit/*.$(TARGET) ; do java org.antlr.v4.gui.TestRig $(TARGET) $(TARGET) -token -tree -gui $$g ; done

clean:
	-rm -rf $(GENSRCS) $(TOKENS)

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
