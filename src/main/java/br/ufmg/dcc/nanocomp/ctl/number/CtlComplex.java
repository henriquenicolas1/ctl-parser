package br.ufmg.dcc.nanocomp.ctl.number;

import br.ufmg.dcc.nanocomp.ctl.CtlNumber;

public class CtlComplex extends CtlNumber<Complex> {

	private static final long serialVersionUID = 1L;

	public CtlComplex(Double real, Double imaginary){
		super(new Complex(real, imaginary));
	}
	
}
