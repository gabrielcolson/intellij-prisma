package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.PrismaTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class PrismaSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("PRISMA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};

    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("PRISMA_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("PRISMA_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};

    public static final TextAttributesKey STRING_LITERAL =
            createTextAttributesKey("PRISMA_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    private static final TextAttributesKey[] STRING_LITERAL_KEYS = new TextAttributesKey[]{STRING_LITERAL};

    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("PRISMA_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};

    public static final TextAttributesKey BRACKET =
            createTextAttributesKey("PRISMA_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKET};

    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("PRISMA_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new PrismaLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(PrismaTypes.STRING_LITERAL)) {
            return STRING_LITERAL_KEYS;
        } else if (PrismaSyntaxHighlighter.isKeyword(tokenType)) {
            return KEYWORD_KEYS;
        } else if (PrismaSyntaxHighlighter.isBracket(tokenType)) {
            return BRACKET_KEYS;
        } else if (tokenType.equals(PrismaTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(PrismaTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(PrismaTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

    static private boolean isKeyword(IElementType tokenType) {
        return tokenType.equals(PrismaTypes.DATASOURCE_KEYWORD)
                || tokenType.equals(PrismaTypes.GENERATOR_KEYWORD)
                || tokenType.equals(PrismaTypes.MODEL_KEYWORD);
    }

    static private boolean isBracket(IElementType tokenType) {
        return tokenType.equals(PrismaTypes.BLOCK_OPEN)
                || tokenType.equals(PrismaTypes.BLOCK_CLOSE);
    }
}