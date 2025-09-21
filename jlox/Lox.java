import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;

/*
 * TODOs
 * 
 * -- Error handling abstraction --
 * Some kind of of ErrorReporter interface
 * that gets passed to the scaner and parser and which will decide how
 * exactly render/stdout/etc errors.
 * 
*/

// Lox is a scripting language, which means it executes directly from source. 

public class Lox {
  static boolean hadError = false;

  public static void main(String[] args) throws IOException {
    // System.out.println(java.util.Arrays.toString(args));

    if (args.length > 1) {
      //
    } else if (args.length == 1) {
      runFile(args[0]);
    } else {
      runPrompt();
    }
  }

  private static void runFile(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    run(new String(bytes, Charset.defaultCharset()));

    if (hadError)
      System.exit(65);
  }

  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader bufReader = new BufferedReader(input);

    while (true) {
      System.out.println("> ");
      String line = bufReader.readLine();

      if (line == null)
        break;
      run(line);
      hadError = false;
    }
  }

  private static void run(String source) throws IOException {
    Scanner scanner = new Scanner(source);
    List<Token> tokens = scanner.scanTokens();

    for (Token token : tokens) {
      //
    }
  }

  /// It's good engineering practice to separate the code that generates
  /// the errors from the code that reports them.
  static void error(int line, String message) {
    reportErr(line, "", message);
  }

  private static void reportErr(int line, String where, String message) {
    System.err.println("[line " + line + "] Error" + where + ": " + message);
    hadError = true;
  }
}
