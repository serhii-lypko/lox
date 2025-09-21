JAVA_FILES = Lox.java
CLASS_FILES = $(JAVA_FILES:.java=.class)
MAIN_CLASS = Lox

# Default target
all: $(CLASS_FILES)

# Compile Java files
%.class: %.java
	@javac $<

# Run the program
run: $(CLASS_FILES)
	@java $(MAIN_CLASS)

# Run with arguments - pass ARGS variable
run-args: $(CLASS_FILES)
	@java $(MAIN_CLASS) $(ARGS)

# Clean compiled files
clean:
	@rm -f *.class

.PHONY: all run run-args clean