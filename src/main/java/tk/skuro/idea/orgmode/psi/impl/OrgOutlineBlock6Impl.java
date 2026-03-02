// This is a generated file. Not intended for manual editing.
package tk.skuro.idea.orgmode.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tk.skuro.idea.orgmode.parser.OrgTokenTypes.*;
import tk.skuro.idea.orgmode.psi.OrgPsiElementImpl;
import tk.skuro.idea.orgmode.psi.*;

public class OrgOutlineBlock6Impl extends OrgPsiElementImpl implements OrgOutlineBlock6 {

  public OrgOutlineBlock6Impl(@NotNull ASTNode astNode) {
    super(astNode);
  }

  public void accept(@NotNull OrgVisitor visitor) {
    visitor.visitOutlineBlock6(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OrgVisitor) accept((OrgVisitor)visitor);
    else super.accept(visitor);
  }

}
