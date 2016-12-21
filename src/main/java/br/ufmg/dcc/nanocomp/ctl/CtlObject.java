package br.ufmg.dcc.nanocomp.ctl;

import java.io.IOException;
import java.io.Serializable;

/**
 * A general class for all ctl objects.
 * This states that the objects are {@link Serializable} and writable
 * @author Jerônimo Nunes Rocha
 *
 */
public abstract class CtlObject implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract void write(Appendable appendable) throws IOException;
	
	@Override
	public String toString() {
		Appendable appendable = new StringBuilder();
		try {
			write(appendable);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return appendable.toString();
	}

}
