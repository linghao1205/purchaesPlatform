/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if(type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Finance.getValue())){
            organization = new FinanceDepartment();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Warehouse.getValue())){
            organization = new Warehouse();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.ProductionCom.getValue())){
            organization = new ComProductionDepartment();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Purchasing.getValue())){
            organization = new PurchasingDepartment();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Sales.getValue())){
            organization = new SalesDepartment();
            organizationList.add(organization);
        }
        return organization;
    }
}