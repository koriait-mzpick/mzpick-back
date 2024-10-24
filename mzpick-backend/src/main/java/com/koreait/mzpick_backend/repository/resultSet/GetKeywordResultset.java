package com.koreait.mzpick_backend.repository.resultSet;

import java.time.LocalDate;

public interface GetKeywordResultset {
    String getKeywordContent();
    String getUserId();
    LocalDate getKeywordDate();
}
