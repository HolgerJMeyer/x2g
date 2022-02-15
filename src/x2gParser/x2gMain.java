//package x2g;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.*;

public class x2gMain {
	static String x2g = "X2G";
	static Boolean verbose = false;

	/* pretty print Error messages */
	public static class x2gErrorListener extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer, Object sym, int line, int pos, String msg, RecognitionException e) {
			if (verbose) {
				List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
				Collections.reverse(stack);

				System.err.println(x2g + ": exception: " + e);
				System.err.println(x2g + ": rule stack: " + stack);
				System.err.println(x2g + ": line " + line + ":" + pos + ": " + msg);
			} else {
				System.err.println(x2g + ": line " + line + ": " + msg);
			}
		}
	}

	/* main parser entry */
	public static void main(String[] args) throws Exception {
		// CharStream from Stadard Input
		CharStream input = CharStreams.fromStream(System.in);
		// Lexer feeds off of input CharStream
		x2gLexer lexer = new x2gLexer(input);
		// Create buffer of tokens pulled from lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create parser that feeds off of the token buffer
		x2gParser parser = new x2gParser(tokens);
		// Remove standard ErrorListener ConsoleErrorListener
		parser.removeErrorListeners();
		parser.addErrorListener(new x2gErrorListener());

		ParseTree tree = parser.x2g();	// begin parsing at init rule
		System.out.println(x2g + " parse tree: " + tree.toStringTree(parser));	// print LISP-style tree
		x2gEvaluator eval = new x2gEvaluator("axmlfile");
		eval.visit(tree);
		System.out.println(x2g + " parse tree: " + tree.toStringTree(parser));	// print LISP-style tree
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet
