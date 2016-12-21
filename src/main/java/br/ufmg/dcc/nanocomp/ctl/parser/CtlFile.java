package br.ufmg.dcc.nanocomp.ctl.parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import br.ufmg.dcc.nanocomp.ctl.CtlObject;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public class CtlFile extends CtlObject {

	private static final long serialVersionUID = 1L;
	
	private List<? extends CtlVariable<?>> objects;
	private Map<String, ? extends CtlVariable<?>> variables;
	
	public CtlFile(List<? extends CtlVariable<?>> objects,
			Map<String,? extends CtlVariable<?>> variables) {
		this.objects = objects;
		this.variables = variables;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends CtlVariable<?>> T getVariable(String name) {
		return (T) variables.get(name);
	}
	
	public List<? extends CtlVariable<?>> getObjects() {
		return objects;
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		for(CtlObject obj : getObjects()) {
			obj.write(appendable);
			appendable.append("\n\n");
		}
	}

}
