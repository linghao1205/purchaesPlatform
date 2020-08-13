/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author xia.jia
 */
public class FinanceTestWorkRequest extends WorkRequest{
    private boolean DeliveryStatus;
    private boolean FinanceStatus;
    private String prepareStatus;

    public FinanceTestWorkRequest() {
        this.setMaterial(new Material());
    }

    
    public String getPrepareStatus() {
        return prepareStatus;
    }

    public void setPrepareStatus(String prepareStatus) {
        this.prepareStatus = prepareStatus;
    }

    public boolean isDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(boolean DeliveryStatus) {
        this.DeliveryStatus = DeliveryStatus;
    }

    public boolean isFinanceStatus() {
        return FinanceStatus;
    }

    public void setFinanceStatus(boolean FinanceStatus) {
        this.FinanceStatus = FinanceStatus;
    }   
    @Override
    public String toString(){
        return String.valueOf(this.getDeliveryNumber());
    }
}
