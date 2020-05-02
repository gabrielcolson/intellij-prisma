package org.intellij.sdk.language;

import com.intellij.lang.Language;

public class PrismaLanguage extends Language {
    public static final PrismaLanguage INSTANCE = new PrismaLanguage();

    private PrismaLanguage() {
        super("Prisma");
    }
}
