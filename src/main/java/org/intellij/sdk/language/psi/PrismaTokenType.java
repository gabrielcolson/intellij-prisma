package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.PrismaLanguage;
import org.jetbrains.annotations.*;

public class PrismaTokenType extends IElementType {
    public PrismaTokenType(@NotNull @NonNls String debugName) {
        super(debugName, PrismaLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "PrismaTokenType." + super.toString();
    }
}