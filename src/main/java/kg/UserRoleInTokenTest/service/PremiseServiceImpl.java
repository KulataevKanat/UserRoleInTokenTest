package kg.UserRoleInTokenTest.service;

import kg.UserRoleInTokenTest.entity.Premise;
import kg.UserRoleInTokenTest.repository.PremiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiseServiceImpl implements PremiseService{
    @Autowired
    private PremiseRepository premiseRepository;

    @Override
    public Premise addPremise(Premise premise) {
        return premiseRepository.save(premise);
    }

    @Override
    public Premise findPremiseById(Long id) {
        return premiseRepository.findById(id).get();
    }

    @Override
    public List<Premise> findAll() {
        return premiseRepository.findAll();
    }
}
