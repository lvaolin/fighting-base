package com.dhy.leetcode.loadbanlance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @Project fighting-core
 * @Description 基于权重的负载均衡算法代码实现
 * @Author lvaolin
 * @Date 2021/5/10 11:51 上午
 */
public class ByWeight {
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<DbKeyWeightDto> weightList = getWeightList();
        for (int i = 0; i <10000 ; i++) {
            DbKeyWeightDto dto = selectOne(weightList);
            System.out.println(dto.getDbkey());
        }
    }

    /**
     * 负载均衡算法
     * @param weightList
     * @return
     */
    private static DbKeyWeightDto selectOne(ArrayList<DbKeyWeightDto> weightList) {
        int size = weightList.stream().mapToInt(DbKeyWeightDto::getWeight).sum();
        int[] tempArray = new int[size];
        int i=0;
        for (int i1 = 0; i1 < weightList.size(); i1++) {
            int weight = weightList.get(i1).getWeight();
            for (int j = 0; j <weight ; j++) {
                tempArray[i]=i1;
                i++;
            }
        }
        Random random = new Random();
        return weightList.get(tempArray[random.nextInt(size)]);
    }

    /**
     * 模拟获取权重信息
     * @return
     */
    private static ArrayList<DbKeyWeightDto> getWeightList() {
        //模拟定时任务统计获取分库的企业数量数据
        ArrayList<DbKeyWeightDto> dbKeyWeightDtos = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <=4 ; i++) {
            dbKeyWeightDtos.add(new DbKeyWeightDto("dbkey"+i,random.nextInt(100)));
        }
        //排序
        Collections.sort(dbKeyWeightDtos,(a1, a2)->{
            if (a1.getWeight()==null) {
                a1.setWeight(0);
            }
            if (a2.getWeight()==null) {
                a2.setWeight(0);
            }
            return a1.getWeight()-a2.getWeight();
        });
        //首尾权重对调
        for (int i = 0; i < dbKeyWeightDtos.size()/2; i++) {
            Integer temp = dbKeyWeightDtos.get(i).getWeight();
            dbKeyWeightDtos.get(i).setWeight(dbKeyWeightDtos.get(dbKeyWeightDtos.size()-1-i).getWeight());
            dbKeyWeightDtos.get(dbKeyWeightDtos.size()-1-i).setWeight(temp);
        }
        return dbKeyWeightDtos;
    }
}
