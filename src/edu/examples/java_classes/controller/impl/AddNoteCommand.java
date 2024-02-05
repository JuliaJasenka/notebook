package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.util.DateUtil;

public class AddNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Note newNote;

		params = request.split("\n");

		String title = params[1].split("=")[1];
		if (title == null || title.isEmpty()) {
			throw new RuntimeException("Title is null.");
		}

		String content = params[2].split("=")[1];
		if (content == null || content.isEmpty()) {
			throw new RuntimeException("Content is null.");
		}

		newNote = new Note();
		newNote.setTitle(title);
		newNote.setContent(content);

		if (params.length > 3) {
			Date date;
			try {
				date = DateUtil.toDate(params[3].split("=")[1]);
				newNote.setData(date);
			} catch (ParseException e) {
			}
		}

		try {
			logic.add(newNote);
			response = "Запись сохранена успешно.";
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}

		return response;
	}

}
