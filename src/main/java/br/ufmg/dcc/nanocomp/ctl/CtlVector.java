package br.ufmg.dcc.nanocomp.ctl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CtlVector extends CtlObject implements Iterable<CtlVariable<?>> {

	private static final long serialVersionUID = 1L;

	private List<CtlVariable<?>> values;

	public CtlVector(List<CtlVariable<?>> values) {
		this.values = values;
	}
	
	public CtlVariable<?> get(int index) {
		return this.values.get(index);
	}
	
	@Override
	public Iterator<CtlVariable<?>> iterator() {
		return this.values.iterator();
	}

	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append("(vector");
		for(CtlVariable<?> value : values) {
			appendable.append(" ");
			value.write(appendable);
		}
		appendable.append(")");
	}

}
