package com.flp.fms.service;
import java.text.ParseException;

import com.flp.fms.Exceptions.DuplicateRecordException;
import com.flp.fms.Exceptions.FieldEmptyException;

import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.domain.Film;
import java.util.*;

public interface IFilmService {

	abstract  String addFilm(Map filmList) throws ParseException,  FieldEmptyException, NegativeFieldException, DuplicateRecordException;
	abstract   String modifyFilm(Map filmList);
	abstract boolean removeFilm(int filmId) throws FieldEmptyException, NegativeFieldException, RecordNotFoundException;
	abstract  Film searchFilm(int filmId) throws FieldEmptyException, NegativeFieldException, RecordNotFoundException;
	abstract List<Film> getAllFilms();
}
