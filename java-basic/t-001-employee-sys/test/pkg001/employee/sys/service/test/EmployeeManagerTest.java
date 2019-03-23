package pkg001.employee.sys.service.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg001.employee.sys.model.Employee;
import pkg001.employee.sys.service.EmployeeManager;

/**
 * 社員管理マネージャーテスター
 *
 * @author FXD
 */
public class EmployeeManagerTest {

    /**
     * テストケース001<br>
     * DBを正しく接続できるを検証する
     */
    @Test
    public void testCase0001() {
        // 実際返却された値
        boolean actualValue = new EmployeeManager().createEmployeeData("陳11", "1", "XA");
        // 期待値
        boolean exceptValue = true;
        // 比較する
        assertEquals(exceptValue, actualValue);
    }

    /**
     * 性別最大桁数超えるテスト(異常系)
     */
    @Test
    public void testCase0002() {
        // 実際返却された値
        boolean actualValue = new EmployeeManager().createEmployeeData("陳11", "22", "XA");
        // 期待値
        boolean exceptValue = false;
        // 比較する
        assertEquals(exceptValue, actualValue);
    }

    @Test
    public void testCase0003() {
        // 実際返却された値
        List<Employee> actualValue = new EmployeeManager().selectAllEmployee();
        // do nothing
    }
}
