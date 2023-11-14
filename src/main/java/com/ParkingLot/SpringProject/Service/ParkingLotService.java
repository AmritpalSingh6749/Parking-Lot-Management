package com.ParkingLot.SpringProject.Service;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.Repository.ParkingLotRepository;
import com.ParkingLot.SpringProject.dtos.UpdateParkingLotRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {
    private ParkingLotRepository repository;

    public ParkingLot getParkingLot(Long id) {
        return repository.fetch(id);
    }

    public void create(ParkingLot request) {
        repository.save(request);
    }

    public ParkingLot update(UpdateParkingLotRequest request, Long id){
        return  repository.update(request, id);
    }

    public void delete(long id) {
        repository.delete(id);
    }
}
