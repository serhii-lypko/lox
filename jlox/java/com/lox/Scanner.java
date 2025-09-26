package com.lox;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Scanner {
  private final String source;
  private final List<Token> tokens = new ArrayList<>();

  public Scanner(String source) {
    this.source = source;
  }

  public List<Token> scanTokens() {
    //

    return Collections.emptyList();
  }
}