package br.ufmg.dcc.nanocomp.ctl.functions;

import java.util.List;

import br.ufmg.dcc.nanocomp.ctl.CtlVariable;
import br.ufmg.dcc.nanocomp.ctl.defines.CtlSimpleFunction;
import br.ufmg.dcc.nanocomp.ctl.number.Complex;

public class Sum<T> extends CtlSimpleFunction<T> {

	private static final long serialVersionUID = 1L;

	public Sum(List<CtlVariable<Object>> args) {
		super("+", args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getValue() {
		try {
			int v = 0;
			for(CtlVariable<Object> variable : getArgs()) {
				v += (int) variable.getValue();
			}
			return (T) Integer.valueOf(v);
		} catch (ClassCastException e) {
			try {
				double v = 0;
				for(CtlVariable<Object> variable : getArgs()) {
					v += ((Number) variable.getValue()).doubleValue();
				}
				return (T) Double.valueOf(v);
			} catch (ClassCastException f) {
				Complex v = Complex.ZERO;
				for(CtlVariable<Object> variable : getArgs()) {
					v = v.sum(Complex.valueOf(variable.getValue()));
				}
				return (T) v;
			}
		}
	}

}
