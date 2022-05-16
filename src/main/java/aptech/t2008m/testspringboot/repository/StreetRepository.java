package aptech.t2008m.testspringboot.repository;

import aptech.t2008m.testspringboot.entity.Street;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {
    Page<Street> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM streets s WHERE s.name like %: name% and s.district = district ",
            nativeQuery = true)
    List<Street> search(@Param("name") String name, @Param("district") Integer district);

    List<Street> findAllByNameContainsAndDistrictContains(String name, Integer district);


}
