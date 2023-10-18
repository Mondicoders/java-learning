JC = javac
JPARAMS = -d target

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JPARAMS) $*.java

CLASSES = *.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

run:
	cd target && java $(ARGS)
