package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.util.DateUtil;

public class FindDateCommand implements Command {
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		
		Date date;
		
		params = request.split("\n");
		try {
			date = DateUtil.toDate(params[1].split("=")[1]);
			return logic.find(date).toString();
		} catch (ParseException e) {
			response = "Ошибка поиска.";
		} catch(LogicException e) {
			response = "Что-то пошло не так.";
		}

		return response;
	}

}
