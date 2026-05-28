/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.entity.MetricEntity;

/**
 *
 * @author mokau
 */
@Local
public interface MetricEntityFacadeLocal {

    void create(MetricEntity metricEntity);

    void edit(MetricEntity metricEntity);

    void remove(MetricEntity metricEntity);

    MetricEntity find(Object id);
    String generateBatch();
    String evaluateInputAndBatch(String userInput, String genBatch);
    Integer calcEffeciency(Integer numPristine, Integer numTolerable, Integer totalBatches);

    List<MetricEntity> findAll();

    List<MetricEntity> findRange(int[] range);

    int count();
    
}
