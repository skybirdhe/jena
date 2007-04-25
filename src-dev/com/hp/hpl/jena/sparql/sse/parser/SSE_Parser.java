/* Generated By:JavaCC: Do not edit this line. SSE_Parser.java */
/*
 * (c) Copyright 2007 Hewlett-Packard Development Company, LP
 * All rights reserved.
 */

package com.hp.hpl.jena.sparql.sse.parser ;

import com.hp.hpl.jena.sparql.sse.* ;
import com.hp.hpl.jena.graph.* ;
import com.hp.hpl.jena.sparql.core.Var;


public class SSE_Parser extends ParserSSEBase implements SSE_ParserConstants {

// --- Entry point
  final public Item parse() throws ParseException {
                 Item list ; Item elt ;
    //    list = BareList()
        list = List();
    jj_consume_token(0);
      {if (true) return list ;}
    throw new Error("Missing return statement in function");
  }

  final public Item List() throws ParseException {
                Token t ; Item list ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
      t = jj_consume_token(LPAREN);
      list = Item.createList(t.beginLine, t.beginColumn) ;
      BareList(list);
      jj_consume_token(RPAREN);
      break;
    case LBRACKET:
      t = jj_consume_token(LBRACKET);
      list = Item.createList(t.beginLine, t.beginColumn) ;
      list = BareList(list);
      jj_consume_token(RBRACKET);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      {if (true) return list ;}
    throw new Error("Missing return statement in function");
  }

  final public Item BareList(Item list) throws ParseException {
                             Item elt ;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Q_IRIref:
      case QNAME:
      case BLANK_NODE_LABEL:
      case VAR1:
      case VAR2:
      case INTEGER:
      case DECIMAL:
      case DOUBLE:
      case STRING_LITERAL1:
      case STRING_LITERAL2:
      case STRING_LITERAL_LONG1:
      case STRING_LITERAL_LONG2:
      case LPAREN:
      case LBRACKET:
      case HOOK:
      case WORD:
      case OP:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      elt = WordOrList();
        list.getList().add(elt) ;
    }
      {if (true) return list ;}
    throw new Error("Missing return statement in function");
  }

  final public Item Word() throws ParseException {
                String str ; Token t ; Node node ; Var v ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WORD:
    case OP:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        t = jj_consume_token(WORD);
        break;
      case OP:
        t = jj_consume_token(OP);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      {if (true) return Item.createWord(t.image, t.beginLine, t.beginColumn) ;}
      break;
    case Q_IRIref:
    case QNAME:
    case BLANK_NODE_LABEL:
    case VAR1:
    case VAR2:
    case INTEGER:
    case DECIMAL:
    case DOUBLE:
    case STRING_LITERAL1:
    case STRING_LITERAL2:
    case STRING_LITERAL_LONG1:
    case STRING_LITERAL_LONG2:
    case HOOK:
      node = GraphTerm();
      {if (true) return Item.createNode(node, token.beginLine, token.beginColumn) ;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Item WordOrList() throws ParseException {
                      Item item ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Q_IRIref:
    case QNAME:
    case BLANK_NODE_LABEL:
    case VAR1:
    case VAR2:
    case INTEGER:
    case DECIMAL:
    case DOUBLE:
    case STRING_LITERAL1:
    case STRING_LITERAL2:
    case STRING_LITERAL_LONG1:
    case STRING_LITERAL_LONG2:
    case HOOK:
    case WORD:
    case OP:
      item = Word();
                   {if (true) return item ;}
      break;
    case LPAREN:
    case LBRACKET:
      item = List();
                  {if (true) return item ;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

// Abstract terminals (wrapped in grammar rules)
  final public Node GraphTerm() throws ParseException {
                     Node n ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Q_IRIref:
    case QNAME:
      n = IRIref();
                 {if (true) return n ;}
      break;
    case VAR1:
    case VAR2:
    case HOOK:
      n = Var();
              {if (true) return n ;}
      break;
    case STRING_LITERAL1:
    case STRING_LITERAL2:
    case STRING_LITERAL_LONG1:
    case STRING_LITERAL_LONG2:
      n = RDFLiteral();
                     {if (true) return n ;}
      break;
    case INTEGER:
    case DECIMAL:
    case DOUBLE:
      n = NumericLiteral();
                         {if (true) return n ;}
      break;
    case BLANK_NODE_LABEL:
      n = BlankNode();
                    {if (true) return n ;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Node Var() throws ParseException {
               Token t ; Var v ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR1:
    case VAR2:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR1:
        t = jj_consume_token(VAR1);
        break;
      case VAR2:
        t = jj_consume_token(VAR2);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    {if (true) return createVariable(t.image, t.beginLine, t.beginColumn) ;}
      break;
    case HOOK:
      t = jj_consume_token(HOOK);
    {if (true) return createVariable() ;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Node RDFLiteral() throws ParseException {
                      Token t ; String lex = null ;
    lex = String();
    String lang = null ; Node uri = null ; String qname = null ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LANGTAG:
    case DATATYPE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LANGTAG:
        t = jj_consume_token(LANGTAG);
                      lang = stripChars(t.image, 1) ;
        break;
      case DATATYPE:
        jj_consume_token(DATATYPE);
        uri = IRIref();
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
      {if (true) return makeNode(lex, lang, uri) ;}
    throw new Error("Missing return statement in function");
  }

  final public Node NumericLiteral() throws ParseException {
                          Token t ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      t = jj_consume_token(INTEGER);
                  {if (true) return makeNodeInteger(t.image) ;}
      break;
    case DECIMAL:
      t = jj_consume_token(DECIMAL);
                  {if (true) return makeNodeDecimal(t.image) ;}
      break;
    case DOUBLE:
      t = jj_consume_token(DOUBLE);
                 {if (true) return makeNodeDouble(t.image) ;}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

// Node BooleanLiteral() : {}
// {
//   <TRUE> { return XSD_TRUE ; }
//  |
//   <FALSE> { return XSD_FALSE ; }
// }
  final public String String() throws ParseException {
                    Token t ; String lex ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_LITERAL1:
      t = jj_consume_token(STRING_LITERAL1);
                            lex = stripQuotes(t.image) ;
      break;
    case STRING_LITERAL2:
      t = jj_consume_token(STRING_LITERAL2);
                            lex = stripQuotes(t.image) ;
      break;
    case STRING_LITERAL_LONG1:
      t = jj_consume_token(STRING_LITERAL_LONG1);
                                 lex = stripQuotes3(t.image) ;
      break;
    case STRING_LITERAL_LONG2:
      t = jj_consume_token(STRING_LITERAL_LONG2);
                                 lex = stripQuotes3(t.image) ;
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      lex = unescapeStr(lex, t.beginLine, t.beginColumn) ;
      {if (true) return lex ;}
    throw new Error("Missing return statement in function");
  }

  final public Node IRIref() throws ParseException {
                  Node n ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Q_IRIref:
      n = Q_IRI_REF();
                    {if (true) return n ;}
      break;
    case QNAME:
      n = QName();
                {if (true) return n ;}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Node QName() throws ParseException {
                 Token t ; Node n ;
    t = jj_consume_token(QNAME);
      {if (true) return createNodeFromPrefixedName(t.image, t.beginLine, t.beginColumn) ;}
    throw new Error("Missing return statement in function");
  }

  final public Node BlankNode() throws ParseException {
                     Token t = null ;
    t = jj_consume_token(BLANK_NODE_LABEL);
      {if (true) return createBNode(t.image, t.beginLine, t.beginColumn) ;}
    throw new Error("Missing return statement in function");
  }

  final public Node Q_IRI_REF() throws ParseException {
                     Token t ;
    t = jj_consume_token(Q_IRIref);
    {if (true) return createNodeFromURI(t.image, t.beginLine, t.beginColumn) ;}
    throw new Error("Missing return statement in function");
  }

  public SSE_ParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_0();
      jj_la1_1();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x10000000,0x1f0e1f00,0x0,0xf0e1f00,0x1f0e1f00,0xf0e1f00,0x1800,0x1800,0x2000,0x2000,0xe0000,0xf000000,0x300,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x1,0x1811,0x1800,0x1810,0x1811,0x10,0x0,0x10,0x4,0x4,0x0,0x0,0x0,};
   }

  public SSE_Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  public SSE_Parser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new SSE_ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public SSE_Parser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new SSE_ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public SSE_Parser(SSE_ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public void ReInit(SSE_ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[46];
    for (int i = 0; i < 46; i++) {
      la1tokens[i] = false;
    }
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
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 46; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

}
