// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaModelEntry extends PsiElement {

  @Nullable
  PrismaBlockAttribute getBlockAttribute();

  @NotNull
  List<PrismaInlineAttribute> getInlineAttributeList();

  @Nullable
  PrismaType getType();

}
