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

public class PrismaModelBlockImpl extends ASTWrapperPsiElement implements PrismaModelBlock {

  public PrismaModelBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitModelBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PrismaModelDefinition getModelDefinition() {
    return findNotNullChildByClass(PrismaModelDefinition.class);
  }

  @Override
  @NotNull
  public List<PrismaModelEntry> getModelEntryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaModelEntry.class);
  }

}
