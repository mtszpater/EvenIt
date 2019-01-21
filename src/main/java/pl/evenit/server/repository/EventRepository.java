package pl.evenit.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.evenit.server.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existsByForeignId(String id);

    Event getOneByForeignId(String id);
}
