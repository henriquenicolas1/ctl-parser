package br.ufmg.dcc.nanocomp.ctl.defines;

import java.util.Iterator;
import java.util.List;

import br.ufmg.dcc.nanocomp.ctl.CtlFunction;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public abstract class CtlFunctionDeclaration<T> extends CtlFunction<T,CtlDeclaredVariable> {
	
	private static final long serialVersionUID = 1L;
	
	private CtlVariable<T> body;

	public CtlFunctionDeclaration(List<CtlDeclaredVariable> args) {
		super(args);
	}
	
	public abstract void fillArgs(Iterator<? extends CtlVariable<Object>> values);

	public CtlVariable<T> getBody() {
		return body;
	}
	
	public void setBody(CtlVariable<T> body) {
		this.body = body;
	}

	@Override
	public T getValue() {
		return getBody().getValue();
	}
}
