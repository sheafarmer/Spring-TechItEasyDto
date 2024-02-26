package nl.novi.techiteasydto.mappers;

import nl.novi.techiteasydto.models.ResponseTelevisionDto;
import nl.novi.techiteasydto.models.Television;
import org.springframework.stereotype.Service;

@Service
public class TelevisionDtoMapper {

    //MAPPER
    private ResponseTelevisionDto toDto(Television television){
        ResponseTelevisionDto dto = new ResponseTelevisionDto();
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setType(television.getType());
        dto.setPrice(television.getPrice());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setScreenType(television.getScreenType());
        dto.setSmartTv(television.getSmartTv());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setWifi(television.getWifi());
        return dto;
    }
}
