PROJ=editor
all:
	javac `find $(PROJ) pt -name "*.java"`
	jar -cfm $(PROJ)-`date "+%Y%m%d%H%M%S"`.jar MANIFEST.MF `find $(PROJ) pt -name "*.java"` README Makefile MANIFEST.MF applet.html
	jar -cf pt.jar `find pt -name "*.class"`
	jar -cfm $(PROJ).jar MANIFEST.MF pt.jar `find $(PROJ) -name "*.class"`
run:
	java -jar $(PROJ).jar
swing:
	java -Dui=swing -jar $(PROJ).jar
clean:
	rm -f `find $(PROJ) pt -name "*.class"`
