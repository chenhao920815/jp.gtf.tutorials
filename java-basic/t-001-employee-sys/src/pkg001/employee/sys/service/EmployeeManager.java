/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001.employee.sys.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pkg001.employee.sys.model.Employee;

/**
 * オブジェクト操作クラス<br>
 * 社員操作クラス（ビジネスロジック） 試す修正
 *
 * @author FXD
 */
public class EmployeeManager {

    /**
     * 社員情報個別登録<br>
     * トランザクション無視
     *
     * @param eName 名称
     * @param eSex 性別
     * @param ePos 職位
     * @return 登録成功
     */
    public boolean createEmployeeData(String eName, String eSex, String ePos) {
        try {
            // step1 OPEN THE DOOR
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://133.130.72.94:5432/java_basic_employee",
                    "postgres",
                    "postgres");

            // step2 自動採番操作
            // シーケンスからIDを取得する
            Statement stmtSeq = connection.createStatement();
            ResultSet seqResutSet = stmtSeq.executeQuery("select nextval('employee_id');");
            seqResutSet.next();
            long seq = seqResutSet.getLong(1);

            // step2 EXECUTE SQL Google:Java query Postgres
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String currentYMD = dateFormat.format(date);

            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO EMPLOYEE VALUES ('" + String.format("%05d", seq) + "', '" + eName + "', '" + eSex + "', '" + ePos + "', '" + currentYMD + "')";
            stmt.executeUpdate(sql);
            stmt.close();

            // step3 CLOSE DOOR
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 社員情報一覧表示
     *
     * @return 社員情報リスト
     */
    public List<Employee> selectAllEmployee() {
        try {
            List<Employee> datas = new ArrayList<>();
            // step1 OPEN THE DOOR
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://133.130.72.94:5432/java_basic_employee",
                    "postgres",
                    "postgres");

            // step2 自動採番操作
            // シーケンスからIDを取得する
            Statement stmtSeq = connection.createStatement();
            ResultSet resutSet = stmtSeq.executeQuery("select * from employee;");

            while (resutSet.next()) {
                Employee employee = new Employee();
                employee.eId = resutSet.getObject("e_id").toString();
                employee.eName = resutSet.getObject("e_name").toString();
                employee.eSex = resutSet.getObject("e_sex").toString().endsWith("1") ? "男性" : "女性";
                employee.ePos = resutSet.getObject("e_pos").toString();
                employee.eEntryDate = resutSet.getTimestamp("e_entrydate");
                datas.add(employee);
            }
            // step3 CLOSE DOOR
            connection.close();

            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
