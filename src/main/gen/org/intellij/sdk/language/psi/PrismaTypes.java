// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface PrismaTypes {

  IElementType ARRAY_VALUE = new PrismaElementType("ARRAY_VALUE");
  IElementType BLOCK = new PrismaElementType("BLOCK");
  IElementType BLOCK_ATTRIBUTE = new PrismaElementType("BLOCK_ATTRIBUTE");
  IElementType CONFIG_BLOCK = new PrismaElementType("CONFIG_BLOCK");
  IElementType CONFIG_ENTRY = new PrismaElementType("CONFIG_ENTRY");
  IElementType CONFIG_KEYWORD = new PrismaElementType("CONFIG_KEYWORD");
  IElementType ENUM_BLOCK = new PrismaElementType("ENUM_BLOCK");
  IElementType FUNCTION_CALL = new PrismaElementType("FUNCTION_CALL");
  IElementType FUNCTION_NAME = new PrismaElementType("FUNCTION_NAME");
  IElementType INLINE_ATTRIBUTE = new PrismaElementType("INLINE_ATTRIBUTE");
  IElementType LIST_TYPE = new PrismaElementType("LIST_TYPE");
  IElementType MODEL_BLOCK = new PrismaElementType("MODEL_BLOCK");
  IElementType MODEL_DEFINITION = new PrismaElementType("MODEL_DEFINITION");
  IElementType MODEL_ENTRY = new PrismaElementType("MODEL_ENTRY");
  IElementType NAMED_PARAMETER = new PrismaElementType("NAMED_PARAMETER");
  IElementType NULLABLE_TYPE = new PrismaElementType("NULLABLE_TYPE");
  IElementType PARAMETER = new PrismaElementType("PARAMETER");
  IElementType PARAMETER_LIST = new PrismaElementType("PARAMETER_LIST");
  IElementType PARAMETER_NAME = new PrismaElementType("PARAMETER_NAME");
  IElementType TYPE = new PrismaElementType("TYPE");
  IElementType TYPE_ALIAS = new PrismaElementType("TYPE_ALIAS");
  IElementType TYPE_NAME = new PrismaElementType("TYPE_NAME");
  IElementType VALUE = new PrismaElementType("VALUE");

  IElementType BLOCK_ATTRIBUTE_NAME = new PrismaTokenType("BLOCK_ATTRIBUTE_NAME");
  IElementType BOOLEAN = new PrismaTokenType("BOOLEAN");
  IElementType BRACE_L = new PrismaTokenType("BRACE_L");
  IElementType BRACE_R = new PrismaTokenType("BRACE_R");
  IElementType BRACKET_L = new PrismaTokenType("BRACKET_L");
  IElementType BRACKET_R = new PrismaTokenType("BRACKET_R");
  IElementType COLON = new PrismaTokenType("COLON");
  IElementType COMA = new PrismaTokenType("COMA");
  IElementType COMMENT = new PrismaTokenType("COMMENT");
  IElementType CRLF = new PrismaTokenType("CRLF");
  IElementType DATASOURCE_KEYWORD = new PrismaTokenType("DATASOURCE_KEYWORD");
  IElementType ENUM_KEYWORD = new PrismaTokenType("ENUM_KEYWORD");
  IElementType EQUAL = new PrismaTokenType("EQUAL");
  IElementType GENERATOR_KEYWORD = new PrismaTokenType("GENERATOR_KEYWORD");
  IElementType IDENTIFIER = new PrismaTokenType("IDENTIFIER");
  IElementType INLINE_ATTRIBUTE_NAME = new PrismaTokenType("INLINE_ATTRIBUTE_NAME");
  IElementType MODEL_KEYWORD = new PrismaTokenType("MODEL_KEYWORD");
  IElementType NUMBER = new PrismaTokenType("NUMBER");
  IElementType PAREN_L = new PrismaTokenType("PAREN_L");
  IElementType PAREN_R = new PrismaTokenType("PAREN_R");
  IElementType PERIOD = new PrismaTokenType("PERIOD");
  IElementType QUESTION_MARK = new PrismaTokenType("QUESTION_MARK");
  IElementType STRING_LITERAL = new PrismaTokenType("STRING_LITERAL");
  IElementType TYPE_KEYWORD = new PrismaTokenType("TYPE_KEYWORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_VALUE) {
        return new PrismaArrayValueImpl(node);
      }
      else if (type == BLOCK) {
        return new PrismaBlockImpl(node);
      }
      else if (type == BLOCK_ATTRIBUTE) {
        return new PrismaBlockAttributeImpl(node);
      }
      else if (type == CONFIG_BLOCK) {
        return new PrismaConfigBlockImpl(node);
      }
      else if (type == CONFIG_ENTRY) {
        return new PrismaConfigEntryImpl(node);
      }
      else if (type == CONFIG_KEYWORD) {
        return new PrismaConfigKeywordImpl(node);
      }
      else if (type == ENUM_BLOCK) {
        return new PrismaEnumBlockImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new PrismaFunctionCallImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new PrismaFunctionNameImpl(node);
      }
      else if (type == INLINE_ATTRIBUTE) {
        return new PrismaInlineAttributeImpl(node);
      }
      else if (type == LIST_TYPE) {
        return new PrismaListTypeImpl(node);
      }
      else if (type == MODEL_BLOCK) {
        return new PrismaModelBlockImpl(node);
      }
      else if (type == MODEL_DEFINITION) {
        return new PrismaModelDefinitionImpl(node);
      }
      else if (type == MODEL_ENTRY) {
        return new PrismaModelEntryImpl(node);
      }
      else if (type == NAMED_PARAMETER) {
        return new PrismaNamedParameterImpl(node);
      }
      else if (type == NULLABLE_TYPE) {
        return new PrismaNullableTypeImpl(node);
      }
      else if (type == PARAMETER) {
        return new PrismaParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new PrismaParameterListImpl(node);
      }
      else if (type == PARAMETER_NAME) {
        return new PrismaParameterNameImpl(node);
      }
      else if (type == TYPE) {
        return new PrismaTypeImpl(node);
      }
      else if (type == TYPE_ALIAS) {
        return new PrismaTypeAliasImpl(node);
      }
      else if (type == TYPE_NAME) {
        return new PrismaTypeNameImpl(node);
      }
      else if (type == VALUE) {
        return new PrismaValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
