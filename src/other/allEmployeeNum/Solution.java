package other.allEmployeeNum;

import com.alibaba.fastjson.JSONObject;
import other.RedisUtils;

import java.util.*;

public class Solution {

    static List<HashMap> deptMap = new ArrayList<>();

    static String[] kindsArr = new String[]{"全部类别","临床","科研","行政后勤","其他"};


    private List<EmployeeNum> getEmployeeNum(final EmployeeNum employeeNum,Integer level,Integer i){
        List<EmployeeNum> result = new ArrayList<>();
        EmployeeNum copy = new EmployeeNum();
        copy.setFirstDept(employeeNum.firstDept);
        copy.setSecondDept(employeeNum.secondDept);
        copy.setThirdDept(employeeNum.thirdDept);
        copy.setFourthDept(employeeNum.fourthDept);
        copy.setKind(employeeNum.kind);
        if(level ==  4){
            Random random = new Random();
            employeeNum.setFourthDept(level+"级科室" + ++i);
            employeeNum.setEmployeeNum(random.nextInt(10));
            copy.setFourthDept(level+"级科室" + ++i);
            copy.setEmployeeNum(random.nextInt(10));
            result.add(copy);
            result.add(employeeNum);
            return result;
        }
        switch (level){
            case 1:
                employeeNum.setFirstDept(level+"级科室" + ++i);
                copy.setFirstDept(level+"级科室" + ++i);
                result.addAll(getEmployeeNum(employeeNum,level+1,i));
                result.addAll(getEmployeeNum(copy,level+1,i));
                break;
            case 2:
                employeeNum.setSecondDept(level+"级科室" + ++i);
                copy.setSecondDept(level+"级科室" + ++i);
                result.addAll(getEmployeeNum(employeeNum,level+1,i));
                result.addAll(getEmployeeNum(copy,level+1,i));
                break;
            case 3:
                employeeNum.setThirdDept(level+"级科室" + ++i);
                copy.setThirdDept(level+"级科室" + ++i);
                result.addAll(getEmployeeNum(employeeNum,level+1,i));
                result.addAll(getEmployeeNum(copy,level+1,i));
                break;
        }
        return result;
    }

    public String generateDate(){
        int index = 0;
        for (int i = 0; i < kindsArr.length; i++) {
            EmployeeNum employeeNum = new EmployeeNum();
            employeeNum.setKind(kindsArr[i]);
            String result = JSONObject.toJSONString(getEmployeeNum(employeeNum,1,index));
            RedisUtils.getConnection().hset("allEmployeeNum_hash",kindsArr[i],result);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateDate());
    }
}
