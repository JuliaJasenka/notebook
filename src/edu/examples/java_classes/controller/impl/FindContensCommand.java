package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class FindContensCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		String contents;

		params = request.split("\n");
		contents = params[1].split("=")[1];

		try {
			return logic.find(contents).toString();
		} catch (LogicException e) {
			response = "Ошибка поиска.";
		}
		
		return response;
	}

}
