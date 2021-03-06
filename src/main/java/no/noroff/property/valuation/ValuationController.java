package no.noroff.property.valuation;

import no.noroff.property.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ValuationController {

    @Autowired
    private ValuationRepository valuationRepository;

    @GetMapping ("/valuation")
    public ResponseEntity<List<Valuation>> getAll(){
        try{
             List<Valuation> valuation = valuationRepository.findAll();
             return new ResponseEntity<>(valuation, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/valuation")
    public ResponseEntity<Valuation> addValuation(@RequestBody Valuation valuation){
        try{
          valuationRepository.save(valuation);
          return new ResponseEntity<>(valuation, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
