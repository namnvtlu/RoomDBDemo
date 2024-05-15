package com.namnv.tlu.android.roomdbdemo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert (Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("DELETE FROM word_table WHERE word = :word")
    void deleteWord(String word);


    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

}
