package com.group_sessions.repository;


import com.group_sessions.entity.Geolocation;
import com.group_sessions.entity.Session;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long>, JpaSpecificationExecutor<Session> {

    List<Session> findAll();

    List<Session> findAllByHabit_Id(Long habitId);




//    @Query("select j from sessions j")
//            + " join geolocation g on s.geolocation_id = g.id"
//            +" where g.longitude between :longitudeSW and longitudeNE " +
//            "and g.latitude between :latitudeSW and :latitudeNE")
//            + " where expired > :now and status = 2 and top = 1"
//            + " order by published DESC nulls last")
@Query("select j from Session j"
        + " join j.geolocation g"
        + " where g.longitude between :longitudeSW and :longitudeNE" +
        " and g.latitude between :latitudeSW and :latitudeNE")
    List<Session> findWIthGeolocation(@Param("longitudeNE") double longitudeNE,
                                       @Param("latitudeNE") double latitudeNE,
                                       @Param("longitudeSW") double longitudeSW,
                                       @Param("latitudeSW") double latitudeSW
    );
    
}
