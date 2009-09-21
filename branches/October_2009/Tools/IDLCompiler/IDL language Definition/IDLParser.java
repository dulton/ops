/* Generated By:JavaCC: Do not edit this line. IDLParser.java */
public class IDLParser implements IDLParserConstants {

  public static void main(String args[]) {
    IDLParser parser;
    if (args.length == 0) {
      System.out.println("IDL Parser Version 0.1:  Reading from standard input . . .");
      parser = new IDLParser(System.in);
    } else if (args.length == 1) {
      System.out.println("IDL Parser Version 0.1:  Reading from file " + args[0] + " . . .");
      try {
        parser = new IDLParser(new java.io.FileInputStream(args[0]));
      } catch (java.io.FileNotFoundException e) {
        System.out.println("IDL Parser Version 0.1:  File " + args[0] + " not found.");
        return;
      }
    } else {
      System.out.println("IDL Parser Version 0.1:  Usage is one of:");
      System.out.println("         java IDLParser < inputfile");
      System.out.println("OR");
      System.out.println("         java IDLParser inputfile");
      return;
    }
    try {
      parser.specification();
      System.out.println("IDL Parser Version 0.1:  IDL file parsed successfully.");
    } catch (ParseException e) {
      System.out.println("IDL Parser Version 0.1:  Encountered errors during parse.");
    }
  }

/* Production 1 */
  static final public void specification() throws ParseException {
    label_1:
    while (true) {
      definition();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
  }

/* Production 2 */
  static final public void definition() throws ParseException {
    module();
    jj_consume_token(8);
    struct_type();
  }

/* Production 3 */
  static final public void module() throws ParseException {
    jj_consume_token(9);
    identifier();
    jj_consume_token(10);
    label_2:
    while (true) {
      definition();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
    }
    jj_consume_token(11);
  }

  static final public void struct_type() throws ParseException {
    jj_consume_token(12);
    identifier();
    jj_consume_token(10);
    member_list();
    jj_consume_token(11);
  }

/* Production 51 */
  static final public void member_list() throws ParseException {
    label_3:
    while (true) {
      member();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
    }
  }

/* Production 52 */
  static final public void member() throws ParseException {
    type_spec();
    declarators();
    jj_consume_token(8);
  }

  static final public void identifier() throws ParseException {
    jj_consume_token(ID);
  }

  static final public void declarators() throws ParseException {
    declarator();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 13:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_4;
      }
      jj_consume_token(13);
      declarator();
    }
  }

/* Production 35 */
  static final public void declarator() throws ParseException {
    if (jj_2_1(2)) {
      complex_declarator();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        simple_declarator();
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void type_spec() throws ParseException {
    simple_type_spec();
  }

  static final public void simple_type_spec() throws ParseException {
    base_type_spec();
  }

  static final public void base_type_spec() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 16:
    case 17:
      floating_pt_type();
      break;
    case 18:
    case 19:
    case 20:
      integer_type();
      break;
    case 21:
      char_type();
      break;
    case 22:
      boolean_type();
      break;
    case 23:
      octet_type();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void simple_declarator() throws ParseException {
    identifier();
  }

  static final public void complex_declarator() throws ParseException {
    array_declarator();
  }

  static final public void array_declarator() throws ParseException {
    identifier();
    label_5:
    while (true) {
      fixed_array_size();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 14:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_5;
      }
    }
  }

/* Production 64 */
  static final public void fixed_array_size() throws ParseException {
    jj_consume_token(14);
    jj_consume_token(15);
  }

/* Production 38 */
  static final public void floating_pt_type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 16:
      jj_consume_token(16);
      break;
    case 17:
      jj_consume_token(17);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/* Production 39 */
  static final public void integer_type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 18:
    case 19:
      signed_int();
      break;
    case 20:
      unsigned_int();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/* Production 40 */
  static final public void signed_int() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 18:
      signed_long_int();
      break;
    case 19:
      signed_short_int();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/* Production 41 */
  static final public void signed_long_int() throws ParseException {
    jj_consume_token(18);
  }

/* Production 42 */
  static final public void signed_short_int() throws ParseException {
    jj_consume_token(19);
  }

/* Production 43 */
  static final public void unsigned_int() throws ParseException {
    if (jj_2_2(2)) {
      unsigned_long_int();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 20:
        unsigned_short_int();
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

/* Production 44 */
  static final public void unsigned_long_int() throws ParseException {
    jj_consume_token(20);
    jj_consume_token(18);
  }

/* Production 45 */
  static final public void unsigned_short_int() throws ParseException {
    jj_consume_token(20);
    jj_consume_token(19);
  }

/* Production 46 */
  static final public void char_type() throws ParseException {
    jj_consume_token(21);
  }

/* Production 47 */
  static final public void boolean_type() throws ParseException {
    jj_consume_token(22);
  }

/* Production 48 */
  static final public void octet_type() throws ParseException {
    jj_consume_token(23);
  }

  static final public void integer_literal() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OCTALINT:
      jj_consume_token(OCTALINT);
      break;
    case DECIMALINT:
      jj_consume_token(DECIMALINT);
      break;
    case HEXADECIMALINT:
      jj_consume_token(HEXADECIMALINT);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void string_literal() throws ParseException {
    jj_consume_token(STRING);
  }

  static final public void character_literal() throws ParseException {
    jj_consume_token(CHARACTER);
  }

  static final public void floating_pt_literal() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FLOATONE:
      jj_consume_token(FLOATONE);
      break;
    case FLOATTWO:
      jj_consume_token(FLOATTWO);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_3R_8() {
    if (jj_scan_token(24)) return true;
    Token xsp;
    if (jj_3R_9()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_9()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_scan_token(14)) return true;
    return false;
  }

  static private boolean jj_3R_7() {
    if (jj_scan_token(20)) return true;
    if (jj_scan_token(18)) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3R_6() {
    if (jj_3R_8()) return true;
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_6()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public IDLParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200,0x200,0xff0000,0x2000,0x1000000,0xff0000,0x4000,0x30000,0x1c0000,0xc0000,0x100000,0xe000000,0x30000000,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[2];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public IDLParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public IDLParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new IDLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public IDLParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new IDLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public IDLParser(IDLParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(IDLParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[32];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 32; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
