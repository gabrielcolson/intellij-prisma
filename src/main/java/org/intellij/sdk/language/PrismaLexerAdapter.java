package org.intellij.sdk.language;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class PrismaLexerAdapter extends FlexAdapter {
    public PrismaLexerAdapter() {
        super(new PrismaLexer((Reader) null));
    }
}