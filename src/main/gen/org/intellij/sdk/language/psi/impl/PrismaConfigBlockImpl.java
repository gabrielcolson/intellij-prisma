// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.PrismaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class PrismaConfigBlockImpl extends ASTWrapperPsiElement implements PrismaConfigBlock {

  public PrismaConfigBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitConfigBlock(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PrismaConfigEntry> getConfigEntryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaConfigEntry.class);
  }

  @Override
  @NotNull
  public PrismaConfigKeyword getConfigKeyword() {
    return findNotNullChildByClass(PrismaConfigKeyword.class);
  }

}
