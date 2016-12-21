package br.ufmg.dcc.nanocomp.ctl.defines;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import br.ufmg.dcc.nanocomp.ctl.CtlObject;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public class CtlCompositeFunctionDeclaration<T> extends CtlFunctionDeclaration<T> {
	
	private static final long serialVersionUID = 1L;
	private CtlFunctionDeclaration<T> innerFunction;

	public CtlCompositeFunctionDeclaration(CtlFunctionDeclaration<T> innerFunction, List<CtlDeclaredVariable> args) {
		super(args);
		this.innerFunction = innerFunction;
	}
	
	@Override
	public void fillArgs(Iterator<? extends CtlVariable<Object>> values) {
		for(CtlDeclaredVariable arg : (List<CtlDeclaredVariable>)getArgs()) {
			arg.setValue(values.next());
		}
		this.innerFunction.fillArgs(values);
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append("(");
		this.innerFunction.write(appendable);
		for(CtlObject obj : getArgs()) {
			appendable.append(" ");
			obj.write(appendable);
		}
		appendable.append(")");
	}

}
