//package x2g;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

//import org.apache.commons.cli.*; // otherwise conclicts with antlr4 parser class

import java.util.*;
import java.io.*;


public class Main {
	static final String conflictOptions[] = { "create", "link", "merge", "reject" };
	static String x2g = "X2G";
	static boolean special = false;
	static boolean verbose = false;
	static boolean warnings = false;
	static boolean mixed = false;
	static boolean parseOnly = false;
	static boolean multiGraph = false;
	static boolean nameSpaces = false;
	static String conflict = "reject"; // other options: merga, link
	static String inputDir = null;
	static String rulesFile = null;
	static String outFile = null;
	static String inputURL = null;
	static String inputJDBC = null;
	static String outputFormat = "csv";

	/* pretty print Error messages */
	public static class ErrorListener extends BaseErrorListener {
		public void syntaxError(Recognizer<?, ?> recognizer, Object sym, int line, int pos, String msg, RecognitionException e) {
			if (verbose) {
				List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
				Collections.reverse(stack);

				if (e != null) {
					System.err.println(x2g + ": exception: " + e);
				}
				//System.err.println(x2g + ": rule stack: " + stack);
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
		options.addOption("d", "input-dir", true, "transform all files found in this directory");
		options.addOption("f", "output-format", true, "output file format: csv, dot, gefx, graphml, and lg are supported options");
		options.addOption("h", "help", false, "print this help");
		options.addOption("i", "integrate-mode", false, "mixed input formats (xml, json, sql, csv) are used");
		options.addOption("j", "jdbc-connection", true, "read from JDBC connection specified as connection URL");
		options.addOption("m", "mixed-mode", false, "allow different input type sources");
		options.addOption("x", "multi-graph", false, "multi-graph, i.e., allow muliple edges between a pair of nodes");
		options.addOption("n", "namespace", false, "enable namespace processing (default: false)");
		options.addOption("o", "output-file", true, "basename of output file(s), default \"null\"*");
		options.addOption("p", "parse-only", false, "only parse ruleset, don't transform xml files");
		options.addOption("r", "rules", true, "read x2g rules from file or stdin (default)");
		options.addOption("s", "special-props", false, "export special properties starting with\"__\" (dfefault: not)");
		options.addOption("u", "input-url", true, "read input data from that URL");
		options.addOption("v", "verbose", false, "being verbose");
		options.addOption("w", "warnings", false, "issue warnings about e.g. xpath empty results");

		org.apache.commons.cli.CommandLineParser cmdparser = new org.apache.commons.cli.DefaultParser();
		org.apache.commons.cli.CommandLine cmd = cmdparser.parse(options, args);

		if (cmd.hasOption("conflict")) { conflict = cmd.getOptionValue("c"); }
		if (cmd.hasOption("input-dir")) { inputDir = cmd.getOptionValue("d"); }
		if (cmd.hasOption("output-format")) { outputFormat = cmd.getOptionValue("f"); }
		if (cmd.hasOption("jdbc-connection")) { inputJDBC = cmd.getOptionValue("s"); }
		if (cmd.hasOption("output-file")) { outFile = cmd.getOptionValue("o"); }
		if (cmd.hasOption("input-url")) { inputURL = cmd.getOptionValue("u"); }
		if (cmd.hasOption("rules")) { rulesFile = cmd.getOptionValue("r"); }
		if (cmd.hasOption("mixed-mode")) { mixed = true; }
		if (cmd.hasOption("special")) { special = true; }
		if (cmd.hasOption("verbose")) { verbose = true; }
		if (cmd.hasOption("warnings")) { warnings = true; }
		if (cmd.hasOption("parse-only")) { parseOnly = true; }
		if (cmd.hasOption("multi-graph")) { multiGraph = true; }
		if (cmd.hasOption("namespace")) { nameSpaces = true; }

		if (cmd.hasOption("help")) {
			org.apache.commons.cli.HelpFormatter formatter = new org.apache.commons.cli.HelpFormatter();
			formatter.printHelp("x2g [options] [input-file ...]", options);
			return;
		}

		// set rules file input, default: CharStream from Stadard Input
		CharStream input;
		if (rulesFile != null) {
			input = CharStreams.fromFileName(rulesFile);
		}
		else {
			input = CharStreams.fromStream(System.in);
		}
		// Lexer feeds off of input CharStream
		x2gLexer lexer = new x2gLexer(input);
		// Create buffer of tokens pulled from lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create symbol table with global scope
		SymbolTable symtab = new SymbolTable(false);
		// Create parser that feeds off of the token buffer
		x2gParser parser = new x2gParser(tokens, symtab, verbose);
		// Remove standard ErrorListener ConsoleErrorListener
		parser.removeErrorListeners();
		parser.addErrorListener(new ErrorListener());

		ParseTree tree = parser.x2g();	// begin parsing at init rule
		if (verbose) {
			System.err.println(x2g + " parse tree: " + tree.toStringTree(parser));	// print LISP-style tree
			System.err.println(x2g + " symbol table after parsing: " + symtab.toString());
		}
		
		if (parseOnly) {
			return;
		}

		final gGraph graph = new gGraph(verbose);
		final Evaluator eval = new Evaluator(symtab, graph, warnings, verbose);

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
		if (filelist.size() == 0) {
			System.err.println(x2g + ": no input files specified for processing!");
			System.exit(-1);
		}
		for (File file : filelist) {
			if (verbose) {
				System.err.println(x2g + ": processing xml file " + file.getAbsolutePath());
			}
			eval.setXtractor(file.getAbsolutePath(), nameSpaces);
			eval.visit(tree);
		}
		if (verbose) {
			System.err.println(x2g + ": symtab [[" + symtab.toString() + "]]");
			System.err.println(x2g + ": graph [[" + graph.toString() + "]]");
		}
		switch (outputFormat) {
			case "csv":
				csvExport ex = new csvExport();
				ex.export(graph, outFile, special);
				break;
			default:
				break;
		}
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet
