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
  // BRACKET_L ((value COMA)* value)? BRACKET_R
  public static boolean arrayValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayValue")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && arrayValue_1(b, l + 1);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, ARRAY_VALUE, r);
    return r;
  }

  // ((value COMA)* value)?
  private static boolean arrayValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayValue_1")) return false;
    arrayValue_1_0(b, l + 1);
    return true;
  }

  // (value COMA)* value
  private static boolean arrayValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arrayValue_1_0_0(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (value COMA)*
  private static boolean arrayValue_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayValue_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arrayValue_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayValue_1_0_0", c)) break;
    }
    return true;
  }

  // value COMA
  private static boolean arrayValue_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayValue_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    r = r && consumeToken(b, COMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT | CRLF | configBlock | modelBlock | enumBlock | typeAlias
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = configBlock(b, l + 1);
    if (!r) r = modelBlock(b, l + 1);
    if (!r) r = enumBlock(b, l + 1);
    if (!r) r = typeAlias(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BLOCK_ATTRIBUTE_NAME PAREN_L parameterList? PAREN_R
  public static boolean blockAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockAttribute")) return false;
    if (!nextTokenIs(b, BLOCK_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BLOCK_ATTRIBUTE_NAME, PAREN_L);
    r = r && blockAttribute_2(b, l + 1);
    r = r && consumeToken(b, PAREN_R);
    exit_section_(b, m, BLOCK_ATTRIBUTE, r);
    return r;
  }

  // parameterList?
  private static boolean blockAttribute_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockAttribute_2")) return false;
    parameterList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // configKeyword IDENTIFIER BRACE_L configEntry+ BRACE_R
  public static boolean configBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configBlock")) return false;
    if (!nextTokenIs(b, "<config block>", DATASOURCE_KEYWORD, GENERATOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BLOCK, "<config block>");
    r = configKeyword(b, l + 1);
    r = r && consumeTokens(b, 0, IDENTIFIER, BRACE_L);
    r = r && configBlock_3(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // configEntry+
  private static boolean configBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configBlock_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configEntry(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!configEntry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "configBlock_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUAL value
  public static boolean configEntry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configEntry")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUAL);
    r = r && value(b, l + 1);
    exit_section_(b, m, CONFIG_ENTRY, r);
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
  // ENUM_KEYWORD IDENTIFIER BRACE_L IDENTIFIER+ BRACE_R
  public static boolean enumBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBlock")) return false;
    if (!nextTokenIs(b, ENUM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENUM_KEYWORD, IDENTIFIER, BRACE_L);
    r = r && enumBlock_3(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, ENUM_BLOCK, r);
    return r;
  }

  // IDENTIFIER+
  private static boolean enumBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBlock_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, IDENTIFIER)) break;
      if (!empty_element_parsed_guard_(b, "enumBlock_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // functionName PAREN_L parameterList? PAREN_R
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionName(b, l + 1);
    r = r && consumeToken(b, PAREN_L);
    r = r && functionCall_2(b, l + 1);
    r = r && consumeToken(b, PAREN_R);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  // parameterList?
  private static boolean functionCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2")) return false;
    parameterList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean functionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // INLINE_ATTRIBUTE_NAME (PAREN_L parameterList? PAREN_R)?
  public static boolean inlineAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inlineAttribute")) return false;
    if (!nextTokenIs(b, INLINE_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INLINE_ATTRIBUTE_NAME);
    r = r && inlineAttribute_1(b, l + 1);
    exit_section_(b, m, INLINE_ATTRIBUTE, r);
    return r;
  }

  // (PAREN_L parameterList? PAREN_R)?
  private static boolean inlineAttribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inlineAttribute_1")) return false;
    inlineAttribute_1_0(b, l + 1);
    return true;
  }

  // PAREN_L parameterList? PAREN_R
  private static boolean inlineAttribute_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inlineAttribute_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_L);
    r = r && inlineAttribute_1_0_1(b, l + 1);
    r = r && consumeToken(b, PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameterList?
  private static boolean inlineAttribute_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inlineAttribute_1_0_1")) return false;
    parameterList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // typeName BRACKET_L BRACKET_R
  public static boolean listType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeName(b, l + 1);
    r = r && consumeTokens(b, 0, BRACKET_L, BRACKET_R);
    exit_section_(b, m, LIST_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // MODEL_KEYWORD modelDefinition BRACE_L modelEntry+ BRACE_R
  public static boolean modelBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelBlock")) return false;
    if (!nextTokenIs(b, MODEL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODEL_KEYWORD);
    r = r && modelDefinition(b, l + 1);
    r = r && consumeToken(b, BRACE_L);
    r = r && modelBlock_3(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, MODEL_BLOCK, r);
    return r;
  }

  // modelEntry+
  private static boolean modelBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelBlock_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modelEntry(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!modelEntry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modelBlock_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean modelDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODEL_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER type inlineAttribute*) | blockAttribute
  public static boolean modelEntry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry")) return false;
    if (!nextTokenIs(b, "<model entry>", BLOCK_ATTRIBUTE_NAME, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_ENTRY, "<model entry>");
    r = modelEntry_0(b, l + 1);
    if (!r) r = blockAttribute(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER type inlineAttribute*
  private static boolean modelEntry_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && type(b, l + 1);
    r = r && modelEntry_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inlineAttribute*
  private static boolean modelEntry_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelEntry_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inlineAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modelEntry_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // parameterName COLON value
  public static boolean namedParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedParameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterName(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && value(b, l + 1);
    exit_section_(b, m, NAMED_PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // typeName QUESTION_MARK
  public static boolean nullableType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullableType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeName(b, l + 1);
    r = r && consumeToken(b, QUESTION_MARK);
    exit_section_(b, m, NULLABLE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // namedParameter | value
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = namedParameter(b, l + 1);
    if (!r) r = value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (parameter COMA)* parameter
  public static boolean parameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
    r = parameterList_0(b, l + 1);
    r = r && parameter(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (parameter COMA)*
  private static boolean parameterList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameterList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameterList_0", c)) break;
    }
    return true;
  }

  // parameter COMA
  private static boolean parameterList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && consumeToken(b, COMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean parameterName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PARAMETER_NAME, r);
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

  /* ********************************************************** */
  // nullableType | listType | typeName
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nullableType(b, l + 1);
    if (!r) r = listType(b, l + 1);
    if (!r) r = typeName(b, l + 1);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE_KEYWORD typeName EQUAL type inlineAttribute*
  public static boolean typeAlias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlias")) return false;
    if (!nextTokenIs(b, TYPE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_KEYWORD);
    r = r && typeName(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && type(b, l + 1);
    r = r && typeAlias_4(b, l + 1);
    exit_section_(b, m, TYPE_ALIAS, r);
    return r;
  }

  // inlineAttribute*
  private static boolean typeAlias_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlias_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inlineAttribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeAlias_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean typeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL | NUMBER | BOOLEAN | functionCall | arrayValue | IDENTIFIER
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = arrayValue(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
