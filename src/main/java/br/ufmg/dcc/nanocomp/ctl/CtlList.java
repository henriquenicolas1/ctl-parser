package br.ufmg.dcc.nanocomp.ctl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CtlList extends CtlObject implements Iterable<CtlVariable<?>> {
	
	private static final long serialVersionUID = 1L;

	private List<CtlVariable<?>> values;

	public CtlList(List<CtlVariable<?>> values) {
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
		appendable.append("(list");
		for(CtlVariable<?> value : values) {
			appendable.append("\n");
			value.write(appendable);
		}
		appendable.append(")");
	}

}
