package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.entity.RTable;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RTableRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RTableService {

    private RTableRepository rTableRepository;

    public List<RTable> getRTables(){
        return rTableRepository.findAll();
    };

    public Optional<RTable> getRTableById(Long id){
        return rTableRepository.findById(id);
    };

    public RTable addRTable(RTable rTable) {
        List<RTable> rTableList = rTableRepository.findAll();

//        if (rTableList.stream().map(RTable::getEnglishName).anyMatch(rTable.getEnglishName()::equals) || rTableList.stream().map(RTable::getPolishName).anyMatch(rTable.getPolishName()::equals))
//            throw new RuntimeException("RTable with this name already exists.");

        return rTableRepository.save(rTable);
    }

    public void updateRTable(Long id, RTable rTable) {

        Optional<RTable> oldRTable = rTableRepository.findById(id);
        if(!oldRTable.isPresent())
            throw new RuntimeException("RTable with id " + id + "does not exist");
        else{
            rTable.setRTableId(id);
            rTableRepository.save(rTable);
        }

    }

    public void deleteRTableById(Long id){
        rTableRepository.deleteById(id);
    }

}
