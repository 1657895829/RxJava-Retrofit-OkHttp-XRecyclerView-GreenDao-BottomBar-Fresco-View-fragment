package com.example.duhongwang20180514.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created   by    Dewey
 * 此表暂时没用
 */
@Entity
public class UserBean {
        @Id(autoincrement = true)
        private Long   id;
        private String age;
        private String fans;
        private String icon;
        private String nickname;
        private String praiseNum;
        @Generated(hash = 1110629178)
        public UserBean(Long id, String age, String fans, String icon, String nickname,
                String praiseNum) {
            this.id = id;
            this.age = age;
            this.fans = fans;
            this.icon = icon;
            this.nickname = nickname;
            this.praiseNum = praiseNum;
        }
        @Generated(hash = 1203313951)
        public UserBean() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getAge() {
            return this.age;
        }
        public void setAge(String age) {
            this.age = age;
        }
        public String getFans() {
            return this.fans;
        }
        public void setFans(String fans) {
            this.fans = fans;
        }
        public String getIcon() {
            return this.icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
        public String getNickname() {
            return this.nickname;
        }
        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
        public String getPraiseNum() {
            return this.praiseNum;
        }
        public void setPraiseNum(String praiseNum) {
            this.praiseNum = praiseNum;
        }


}
