package furrymatch.repository;

import furrymatch.domain.Chat;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Chat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {}
