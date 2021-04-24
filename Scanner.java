// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: scanner.jflex

import java.util.*;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\1\1\4\22\0\1\1"+
    "\1\5\3\0\1\5\1\6\1\0\2\7\1\10\1\11"+
    "\1\7\1\12\1\13\1\14\1\15\7\16\2\17\2\7"+
    "\1\20\1\21\1\22\1\7\1\0\4\23\1\24\1\23"+
    "\5\25\1\26\2\25\1\27\5\25\1\30\2\25\1\31"+
    "\2\25\1\7\1\0\1\7\1\5\1\25\1\0\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\25\1\43\1\44\1\45\1\46\1\47\1\50\1\25"+
    "\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60"+
    "\1\61\1\7\1\62\2\7\6\0\1\3\u01a2\0\2\3"+
    "\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\2\7\4\2\5\2\4"+
    "\20\6\1\4\2\5\2\0\1\2\3\5\1\0\6\6"+
    "\1\7\4\6\1\7\13\6\3\0\2\5\30\6\1\0"+
    "\1\5\1\0\1\2\27\6";

  private static int [] zzUnpackAction() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\63\0\63\0\146\0\231\0\314\0\63"+
    "\0\377\0\u0132\0\u0165\0\u0198\0\u01cb\0\u01fe\0\u0231\0\u0264"+
    "\0\u0297\0\u02ca\0\u02fd\0\u0330\0\u0363\0\u0396\0\u03c9\0\u03fc"+
    "\0\u042f\0\u0462\0\u0495\0\u04c8\0\u04fb\0\u052e\0\u0561\0\u0594"+
    "\0\u05c7\0\u05fa\0\u062d\0\u0165\0\u0660\0\u0693\0\u06c6\0\u06f9"+
    "\0\u072c\0\u075f\0\u0792\0\u07c5\0\u07f8\0\u082b\0\u085e\0\u0891"+
    "\0\u08c4\0\u08f7\0\u092a\0\u095d\0\u0990\0\u0297\0\u09c3\0\u09f6"+
    "\0\u0a29\0\u0a5c\0\u0a8f\0\u0ac2\0\u0af5\0\u0b28\0\u0b5b\0\u0b8e"+
    "\0\u0bc1\0\u0bf4\0\u0c27\0\u0c5a\0\63\0\u0c8d\0\u0cc0\0\u0cf3"+
    "\0\u0d26\0\u0d59\0\u0d8c\0\u0dbf\0\u0df2\0\u0e25\0\u0e58\0\u0e8b"+
    "\0\u0ebe\0\u0ef1\0\u0f24\0\u0f57\0\u0f8a\0\u0fbd\0\u0ff0\0\u1023"+
    "\0\u1056\0\u1089\0\u10bc\0\u10ef\0\u1122\0\u1155\0\u1188\0\u11bb"+
    "\0\u11ee\0\u0c27\0\u1221\0\u1254\0\u1287\0\u12ba\0\u12ed\0\u1320"+
    "\0\u1353\0\u1386\0\u13b9\0\u13ec\0\u141f\0\u1452\0\u1485\0\u14b8"+
    "\0\u14eb\0\u151e\0\u1551\0\u1584\0\u15b7\0\u15ea\0\u161d\0\u1650"+
    "\0\u1683";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\6"+
    "\1\11\1\12\1\13\1\14\1\15\2\16\1\17\1\6"+
    "\1\20\7\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\21\1\31\1\21\1\32\4\21\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\3\21\1\41\65\0\1\3"+
    "\101\0\1\10\47\0\1\10\12\0\1\10\52\0\1\10"+
    "\7\0\1\10\53\0\1\10\6\0\2\10\55\0\1\42"+
    "\2\43\7\0\1\44\43\0\1\45\3\0\1\46\4\0"+
    "\1\10\54\0\1\44\2\0\1\47\7\0\1\50\1\0"+
    "\1\51\1\52\25\0\1\52\16\0\1\44\1\0\3\16"+
    "\6\0\1\50\1\0\1\51\52\0\1\6\1\10\62\0"+
    "\1\10\1\6\55\0\3\21\3\0\37\21\16\0\3\21"+
    "\3\0\31\21\1\53\5\21\16\0\3\21\3\0\26\21"+
    "\1\54\10\21\16\0\3\21\3\0\7\21\1\55\6\21"+
    "\1\56\5\21\1\57\12\21\16\0\3\21\3\0\13\21"+
    "\1\60\10\21\1\61\12\21\16\0\3\21\3\0\21\21"+
    "\1\55\1\21\1\62\10\21\1\63\2\21\16\0\3\21"+
    "\3\0\21\21\1\64\2\21\1\65\12\21\16\0\3\21"+
    "\3\0\24\21\1\53\12\21\16\0\3\21\3\0\14\21"+
    "\1\66\6\21\1\67\13\21\16\0\3\21\3\0\24\21"+
    "\1\70\12\21\16\0\3\21\3\0\13\21\1\71\23\21"+
    "\16\0\3\21\3\0\16\21\1\72\1\73\10\21\1\74"+
    "\2\21\1\75\3\21\16\0\3\21\3\0\35\21\1\76"+
    "\1\21\16\0\3\21\3\0\23\21\1\77\13\21\16\0"+
    "\3\21\3\0\24\21\1\100\12\21\16\0\3\21\3\0"+
    "\16\21\1\101\20\21\22\0\1\10\40\0\1\10\24\0"+
    "\1\102\11\0\1\102\41\0\3\43\4\0\1\102\11\0"+
    "\1\102\24\0\10\103\1\104\52\103\2\46\1\3\1\46"+
    "\1\5\56\46\15\0\2\47\7\0\1\50\1\0\1\51"+
    "\62\0\1\105\60\0\1\105\52\0\2\106\3\0\2\106"+
    "\53\0\3\21\3\0\30\21\1\107\6\21\16\0\3\21"+
    "\3\0\13\21\1\110\23\21\16\0\3\21\3\0\27\21"+
    "\1\111\7\21\16\0\3\21\3\0\7\21\1\65\27\21"+
    "\16\0\3\21\3\0\23\21\1\112\13\21\16\0\3\21"+
    "\3\0\14\21\1\113\22\21\16\0\3\21\3\0\31\21"+
    "\1\114\5\21\16\0\3\21\3\0\31\21\1\115\5\21"+
    "\16\0\3\21\3\0\30\21\1\116\6\21\16\0\3\21"+
    "\3\0\24\21\1\117\12\21\16\0\3\21\3\0\26\21"+
    "\1\66\10\21\16\0\3\21\3\0\30\21\1\66\6\21"+
    "\16\0\3\21\3\0\23\21\1\120\13\21\16\0\3\21"+
    "\3\0\15\21\1\121\12\21\1\122\6\21\16\0\3\21"+
    "\3\0\24\21\1\123\12\21\16\0\3\21\3\0\15\21"+
    "\1\124\20\21\1\125\16\0\3\21\3\0\7\21\1\126"+
    "\16\21\1\127\10\21\16\0\3\21\3\0\17\21\1\130"+
    "\17\21\16\0\3\21\3\0\25\21\1\131\11\21\16\0"+
    "\3\21\3\0\17\21\1\132\7\21\1\133\7\21\16\0"+
    "\3\21\3\0\17\21\1\134\1\21\1\135\15\21\16\0"+
    "\3\21\3\0\17\21\1\136\17\21\12\0\2\137\2\0"+
    "\1\105\2\140\43\0\10\103\1\141\62\103\1\141\3\103"+
    "\1\142\46\103\16\0\2\106\3\0\2\106\1\0\1\50"+
    "\1\0\1\51\47\0\3\21\3\0\24\21\1\66\12\21"+
    "\16\0\3\21\3\0\7\21\1\143\27\21\16\0\3\21"+
    "\3\0\13\21\1\66\23\21\16\0\3\21\3\0\27\21"+
    "\1\67\1\144\6\21\16\0\3\21\3\0\7\21\1\145"+
    "\27\21\16\0\3\21\3\0\10\21\1\136\26\21\16\0"+
    "\3\21\3\0\22\21\1\66\14\21\16\0\3\21\3\0"+
    "\13\21\1\146\23\21\16\0\3\21\3\0\7\21\1\67"+
    "\27\21\16\0\3\21\3\0\15\21\1\66\21\21\16\0"+
    "\3\21\3\0\17\21\1\147\17\21\16\0\3\21\3\0"+
    "\31\21\1\146\5\21\16\0\3\21\3\0\26\21\1\67"+
    "\10\21\16\0\3\21\3\0\23\21\1\150\13\21\16\0"+
    "\3\21\3\0\13\21\1\151\23\21\16\0\3\21\3\0"+
    "\30\21\1\152\6\21\16\0\3\21\3\0\31\21\1\153"+
    "\5\21\16\0\3\21\3\0\30\21\1\154\6\21\16\0"+
    "\3\21\3\0\13\21\1\155\23\21\16\0\3\21\3\0"+
    "\24\21\1\156\12\21\16\0\3\21\3\0\17\21\1\157"+
    "\17\21\16\0\3\21\3\0\12\21\1\66\24\21\16\0"+
    "\3\21\3\0\7\21\1\160\27\21\16\0\3\21\3\0"+
    "\21\21\1\111\15\21\16\0\1\105\2\140\60\0\3\140"+
    "\43\0\10\103\1\141\3\103\1\3\46\103\15\0\3\21"+
    "\3\0\20\21\1\66\16\21\16\0\3\21\3\0\17\21"+
    "\1\161\17\21\16\0\3\21\3\0\31\21\1\162\5\21"+
    "\16\0\3\21\3\0\26\21\1\156\10\21\16\0\3\21"+
    "\3\0\27\21\1\163\7\21\16\0\3\21\3\0\13\21"+
    "\1\134\23\21\16\0\3\21\3\0\24\21\1\164\12\21"+
    "\16\0\3\21\3\0\17\21\1\165\17\21\16\0\3\21"+
    "\3\0\11\21\1\67\25\21\16\0\3\21\3\0\11\21"+
    "\1\166\25\21\16\0\3\21\3\0\12\21\1\167\24\21"+
    "\16\0\3\21\3\0\23\21\1\66\13\21\16\0\3\21"+
    "\3\0\15\21\1\124\21\21\16\0\3\21\3\0\30\21"+
    "\1\101\6\21\16\0\3\21\3\0\23\21\1\170\13\21"+
    "\16\0\3\21\3\0\21\21\1\67\15\21\16\0\3\21"+
    "\3\0\30\21\1\171\6\21\16\0\3\21\3\0\14\21"+
    "\1\66\22\21\16\0\3\21\3\0\11\21\1\66\25\21"+
    "\16\0\3\21\3\0\16\21\1\66\20\21\16\0\3\21"+
    "\3\0\13\21\1\164\23\21\16\0\3\21\3\0\31\21"+
    "\1\111\5\21\16\0\3\21\3\0\13\21\1\65\23\21"+
    "\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5814];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\3\11\3\1\1\11\33\1\2\0\4\1\1\0"+
    "\27\1\3\0\1\11\31\1\1\0\1\1\1\0\30\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    List<ArrayList<String>> literals = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> operators = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> identifiers = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> keywords = new ArrayList<ArrayList<String>>();
    
    private void addOp(List<ArrayList<String>> pList, String pOp, int pLine, int pCol) {
        ArrayList<String> op = new ArrayList();
        op.add(pOp);
        op.add(String.valueOf(pLine));
        op.add(String.valueOf(pCol));
        pList.add(op);
    }

    private void printArrays(List<ArrayList<String>> pArray) {
        for (int i = 0; i < pArray.size(); i++) {
            System.out.print("[ "+(pArray.get(i)).get(0) + " ] \t ( "+(pArray.get(i)).get(1) + ":"+(pArray.get(i)).get(2)+" ) \n");
        }
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    System.out.print("Operators: \n");
    printArrays(this.operators);
    System.out.print("Keywords: \n");
    printArrays(this.keywords);
    System.out.print("Identifiers: \n");
    printArrays(this.identifiers);
    System.out.print("Literals: \n");
    printArrays(this.literals);
    
    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return YYEOF;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.out.println("Error: "+yytext()+ " in line:" + yyline + " column: " + yycolumn);
            }
            // fall through
          case 8: break;
          case 2:
            { 
            }
            // fall through
          case 9: break;
          case 3:
            { System.out.print(yytext());
            }
            // fall through
          case 10: break;
          case 4:
            { addOp(this.operators, yytext(), yyline, yycolumn);
            }
            // fall through
          case 11: break;
          case 5:
            { addOp(this.literals, yytext(), yyline, yycolumn);
            }
            // fall through
          case 12: break;
          case 6:
            { addOp(this.identifiers, yytext(), yyline, yycolumn);
            }
            // fall through
          case 13: break;
          case 7:
            { addOp(this.keywords, yytext(), yyline, yycolumn);
            }
            // fall through
          case 14: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String[] argv) {
    if (argv.length == 0) {
      System.out.println("Usage : java Scanner [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          // Side-effect: is encodingName valid?
          java.nio.charset.Charset.forName(encodingName);
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Scanner scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Scanner(reader);
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
