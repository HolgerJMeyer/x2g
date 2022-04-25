//package x2g;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

//import org.apache.commons.cli.*; // otherwise conclicts with antlr4 parser class

import java.util.*;
import java.io.*;


public class Main {
	static final String conflictOptions[] = { "create", "link", "merge", "reject" };
	static String x2g = "X2G";
	static boolean verbose = false;
	static boolean parseOnly = false;
	static String conflict = "reject"; // other options: merga, link
	static String inputDir = null;
	static String outFile = null;
	static String outputFormat = ".csv";

	/* pretty print Error messages */
	public static class ErrorListener extends BaseErrorListener {
		public void syntaxError(Recognizer<?, ?> recognizer, Object sym, int line, int pos, String msg, RecognitionException e) {
			if (verbose) {
				List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
				Collections.reverse(stack);

				if (e != null)
					System.err.println(x2g + ": exception: " + e);
				System.err.println(x2g + ": rule stack: " + stack);
				//System.err.println(x2g + ": line " + line + ":" + pos + ": " + msg);
				System.err.println(x2g + ": line " + line + ": " + msg);
			} else {
				System.err.println(x2g + ": line " + line + ": " + msg);
			}
		}
	}

	/* main parser entry */
	public static void main(String[] args) throws Exception {
		// command line parsing
		org.apache.commons.cli.Options options = new org.apache.commons.cli.Options();

		options.addOption("c", "conflict", true, "conflict resolution options during node creation: create, (create and) link, merge, reject are valid options");
		options.addOption("d", "input-dir", true, "transform all xml files found in this directory");
		options.addOption("f", "output-format", true, "output file format: csv, dot, gefx, graphml, and lg are supported options");
		options.addOption("h", "help", false, "print this help");
		options.addOption("n", "namespace", false, "enable namespace processing (default: false)");
		options.addOption("o", "out-file", true, "basename of output file(s)");
		options.addOption("p", "parse-only", false, "only parse ruleset, don't transform xml files");
		options.addOption("r", "rules", true, "read x2g rules from file or stdin (default)");
		options.addOption("v", "verbose", false, "being verbose");

		org.apache.commons.cli.CommandLineParser cmdparser = new org.apache.commons.cli.DefaultParser();
		org.apache.commons.cli.CommandLine cmd = cmdparser.parse(options, args);

		if (cmd.hasOption("conflict")) {
			conflict = cmd.getOptionValue("c");
		}

		if (cmd.hasOption("input-dir")) {
			inputDir = cmd.getOptionValue("d");
		}

		if (cmd.hasOption("output-format")) {
			outputFormat = cmd.getOptionValue("f");
		}

		if (cmd.hasOption("out-file")) {
			outFile = cmd.getOptionValue("o");
		}

		if (cmd.hasOption("verbose")) {
			verbose = true;
		}

		if (cmd.hasOption("parse-only")) {
			parseOnly = true;
		}

		if (cmd.hasOption("help")) {
			org.apache.commons.cli.HelpFormatter formatter = new org.apache.commons.cli.HelpFormatter();
			formatter.printHelp("x2g [options] [xml-file ...]", options);
			return;
		}

		// CharStream from Stadard Input
		CharStream input = CharStreams.fromStream(System.in);
		// Lexer feeds off of input CharStream
		x2gLexer lexer = new x2gLexer(input);
		// Create buffer of tokens pulled from lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create symbol table with global scope
		SymbolTable symtab = new SymbolTable();
		// Create parser that feeds off of the token buffer
		x2gParser parser = new x2gParser(tokens, symtab, verbose);
		// Remove standard ErrorListener ConsoleErrorListener
		parser.removeErrorListeners();
		parser.addErrorListener(new ErrorListener());

		ParseTree tree = parser.x2g();	// begin parsing at init rule
		if (verbose)
			System.err.println(x2g + " parse tree: " + tree.toStringTree(parser));	// print LISP-style tree
		
		if (parseOnly) {
			return;
		}

		final gGraph graph = new gGraph(verbose);
		final Evaluator eval = new Evaluator(symtab, graph, verbose);

		// process all xml files from a given folder or specified on command line
		List<File> filelist = new ArrayList<File>();
		if (inputDir != null) {
			File[] files = new File(inputDir).listFiles();
			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(".xml")) {
					filelist.add(file);
				}
				else {
					System.err.println(x2g + ": " + file.getName() + " is not a regular xml file");
				}
			}
		}
		if (cmd.getArgList() != null) {
			for (String filename : cmd.getArgList()) {
				File file = new File(filename);
				if (file.isFile() && file.getName().endsWith(".xml")) {
					filelist.add(file);
				}
				else {
					System.err.println(x2g + ": " + file.getAbsolutePath() + " is not a regular xml file");
				}
			}
		}
		for (File file : filelist) {
			if (verbose)
				System.err.println(x2g + ": processing xml file " + file.getAbsolutePath());
			eval.setXtractor(file.getAbsolutePath());
			eval.visit(tree);
		}
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet
