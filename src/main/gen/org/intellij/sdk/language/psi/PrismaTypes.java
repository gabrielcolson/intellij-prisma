// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface PrismaTypes {

  IElementType CONFIG_BLOCK = new PrismaElementType("CONFIG_BLOCK");
  IElementType CONFIG_ENTRY = new PrismaElementType("CONFIG_ENTRY");
  IElementType CONFIG_KEYWORD = new PrismaElementType("CONFIG_KEYWORD");
  IElementType MODEL_BLOCK = new PrismaElementType("MODEL_BLOCK");
  IElementType MODEL_ENTRY = new PrismaElementType("MODEL_ENTRY");

  IElementType BLOCK_CLOSE = new PrismaTokenType("BLOCK_CLOSE");
  IElementType BLOCK_OPEN = new PrismaTokenType("BLOCK_OPEN");
  IElementType COMMENT = new PrismaTokenType("COMMENT");
  IElementType CRLF = new PrismaTokenType("CRLF");
  IElementType DATASOURCE_KEYWORD = new PrismaTokenType("DATASOURCE_KEYWORD");
  IElementType GENERATOR_KEYWORD = new PrismaTokenType("GENERATOR_KEYWORD");
  IElementType IDENTIFIER = new PrismaTokenType("IDENTIFIER");
  IElementType MODEL_KEYWORD = new PrismaTokenType("MODEL_KEYWORD");
  IElementType SEPARATOR = new PrismaTokenType("SEPARATOR");
  IElementType STRING_LITERAL = new PrismaTokenType("STRING_LITERAL");
  IElementType WHITE_SPACE = new PrismaTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CONFIG_BLOCK) {
        return new PrismaConfigBlockImpl(node);
      }
      else if (type == CONFIG_ENTRY) {
        return new PrismaConfigEntryImpl(node);
      }
      else if (type == CONFIG_KEYWORD) {
        return new PrismaConfigKeywordImpl(node);
      }
      else if (type == MODEL_BLOCK) {
        return new PrismaModelBlockImpl(node);
      }
      else if (type == MODEL_ENTRY) {
        return new PrismaModelEntryImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
