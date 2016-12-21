package br.ufmg.dcc.nanocomp.ctl;

import java.io.IOException;

public class CtlConstant<T> extends CtlVariable<T> {

	private static final long serialVersionUID = 1L;
	
	private T value;

	public CtlConstant(T value) {
		super("constant");
		this.value = value;
	}
	
	protected CtlConstant(String type, T value) {
		super(type);
		this.value = value;
	}
	
	public void write(Appendable appendable) throws IOException {
		appendable.append(getValue().toString());
	}
	
	@Override
	public T getValue() {
		return this.value;
	}

}
