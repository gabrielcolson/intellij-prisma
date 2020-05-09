package org.intellij.sdk.language;

import com.intellij.lang.annotation.*;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.*;
import org.intellij.sdk.language.psi.PrismaVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class PrismaAnnotator implements Annotator {
    public static final TextAttributesKey MODEL_DEFINITION =
            createTextAttributesKey("PRISMA_MODEL_DEFINITION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey TYPE_NAME =
            createTextAttributesKey("PRISMA_TYPE_NAME", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey FUNCTION_NAME =
            createTextAttributesKey("PRISMA_FUNCTION_NAME", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
    public static final TextAttributesKey PARAMETER_NAME =
            createTextAttributesKey("PRISMA_PARAMETER_NAME", DefaultLanguageHighlighterColors.PARAMETER);

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        element.accept(new PrismaVisitor() {
            @Override
            public void visitModelDefinition(@NotNull PrismaModelDefinition modelDefinition) {
                applyTextAttributes(element, MODEL_DEFINITION);
            }

            @Override
            public void visitTypeName(@NotNull PrismaTypeName typeName) {
                applyTextAttributes(element, TYPE_NAME);
            }

            @Override
            public void visitFunctionName(@NotNull PrismaFunctionName functionName) {
                applyTextAttributes(element, FUNCTION_NAME);
            }

            @Override
            public void visitParameterName(@NotNull PrismaParameterName parameterName) {
                applyTextAttributes(element, PARAMETER_NAME);
            }

            private void applyTextAttributes(@Nullable PsiElement element, @NotNull TextAttributesKey attributes) {
                if (element == null) return;
                Annotation annotation = holder.createInfoAnnotation(element, null);
                annotation.setTextAttributes(attributes);
            }
        });
    }
}
