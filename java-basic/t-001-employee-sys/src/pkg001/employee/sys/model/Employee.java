/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001.employee.sys.model;

import java.util.Date;

/**
 * 社員データ
 *
 * @author FXD
 */
public class Employee {

    public String eId;
    public String eName;
    public String eSex;
    public String ePos;
    public Date eEntryDate;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public String getePos() {
        return ePos;
    }

    public void setePos(String ePos) {
        this.ePos = ePos;
    }

    public Date geteEntryDate() {
        return eEntryDate;
    }

    public void seteEntryDate(Date eEntryDate) {
        this.eEntryDate = eEntryDate;
    }

}
