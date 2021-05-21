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

public class PrismaTypeImpl extends ASTWrapperPsiElement implements PrismaType {

  public PrismaTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismaListType getListType() {
    return findChildByClass(PrismaListType.class);
  }

  @Override
  @Nullable
  public PrismaNullableType getNullableType() {
    return findChildByClass(PrismaNullableType.class);
  }

  @Override
  @Nullable
  public PrismaTypeName getTypeName() {
    return findChildByClass(PrismaTypeName.class);
  }

}
