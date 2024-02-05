package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.util.DateUtil;

public class UpdateNoteCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Note newNote;

		params = request.split("\n");

		String id = params[1].split("=")[0];
		if (id == null || id.isEmpty()) {
			throw new RuntimeException("ID is null.");
		}

		String title = params[2].split("=")[1];
		if (title == null || title.isEmpty()) {
			throw new RuntimeException("Title is null.");
		}

		String content = params[3].split("=")[1];
		if (content == null || content.isEmpty()) {
			throw new RuntimeException("Content is null.");
		}

		newNote = new Note();
		newNote.setId(Integer.parseInt(params[1].split("=")[1]));
		newNote.setTitle(params[2].split("=")[1]);
		newNote.setContent(params[3].split("=")[1]);

		if (params.length > 4) {
			
			Date date;
			try {date = DateUtil.toDate(params[4].split("=")[1]);
			newNote.setData(date);}
			catch (ParseException e) {
				return "Запись необновлена.";
			}
		}
		
		try {
			
			logic.add(newNote);
			response = "Запись обновлена успешно.";
		} catch (LogicException e) {
			response = "Что-то случилось.";
		}

		return response;
	}

}
