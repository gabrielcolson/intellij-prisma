package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.PrismaTypes;
import com.intellij.psi.TokenType;

%%

%class PrismaLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF            = \r|\n|\r\n
whiteSpace     = [\ \n\t\f]
INPUT_CHARACTER = [^\r\n]
COMMENT         = "//" {INPUT_CHARACTER}* {CRLF}?
identifierCharacter     = [a-zA-Z_0-9]

separator = "="
spacedSeparator = {whiteSpace}*{separator}{whiteSpace}*

%%
<YYINITIAL> {
    // Comments
    {COMMENT}                  { yybegin(YYINITIAL); return PrismaTypes.COMMENT; }

    // Keywords
    "datasource" { yybegin(YYINITIAL); return PrismaTypes.DATASOURCE_KEYWORD; }
    "generator" { yybegin(YYINITIAL); return PrismaTypes.GENERATOR_KEYWORD; }
    "model" { yybegin(YYINITIAL); return PrismaTypes.MODEL_KEYWORD; }

    // Primitives
    "\""{INPUT_CHARACTER}*"\""  { yybegin(YYINITIAL); return PrismaTypes.STRING_LITERAL; }
    //{identifierCharacter}+("[]"|"?")  { yybegin(YYINITIAL); return PrismaTypes.TYPE; }
    {identifierCharacter}+              { yybegin(YYINITIAL); return PrismaTypes.IDENTIFIER; }

    // Signs
    {spacedSeparator} { yybegin(YYINITIAL); return PrismaTypes.SEPARATOR; }
    "{" { yybegin(YYINITIAL); return PrismaTypes.BLOCK_OPEN; }
    "}"  { yybegin(YYINITIAL); return PrismaTypes.BLOCK_CLOSE; }

    // Spaces
    {CRLF} { yybegin(YYINITIAL); return PrismaTypes.CRLF; }
    {whiteSpace}              { yybegin(YYINITIAL); return PrismaTypes.WHITE_SPACE; }
}

[^]                                                         { return TokenType.BAD_CHARACTER; }