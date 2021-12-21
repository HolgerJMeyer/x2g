//package grafl;

import org.antlr.v4.runtime.*;

public class graflErrorListener extends BaseErrorListener {
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object sym, int line, int pos, String msg, RecognitionException e)
	{
		List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		System.err.println("grafl rule stack: "+stack);
		System.err.println("line "+line+" char pos "+pos+" at "+sym+": "+msg);
	}
}
