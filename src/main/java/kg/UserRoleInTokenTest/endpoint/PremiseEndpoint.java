package kg.UserRoleInTokenTest.endpoint;

import kg.UserRoleInTokenTest.dto.premise.PremiseDto;
import kg.UserRoleInTokenTest.dto.premise.PremiseRequest;

import java.util.List;

public interface PremiseEndpoint {
    PremiseDto addPremise(PremiseRequest premiseRequest);

    PremiseDto findById(Long id);

    List<PremiseDto> findAll();
}
