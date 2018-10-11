package ro.sda.hypermarket.core.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    /**
     * * Search record by id.
     *
     * @param id The id of the requested record
     * @return The record with the specified id.
     *
     * @since 25 sept. 2018
     */
    public T findById(long id);
}
