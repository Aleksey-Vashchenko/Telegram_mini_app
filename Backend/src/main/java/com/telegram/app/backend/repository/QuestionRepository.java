package com.telegram.app.backend.repository;

import com.telegram.app.backend.core.enums.Gender;
import com.telegram.app.backend.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Action,Integer> {

    @Query(value = "SELECT a FROM Action a WHERE a.level BETWEEN :levelFrom AND :levelTo " +
            "AND JSON_EXTRACT(a.tagsJson, '$.tags.target') = 'none' " +
            "ORDER BY FUNCTION('RAND')")
    Optional<Action> findSingleAction(@Param("levelFrom") Short levelFrom, @Param("levelTo") Short levelTo);

    Optional<Action> findPairedAction(@Param("levelFrom") Short levelFrom,
                                      @Param("levelTo") Short levelTo,
                                      @Param("targets") Set<Gender> targets);
}
