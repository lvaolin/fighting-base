package com.dhy.reactor.chapter10;

/**
 * @Project fighting-core
 * @Description 移除设置函数
 * @Author lvaolin
 * @Date 2022/7/10 上午11:12
 */
public class RemoveSettingMethod {

    class Account{
        private final String _id;
        public Account(String id){
            this._id = "dhy"+id;
        }
    }


    //这种写法虽然也是对final变量只赋值了一次但是编译不过去
//    class Account{
//        private final String _id;
//        public Account(String id){
//            init(id);
//        }
//        private void init(String id){
//            this._id = "dhy"+id;
//        }
//    }
}

