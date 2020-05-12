package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.PrismaNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class PrismaNamedElementImpl extends ASTWrapperPsiElement implements PrismaNamedElement {
    public PrismaNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
