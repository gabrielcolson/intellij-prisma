package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.PrismaTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class PrismaSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("PRISMA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("PRISMA_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey INLINE_ATTRIBUTE =
            createTextAttributesKey("PRISMA_INLINE_ATTRIBUTE", DefaultLanguageHighlighterColors.STATIC_FIELD);
    public static final TextAttributesKey BLOCK_ATTRIBUTE =
            createTextAttributesKey("PRISMA_BLOCK_ATTRIBUTE", DefaultLanguageHighlighterColors.STATIC_METHOD);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("PRISMA_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey EQUAL =
            createTextAttributesKey("PRISMA_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BRACE =
            createTextAttributesKey("PRISMA_BRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKET =
            createTextAttributesKey("PRISMA_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("PRISMA_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("PRISMA_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BOOLEAN =
            createTextAttributesKey("PRISMA_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("PRISMA_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] INLINE_ATTRIBUTE_KEYS = new TextAttributesKey[]{INLINE_ATTRIBUTE};
    private static final TextAttributesKey[] BLOCK_ATTRIBUTE_KEYS = new TextAttributesKey[]{BLOCK_ATTRIBUTE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EQUAL_KEYS = new TextAttributesKey[]{EQUAL};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACE};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKET};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final Set<IElementType> KEYWORDS = new HashSet<>();
    static {
        KEYWORDS.add(PrismaTypes.DATASOURCE_KEYWORD);
        KEYWORDS.add(PrismaTypes.GENERATOR_KEYWORD);
        KEYWORDS.add(PrismaTypes.MODEL_KEYWORD);
        KEYWORDS.add(PrismaTypes.ENUM_KEYWORD);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new PrismaLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(PrismaTypes.BRACE_L) || tokenType.equals(PrismaTypes.BRACE_R)) {
            return BRACE_KEYS;
        } else if (tokenType.equals(PrismaTypes.BRACKET_L) || tokenType.equals(PrismaTypes.BRACKET_R)) {
            return BRACKET_KEYS;
        } else if (tokenType.equals(PrismaTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(PrismaTypes.INLINE_ATTRIBUTE_NAME)) {
            return INLINE_ATTRIBUTE_KEYS;
        } else if (tokenType.equals(PrismaTypes.BLOCK_ATTRIBUTE_NAME)) {
            return BLOCK_ATTRIBUTE_KEYS;
        } else if (tokenType.equals(PrismaTypes.EQUAL)) {
            return EQUAL_KEYS;
        } else if (tokenType.equals(PrismaTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(PrismaTypes.STRING_LITERAL)) {
            return STRING_KEYS;
        } else if (tokenType.equals(PrismaTypes.NUMBER)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(PrismaTypes.BOOLEAN)) {
            return BOOLEAN_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}