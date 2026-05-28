/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Random;
import za.ac.tut.entity.MetricEntity;

/**
 *
 * @author mokau
 */
@Stateless
public class MetricEntityFacade extends AbstractFacade<MetricEntity> implements MetricEntityFacadeLocal {

    @PersistenceContext(unitName = "ExamFastMoveLogisticsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MetricEntityFacade() {
        super(MetricEntity.class);
    }

    @Override
    public String generateBatch() {
        String batch="";
        Random ran = new Random();
        
        for(int x=0; x<8; x++)
        {
         Integer letterGen = ran.nextInt(26)+1;
         if(x<2 || x==4 || x==6)
         {
          switch(letterGen)
          {
            case 1: batch += "" + "A";break;
            case 2: batch += "" + "B";break;
            case 3: batch += "" + "C";break;
            case 4: batch += "" + "D";break;
            case 5: batch += "" + "E";break;
            case 6: batch += "" + "F";break;
            case 7: batch += "" + "G";break;
            case 8: batch += "" + "H";break;
            case 9: batch += "" + "I";break;
            case 10: batch += "" + "J";break;
            case 11: batch += "" + "K";break;
            case 12: batch += "" + "L";break;
            case 13: batch += "" + "M";break;
            case 14: batch += "" + "N";break;
            case 15: batch += "" + "O";break;
            case 16: batch += "" + "P";break;
            case 17: batch += "" + "Q";break;
            case 18: batch += "" + "R";break;
            case 19: batch += "" + "S";break;
            case 20: batch += "" + "T";break;
            case 21: batch += "" + "U";break;
            case 22: batch += "" + "V";break;
            case 23: batch += "" + "W";break;
            case 24: batch += "" + "X";break;
            case 25: batch += "" + "Y";break;
            case 26: batch += "" + "Z";break;
            default:;break;
          }
         }
         if((x>=2 && x<4) || x==5 || x==7)
         {
              Integer numGen = ran.nextInt(9)+0;
              batch+= "" + numGen;
         }
         
        }
        return batch;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String evaluateInputAndBatch(String userInput, String genBatch) {
       String result="";
       Integer genLength=8;
       Integer numMatch=0;
       if(userInput.equalsIgnoreCase(genBatch))
       {
           result="PRISTINE";
       }
       else if(userInput.length() != genBatch.length())
        { 
            result= "CRITICAL_DISCREPANCY";
        }
        else if(userInput.length() == genBatch.length())
        {
            for(int x=0; x<genBatch.length(); x++)
            {
                char inputCharacter= userInput.charAt(x);
                char batchCharacter= genBatch.charAt(x);
                if(inputCharacter==batchCharacter)
                {
                    numMatch++;
                }
            }
            if(numMatch>=4)
            {
                result= "TOLERABLE";
            }
            else if(numMatch<4)
            {
                result= "CRITICAL_DISCREPANCY";
            }
        }
       return result;
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer calcEffeciency(Integer numPristine, Integer numTolerable, Integer totalBatches) {
        Integer effIndex = (int)(((numPristine + numTolerable +0.0)/totalBatches)*100);
        return effIndex;
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
