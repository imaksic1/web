package com.maxa.web.dto;

import com.maxa.web.model.AssembleComputer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface  AssembleCopmuterMapper {

//    AssembleCopmuterMapper INSTANCE = Mappers.getMapper( AssembleCopmuterMapper.class );

    @Mappings({
            @Mapping(source = "computer.computerName", target = "computerName"),
            @Mapping(source = "computer.price", target = "computerPrice"),
            @Mapping(source = "computerParts.partType", target = "partType"),
            @Mapping(source = "computerParts.price", target = "partPrice"),
            @Mapping(source = "computerParts.producer", target = "partProducer")
    })
    AssembleComputerDTO assembleToAssembleDTO(AssembleComputer assembleComputer);

    List<AssembleComputerDTO> assembleToAssembleDTO(List<AssembleComputer> assembleComputer);

}
