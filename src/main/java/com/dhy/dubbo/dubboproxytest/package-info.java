/**
 * @Title package-info
 * @Description  测试下  json报文转  方法参数
 *
 * 比如参数列表是   hello(String id,Date date, MyDto myDto)
 *
 * 前端报文 json，一定要用数组的形式传，这样很方便转换成  Object[]
{
        "paramValues":[
            {
                "id":"001"
            },
            {
                "date":"2022-03-04"
            },
            {
                "myDto":{
                "name":"zhangsan",
                "school":"hbu"
                }
            }
        ]
}
 *
 * @Author lvaolin
 * @Date 2022/3/16 23:23
 **/
package com.dhy.dubbo.dubboproxytest;