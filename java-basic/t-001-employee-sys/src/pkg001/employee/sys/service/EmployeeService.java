/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001.employee.sys.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pkg001.employee.sys.model.Employee;

/**
 * 社員管理サービス
 *
 * @author FXD
 */
public class EmployeeService {

    /**
     * CSVファイルから社員データを取り込む
     *
     * @param csvFile CSVファイルパス
     * @return 社員データリスト
     */
    public static List<Employee> getDataFrom(String csvFile) {
        List<Employee> datas = new ArrayList<>();

        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            for (int row = 0; (line = br.readLine()) != null; row++) {
                String[] emp = line.split(",");

                Employee tmp = new Employee();
                tmp.seteId(emp[0]);

                //....
                Date eEntryDate = null;
                // TODO: Google: Java String to Date
                tmp.seteEntryDate(eEntryDate);
                datas.add(tmp);
                // datas.add(???);

                for (String data : emp) {
                    System.out.println(data);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datas;
    }

    /**
     * EmployeeデータをDB一括登録
     *
     * @param datas 社員リスト
     * @return 結果
     */
    public static boolean saveToDB(List<Employee> datas) {
        //
        return false;
    }

    /**
     * Employeeを追加する<br>
     * 追加成功の場合TRUE,名前重複の場合、追加失敗、falseを返却する
     *
     * @param eName 名前
     * @param eSex 性別
     * @param ePos 職位
     * @return 追加結果
     */
    public static boolean addEmployee(
            String eName,
            String eSex,
            String ePos) {

        return false;
    }

    /**
     * 指定された社員ID紐付くデータを削除
     *
     * @param eId 社員ID
     * @return 削除結果
     */
    public static boolean removeEmployee(String eId) {

        return false;
    }
}
