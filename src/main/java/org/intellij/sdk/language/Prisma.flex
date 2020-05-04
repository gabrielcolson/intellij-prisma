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
WhiteSpace     = " " | \t
INPUT_CHARACTER = [^\r\n]
COMMENT         = "//" {INPUT_CHARACTER}* {CRLF}?
Name = [_a-zA-Z][a-zA-Z_0-9]*

%%
<YYINITIAL> {
    // Ignored
    {COMMENT}                   { return PrismaTypes.COMMENT; }
    {CRLF}+                     { return TokenType.WHITE_SPACE; }
    {WhiteSpace}+               { return TokenType.WHITE_SPACE; }

    // Ponctuators
    "="                         { return PrismaTypes.EQUAL; }
    "?"                         { return PrismaTypes.QUESTION_MARK; }
    ","                         { return PrismaTypes.COMA; }
    ":"                         { return PrismaTypes.COLON; }
    "{"                         { return PrismaTypes.BRACE_L; }
    "}"                         { return PrismaTypes.BRACE_R; }
    "["                         { return PrismaTypes.BRACKET_L; }
    "]"                         { return PrismaTypes.BRACKET_R; }
    "("                         { return PrismaTypes.PAREN_L; }
    ")"                         { return PrismaTypes.PAREN_R; }

    // Keywords
    "datasource"                { return PrismaTypes.DATASOURCE_KEYWORD; }
    "generator"                 { return PrismaTypes.GENERATOR_KEYWORD; }
    "model"                     { return PrismaTypes.MODEL_KEYWORD; }
    "enum"                      { return PrismaTypes.ENUM_KEYWORD; }

    // Literals
    "\""{INPUT_CHARACTER}*"\""  { return PrismaTypes.STRING_LITERAL; }
    -?[0-9]+|([0-9]*\.[0-9]+) 	{ return PrismaTypes.NUMBER; }
    "true" | "false"            { return PrismaTypes.BOOLEAN; }

    // Identifier
    {Name}                      { return PrismaTypes.IDENTIFIER; }
    "@@"{Name}                  { return PrismaTypes.BLOCK_ATTRIBUTE_NAME; }
    "@"{Name}                   { return PrismaTypes.INLINE_ATTRIBUTE_NAME; }

    [^]                         { return TokenType.BAD_CHARACTER; }
}
