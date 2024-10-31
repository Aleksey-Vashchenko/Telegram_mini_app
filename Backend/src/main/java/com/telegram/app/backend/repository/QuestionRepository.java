package com.telegram.app.backend.repository;

import com.telegram.app.backend.core.enums.ActionType;
import com.telegram.app.backend.core.enums.Gender;
import com.telegram.app.backend.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Action,Integer> {

    @Query(value = "select a from Action a " +
            "where a.actionsPackage.id between :levelFrom and :levelTo " +
            "and a.actionType = :actionType " +
            "and a.doer in (:doer) " +
            "and a.target in (:target) " +
            "and a.actionsPackage.id in (:packages) " +
            "order by function('random')")
    Optional<Action> findSingleAction(@Param("levelFrom") Short levelFrom, @Param("levelTo") Short levelTo,
                                      @Param("doer") Set<Gender> doer, @Param("target") Set<Gender> target,
                                      @Param("packages") List<Short> packages,@Param("actionType") ActionType type);

    // Метод для поиска вопроса с target, подходящим из множества
    // Метод для поиска вопроса с target, подходящим из списка
//    @Query(value = "SELECT a FROM Action a WHERE a.level BETWEEN :levelFrom AND :levelTo " +
//            "AND CAST(JSON_EXTRACT(a.tagsJson, '$.tags.target') AS string) IN :targets " +
//            "ORDER BY FUNCTION('RAND')")
//    Optional<Action> findPairedAction(@Param("levelFrom") Short levelFrom,
//                                      @Param("levelTo") Short levelTo,
//                                      @Param("targets") Set<Gender> targets);
}
