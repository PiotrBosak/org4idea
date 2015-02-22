package tk.skuro.idea.orgmode.parser;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * Org Tokens for lexing
 *
 * @author Carlo Sciolla
 * @since 0.1
 */
public interface OrgTokenTypes {
    // TODO: package rego
    // maybe make a single declaration

    public final static IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
    public final static IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;
    public final static IElementType KEYWORD = new OrgElementType("ORG_KEYWORD");
    public final static IElementType COMMENT = new OrgElementType("ORG_COMMENT");
    public final static IElementType OUTLINE = new OrgElementType("ORG_OUTLINE");
    public final static IElementType BLOCK_DELIMITER = new OrgElementType("ORG_BLOCK_DELIMITEr");
    public final static IElementType BLOCK_CONTENT = new OrgElementType("ORG_BLOCK_CONTENT");
    public final static IElementType TEXT = new OrgElementType("ORG_TEXT");
    public final static IElementType BOLD = new OrgElementType("ORG_BOLD");
    public final static IElementType CODE = new OrgElementType("ORG_CODE");
    public final static IElementType ITALIC = new OrgElementType("ORG_ITALIC");
    public final static IElementType UNDERLINE = new OrgElementType("ORG_UNDERLINE");

    // see: tokenset from element
    public final static TokenSet WHITESPACES = TokenSet.create(WHITE_SPACE);
    public final static TokenSet COMMENTS = TokenSet.create(COMMENT);
    public final static TokenSet OUTLINES = TokenSet.create(OUTLINE);
    public final static TokenSet KEYWORDS = TokenSet.create(KEYWORD);
    public final static TokenSet UNDERLINES = TokenSet.create(UNDERLINE);
    public final static TokenSet CODES = TokenSet.create(CODE);
    public final static TokenSet BLOCK_DELIMITERS = TokenSet.create(BLOCK_DELIMITER);
    public final static TokenSet BLOCK_CONTENTS = TokenSet.create(BLOCK_CONTENT);
}
