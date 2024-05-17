package model.mapper;

import model.dto.DivisaDto;
import model.entity.DivisaEntity;

public class ConvertToEntity {

    private DivisaEntity divisaEntity = new DivisaEntity();
    public ConvertToEntity(DivisaDto divisaDto) {

        this.divisaEntity.setBaseCode(divisaDto.base_code());
        this.divisaEntity.setARS(divisaDto.conversion_rates().ARS());
        this.divisaEntity.setCAD(divisaDto.conversion_rates().CAD());
        this.divisaEntity.setEUR(divisaDto.conversion_rates().EUR());
        this.divisaEntity.setJPY(divisaDto.conversion_rates().JPY());
        this.divisaEntity.setMXN(divisaDto.conversion_rates().MXN());
        this.divisaEntity.setUSD(divisaDto.conversion_rates().USD());

    }

    public DivisaEntity getDivisaEntity() {
        return divisaEntity;
    }
}
