package tk.skuro.idea.orgmode.highlight;

import tk.skuro.idea.orgmode.parser.OrgLexer;
import tk.skuro.idea.orgmode.parser.OrgTokenTypes;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;

/**
 * @author Carlo Sciolla
 */
public class OrgSyntaxHighlighter extends SyntaxHighlighterBase {

    /**
     * The map of text attribute keys for each token type.
     */
    protected static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

    static {
        fillMap(ATTRIBUTES, OrgTokenTypes.COMMENTS, OrgHighlighterColors.COMMENTS_ATTR_KEY);
        fillMap(ATTRIBUTES, OrgTokenTypes.OUTLINES, OrgHighlighterColors.OUTLINE_ATTR_KEY);
        fillMap(ATTRIBUTES, OrgTokenTypes.UNDERLINES, OrgHighlighterColors.UNDERLINE_ATTR_KEY);
        fillMap(ATTRIBUTES, OrgTokenTypes.KEYWORDS, OrgHighlighterColors.KEYWORD_ATTR_KEY);
        fillMap(ATTRIBUTES, OrgTokenTypes.CODES, OrgHighlighterColors.CODE_ATTR_KEY);
        fillMap(ATTRIBUTES, OrgTokenTypes.BLOCK_CONTENTS, OrgHighlighterColors.BLOCK_CONTENT_ATTR_KEY);
        fillMap(ATTRIBUTES, OrgTokenTypes.BLOCK_DELIMITERS, OrgHighlighterColors.BLOCK_DELIM_ATTR_KEY);
        // maybe refactor with static import
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new OrgLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }
}
