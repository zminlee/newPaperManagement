package com.ecust.Dao;

import com.ecust.Entity.Paper.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorDao {
    public List<Author> getAuthor(@Param("AuthorID") String AuthorID, @Param("AuthorName") String AuthorName);

    public void AddAuthor(@Param("AuthorID") String AuthorID, @Param("AuthorName") String AuthorName);

    public void DeleteAuthor(@Param("AuthorID") String AuthorID, @Param("AuthorName") String AuthorName);

    public void UpdateAuthor(@Param("AuthorID") String AuthorID, @Param("AuthorName") String AuthorName);
}
