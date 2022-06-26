package com.dhy.reactor.chapter7;

/**
 * @Project fighting-core
 * @Description 提炼类
 * @Author lvaolin
 * @Date 2022/6/26 下午3:27
 */
public class ExtractClass2 {


    class Person{
        private String name;

        private TelephoneNumber officeTelephone;

        public String getTelephoneNumber(){
            return officeTelephone.getTelephoneNumber();
        }

        public TelephoneNumber getOfficeTelephone() {
            return officeTelephone;
        }

        public void setTelephoneNumber(TelephoneNumber officeTelephone) {
            this.officeTelephone = officeTelephone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    class TelephoneNumber{
        private String officeAreaCode;
        private String officeNumber;

        public String getTelephoneNumber(){
            return officeAreaCode+officeNumber;
        }

        public String getOfficeAreaCode() {
            return officeAreaCode;
        }

        public void setOfficeAreaCode(String officeAreaCode) {
            this.officeAreaCode = officeAreaCode;
        }

        public String getOfficeNumber() {
            return officeNumber;
        }

        public void setOfficeNumber(String officeNumber) {
            this.officeNumber = officeNumber;
        }
    }
}
