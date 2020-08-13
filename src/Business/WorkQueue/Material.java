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
public class Material {
    private String ProductionModel;
    private int UnitPrice;

    public Material(String ProductionModel, int UnitPrice) {
        this.ProductionModel = ProductionModel;
        this.UnitPrice = UnitPrice;
    }
    public Material(){}

    public String getProductionModel() {
        return ProductionModel;
    }

    public void setProductionModel(String ProductionModel) {
        this.ProductionModel = ProductionModel;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
    
}
