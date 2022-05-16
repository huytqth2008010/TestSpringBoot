package aptech.t2008m.testspringboot.service;

import aptech.t2008m.testspringboot.entity.Street;
import aptech.t2008m.testspringboot.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    public Page<Street> findAll(int page, int limit) {
        return streetRepository.findAll(
                PageRequest.of(page - 1, limit));
    }

    public List<Street> findByStreetAnDistrict (String name, int districtId) {
        if (districtId==0){
            return streetRepository.findByInfo(name);
        }
        return streetRepository.findByInfo(name,districtId);
    }
    public Optional<Street> findById(Integer id) {
        return streetRepository.findById(id);
    }

    public Street save(Street street) {
        return streetRepository.save(street);
    }

    public void deleteById(Integer id) {
        streetRepository.deleteById(id);
    }
}
