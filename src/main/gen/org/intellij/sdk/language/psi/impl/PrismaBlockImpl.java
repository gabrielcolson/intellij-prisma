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

public class PrismaBlockImpl extends ASTWrapperPsiElement implements PrismaBlock {

  public PrismaBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitBlock(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismaConfigBlock getConfigBlock() {
    return findChildByClass(PrismaConfigBlock.class);
  }

  @Override
  @Nullable
  public PrismaEnumBlock getEnumBlock() {
    return findChildByClass(PrismaEnumBlock.class);
  }

  @Override
  @Nullable
  public PrismaModelBlock getModelBlock() {
    return findChildByClass(PrismaModelBlock.class);
  }

}
