package tk.skuro.idea.orgmode.editor.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk.skuro.idea.orgmode.parser.OrgTokenTypes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enables blocks folding in org files, e.g. for code blocks, drawers, etc.
 *
 * @author Carlo Sciolla
 * @since 0.3.0
 */
public class OrgFoldingBuilder implements FoldingBuilder {

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode astNode, @NotNull Document document) {
        final List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
        collectBlocks(astNode, descriptors);
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    /**
     * @param node
     * @param descriptors
     */
    protected void collectBlocks(final ASTNode node, final List<FoldingDescriptor> descriptors) {
        final IElementType token = node.getElementType();

        if (isOutline(token)) {
            foldOutline(node, descriptors);
        }

        for (ASTNode child : node.getChildren(null)) {
            collectBlocks(child, descriptors);
        }
    }

    private void foldOutline(ASTNode node, List<FoldingDescriptor> descriptors) {
        final ASTNode nextSibling = findNextOutline(node);
        final TextRange textRange;
        if (nextSibling != null) {
            textRange = TextRange.create(node.getStartOffset() + indexOfWhenToStartFold(node), nextSibling.getStartOffset() - 1);
            final FoldingDescriptor descriptor = new FoldingDescriptor(node, textRange);
            descriptors.add(descriptor);
        } else {
            final ASTNode lastNode = getLastNode(node);
            if (!sameNode(node, lastNode)) {
                textRange = TextRange.create(node.getStartOffset() + indexOfWhenToStartFold(node), lastNode.getStartOffset());
                final FoldingDescriptor descriptor = new FoldingDescriptor(node, textRange);
                descriptors.add(descriptor);
            }
        }
    }

    private boolean sameNode(ASTNode node, ASTNode lastNode) {
        return node.getTextRange().getEndOffset() == lastNode.getTextRange().getEndOffset();
    }

    private ASTNode getLastNode(ASTNode node) {
        ASTNode candidate = node;
        while (candidate.getTreeParent() != null) {
            candidate = candidate.getTreeParent();
        }
        return candidate.getLastChildNode();
    }

    /**
     * Find the next outline after the given node which has a depth equal or higher (-> less stars) than the current outline depth
     * Also stops
     *
     * @param node The current outline node
     * @return The node representing the next outline with a depth equal or higher (-> less stars) than the current one
     */
    private ASTNode findNextOutline(ASTNode node) {
        final int depth = outlineDepth(node.getText());

        ASTNode next = null;
        ASTNode outlineBlock = node.getTreeParent();
        for (ASTNode candidate = outlineBlock.getTreeNext(); candidate != null && next == null; candidate = candidate.getTreeNext()) {
            if (isPeerOutline(depth, candidate)) {
                next = candidate;
            }
        }

        return next;
    }

    private boolean isPeerOutline(int depth, ASTNode candidate) {
        if (isOutlineBlock(candidate.getElementType())) {
            return isPeerOutline(depth, candidate.getFirstChildNode());
        } else {
            return isOutline(candidate.getElementType()) && outlineDepth(candidate.getText()) <= depth;
        }
    }

    private boolean isOutlineBlock(IElementType token) {
        return
                OrgTokenTypes.OUTLINE_BLOCK_1.equals(token) ||
                        OrgTokenTypes.OUTLINE_BLOCK_2.equals(token) ||
                        OrgTokenTypes.OUTLINE_BLOCK_3.equals(token) ||
                        OrgTokenTypes.OUTLINE_BLOCK_4.equals(token) ||
                        OrgTokenTypes.OUTLINE_BLOCK_5.equals(token) ||
                        OrgTokenTypes.OUTLINE_BLOCK_6.equals(token);
    }

    /**
     * Count how many stars are used in an outline, indicating its depth
     *
     * @param text The text of the outline
     * @return The number of initial stars in the outline
     */
    private int outlineDepth(String text) {
        if (text.startsWith("*")) {
            return text.split("[^*]")[0].length();
        } else {
            return 0;
        }
    }

    private boolean isOutline(IElementType token) {
        return
                OrgTokenTypes.FIRSTOUTLINE.equals(token) ||
                        OrgTokenTypes.SECONDOUTLINE.equals(token) ||
                        OrgTokenTypes.THIRDOUTLINE.equals(token) ||
                        OrgTokenTypes.FOURTHOUTLINE.equals(token) ||
                        OrgTokenTypes.FIFTHOUTLINE.equals(token) ||
                        OrgTokenTypes.SIXTHOUTLINE.equals(token);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode astNode) {
        String firstLine = astNode.getText()
                .lines()
                .findFirst()
                .orElse("");
        int indexOfKeyword = indexOfWhenToStartFold(astNode);

        return firstLine.substring(indexOfKeyword) + " [...]";
    }

    private int indexOfWhenToStartFold(ASTNode node) {
        List<String> list = List.of(
                "DONE", "CANCELLED", "TODO", "WAITING", "NEXT", "PROJECT"
        );
        String line = node.getText().lines().findFirst().orElse("");
        for (String keyword : list) {
            if (line.contains(keyword))
                return line.indexOf(keyword) + keyword.length() + 1;
        }
        int numberOfAsterisks = 0;
        for (char c : line.toCharArray()) {
            if (c == '*')
                numberOfAsterisks++;
            else break;
        }
        if(line.replace("*", " ").isBlank())
            return numberOfAsterisks;
        else return numberOfAsterisks + 1;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode astNode) {
        return false;
    }
}
