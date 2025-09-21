/*
 * When we take the lexeme and bundle it together with that other data, the
 * result is a token. At the point that we recognize a lexeme, we also remember
 * which kind of lexeme it represents.
 * 
 */

class Token {
  final TokenType type;
  final String lexeme;

  /*
   * There are lexemes for literal values—numbers and strings and the like. Since
   * the scanner has to walk each character in the literal to correctly identify
   * it, it can also convert that textual representation of a value to the living
   * runtime object that will be used by the interpreter later.
   */
  final Object literal;

  final int line;

  Token(TokenType tokenType, String lexeme, Object literal, int line) {
    this.type = tokenType;
    this.lexeme = lexeme;
    this.literal = literal;
    this.line = line;
  }

  public String toString() {
    return type + " " + lexeme + " " + literal;
  }
}