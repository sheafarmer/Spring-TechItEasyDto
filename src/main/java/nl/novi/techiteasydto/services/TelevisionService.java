package nl.novi.techiteasydto.services;

import nl.novi.techiteasydto.mappers.TelevisionDtoMapper;
import nl.novi.techiteasydto.models.ResponseTelevisionDto;
import nl.novi.techiteasydto.models.Television;
import nl.novi.techiteasydto.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository, TelevisionDtoMapper toDto) {
        this.televisionRepository = televisionRepository;
        this.toDto = toDto;
    }



    //GET ONE TELEVISION DTO WITH MAPPER

    public ResponseTelevisionDto getTelevisionDto(Long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()) {
            throw new RuntimeException("No Tv With Id");
        } else {
            return toDto(optionalTelevision.get());
        }
    }

    //GET ALL TELEVISIONS IN DTO
    public List<ResponseTelevisionDto> getTelevisionsDto(){
        List<Television> televisions = televisionRepository.findAll();
        List<ResponseTelevisionDto> televisionDtos = new ArrayList<>();

        for (Television television : televisions) {
            ResponseTelevisionDto dto = toDto(television);
            televisionDtos.add(dto);
        }

        return televisionDtos;
    }

    //SAVES THE DTO TELEVISION
    public void saveTelevisionDto (RequestTelevisionDto dto){
        Television television = new Television();
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setType(dto.getType());
        television.setPrice(dto.getPrice());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenQuality(dto.getScreenQuality());
        television.setScreenType(dto.getScreenType());
        television.setSmartTv(dto.getSmartTv());
        television.setVoiceControl(dto.getVoiceControl());
        television.setWifi(dto.getWifi());
        televisionRepository.save(television);
    }

}
