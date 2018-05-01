package com.ecust.Dao;

import com.ecust.Entity.Paper.Key;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeyDao {
    public List<Key> getKey(@Param("KeyID") String KeyID, @Param("KeyInfo") String KeyInfo);

    public void AddKey(@Param("KeyID") String KeyID, @Param("KeyInfo") String KeyInfo);

    public void DeleteKey(@Param("KeyID") String KeyID, @Param("KeyInfo") String KeyInfo);

    public void UpdateKey(@Param("KeyID") String KeyID, @Param("KeyInfo") String KeyInfo);
}