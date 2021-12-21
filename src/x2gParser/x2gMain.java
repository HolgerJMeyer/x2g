//package grafl;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.*;

public class graflMain {
	/* pretty print Error messages */
	static String grafl = "GrafL";

	public static class graflErrorListener extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer, Object sym, int line, int pos, String msg, RecognitionException e)
		{
			List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
			Collections.reverse(stack);
			System.err.println(grafl+" rule stack: "+stack);
			System.err.println("line "+line+" char pos "+pos+" at "+sym+": "+msg);
		}
	}
	/* main parser entry */
	public static void main(String[] args) throws Exception {
		// CharStream from Stadard Input
		CharStream input = CharStreams.fromStream(System.in);
		// Lexer feeds off of input CharStream
		graflLexer lexer = new graflLexer(input);
		// Create buffer of tokens pulled from lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create parser that feeds off of the token buffer
		graflParser parser = new graflParser(tokens);
		// Remove standard ErrorListener ConsoleErrorListener
		parser.removeErrorListeners();
		parser.addErrorListener(new graflErrorListener());

		ParseTree tree = parser.grafl();	// begin parsing at init rule
		System.out.println(grafl+" parse tree: "+tree.toStringTree(parser));	// print LISP-style tree
	}
}

// vim: ts=3 sw=3 sts=3 noet
