// This is a generated file. Not intended for manual editing.
package tk.skuro.idea.orgmode.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import tk.skuro.idea.orgmode.psi.impl.*;

public interface OrgTokenTypes {

  IElementType BLOCK = new OrgTokenType("BLOCK");
  IElementType DRAWER = new OrgTokenType("DRAWER");
  IElementType OUTLINE_BLOCK_1 = new OrgTokenType("OUTLINE_BLOCK_1");
  IElementType OUTLINE_BLOCK_2 = new OrgTokenType("OUTLINE_BLOCK_2");
  IElementType OUTLINE_BLOCK_3 = new OrgTokenType("OUTLINE_BLOCK_3");
  IElementType OUTLINE_BLOCK_4 = new OrgTokenType("OUTLINE_BLOCK_4");
  IElementType OUTLINE_BLOCK_5 = new OrgTokenType("OUTLINE_BLOCK_5");
  IElementType OUTLINE_BLOCK_6 = new OrgTokenType("OUTLINE_BLOCK_6");
  IElementType TEXT_ELEMENT = new OrgTokenType("TEXT_ELEMENT");

  IElementType BLOCK_CONTENT = new OrgElementType("BLOCK_CONTENT");
  IElementType BLOCK_END = new OrgElementType("BLOCK_END");
  IElementType BLOCK_START = new OrgElementType("BLOCK_START");
  IElementType BOLD = new OrgElementType("BOLD");
  IElementType CODE = new OrgElementType("CODE");
  IElementType COMMENT = new OrgElementType("COMMENT");
  IElementType CRLF = new OrgElementType("CRLF");
  IElementType DRAWER_CONTENT = new OrgElementType("DRAWER_CONTENT");
  IElementType DRAWER_DELIMITER = new OrgElementType("DRAWER_DELIMITER");
  IElementType FIFTHOUTLINE = new OrgElementType("FIFTHOUTLINE");
  IElementType FIRSTOUTLINE = new OrgElementType("FIRSTOUTLINE");
  IElementType FOURTHOUTLINE = new OrgElementType("FOURTHOUTLINE");
  IElementType SEVENTHOUTLINE = new OrgElementType("SEVENTHOUTLINE");
  IElementType EIGTHOUTLINE = new OrgElementType("EIGTHOUTLINE");
  IElementType NINTHOUTLINE = new OrgElementType("NINTHOUTLINE");
  IElementType TENTHOUTLINE = new OrgElementType("TENTHOUTLINE");
  IElementType KEYWORD = new OrgElementType("KEYWORD");
  IElementType PROPERTIES = new OrgElementType("PROPERTIES");
  IElementType SECONDOUTLINE = new OrgElementType("SECONDOUTLINE");
  IElementType SIXTHOUTLINE = new OrgElementType("SIXTHOUTLINE");
  IElementType TEXT = new OrgElementType("TEXT");
  IElementType THIRDOUTLINE = new OrgElementType("THIRDOUTLINE");
  IElementType UNMATCHED_DELIMITER = new OrgElementType("UNMATCHED_DELIMITER");
  IElementType WHITE_SPACE = new OrgElementType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BLOCK) {
        return new OrgBlockImpl(node);
      }
      else if (type == DRAWER) {
        return new OrgDrawerImpl(node);
      }
      else if (type == OUTLINE_BLOCK_1) {
        return new OrgOutlineBlock1Impl(node);
      }
      else if (type == OUTLINE_BLOCK_2) {
        return new OrgOutlineBlock2Impl(node);
      }
      else if (type == OUTLINE_BLOCK_3) {
        return new OrgOutlineBlock3Impl(node);
      }
      else if (type == OUTLINE_BLOCK_4) {
        return new OrgOutlineBlock4Impl(node);
      }
      else if (type == OUTLINE_BLOCK_5) {
        return new OrgOutlineBlock5Impl(node);
      }
      else if (type == OUTLINE_BLOCK_6) {
        return new OrgOutlineBlock6Impl(node);
      }
      else if (type == TEXT_ELEMENT) {
        return new OrgTextElementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
