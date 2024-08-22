package tk.skuro.idea.orgmode.highlight;

import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 *
 * @author Carlo Sciolla
 * @since 0.1
 */
public interface OrgHighlighterColors {
    /**
     * Default style for outline
     */
    TextAttributesKey OUTLINE_ATTR_KEY1 = createTextAttributesKey("ORG.OUTLINE1", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY2 = createTextAttributesKey("ORG.OUTLINE2", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY3 = createTextAttributesKey("ORG.OUTLINE3", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY4 = createTextAttributesKey("ORG.OUTLINE4", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY5 = createTextAttributesKey("ORG.OUTLINE5", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY6 = createTextAttributesKey("ORG.OUTLINE6", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY7 = createTextAttributesKey("ORG.OUTLINE7", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY8 = createTextAttributesKey("ORG.OUTLINE8", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY9 = createTextAttributesKey("ORG.OUTLINE9", IDENTIFIER);
    TextAttributesKey OUTLINE_ATTR_KEY10 = createTextAttributesKey("ORG.OUTLINE10", IDENTIFIER);

    /**
     * Default style of comments
     */
    TextAttributesKey COMMENTS_ATTR_KEY = createTextAttributesKey("ORG.COMMENT", LINE_COMMENT);

    /**
     * Default style of comment keyword {@code #+TITLE}
     */
    TextAttributesKey KEYWORD_ATTR_KEY = createTextAttributesKey("ORG.KEYWORD", LINE_COMMENT);

    /**
     * Default style of block delimiter
     */
    TextAttributesKey BLOCK_DELIM_ATTR_KEY = createTextAttributesKey("ORG.BLOCK_DELIMITER", KEYWORD_ATTR_KEY);

    /**
     * Default style of code
     */
    TextAttributesKey CODE_ATTR_KEY = createTextAttributesKey("ORG.CODE", TEMPLATE_LANGUAGE_COLOR);

    /**
     * Default style of block content
     */
    TextAttributesKey BLOCK_CONTENT_ATTR_KEY = createTextAttributesKey("ORG.BLOCK_CONTENT", CODE_ATTR_KEY);

    /**
     * Default style of Bold text
     */
    TextAttributesKey BOLD_ATTR_KEY = createTextAttributesKey("ORG.BOLD", STRING);
    /**
     * Default style of underline text
     */
    TextAttributesKey UNDERLINE_ATTR_KEY = createTextAttributesKey("ORG.UNDERLINE", STRING);


}
