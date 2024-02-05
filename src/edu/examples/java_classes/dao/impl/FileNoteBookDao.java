package edu.examples.java_classes.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.util.DateUtil;

public class FileNoteBookDao implements NoteBookDao {
	private static final Path RESOURCES_PATH = Path.of("resources", "notes.txt");

	public FileNoteBookDao() {

	}

	@Override
	public void save(Note n) throws DaoException {

		try (FileWriter fileWriter = new FileWriter(RESOURCES_PATH.toString(), true)) {
			fileWriter.append(n.toString() + System.lineSeparator());

		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException {
		try {
			List<String> strings = Files.readAllLines(RESOURCES_PATH);
			List<Note> noteList = new ArrayList<>();
			for (String line : strings) {
				line = line.replace("Note [", "").replace("]", "");

				String[] split = line.split(", ");

				Note note = new Note();
				note.setId(Integer.parseInt(split[0].split("=")[1]));
				note.setTitle(split[1].split("=")[1]);
				note.setContent(split[2].split("=")[1]);

				if (!split[3].contains("null")) {
					note.setData(DateUtil.toDate(split[3].split("=")[1]));
				}
				noteList.add(note);
			}
			return noteList;

		} catch (IOException | ParseException e) {
			throw new DaoException(e);
		}

	}
}
