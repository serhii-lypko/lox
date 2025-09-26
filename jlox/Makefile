# Java source directory
SRC_DIR = java
# Package path
PACKAGE_PATH = com/lox
# Main class with package
MAIN_CLASS = com.lox.Lox

# Java source files (relative to SRC_DIR)
JAVA_FILES = $(SRC_DIR)/$(PACKAGE_PATH)/Lox.java $(SRC_DIR)/$(PACKAGE_PATH)/Scanner.java $(SRC_DIR)/$(PACKAGE_PATH)/Token.java $(SRC_DIR)/$(PACKAGE_PATH)/TokenType.java
# Class files will be generated in the same structure
CLASS_FILES = $(JAVA_FILES:.java=.class)

# Default target
all: $(CLASS_FILES)

# Compile all Java files at once (more efficient for packages)
compile:
	@echo "Compiling Java files..."
	@cd $(SRC_DIR) && javac $(PACKAGE_PATH)/*.java

# Alternative: compile individual files
%.class: %.java
	@echo "Compiling $<..."
	@cd $(SRC_DIR) && javac $(subst $(SRC_DIR)/,,$<)

# Run the program
run: compile
	@echo "Running $(MAIN_CLASS)..."
	@cd $(SRC_DIR) && java $(MAIN_CLASS)

# Run with arguments - pass ARGS variable
run-args: compile
	@echo "Running $(MAIN_CLASS) with arguments: $(ARGS)"
	@cd $(SRC_DIR) && java $(MAIN_CLASS) $(ARGS)

# Clean compiled files
clean:
	@echo "Cleaning class files..."
	@find $(SRC_DIR) -name "*.class" -delete

.PHONY: all compile run run-args clean