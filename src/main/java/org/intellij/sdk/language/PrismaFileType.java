package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PrismaFileType extends LanguageFileType {
    public static final PrismaFileType INSTANCE = new PrismaFileType();

    private PrismaFileType() {
        super(PrismaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Prisma";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Prisma schema language (PSL)";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "prisma";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PrismaIcons.FILE;
    }
}
