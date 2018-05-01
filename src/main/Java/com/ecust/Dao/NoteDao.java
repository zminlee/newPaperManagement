package com.ecust.Dao;

import com.ecust.Entity.Paper.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteDao {
    public List<Note> getKey(@Param("NoteID") String NoteID, @Param("NoteInfo") String NoteInfo);

    public void AddNote(@Param("NoteID") String NoteID, @Param("NoteInfo") String NoteInfo);

    public void DeleteNote(@Param("NoteID") String NoteID, @Param("NoteInfo") String NoteInfo);

    public void UpdateNote(@Param("NoteID") String NoteID, @Param("NoteInfo") String NoteInfo);
}
