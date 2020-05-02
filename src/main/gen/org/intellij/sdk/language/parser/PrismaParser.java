// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.PrismaTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PrismaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return prismaFile(b, l + 1);
  }

  /* ********************************************************** */
  // COMMENT | CRLF | configBlock | modelBlock
  static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = configBlock(b, l + 1);
    if (!r) r = modelBlock(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // configKeyword WHITE_SPACE+ IDENTIFIER WHITE_SPACE+ BLOCK_OPEN CRLF* configEntry+ BLOCK_CLOSE
  public static boolean configBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configBlock")) return false;
    if (!nextTokenIs(b, "<config block>", DATASOURCE_KEYWORD, GENERATOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BLOCK, "<config block>");
    r = configKeyword(b, l + 1);
    r = r && configBlock_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && configBlock_3(b, l + 1);
    r = r && consumeToken(b, BLOCK_OPEN);
    r = r && configBlock_5(b, l + 1);
    r = r && configBlock_6(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE+
  private static boolean configBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "configBlock_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE+
  private static boolean configBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configBlock_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "configBlock_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // CRLF*
  private static boolean configBlock_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configBlock_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, CRLF)) break;
      if (!empty_element_parsed_guard_(b, "configBlock_5", c)) break;
    }
    return true;
  }

  // configEntry+
  private static boolean configBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configBlock_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configEntry(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!configEntry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "configBlock_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT | (WHITE_SPACE* IDENTIFIER SEPARATOR STRING_LITERAL (WHITE_SPACE|CRLF)*)
  public static boolean configEntry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configEntry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_ENTRY, "<config entry>");
    r = consumeToken(b, COMMENT);
    if (!r) r = configEntry_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE* IDENTIFIER SEPARATOR STRING_LITERAL (WHITE_SPACE|CRLF)*
  private static boolean configEntry_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configEntry_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configEntry_1_0(b, l + 1);
    r = r && consumeTokens(b, 0, IDENTIFIER, SEPARATOR, STRING_LITERAL);
    r = r && configEntry_1_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean configEntry_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configEntry_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "configEntry_1_0", c)) break;
    }
    return true;
  }

  // (WHITE_SPACE|CRLF)*
  private static boolean configEntry_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configEntry_1_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!configEntry_1_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "configEntry_1_4", c)) break;
    }
    return true;
  }

  // WHITE_SPACE|CRLF
  private static boolean configEntry_1_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configEntry_1_4_0")) return false;
    boolean r;
    r = consumeToken(b, WHITE_SPACE);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // DATASOURCE_KEYWORD|GENERATOR_KEYWORD
  public static boolean configKeyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configKeyword")) return false;
    if (!nextTokenIs(b, "<config keyword>", DATASOURCE_KEYWORD, GENERATOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_KEYWORD, "<config keyword>");
    r = consumeToken(b, DATASOURCE_KEYWORD);
    if (!r) r = consumeToken(b, GENERATOR_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MODEL_KEYWORD WHITE_SPACE+ IDENTIFIER WHITE_SPACE+ BLOCK_OPEN CRLF+ modelEntry+ BLOCK_CLOSE
  public static boolean modelBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelBlock")) return false;
    if (!nextTokenIs(b, MODEL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODEL_KEYWORD);
    r = r && modelBlock_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && modelBlock_3(b, l + 1);
    r = r && consumeToken(b, BLOCK_OPEN);
    r = r && modelBlock_5(b, l + 1);
    r = r && modelBlock_6(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, m, MODEL_BLOCK, r);
    return r;
  }

  // WHITE_SPACE+
  private static boolean modelBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "modelBlock_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE+
  private static boolean modelBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelBlock_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "modelBlock_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // CRLF+
  private static boolean modelBlock_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelBlock_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CRLF);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, CRLF)) break;
      if (!empty_element_parsed_guard_(b, "modelBlock_5", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // modelEntry+
  private static boolean modelBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelBlock_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modelEntry(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!modelEntry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modelBlock_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT | (WHITE_SPACE* IDENTIFIER (WHITE_SPACE|CRLF)*)
  public static boolean modelEntry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_ENTRY, "<model entry>");
    r = consumeToken(b, COMMENT);
    if (!r) r = modelEntry_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITE_SPACE* IDENTIFIER (WHITE_SPACE|CRLF)*
  private static boolean modelEntry_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modelEntry_1_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && modelEntry_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean modelEntry_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "modelEntry_1_0", c)) break;
    }
    return true;
  }

  // (WHITE_SPACE|CRLF)*
  private static boolean modelEntry_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modelEntry_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modelEntry_1_2", c)) break;
    }
    return true;
  }

  // WHITE_SPACE|CRLF
  private static boolean modelEntry_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry_1_2_0")) return false;
    boolean r;
    r = consumeToken(b, WHITE_SPACE);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // block*
  static boolean prismaFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prismaFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "prismaFile", c)) break;
    }
    return true;
  }

}
