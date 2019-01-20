package pl.evenit.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.evenit.server.entity.Event;
import pl.evenit.server.entity.MeetUpGroup;

@Repository
public interface MeetUpGroupRepository extends JpaRepository<MeetUpGroup, Long> {
    boolean existsByForeignId(String id);
}
