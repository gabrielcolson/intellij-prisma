package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.PrismaLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PrismaElementType extends IElementType {
    public PrismaElementType( @NotNull @NonNls String debugName) {
        super(debugName, PrismaLanguage.INSTANCE);
    }
}