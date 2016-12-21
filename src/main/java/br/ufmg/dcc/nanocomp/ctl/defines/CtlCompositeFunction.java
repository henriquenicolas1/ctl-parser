package br.ufmg.dcc.nanocomp.ctl.defines;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import br.ufmg.dcc.nanocomp.ctl.CtlObject;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public class CtlCompositeFunction<T> extends CtlDeclaredFunction<T> {

	private static final long serialVersionUID = 1L;
	private CtlDeclaredFunction<T> innerFunction;
	
	public CtlCompositeFunction(CtlDeclaredFunction<T> innerFunction ,List<CtlVariable<Object>> args) {
		super(args);
		this.innerFunction = innerFunction;
	}
	
	@Override
	public T getValue() {
		return innerFunction.getValue(getArgs().stream());
	}
	
	@Override
	public T getValue(Stream<? extends CtlVariable<Object>> stream) {
		return innerFunction.getValue(Stream.concat(stream, this.getArgs().stream()));
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append("(");
		innerFunction.write(appendable);
		for(CtlObject obj : getArgs()) {
			appendable.append(" ");
			obj.write(appendable);
		}
		appendable.append(")");
	}

}
