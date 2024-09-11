
import dao.AccountDAO;
import dao.MealDAO;
import dto.Account;
import dto.Meal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trung
 */
public class test {

    public static void main(String[] args) {
//        HashMap<String, Integer> list = new HashMap<>();
//        list.merge("Test 1", 1, Integer::sum);
//        list.merge("Test 1", 1, Integer::sum);
//        list.merge("Test 2", 1, Integer::sum);
//        list.merge("Test 3", 1, Integer::sum);
//        list.merge("Test 1", 4, Integer::sum);
//        for (Map.Entry<String, Integer> entry : list.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key +" "+ value);
//        }
    String test = "123";
    String t1 = test.substring(test.length()-1);
    String t2 = test.substring(0,test.length()-1);
        System.out.println(t1);
        System.out.println(t2);
    }
}
