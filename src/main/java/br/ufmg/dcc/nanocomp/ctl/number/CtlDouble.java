package br.ufmg.dcc.nanocomp.ctl.number;

import java.io.IOException;

import br.ufmg.dcc.nanocomp.ctl.CtlNumber;

public class CtlDouble extends CtlNumber<Double> {

	private static final long serialVersionUID = 1L;

	public CtlDouble(String value) {
		super(Double.valueOf(value));
	}
	
	public CtlDouble(Number value){
		super(value.doubleValue());
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		if(getValue().isNaN()) {
			appendable.append("no-size");
		} else if(getValue().isInfinite()) {
			appendable.append("infinity");
		} else {
			appendable.append(getValue().toString());
		}
	}

}
