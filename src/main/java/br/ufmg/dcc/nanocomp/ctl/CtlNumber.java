package br.ufmg.dcc.nanocomp.ctl;

public abstract class CtlNumber<T> extends CtlConstant<T> {

	private static final long serialVersionUID = 1L;

	public CtlNumber(T value) {
		super("number",value);
	}

}
