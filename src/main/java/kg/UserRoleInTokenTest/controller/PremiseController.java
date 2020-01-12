package kg.UserRoleInTokenTest.controller;

import kg.UserRoleInTokenTest.dto.premise.PremiseDto;
import kg.UserRoleInTokenTest.dto.premise.PremiseRequest;
import kg.UserRoleInTokenTest.endpoint.PremiseEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premise")
public class PremiseController {
    @Autowired
    private PremiseEndpoint premiseEndpoint;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PremiseDto addPremise(@RequestBody PremiseRequest premiseRequest) {
        return premiseEndpoint.addPremise(premiseRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PremiseDto findById(@PathVariable Long id) {
        return premiseEndpoint.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PremiseDto> findAll() {
        return premiseEndpoint.findAll();
    }
}
