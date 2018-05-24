package com.example.duhongwang20180514.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created   by    Dewey
 */
@Entity
public class DataBean {

        @Id(autoincrement = true)
        private Long   id;
        private String commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private String  praiseNum;
        private String  shareNum;
        private int uid;
        @Generated(hash = 1512982012)
        public DataBean(Long id, String commentNum, String content, String createTime,
                String imgUrls, int jid, String praiseNum, String shareNum, int uid) {
            this.id = id;
            this.commentNum = commentNum;
            this.content = content;
            this.createTime = createTime;
            this.imgUrls = imgUrls;
            this.jid = jid;
            this.praiseNum = praiseNum;
            this.shareNum = shareNum;
            this.uid = uid;
        }
        @Generated(hash = 908697775)
        public DataBean() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getCommentNum() {
            return this.commentNum;
        }
        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }
        public String getContent() {
            return this.content;
        }
        public void setContent(String content) {
            this.content = content;
        }
        public String getCreateTime() {
            return this.createTime;
        }
        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
        public String getImgUrls() {
            return this.imgUrls;
        }
        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }
        public int getJid() {
            return this.jid;
        }
        public void setJid(int jid) {
            this.jid = jid;
        }
        public String getPraiseNum() {
            return this.praiseNum;
        }
        public void setPraiseNum(String praiseNum) {
            this.praiseNum = praiseNum;
        }
        public String getShareNum() {
            return this.shareNum;
        }
        public void setShareNum(String shareNum) {
            this.shareNum = shareNum;
        }
        public int getUid() {
            return this.uid;
        }
        public void setUid(int uid) {
            this.uid = uid;
        }

    @Override
    public String toString() {
        return "DataBean{" +
                "id=" + id +
                ", commentNum='" + commentNum + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", imgUrls='" + imgUrls + '\'' +
                ", jid=" + jid +
                ", praiseNum='" + praiseNum + '\'' +
                ", shareNum='" + shareNum + '\'' +
                ", uid=" + uid +
                '}';
    }
}
