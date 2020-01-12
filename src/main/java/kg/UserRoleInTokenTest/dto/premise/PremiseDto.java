package kg.UserRoleInTokenTest.dto.premise;

import kg.UserRoleInTokenTest.entity.Premise;

import java.util.LinkedList;
import java.util.List;

public class PremiseDto {
    private Long id;
    private String name;

    public PremiseDto(Premise premise) {
        this.id = premise.getId();
        this.name = premise.getName();
    }

    public static List<PremiseDto> toList(List<Premise> list) {
        List<PremiseDto> result = new LinkedList<>();
        for (Premise premise : list) {
            result.add(new PremiseDto(premise));
        }
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
