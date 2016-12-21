package br.ufmg.dcc.nanocomp.ctl.defines;

import java.io.IOException;

import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public class CtlDeclaredVariable extends CtlVariable<Object> {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private CtlVariable<?> value;
	
	public CtlDeclaredVariable(String name) {
		super("declared-variable");
		this.name = name;
	}
	
	public CtlDeclaredVariable(String name,CtlVariable<?> defaultValue) {
		this(name);
		this.value = defaultValue;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(CtlVariable<?> value) {
		this.value = value;
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append(getName());
	}

	@Override
	public Object getValue() {
		if(this.value!=null) {
			return this.value.getValue();
		} else {
			throw new RuntimeException("Variable "+this.toString()+" does not have a default value");
		}
	}
}
