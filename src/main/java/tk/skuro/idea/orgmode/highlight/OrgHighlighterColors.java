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
    // TODO: different style for outline levels
    public static final TextAttributesKey OUTLINE_ATTR_KEY = createTextAttributesKey("ORG.OUTLINE", KEYWORD);

    /**
     * Default style of comments
     */
    public static final TextAttributesKey COMMENTS_ATTR_KEY = createTextAttributesKey("ORG.COMMENT", LINE_COMMENT);

    /**
     * Default style of comment keyword {@code #+TITLE}
     */
    public static final TextAttributesKey KEYWORD_ATTR_KEY = createTextAttributesKey("ORG.KEYWORD", LINE_COMMENT);

    /**
     * Default style of block delimiter
     */
    public static final TextAttributesKey BLOCK_DELIM_ATTR_KEY = createTextAttributesKey("ORG.BLOCK_DELIMITER",
            KEYWORD_ATTR_KEY);

    /**
     * Default style of code
     */
    public static final TextAttributesKey CODE_ATTR_KEY = createTextAttributesKey("ORG.CODE", TEMPLATE_LANGUAGE_COLOR);

    /**
     * Default style of block content
     */
    public static final TextAttributesKey BLOCK_CONTENT_ATTR_KEY = createTextAttributesKey("ORG.BLOCK_CONTENT",
            CODE_ATTR_KEY);

    /**
     * Default style of Bold text
     */
    public static final TextAttributesKey BOLD_ATTR_KEY = createTextAttributesKey("ORG.BOLD", STRING);

    /**
     * Default style of verbatim text
     */
    public static final TextAttributesKey VERBATIM_ATTR_KEY = createTextAttributesKey("ORG.VERBATIM", STRING);

    /**
     * Default style of strokethrought text
     */
    public static final TextAttributesKey STRIKETHROUGH_ATTR_KEY = createTextAttributesKey("ORG.STRIKETHROUGH", STRING);
    /**
     * Default style of underline text
     */
    public static final TextAttributesKey UNDERLINE_ATTR_KEY = createTextAttributesKey("ORG.UNDERLINE", STRING);


}
