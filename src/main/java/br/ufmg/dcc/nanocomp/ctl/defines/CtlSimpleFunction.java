package br.ufmg.dcc.nanocomp.ctl.defines;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import br.ufmg.dcc.nanocomp.ctl.CtlObject;
import br.ufmg.dcc.nanocomp.ctl.CtlVariable;

public class CtlSimpleFunction<T> extends CtlDeclaredFunction<T> {

	private static final long serialVersionUID = 1L;

	private String name;
	private CtlFunctionDeclaration<T> declaration;
	
	public CtlSimpleFunction(String name, List<CtlVariable<Object>> args) {
		super(args);
		this.name = name;
	}
	
	public CtlSimpleFunction(String name, List<CtlVariable<Object>> args,CtlFunctionDeclaration<T> declaration) {
		this(name,args);
		this.declaration = declaration;
	}
	
	@Override
	public void write(Appendable appendable) throws IOException {
		appendable.append("(").append(getName());
		for(CtlObject obj : getArgs()) {
			appendable.append(" ");
			obj.write(appendable);
		}
		appendable.append(")");
	}
	
	@Override
	public T getValue() {
		if(this.declaration!=null) {
			this.declaration.fillArgs(getArgs().iterator());
			return this.declaration.getValue();
		}
		throw new RuntimeException("Function "+getName()+" haven't being declared");
	}
	
	@Override
	public T getValue(Stream<? extends CtlVariable<Object>> stream) {
		if(this.declaration!=null) {
			this.declaration.fillArgs(Stream.concat(stream, this.getArgs().stream()).iterator());
			return this.declaration.getValue();
		}
		throw new RuntimeException("Function "+getName()+" haven't being declared");
	}
	
	
	public String getName() {
		return name;
	}
}
