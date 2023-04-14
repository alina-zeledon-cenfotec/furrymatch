package furrymatch.service;

import furrymatch.domain.Likee;
import furrymatch.repository.LikeeRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Likee}.
 */
@Service
@Transactional
public class LikeeService {

    private final Logger log = LoggerFactory.getLogger(LikeeService.class);

    private final LikeeRepository likeeRepository;

    public LikeeService(LikeeRepository likeeRepository) {
        this.likeeRepository = likeeRepository;
    }

    /**
     * Save a likee.
     *
     * @param likee the entity to save.
     * @return the persisted entity.
     */
    public Likee save(Likee likee) {
        log.debug("Request to save Likee : {}", likee);
        return likeeRepository.save(likee);
    }

    /**
     * Update a likee.
     *
     * @param likee the entity to save.
     * @return the persisted entity.
     */
    public Likee update(Likee likee) {
        log.debug("Request to update Likee : {}", likee);
        return likeeRepository.save(likee);
    }

    /**
     * Partially update a likee.
     *
     * @param likee the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Likee> partialUpdate(Likee likee) {
        log.debug("Request to partially update Likee : {}", likee);

        return likeeRepository
            .findById(likee.getId())
            .map(existingLikee -> {
                if (likee.getLikeState() != null) {
                    existingLikee.setLikeState(likee.getLikeState());
                }

                return existingLikee;
            })
            .map(likeeRepository::save);
    }

    /**
     * Get all the likees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Likee> findAll(Pageable pageable) {
        log.debug("Request to get all Likees");
        return likeeRepository.findAll(pageable);
    }

    /**
     * Get one likee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Likee> findOne(Long id) {
        log.debug("Request to get Likee : {}", id);
        return likeeRepository.findById(id);
    }

    /**
     * Delete the likee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Likee : {}", id);
        likeeRepository.deleteById(id);
    }
}
