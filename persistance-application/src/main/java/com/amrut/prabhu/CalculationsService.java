package com.amrut.prabhu;

import com.amrut.prabhu.repository.CalculationsRepository;
import com.amrut.prabhu.repository.DataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CalculationsService {

    @Autowired
    DataRepository dataRepository;
    @Autowired
    CalculationsRepository calculationsRepository;

    @Transactional
    public BigDecimal calculate(BigDecimal value) throws InterruptedException {
        Data data = new Data();
        Optional<Data> firstByDateAscData = dataRepository.findFirstByOrderByDateDesc();

        if (firstByDateAscData.isPresent()) {
            data.setCumulative(firstByDateAscData.get().getCumulative());
        }
        data.setValue(value);
        data.setCumulative(data.getCumulative().add(value));
        data.setDate(LocalDate.now());
        dataRepository.save(data);

        Optional<Calculations> referenceById = calculationsRepository.findById(1l);
        referenceById.get().setTotal(data.getCumulative());
        Thread.sleep(value.longValue()*1000);
        return referenceById.get().getTotal();
    }
}
