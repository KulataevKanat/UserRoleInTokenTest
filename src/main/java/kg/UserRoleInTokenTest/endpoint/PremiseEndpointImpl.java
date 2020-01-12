package kg.UserRoleInTokenTest.endpoint;

import kg.UserRoleInTokenTest.dto.premise.PremiseDto;
import kg.UserRoleInTokenTest.dto.premise.PremiseRequest;
import kg.UserRoleInTokenTest.entity.Premise;
import kg.UserRoleInTokenTest.service.PremiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiseEndpointImpl implements PremiseEndpoint {
    @Autowired
    private PremiseService premiseService;

    @Override
    public PremiseDto addPremise(PremiseRequest premiseRequest) {
        Premise premise = new Premise();
        premise.setName(premiseRequest.getName());
        premiseService.addPremise(premise);
        return new PremiseDto(premise);
    }

    @Override
    public PremiseDto findById(Long id) {
        return new PremiseDto(premiseService.findPremiseById(id));
    }

    @Override
    public List<PremiseDto> findAll() {
        return PremiseDto.toList(premiseService.findAll());
    }
}
