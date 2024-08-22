// This is a generated file. Not intended for manual editing.
package tk.skuro.idea.orgmode.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static tk.skuro.idea.orgmode.parser.OrgTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OrgParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return orgFile(b, l + 1);
  }

  /* ********************************************************** */
  // BLOCK_START BLOCK_CONTENT* BLOCK_END
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, BLOCK_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_START);
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, BLOCK_END);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // BLOCK_CONTENT*
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, BLOCK_CONTENT)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DRAWER_DELIMITER DRAWER_CONTENT* DRAWER_DELIMITER
  public static boolean drawer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "drawer")) return false;
    if (!nextTokenIs(b, DRAWER_DELIMITER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DRAWER_DELIMITER);
    r = r && drawer_1(b, l + 1);
    r = r && consumeToken(b, DRAWER_DELIMITER);
    exit_section_(b, m, DRAWER, r);
    return r;
  }

  // DRAWER_CONTENT*
  private static boolean drawer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "drawer_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, DRAWER_CONTENT)) break;
      if (!empty_element_parsed_guard_(b, "drawer_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COMMENT|KEYWORD|CODE|PROPERTIES|WHITE_SPACE|UNMATCHED_DELIMITER|outlineBlock1|outlineBlock2|outlineBlock3|outlineBlock4|outlineBlock5|outlineBlock6|block|drawer|text_element
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, KEYWORD);
    if (!r) r = consumeToken(b, CODE);
    if (!r) r = consumeToken(b, PROPERTIES);
    if (!r) r = consumeToken(b, WHITE_SPACE);
    if (!r) r = consumeToken(b, UNMATCHED_DELIMITER);
    if (!r) r = outlineBlock1(b, l + 1);
    if (!r) r = outlineBlock2(b, l + 1);
    if (!r) r = outlineBlock3(b, l + 1);
    if (!r) r = outlineBlock4(b, l + 1);
    if (!r) r = outlineBlock5(b, l + 1);
    if (!r) r = outlineBlock6(b, l + 1);
    if (!r) r = block(b, l + 1);
    if (!r) r = drawer(b, l + 1);
    if (!r) r = text_element(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean orgFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orgFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "orgFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // FIRSTOUTLINE
  public static boolean outlineBlock1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outlineBlock1")) return false;
    if (!nextTokenIs(b, FIRSTOUTLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FIRSTOUTLINE);
    exit_section_(b, m, OUTLINE_BLOCK_1, r);
    return r;
  }

  /* ********************************************************** */
  // SECONDOUTLINE
  public static boolean outlineBlock2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outlineBlock2")) return false;
    if (!nextTokenIs(b, SECONDOUTLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SECONDOUTLINE);
    exit_section_(b, m, OUTLINE_BLOCK_2, r);
    return r;
  }

  /* ********************************************************** */
  // THIRDOUTLINE
  public static boolean outlineBlock3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outlineBlock3")) return false;
    if (!nextTokenIs(b, THIRDOUTLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THIRDOUTLINE);
    exit_section_(b, m, OUTLINE_BLOCK_3, r);
    return r;
  }

  /* ********************************************************** */
  // FOURTHOUTLINE
  public static boolean outlineBlock4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outlineBlock4")) return false;
    if (!nextTokenIs(b, FOURTHOUTLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOURTHOUTLINE);
    exit_section_(b, m, OUTLINE_BLOCK_4, r);
    return r;
  }

  /* ********************************************************** */
  // FIFTHOUTLINE
  public static boolean outlineBlock5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outlineBlock5")) return false;
    if (!nextTokenIs(b, FIFTHOUTLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FIFTHOUTLINE);
    exit_section_(b, m, OUTLINE_BLOCK_5, r);
    return r;
  }

  /* ********************************************************** */
  // SIXTHOUTLINE
  public static boolean outlineBlock6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outlineBlock6")) return false;
    if (!nextTokenIs(b, SIXTHOUTLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SIXTHOUTLINE);
    exit_section_(b, m, OUTLINE_BLOCK_6, r);
    return r;
  }

  /* ********************************************************** */
  // TEXT |  BOLD | CRLF
  public static boolean text_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_ELEMENT, "<text element>");
    r = consumeToken(b, TEXT);
    if (!r) r = consumeToken(b, BOLD);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
