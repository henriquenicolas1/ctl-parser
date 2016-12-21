package br.ufmg.dcc.nanocomp.ctl.defines;

import java.util.List;
import java.util.stream.Stream;

import br.ufmg.dcc.nanocomp.ctl.CtlFunction;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public abstract class CtlDeclaredFunction<T> extends CtlFunction<T,CtlVariable<Object>> {

	private static final long serialVersionUID = 1L;

	public CtlDeclaredFunction(List<CtlVariable<Object>> args) {
		super(args);
	}

	public abstract T getValue(Stream<? extends CtlVariable<Object>> stream);

}
