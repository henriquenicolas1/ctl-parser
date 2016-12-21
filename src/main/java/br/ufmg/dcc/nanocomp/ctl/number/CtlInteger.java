package br.ufmg.dcc.nanocomp.ctl.number;

import br.ufmg.dcc.nanocomp.ctl.CtlNumber;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public class CtlInteger extends CtlNumber<Integer> {

	private static final long serialVersionUID = 1L;
	
	public static final CtlVariable<?> ZERO = new CtlInteger(0);

	public CtlInteger(String value) {
		super(Integer.valueOf(value));
	}
	
	public CtlInteger(Number value) {
		super(value.intValue());
	}
	
}
