package br.ufmg.dcc.nanocomp.ctl;

import java.util.List;

public abstract class CtlFunction<T,A extends CtlVariable<Object>> extends CtlVariable<T> {
	
	private static final long serialVersionUID = 1L;
	
	private List<A> args;
	
	public CtlFunction(List<A> args) {
		super("function");
		this.args = args;
	}
	
	public List<A> getArgs() {
		return args;
	}

}
