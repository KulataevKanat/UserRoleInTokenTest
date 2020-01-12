package kg.UserRoleInTokenTest.service;

import kg.UserRoleInTokenTest.entity.Premise;

import java.util.List;

public interface PremiseService {
    Premise addPremise(Premise premise);

    Premise findPremiseById(Long id);

    List<Premise> findAll();
}
