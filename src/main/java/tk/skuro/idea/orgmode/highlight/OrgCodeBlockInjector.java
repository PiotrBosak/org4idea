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
                if (text.startsWith("#+BEGIN_SRC")) {
                    String language = extractLanguage(text);
                    System.out.println(language);
                    if (!language.isEmpty()) {

                        Language injectedLanguage = null;
                        for (Language languageL : Language.getRegisteredLanguages()) {
                            if (languageL.getDisplayName().toLowerCase().contains(language.toLowerCase()))
                                injectedLanguage = languageL;
                        }
//                        Language.findLanguageByID(language.toUpperCase());
                        if (injectedLanguage != null) {
                            // Inject the language into the block between #+BEGIN_SRC and #+END_SRC

                            int startOffset = text.indexOf("#+BEGIN_SRC") + "#+BEGIN_SRC".length() + language.length();
                            startOffset = text.indexOf("\n", startOffset) + 1; // Move to the next line
                            System.out.println("YY");
                            while (startOffset < text.length() && Character.isWhitespace(text.charAt(startOffset))) {
                                startOffset++;
                            }


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
            System.out.println("Error, " + ignored.getMessage());

        }
    }

    private String extractLanguage(String text) {
        var beginOfLang = text.substring(12);
        System.out.println("QQQ");
        System.out.println(beginOfLang);
        if (beginOfLang.startsWith("scala")) {
            return "scala";
        }
        if (beginOfLang.startsWith("java")) {
            return "java";
        }

        if (beginOfLang.startsWith("json")) {
            return "json";
        }

        if (beginOfLang.startsWith("cassandraql")) {
            return "cassandra";
        }
        if (beginOfLang.startsWith("cql")) {
            return "cassandra";
        }
        if (beginOfLang.startsWith("cassandra")) {
            return "cassandra";
        }
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
