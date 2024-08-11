package tk.skuro.idea.orgmode.highlight;

import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class OrgCodeBlockInjector implements MultiHostInjector {

    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement context) {
        try {
            if (context instanceof PsiLanguageInjectionHost host) {
                String text = host.getText();

                // Detect the beginning of a code block and extract the language
                for (Language language : Language.getRegisteredLanguages()) {
                }
                if (text.startsWith("#+BEGIN_SRC")) {
                    String language = extractLanguage(text);
                    if (!language.isEmpty()) {

                        Language injectedLanguage = null;
                        for (Language languageL : Language.getRegisteredLanguages()) {
                            if (languageL.getDisplayName().toLowerCase().contains(language.toLowerCase()))
                                injectedLanguage = languageL;
                        }
//                        Language.findLanguageByID(language.toUpperCase());
                        if (injectedLanguage != null) {
                            // Inject the language into the block between #+BEGIN_SRC and #+END_SRC

                            int startOffset = text.indexOf("#+BEGIN_SRC") + "#+BEGIN_SRC".length() + language.length() + 2;


                            int endOffset = text.indexOf("#+END_SRC");
                            if (endOffset > startOffset) {
                                registrar.startInjecting(injectedLanguage)
                                        .addPlace(null, null, host, TextRange.create(startOffset, endOffset))
                                        .doneInjecting();
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {

        }
    }

    private String extractLanguage(String text) {
        // A simple example to extract language: "#+BEGIN_SRC java" -> "java"
        var parts = text.split(" ");
        if (parts.length >= 2) {
            return text.split(" ")[1].trim();  // Adjust parsing logic as needed
        } else return "";
    }

    @Override
    public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return Collections.singletonList(PsiLanguageInjectionHost.class);
    }
}
