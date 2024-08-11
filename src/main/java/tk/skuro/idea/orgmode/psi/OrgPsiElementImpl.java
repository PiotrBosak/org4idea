package tk.skuro.idea.orgmode.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.ElementManipulators;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

/**
 * An element in the AST of the parsed org-mode file
 *
 * @author Carlo Sciolla
 * @since 0.1
 */
public class OrgPsiElementImpl extends ASTWrapperPsiElement implements PsiLanguageInjectionHost {
    public OrgPsiElementImpl(@org.jetbrains.annotations.NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public boolean isValidHost() {
        return true;
    }

    @Override
    public PsiLanguageInjectionHost updateText(@NotNull String text) {
        return ElementManipulators.handleContentChange(this, text);
    }

    @Override
    public @NotNull LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
        return new OrgLiteralTextEscaper(this);
    }
    private static class OrgLiteralTextEscaper extends LiteralTextEscaper<OrgPsiElementImpl> {

        public OrgLiteralTextEscaper(OrgPsiElementImpl host) {
            super(host);
        }

        @Override
        public boolean isOneLine() {
            return false; // This is typically false unless you're sure your injected text is single-line
        }

        @Override
        public boolean decode(@NotNull TextRange textRange, @NotNull StringBuilder outChars) {
            String text = myHost.getText().substring(textRange.getStartOffset() , textRange.getEndOffset());
            outChars.append(text);
            return true; // Return true if decoding is successful
        }

        @NotNull
        @Override
        public TextRange getRelevantTextRange() {
            return TextRange.from(0, myHost.getTextLength()); // The range that is relevant for injection
        }

        @Override
        public int getOffsetInHost(int offsetInDecoded, @NotNull TextRange rangeInsideHost) {
            int offset = offsetInDecoded + rangeInsideHost.getStartOffset();
            if (offset < 0 || offset > rangeInsideHost.getEndOffset()) {
                return -1; // Return -1 if the offset is out of bounds
            }
            return offset;
        }
    }
}
