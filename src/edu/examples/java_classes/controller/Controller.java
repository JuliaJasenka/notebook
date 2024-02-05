package edu.examples.java_classes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class Controller {
	private final char paramDelimeter = '\n';
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {
				
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName.toUpperCase());
		
		String response;
		response = executionCommand.execute(request);
		
		return response;

	}

}


