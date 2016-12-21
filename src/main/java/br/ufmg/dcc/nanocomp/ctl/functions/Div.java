package br.ufmg.dcc.nanocomp.ctl.functions;

import java.util.Iterator;
import java.util.List;

import br.ufmg.dcc.nanocomp.ctl.CtlVariable;
import br.ufmg.dcc.nanocomp.ctl.defines.CtlSimpleFunction;
import br.ufmg.dcc.nanocomp.ctl.number.Complex;

public class Div<T> extends CtlSimpleFunction<T> {

	private static final long serialVersionUID = 1L;

	public Div(List<CtlVariable<Object>> args) {
		super("/", args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getValue() {
		try {
			Iterator<CtlVariable<Object>> iterator = getArgs().iterator();
			int v = (int) iterator.next().getValue();
			if(iterator.hasNext()) {
				while(iterator.hasNext()) {
					v /= (int) iterator.next().getValue();
				}
				return (T) Integer.valueOf(v);
			} else {
				return (T) Integer.valueOf(1/v);
			}
		} catch (ClassCastException e) {
			try {
				Iterator<CtlVariable<Object>> iterator = getArgs().iterator();
				double v = (double) iterator.next().getValue();
				if(iterator.hasNext()) {
					while(iterator.hasNext()) {
						v /= (double) iterator.next().getValue();
					}
					return (T) Double.valueOf(v);
				} else {
					return (T) Double.valueOf(1d/v);
				}
			} catch (ClassCastException f) {
				Iterator<CtlVariable<Object>> iterator = getArgs().iterator();
				Complex v = Complex.valueOf(iterator.next().getValue());
				if(iterator.hasNext()) {
					while(iterator.hasNext()) {
						v = v.div(Complex.valueOf(iterator.next().getValue()));
					}
					return (T) v;
				} else {
					return (T) Complex.ONE.div(v);
				}
			}
		}
	}

}
