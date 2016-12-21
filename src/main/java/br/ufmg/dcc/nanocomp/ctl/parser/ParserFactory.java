package br.ufmg.dcc.nanocomp.ctl.parser;


import java.util.Scanner;

import br.ufmg.dcc.nanocomp.peg.PEG;
import br.ufmg.dcc.nanocomp.peg.Parser;

public class ParserFactory {

	private Parser<CtlFile> parser;
	private String source;
	private static ParserFactory instance = new ParserFactory();

	/**
	 * This class will be a Singleton, when constructing it will read the Grammars and compile the scripts
	 */
	@SuppressWarnings("unchecked")
	private ParserFactory() {
		try (Scanner grammar = new Scanner(ParserFactory.class.getResourceAsStream("/CtlGrammar.peg"))){
			parser = PEG.getInstance().generate(grammar.useDelimiter("\\Z").next(),Parser.class);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * Method to recover the Singleton
	 * @return
	 */
	public static ParserFactory getInstance() {
		return instance;
	}

	public Parser<CtlFile> getParser() {
		return parser;
	}

	public String getSource() {
		return source;
	}

}
