# version 2.1
ARGS="Banco de Programação com Objectos"
PROJ=bank
FILES= README Makefile MANIFEST.MF applet.html data.txt save.bin
I=-DImport=data.txt # run without importing: make I=
S=-DSave=save.bin
all:
	javac `find $(PROJ) pt -name "*.java"`
	jar -cfm $(PROJ)-`date "+%Y%m%d%H%M%S"`.jar MANIFEST.MF `find $(PROJ) pt -name "*.java"` $(FILES)
	jar -cf pt.jar `find pt -name "*.class"`
	jar -cfm $(PROJ).jar MANIFEST.MF pt.jar `find $(PROJ) -name "*.class"`
run:
	java $(I) -jar $(PROJ).jar $(ARGS)
load:
	java $(S) -jar $(PROJ).jar
swing:
	java $(I) -Dui=swing -jar $(PROJ).jar $(ARGS)
clean:
	rm -f `find $(PROJ) pt -name "*.class"`
