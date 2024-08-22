package tk.skuro.idea.orgmode.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static tk.skuro.idea.orgmode.parser.OrgTokenTypes.*;

// TODO: see if could reuse org lexer src/org_lexer.l

%%

%class _OrgLexer
%implements FlexLexer
%unicode

%function advance
%eof{  return;
%eof}
%type IElementType

%state BLOCK
%state PROPERTIES

/** Classes definitions */
CRLF= \n|\r|\r\n
SPACES = [\ \t]
WHITE_SPACE_CHAR = {CRLF}|{SPACES}|[\f]
INPUT_CHARACTER = [^\r\n\f]
INPUT_OR_SPACES = ({INPUT_CHARACTER}|{SPACES})

COMMENT ="#".*

KEYWORD={SPACES}*"#+"{INPUT_CHARACTER}+":"{INPUT_OR_SPACES}*{CRLF}?

BOLD = "*" [^\r\n]+ "*"
FIRST_OUTLINE = "*" {INPUT_OR_SPACES}*
SECOND_OUTLINE = "**" {INPUT_OR_SPACES}*
THIRD_OUTLINE = "***" {INPUT_OR_SPACES}*
FOURTH_OUTLINE = "****" {INPUT_OR_SPACES}*
FIFTH_OUTLINE = "*****" {INPUT_OR_SPACES}*
SIXTH_OUTLINE = "******" {INPUT_OR_SPACES}*
SEVENTH_OUTLINE = "*******" {INPUT_OR_SPACES}*
EIGTH_OUTLINE = "********" {INPUT_OR_SPACES}*
NINTH_OUTLINE = "*********" {INPUT_OR_SPACES}*
TENTH_OUTLINE = "**********" {INPUT_OR_SPACES}*

// not sure what this was intended to do:
CODELINE = {SPACES}*": "{INPUT_CHARACTER}*

BLOCK_START= {SPACES}*"#+BEGIN_"{INPUT_CHARACTER}+
BLOCK_END= {SPACES}*"#+END_"{INPUT_CHARACTER}+

PROPERTIES_START=[\ \t]*":PROPERTIES:"
PROPERTIES_END=[\ \t]*":END:"

%% /** Lexing Rules */

<YYINITIAL> {
    /** Elements that must start at the beginning of the line **/
    ^{TENTH_OUTLINE}          { yybegin(YYINITIAL); return TENTHOUTLINE; }
    ^{NINTH_OUTLINE}          { yybegin(YYINITIAL); return NINTHOUTLINE; }
    ^{EIGTH_OUTLINE}          { yybegin(YYINITIAL); return EIGTHOUTLINE; }
    ^{SEVENTH_OUTLINE}          { yybegin(YYINITIAL); return SEE; }
    ^{SIXTH_OUTLINE}          { yybegin(YYINITIAL); return SIXTHOUTLINE; }
    ^{FIFTH_OUTLINE}          { yybegin(YYINITIAL); return FIFTHOUTLINE; }
    ^{FOURTH_OUTLINE}          { yybegin(YYINITIAL); return FOURTHOUTLINE; }
    ^{THIRD_OUTLINE}          { yybegin(YYINITIAL); return THIRDOUTLINE; }
    ^{SECOND_OUTLINE}          { yybegin(YYINITIAL); return SECONDOUTLINE; }
    ^{FIRST_OUTLINE}          { yybegin(YYINITIAL); return FIRSTOUTLINE; }
    ^{KEYWORD}          { yybegin(YYINITIAL); return KEYWORD; }
    ^{CODELINE}         { yybegin(YYINITIAL); return CODE; }
    ^{PROPERTIES_START} { yybegin(PROPERTIES); return DRAWER_DELIMITER; }

    /** Elements that can appear in positions other than beginning of line **/
    {BLOCK_START}       { yybegin(BLOCK); return BLOCK_START; }
}

<PROPERTIES> {
    {PROPERTIES_END} { yybegin(YYINITIAL); return DRAWER_DELIMITER; }
    .                 { return DRAWER_CONTENT; }
}

<BLOCK> {
    ^{BLOCK_END}      { yybegin(YYINITIAL); return BLOCK_END; }
    .                 { return BLOCK_CONTENT; }
}

/** unmatched block delimiters **/
{BLOCK_END}           { return UNMATCHED_DELIMITER; }
{PROPERTIES_END}      { return UNMATCHED_DELIMITER; }

{WHITE_SPACE_CHAR}+   { return WHITE_SPACE; }
{COMMENT}             { return COMMENT; }
{BOLD}                { return BOLD; }

.                     { return TEXT; }
